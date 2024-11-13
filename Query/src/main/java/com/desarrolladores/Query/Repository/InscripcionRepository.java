package com.desarrolladores.Query.Repository;

import com.desarrolladores.Query.DTO.ReporteCarreraDTO;
import com.desarrolladores.Query.DTO.ReportePromedioInscriptosDTO;
import com.desarrolladores.Query.Embeddable.InscripcionId;
import com.desarrolladores.Query.Entity.Carrera;
import com.desarrolladores.Query.Entity.Estudiante;
import com.desarrolladores.Query.Entity.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, InscripcionId> {
    //obtener el numero de inscriptos y el numero de egresador por año de una carrera ordenadas por cantidad de egresados
    @Query("SELECT new com.desarrolladores.Query.DTO.ReporteCarreraDTO(c.nombre, " +
            "EXTRACT(YEAR FROM i.fechaInscripcion), " +
            "COUNT(i.estudiante.dniestudiante), " +
            "SUM(CASE WHEN i.graduado = true THEN 1 ELSE 0 END)) " +
            "FROM Carrera c " +
            "INNER JOIN Inscripcion i ON c.idcarrera = i.carrera.idcarrera " +
            "GROUP BY c.nombre, EXTRACT(YEAR FROM i.fechaInscripcion) " +
            "ORDER BY c.nombre ASC, EXTRACT(YEAR FROM i.fechaInscripcion) ASC")
    List<ReporteCarreraDTO> getInscriptosEgresadosPorAnio();

    Optional<Inscripcion> findByEstudianteAndCarrera(Estudiante estudiante, Carrera carrera);


    //obtener el promedio de inscriptos por año de todas las carreras, en orden.
   /* @Query("SELECT new com.desarrolladores.Query.DTO.ReportePromedioInscriptosDTO(c.nombre, EXTRACT(YEAR from i.fechaInscripcion), avg(i)) " +
            "FROM Carrera c " +
            "JOIN Inscripcion i on c = i.carrera " +
            "GROUP BY c.idcarrera, EXTRACT(YEAR from i.fechaInscripcion)" +
            "ORDER BY avg(i) DESC")
    List<ReportePromedioInscriptosDTO> getPromedioInscriptosPorAnio();

 */

}
