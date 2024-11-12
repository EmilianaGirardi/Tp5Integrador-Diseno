package com.desarrolladores.Query.DTO;

import lombok.*;

import java.io.Serializable;
import java.util.Date;


@Data
public class ReporteCarreraDTO implements Serializable {
    private String nombreCarrera;
    private int anioInscripcion;
    private long inscriptos;
    private long egresados;

    public ReporteCarreraDTO(String nombreCarrera, int fechaInscripcion, long inscriptos, long egresados) {
        this.nombreCarrera = nombreCarrera;
        this.anioInscripcion = fechaInscripcion;
        this.inscriptos = inscriptos;
        this.egresados = egresados;
    }
}