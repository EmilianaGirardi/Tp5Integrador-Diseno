package com.desarrolladores.Command.Service;

import com.desarrolladores.Command.Events.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.Optional;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class InscripcionService {
    @Autowired
    private KafkaProducer kafkaProducer;

    public ResponseEntity<String> addInscripcion(String idEstudiante, Integer idCarrera) {
        Event event = new InscripcionCreatedEvent(idEstudiante,idCarrera);
        try {
            kafkaProducer.sendMessage(event);
            return ResponseEntity.ok().body("Inscripcion agregada a Kafka con éxito");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar inscripcion " + e.getMessage());
        }
    }

    // informar que un estudiante se graduo de una carrera.
    public ResponseEntity<String> updateGraduado(String idEstudiante, Integer idCarrera) {
        Event event = new InscripcionUpdatedEvent(idEstudiante,idCarrera);
        try {
            kafkaProducer.sendMessage(event);
            return ResponseEntity.ok().body("Inscripcion a actualizar agregada a Kafka con éxito");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al enviar actualizacion de la inscripcion " + e.getMessage());
        }
    }
}
