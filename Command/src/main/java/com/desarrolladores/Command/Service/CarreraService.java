package com.desarrolladores.Command.Service;

import com.desarrolladores.Command.Events.CarreraCreatedEvent;
import com.desarrolladores.Command.Events.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.desarrolladores.Command.DTO.CarreraDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class CarreraService {
    @Autowired
    private KafkaProducer kafkaProducer;

    //dar de alta una carrera
    public ResponseEntity<String> postCarrera(CarreraDTO carreraDTO){
        Event event = new CarreraCreatedEvent(carreraDTO.getIdcarrera(), carreraDTO.getNombre());
        try {
            kafkaProducer.sendMessage(event);
            return ResponseEntity.ok().body("Carrera agregada a Kafka con éxito");
        }
        catch (Exception e){
            e.printStackTrace();  // Esto imprimirá el error completo en los logs
            return ResponseEntity.internalServerError().body("Error al guardar carrera " + e.getMessage());
        }
    }
}
