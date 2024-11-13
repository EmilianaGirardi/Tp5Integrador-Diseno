package com.desarrolladores.Command.Service;

import com.desarrolladores.Command.Events.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final String TOPIC = "eventos";

    @Autowired
    private KafkaTemplate<String, Event> kafkaTemplate;

    public void sendMessage(Event event) {
        kafkaTemplate.send(TOPIC, event);
    }
}