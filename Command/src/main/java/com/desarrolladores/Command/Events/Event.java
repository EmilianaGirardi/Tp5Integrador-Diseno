package com.desarrolladores.Command.Events;

import java.util.Date;
import java.util.UUID;

import lombok.*;

@Getter
public abstract class Event {
    public final UUID id = UUID.randomUUID();
    public final Date created = new Date();
}
