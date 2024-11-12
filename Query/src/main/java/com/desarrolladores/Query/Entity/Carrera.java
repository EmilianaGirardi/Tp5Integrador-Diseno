package com.desarrolladores.Query.Entity;

import com.desarrolladores.Query.DTO.CarreraDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Carrera implements Serializable {
    @Id
    private Integer idcarrera;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "carrera")
    private List<Inscripcion> inscripciones;

    public Carrera(CarreraDTO carreraDTO){
        this.idcarrera = carreraDTO.getIdcarrera();
        this.nombre = carreraDTO.getNombre();
        this.inscripciones = new ArrayList<>();
    }

}