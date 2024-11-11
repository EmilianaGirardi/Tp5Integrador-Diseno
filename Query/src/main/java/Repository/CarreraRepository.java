package Repository;

import DTO.CarreraInscriptosDTO;
import Entity.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Integer> {
    //recuperar las carreras y ordenar por cantidad de inscriptos.
    @Query("SELECT new CarreraInscriptosDTO(c.idcarrera, c.nombre, count(i)) " +
            "FROM carrera c " +
            "JOIN incripcion i on c = i.id.carrera" +
            "GROUP BY c.idcarerra, c.nombre" +
            "ORDER BY count(i) DESC")
    List<CarreraInscriptosDTO> getCarrerasInscriptos();
}
