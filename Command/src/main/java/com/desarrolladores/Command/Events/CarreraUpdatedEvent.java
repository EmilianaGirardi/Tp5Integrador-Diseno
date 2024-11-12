package com.desarrolladores.Command.Events;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarreraUpdatedEvent extends Event {
    private Integer idcarrera;
    private String nombre;
}