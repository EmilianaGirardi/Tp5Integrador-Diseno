package com.desarrolladores.Command.DTO;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EstudianteDTO {
    private String dniestudiante;
    private String apellido;
    private String nombre;
    private String libretaUniversitaria;
    private char genero;
    private LocalDate fechaNacimiento;
    private String ciudad;
}
