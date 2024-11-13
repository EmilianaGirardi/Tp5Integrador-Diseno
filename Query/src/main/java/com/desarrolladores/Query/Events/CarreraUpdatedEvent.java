package com.desarrolladores.Query.Events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarreraUpdatedEvent extends Event {
    private Integer idcarrera;
    private String nombre;
}