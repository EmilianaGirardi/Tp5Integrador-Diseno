package com.desarrolladores.Query.Service;

import com.desarrolladores.Query.DTO.EstudianteDTO;
import com.desarrolladores.Query.Repository.EstudianteRepository;
import com.desarrolladores.Query.Repository.InscripcionRepository;
import com.desarrolladores.Query.Entity.Estudiante;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.kafka.annotation.KafkaListener;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private InscripcionRepository inscripcionRepository;

    // obtener lista de estudiantes de una carrera ordenados por apellido

        public ResponseEntity<List<EstudianteDTO>> getEstudiantesDeCarreraXApellido(Integer carrera){
        try {
            ArrayList<EstudianteDTO> respuesta = new ArrayList<>(estudianteRepository.getEstudiantesDeCarreraXApellido(carrera));
            return ResponseEntity.ok(respuesta);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(Collections.emptyList());
        }
    }


    //obtener la informacion de un estudiante especifico por dni.
    public ResponseEntity<List<EstudianteDTO>> getEstudiantePorDNI(String dni){
        try {
            ArrayList<EstudianteDTO> respuesta = new ArrayList<>(estudianteRepository.getEstudiantePorDNI(dni));
            return ResponseEntity.ok(respuesta);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(Collections.emptyList());
        }
    }

    //obtener la informacion de un estudiante especifico por libreta universitaria
    public ResponseEntity<List<EstudianteDTO>> getEstudiantePorLibreta(String libreta){
        try {
            ArrayList<EstudianteDTO> respuesta = new ArrayList<>(estudianteRepository.getEstudiantePorLibreta(libreta));
            return ResponseEntity.ok(respuesta);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(Collections.emptyList());
        }
    }

    //METODOS QUE MODIFICAN LA BD
    public ResponseEntity<String> addEstudiante(EstudianteDTO estudianteDTO){
        try {
            Estudiante nuevoEstudiante = new Estudiante(estudianteDTO);
            estudianteRepository.save(nuevoEstudiante);
            return ResponseEntity.ok("Estudiante guardado con exito");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Error al guardar estudiante " + e.getMessage());
        }
    }

}
