package com.desarrolladores.Command.Events;

import java.util.List;

public interface EventStore {
    void addEvent(Event event);

    List<Event> getEvents();
}
