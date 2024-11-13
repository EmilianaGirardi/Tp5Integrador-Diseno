package com.desarrolladores.Query.Events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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
