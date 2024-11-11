package com.desarrolladores.Query.Entity;

import com.desarrolladores.Query.DTO.EstudianteDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Lombok
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode

@Entity
public class Estudiante implements Serializable {

    @Id
    private String dniestudiante;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "libreta_universitaria", nullable = false)
    private String libretaUniversitaria;

    @Column(nullable = false)
    private char genero;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(nullable = false)
    private String ciudad;

    @OneToMany(mappedBy = "estudiante")
    private List<Inscripcion> inscripciones;

    public Estudiante(EstudianteDTO estudianteDTO){
        this.dniestudiante = estudianteDTO.getDniestudiante();
        this.inscripciones = new ArrayList<>();
        this.ciudad = estudianteDTO.getCiudad();
        this.genero = estudianteDTO.getGenero();
        this.apellido = estudianteDTO.getApellido();
        this.nombre = estudianteDTO.getNombre();
        this.libretaUniversitaria = estudianteDTO.getLibretaUniversitaria();
        this.fechaNacimiento = estudianteDTO.getFechaNacimiento();
    }

}