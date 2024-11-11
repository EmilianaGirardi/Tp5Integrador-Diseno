package DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
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