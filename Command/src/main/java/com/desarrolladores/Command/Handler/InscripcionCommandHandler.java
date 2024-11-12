package com.desarrolladores.Command.Handler;

import com.desarrolladores.Command.Entity.*;
import com.desarrolladores.Command.Events.*;
import java.time.LocalDate;

public class InscripcionCommandHandler {

    private EventStore eventStore;

    public InscripcionCommandHandler(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    public void handleCreateInscripcion(Carrera carrera, Estudiante estudiante, LocalDate fechaInscripcion,
            boolean graduado) {
        Event event = new InscripcionCreatedEvent(carrera, estudiante, fechaInscripcion, graduado);
        eventStore.addEvent(event);
    }

    public void handleUpdateInscripcion(Carrera carrera, Estudiante estudiante, LocalDate fechaInscripcion,
            boolean graduado) {
        Event event = new InscripcionUpdatedEvent(carrera, estudiante, fechaInscripcion, graduado);
        eventStore.addEvent(event);
    }

    public void handleDeletedInscripcion(Carrera carrera, Estudiante estudiante) {
        Event event = new InscripcionDeletedEvent(carrera, estudiante);
        eventStore.addEvent(event);
    }
}
