package com.desarrolladores.Command.Events;

import java.util.ArrayList;
import java.util.List;

public class InMemoryEventStore implements EventStore {
    private List<Event> events = new ArrayList<>();

    @Override
    public void addEvent(Event event) {
        events.add(event);
    }

    @Override
    public List<Event> getEvents() {
        return events;
    }
}
