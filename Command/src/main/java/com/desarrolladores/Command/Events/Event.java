package com.desarrolladores.Command.Events;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Getter

@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS,  // Incluye el nombre de la clase en el JSON
        include = JsonTypeInfo.As.PROPERTY,
        property = "@class" // Agrega el tipo de clase en una propiedad JSON llamada "@class"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = EstudianteCreatedEvent.class, name = "estudianteCreatedEvent"),
        @JsonSubTypes.Type(value = CarreraCreatedEvent.class, name = "carreraCreatedEvent"),
        @JsonSubTypes.Type(value = InscripcionCreatedEvent.class, name = "inscripcionCreatedEvent"),
        @JsonSubTypes.Type(value = InscripcionUpdatedEvent.class, name = "inscripcionUpdatedEvent")
})
public abstract class Event {
}
