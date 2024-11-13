package com.desarrolladores.Command.Service;

import com.desarrolladores.Command.Events.EstudianteCreatedEvent;
import com.desarrolladores.Command.Events.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.desarrolladores.Command.DTO.EstudianteDTO;
import org.springframework.kafka.core.KafkaTemplate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class EstudianteService {
    @Autowired
    private KafkaProducer kafkaProducer;

    public ResponseEntity<String> addEstudiante(EstudianteDTO estudianteDTO){
        Event event = new EstudianteCreatedEvent(
                estudianteDTO.getDniestudiante(),
                estudianteDTO.getApellido(),
                estudianteDTO.getNombre(),
                estudianteDTO.getLibretaUniversitaria(),
                estudianteDTO.getGenero(),
                estudianteDTO.getFechaNacimiento(),
                estudianteDTO.getCiudad()
        );

        try {
            kafkaProducer.sendMessage(event);
            return ResponseEntity.ok("Estudiante agregado a Kafka con exito");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
            body("Error al guardar estudiante " + e.getMessage());
        }
    }

}
