package com.desarrolladores.Query.Embeddable;


import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import com.desarrolladores.Query.Entity.Carrera;
import com.desarrolladores.Query.Entity.Estudiante;

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
