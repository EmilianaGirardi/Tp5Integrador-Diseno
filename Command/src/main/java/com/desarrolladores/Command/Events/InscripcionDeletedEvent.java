package com.desarrolladores.Command.Events;

import com.desarrolladores.Command.Entity.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InscripcionDeletedEvent extends Event {

    private Carrera carrera;
    private Estudiante estudiante;

}
