package com.desarrolladores.Command.Events;

import com.desarrolladores.Command.Entity.*;
import java.time.LocalDate;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InscripcionUpdatedEvent extends Event {

    private Carrera carrera;
    private Estudiante estudiante;
    private LocalDate fechaInscripcion;
    private boolean graduado;
}
