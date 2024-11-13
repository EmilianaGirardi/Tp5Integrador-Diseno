package com.desarrolladores.Query.Events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InscripcionDeletedEvent extends Event {

    private String idEstudiante;
    private Integer idCarrera;

}
