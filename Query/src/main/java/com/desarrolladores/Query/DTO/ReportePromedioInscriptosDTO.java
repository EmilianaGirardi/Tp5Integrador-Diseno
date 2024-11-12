package com.desarrolladores.Query.DTO;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
public class ReportePromedioInscriptosDTO implements Serializable {
    private String nombreCarrera;
    private int anioInscripcion;
    private float prom;

    public ReportePromedioInscriptosDTO(String nombreCarrera, int fechaInscripcion, float prom) {
        this.nombreCarrera = nombreCarrera;
        this.anioInscripcion = fechaInscripcion;
        this.prom = prom;
    }
}