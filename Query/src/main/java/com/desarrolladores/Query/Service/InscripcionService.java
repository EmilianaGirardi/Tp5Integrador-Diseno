package com.desarrolladores.Query.Service;

import com.desarrolladores.Query.DTO.ReporteCarreraDTO;
import com.desarrolladores.Query.DTO.ReportePromedioInscriptosDTO;

import com.desarrolladores.Query.Entity.Carrera;
import com.desarrolladores.Query.Entity.Estudiante;
import com.desarrolladores.Query.Embeddable.InscripcionId;
import com.desarrolladores.Query.Entity.Inscripcion;
import com.desarrolladores.Query.Repository.CarreraRepository;
import com.desarrolladores.Query.Repository.EstudianteRepository;
import com.desarrolladores.Query.Repository.InscripcionRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.kafka.annotation.KafkaListener;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class InscripcionService {
    @Autowired
    private InscripcionRepository inscripcionRepository;
    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private CarreraRepository carreraRepository;

    //obtener el numero de inscriptos y el numero de egresador por año de una carrera ordenadas por cantidad de egresados
    public ResponseEntity<List<ReporteCarreraDTO>> getInscriptosYEgresadosPorAnio(){
        try {
            ArrayList<ReporteCarreraDTO> respuesta = new ArrayList<>(inscripcionRepository.getInscriptosEgresadosPorAnio());
            return ResponseEntity.ok(respuesta);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(Collections.emptyList());
        }
    }

    //obtener el promedio de inscriptos por año de todas las carreras, en orden.
    public ResponseEntity<List<ReportePromedioInscriptosDTO>> getPromedioInscriptosPorAnio(){
        try {
            ArrayList<ReportePromedioInscriptosDTO> respuesta = new ArrayList<>();
            //(inscripcionRepository.getPromedioInscriptosPorAnio());
            return ResponseEntity.ok(respuesta);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(Collections.emptyList());
        }
    }

    //METODOS PARA MODIFICAR LA BASE
    public ResponseEntity<String> addInscripcion(String idEstudiante, Integer idCarrera) {
        Estudiante estudiante = estudianteRepository.getById(idEstudiante);
        if (estudiante == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El estudiante no existe");
        } else {
            Carrera carrera = carreraRepository.getById(idCarrera);
            if (carrera == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La carrera no existe");
            } else {
                Inscripcion nuevaInscripcion = new Inscripcion(carrera, estudiante, LocalDate.now(), false);
                try {
                    inscripcionRepository.save(nuevaInscripcion);
                    return ResponseEntity.ok("Inscripcion añadida correctamente");
                } catch (Exception e) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar inscripcion");
                }
            }
        }
    }

    // informar que un estudiante se graduo de una carrera.
    public ResponseEntity<String> updateGraduado(String idEstudiante, Integer idCarrera) {
        Estudiante estudiante = estudianteRepository.getById(idEstudiante);
        if (estudiante == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El estudiante no existe");
        } else {
            Carrera carrera = carreraRepository.getById(idCarrera);
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
                    } catch (Exception e) {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body("Error al graduar estudiante");
                    }

                } else
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body("Error encontrar la inscripcion");
            }
        }
    }
}


