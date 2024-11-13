package com.desarrolladores.Query.Events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarreraCreatedEvent extends Event {
    private Integer idcarrera;
    private String nombre;
}
