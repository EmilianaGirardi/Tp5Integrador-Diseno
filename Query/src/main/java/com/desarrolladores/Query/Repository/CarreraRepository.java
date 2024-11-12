package com.desarrolladores.Query.Repository;

import com.desarrolladores.Query.DTO.CarreraInscriptosDTO;
import com.desarrolladores.Query.Entity.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Integer> {
    //recuperar las carreras y ordenar por cantidad de inscriptos.
    @Query("SELECT new com.desarrolladores.Query.DTO.CarreraInscriptosDTO(c.idcarrera, c.nombre, count(i)) " +
            "FROM Carrera c " +
            "JOIN Inscripcion i on c = i.carrera " +
            "GROUP BY c.idcarrera, c.nombre " +
            "ORDER BY count(i) DESC")
    List<CarreraInscriptosDTO> getCarrerasInscriptos();


}
