package com.desarrolladores.Command.Events;

import java.time.LocalDate;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EstudianteUpdatedEvent extends Event {
    private String dniestudiante;
    private String apellido;
    private String nombre;
    private String libretaUniversitaria;
    private char genero;
    private LocalDate fechaNacimiento;
    private String ciudad;
}
