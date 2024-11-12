package com.desarrolladores.Command.Embeddable;


import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

import com.desarrolladores.Command.Entity.Carrera;
import com.desarrolladores.Command.Entity.Estudiante;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class InscripcionId implements Serializable {
    private Carrera carrera;
    private Estudiante estudiante;

}
