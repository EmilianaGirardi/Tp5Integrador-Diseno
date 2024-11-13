package com.desarrolladores.Query.Service;

import com.desarrolladores.Query.DTO.*;
import com.desarrolladores.Query.Embeddable.*;
import com.desarrolladores.Query.Entity.*;
import com.desarrolladores.Query.Events.*;
import com.desarrolladores.Query.Repository.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class KafkaConsumer{
    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @KafkaListener(topics = "eventos", groupId = "query-service")
    public ResponseEntity<String> consume(ConsumerRecord<String, String> record) throws JsonProcessingException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Meter lo que llega del broker en tipo JSON para parsearlo y ver a quien corresponde.
        String jsonValue = record.value();
        Map<String, Object> eventMap = new ObjectMapper().readValue(jsonValue, Map.class);

        // Detectar el nombre de la clase
        String className = (String) eventMap.get("@class");
        className = className.substring(className.lastIndexOf('.') + 1);
        eventMap.remove("@class");
        return redirect(className,eventMap);
    }


    // Persistir estudiante en BD
    public ResponseEntity<String> apply(EstudianteCreatedEvent e){
        System.out.println("Procesando evento EstudianteCreatedEvent");
        EstudianteDTO estudianteDTO = new EstudianteDTO(
                e.getDniestudiante(),
                e.getApellido(),
                e.getNombre(),
                e.getLibretaUniversitaria(),
                e.getGenero(),
                e.getFechaNacimiento(),
                e.getCiudad()
        );
        Estudiante nuevo = new Estudiante(estudianteDTO);
        try {
            estudianteRepository.save(nuevo);
            return ResponseEntity.ok().body("Estudiante agregado con éxito");
        }
        catch (Exception ex){
            return ResponseEntity.internalServerError().body("Error al guardar estudiante " + ex.getMessage());
        }
    }

    // Persistir carrera en BD
    public ResponseEntity<String> apply(CarreraCreatedEvent e){
        System.out.println("Procesando evento CarreraCreatedEvent");
        CarreraDTO carreraDTO = new CarreraDTO(
                e.getIdcarrera(),
                e.getNombre()
        );
        Carrera nuevo = new Carrera(carreraDTO);

        try {
            carreraRepository.save(nuevo);
            return ResponseEntity.ok().body("Carrera agregada con éxito");
        }
        catch (Exception ex){
            return ResponseEntity.internalServerError().body("Error al guardar carrera " + ex.getMessage());
        }
    }

    public ResponseEntity<String> apply(InscripcionCreatedEvent e) {
        Optional<Estudiante> estudianteOpt = estudianteRepository.findById(e.getIdEstudiante());
        if (!estudianteOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El estudiante no existe");
        }

        Optional<Carrera> carreraOpt = carreraRepository.findById(e.getIdCarrera());
        //Carrera carrera = carreraRepository.findById(e.getIdCarrera()).orElseThrow(() -> new RuntimeException("Carrera no encontrada"));
        if (!carreraOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La carrera no existe");
        }

        Estudiante estudiante = estudianteOpt.get();
        Carrera carrera = carreraOpt.get();

        // Comprobar si ya existe una inscripción para este estudiante en esta carrera
        Optional<Inscripcion> inscripcionExistente = inscripcionRepository.findByEstudianteAndCarrera(estudiante, carrera);
        if (inscripcionExistente.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El estudiante ya está inscrito en esta carrera");
        }

        // Crear la nueva inscripción sin intentar insertar la carrera nuevamente
        Inscripcion nuevaInscripcion = new Inscripcion(carrera, estudiante, LocalDate.now(), false);
        try {
            inscripcionRepository.save(nuevaInscripcion); // No se debe volver a persistir la carrera si ya existe
            return ResponseEntity.ok("Inscripción añadida correctamente");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar inscripción: " + ex.getMessage());
        }
    }




    // Actualizar graduacion de estudiante en tabla inscripcion en BD
    public ResponseEntity<String> apply(InscripcionUpdatedEvent e) {
        System.out.println("Procesando evento InscripcionUpdatedEvent");
        Estudiante estudiante = estudianteRepository.getById(e.getIdEstudiante());
        if (estudiante == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El estudiante no existe");
        } else {
            Carrera carrera = carreraRepository.getById(e.getIdCarrera());
            if (carrera == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La carrera no existe");
            } else {
                InscripcionId id = new InscripcionId(carrera, estudiante);
                Optional<Inscripcion> inscripcion = inscripcionRepository.findById(id);
                if (inscripcion.isPresent()) {
                    System.out.println(inscripcion.get().isGraduado());
                    inscripcion.get().setGraduado(true);
                    try {
                        inscripcionRepository.save(inscripcion.get());
                        return ResponseEntity.ok("Actualizacion de graduado exitosa");
                    } catch (Exception ex) {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body("Error al graduar estudiante" + ex.getMessage());
                    }

                } else
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body("Error encontrar la inscripcion");
            }
        }
    }

    public ResponseEntity<String> redirect(String className, Map<String, Object> eventMap){
        System.out.println(eventMap);
        if ("EstudianteCreatedEvent".equals(className)) {
            EstudianteCreatedEvent event = new EstudianteCreatedEvent();
            event.setApellido((String)eventMap.get("apellido"));
            event.setNombre((String)eventMap.get("nombre"));
            event.setDniestudiante((String)eventMap.get("dniestudiante"));
            event.setCiudad((String)eventMap.get("ciudad"));
            event.setLibretaUniversitaria((String)eventMap.get("libretaUniversitaria"));
            event.setGenero(((String) eventMap.get("genero")).charAt(0));
            List<Integer> fechaNacimientoList = (List<Integer>) eventMap.get("fechaNacimiento");
            LocalDate fechaNacimiento = LocalDate.of(
                    fechaNacimientoList.get(0), // Año
                    fechaNacimientoList.get(1), // Mes
                    fechaNacimientoList.get(2)  // Día
            );
            event.setFechaNacimiento(fechaNacimiento);
            return apply(event);
        } else if ("CarreraCreatedEvent".equals(className)) {
            CarreraCreatedEvent event = new CarreraCreatedEvent();
            event.setIdcarrera((Integer)eventMap.get("idcarrera"));
            event.setNombre((String)eventMap.get("nombre"));
            return apply(event);
        } else if ("InscripcionCreatedEvent".equals(className)) {
            InscripcionCreatedEvent event = new InscripcionCreatedEvent();
            event.setIdCarrera((Integer) eventMap.get("idCarrera"));
            event.setIdEstudiante((String) eventMap.get("idEstudiante"));
            return apply(event);
        } else if ("InscripcionUpdatedEvent".equals(className)) {
            InscripcionUpdatedEvent event = new InscripcionUpdatedEvent();
            event.setIdCarrera((Integer) eventMap.get("idCarrera"));
            event.setIdEstudiante((String) eventMap.get("idEstudiante"));
            return apply(event);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error, clase no coincidente con las del consumidor");
    }

}
