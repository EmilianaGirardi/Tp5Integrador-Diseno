package com.desarrolladores.Command.Handler;

import com.desarrolladores.Command.Events.*;

public class CarreraCommandHandler {

    private EventStore eventStore;

    public CarreraCommandHandler(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    public void handleCreateCarrera(Integer idCarrera, String nombre) {
        Event event = new CarreraCreatedEvent(idCarrera, nombre);
        eventStore.addEvent(event);
    }
}
