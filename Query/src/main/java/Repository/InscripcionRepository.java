package Repository;

import DTO.ReporteCarreraDTO;
import DTO.ReportePromedioInscriptosDTO;
import Embeddable.InscripcionId;
import Entity.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, InscripcionId> {
    //obtener el numero de inscriptos y el numero de egresador por año de una carrera ordenadas por cantidad de egresados
    @Query("SELECT new ReporteCarreraDTO(c.nombre, " +
            "EXTRACT(YEAR FROM i.fechaInscripcion), " +
            "COUNT(i.estudiante.dniestudiante), " +
            "SUM(CASE WHEN i.graduado = true THEN 1 ELSE 0 END)) " +
            "FROM Carrera c " +
            "INNER JOIN Inscripcion i ON c.idcarrera = i.carrera.idcarrera " +
            "GROUP BY c.nombre, EXTRACT(YEAR FROM i.fechaInscripcion) " +
            "ORDER BY c.nombre ASC, EXTRACT(YEAR FROM i.fechaInscripcion) ASC")
    List<ReporteCarreraDTO> getInscriptosEgresadosPorAnio();


    //obtener el promedio de inscriptos por año de todas las carreras, en orden.
    // ACÁ CREO QUE HAY QUE HACER OTRO DTO PORQUE EN ESTE CASO NO INCLUIRÍA EL AÑO
    // ESTA QUERY ES EN JPQL PORQUE EN JPQL NO SE SI FUNCIONA EL YEAR(DATE)
    @Query("SELECT new ReportePromedioInscriptosDTO(c.nombre, EXTRACT(YEAR from i.fechaInscripcion), avg(i), 0) " +
            "FROM carrera c " +
            "JOIN incripcion i on c = i.id.carrera" +
            "GROUP BY c.idcarrera, EXTRACT(YEAR from i.fechaInscripcion)" +
            "ORDER BY avg(i) DESC")
    List<ReportePromedioInscriptosDTO> getPromedioInscriptosPorAnio();
}
