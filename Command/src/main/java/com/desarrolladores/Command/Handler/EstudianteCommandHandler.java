package com.desarrolladores.Command.Handler;

import java.time.LocalDate;

import com.desarrolladores.Command.Events.*;

public class EstudianteCommandHandler {
    private EventStore eventStore;

    public EstudianteCommandHandler(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    public void handleCreateEstudiante(String dniEstudiante, String apellido, String nombre,
            String libretaUniversitaria, char genero, LocalDate fechaNacimiento, String ciudad) {
        Event event = new EstudianteCreatedEvent(dniEstudiante, apellido, nombre, libretaUniversitaria, genero,
                fechaNacimiento, ciudad);
        eventStore.addEvent(event);
    }
}
