package DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarreraInscriptosDTO {
    private Integer idCarrera;
    private String nombreCarrera;
    private Integer cantidadInscriptos;
}
