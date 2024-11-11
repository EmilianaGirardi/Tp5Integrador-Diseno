package DTO;

import Entity.Inscripcion;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

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
    @JsonIgnore
    private List<Inscripcion> inscripciones;
}
