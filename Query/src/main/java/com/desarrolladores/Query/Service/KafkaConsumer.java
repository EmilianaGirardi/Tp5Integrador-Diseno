package com.desarrolladores.Query.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "eventos", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Mensaje recibido: " + message);
        // Aquí puedes manejar la lógica de los eventos para CQRS
        //aca iria un case que llama a los metodos de los services que cargan en la base
        //esos metodos ya los trajimos y estan en los services.
    }
}
