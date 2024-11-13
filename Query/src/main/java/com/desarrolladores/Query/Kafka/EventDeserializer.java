package com.desarrolladores.Query.Kafka;

import com.desarrolladores.Query.Events.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TextNode;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.io.IOException;
public class EventDeserializer extends JsonDeserializer<Event> {

    public EventDeserializer() {
        // Registra el tipo base Event y sus subtipos
        super(Event.class);
        // Registra subtipos (tu clase Event y todas las subclases que heredan de ella)
        this.addTrustedPackages("com.desarrolladores.Query.Events");  // Agrega el paquete base de tus clases de evento

    }

    @Override
    public Event deserialize(String topic, byte[] data) {
        try {
            // Usa el ObjectMapper para deserializar el mensaje y manejar subtipos
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(data, Event.class);
        } catch (Exception e) {
            throw new RuntimeException("Error deserializando el evento", e);
        }
    }
}
