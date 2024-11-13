package com.desarrolladores.Query.Events;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Date;
import java.util.UUID;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type" // Esto indica el nombre de la propiedad que define el tipo
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = EstudianteCreatedEvent.class, name = "estudianteCreated"),
        @JsonSubTypes.Type(value = CarreraCreatedEvent.class, name = "carreraCreated"),
        @JsonSubTypes.Type(value = InscripcionCreatedEvent.class, name = "inscripcionCreated"),
        @JsonSubTypes.Type(value = InscripcionUpdatedEvent.class, name = "inscripcionUpdated")
})
public abstract class Event {
    public final UUID id = UUID.randomUUID();
    public final Date created = new Date();

    public Event(){

    }
}
