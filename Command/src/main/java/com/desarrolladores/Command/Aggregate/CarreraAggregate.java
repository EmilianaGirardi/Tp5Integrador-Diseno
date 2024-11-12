package com.desarrolladores.Command.Aggregate;

import java.util.Arrays;
import java.util.List;

import com.desarrolladores.Command.Events.*;

public class CarreraAggregate {
    private EventStore eventStore;

    public CarreraAggregate(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    public List<Event> handleCreateCarreraCommand(CreateCarreraCommand command) {
        CarreraCreatedEvent event = new CarreraCreatedEvent(command.getCarreraId(), command.getNombre());
        eventStore.addEvent(command.getCarreraId(), event);
        return Arrays.asList(event);
    }

    // Otros comandos como UpdateCarreraCommand
}
