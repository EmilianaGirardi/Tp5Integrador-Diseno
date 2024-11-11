package Embeddable;


import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import Entity.Carrera;
import Entity.Estudiante;

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
