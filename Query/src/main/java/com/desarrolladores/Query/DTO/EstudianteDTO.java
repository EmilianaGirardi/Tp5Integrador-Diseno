package com.desarrolladores.Query.DTO;

import com.desarrolladores.Query.Entity.Inscripcion;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
public class EstudianteDTO {
    private String dniestudiante;
    private String apellido;
    private String nombre;
    private String libretaUniversitaria;
    private char genero;
    private LocalDate fechaNacimiento;
    private String ciudad;
    @JsonIgnore
    private List<Inscripcion> inscripciones;

    public EstudianteDTO(String dniestudiante, String apellido, String nombre, String libretaUniversitaria, char genero, LocalDate fechaNacimiento, String ciudad) {
        this.dniestudiante = dniestudiante;
        this.apellido = apellido;
        this.nombre = nombre;
        this.libretaUniversitaria = libretaUniversitaria;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
    }
}
