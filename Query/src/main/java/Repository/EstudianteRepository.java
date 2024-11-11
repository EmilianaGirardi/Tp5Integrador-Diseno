package Repository;

import DTO.EstudianteDTO;
import Entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, String> {

    //obtener la informacion de un estudiante especifico por dni.
    @Query("SELECT new EstudianteDTO(e.dniEstudiante, e.apellido, e.nombre, e.libreta_universitaria, e.genero, e.fecha_nacimiento, e.ciudad) " +
            "FROM estudiante e " +
            "WHERE e.dniEstudiante = :dni")
    List<EstudianteDTO> getEstudiantePorDNI(@Param("dni") String dni);

    //obtener la informacion de un estudiante especifico por libreta universitaria
    @Query("SELECT new EstudianteDTO(e.dniEstudiante, e.apellido, e.nombre, e.libreta_universitaria, e.genero, e.fecha_nacimiento, e.ciudad) " +
            "FROM estudiante e " +
            "WHERE e.libreta_universitaria = :libreta")
    List<EstudianteDTO> getEstudiantePorLibreta(@Param("libreta") String libreta);

    // obtener lista de estudiantes de una carrera ordenados por apellido
    @Query("SELECT new EstudianteDTO(e.dniEstudiante, e.apellido, e.nombre, e.libreta_universitaria, e.genero, e.fecha_nacimiento, e.ciudad) " +
            "FROM Estudiante e " +
            "JOIN e.inscripciones i " +
            "WHERE i.carrera.id = :carrera " +
            "ORDER BY e.apellido")
    List<EstudianteDTO> getEstudiantesDeCarreraXApellido(@Param("carrera") String carrera);
}