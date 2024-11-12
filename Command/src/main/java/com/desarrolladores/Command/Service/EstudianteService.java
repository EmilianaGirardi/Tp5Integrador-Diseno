package com.desarrolladores.Command.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.desarrolladores.Command.DTO.EstudianteDTO;
import com.desarrolladores.Command.Entity.Estudiante;
import com.desarrolladores.Command.Repository.EstudianteRepository;
import org.springframework.kafka.core.KafkaTemplate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

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
