package com.desarrolladores.Query.DTO;

import lombok.*;

@Data
public class CarreraInscriptosDTO {
    private Integer idCarrera;
    private String nombreCarrera;
    private Long cantidadInscriptos;

    public CarreraInscriptosDTO(Integer idCarrera, String nombre, Long cantidadInscriptos) {
        this.idCarrera = idCarrera;
        this.nombreCarrera = nombre;
        this.cantidadInscriptos = cantidadInscriptos;
    }
}
