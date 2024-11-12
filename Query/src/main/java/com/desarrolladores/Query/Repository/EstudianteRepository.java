package com.desarrolladores.Query.Repository;

import com.desarrolladores.Query.DTO.EstudianteDTO;
import com.desarrolladores.Query.Entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, String> {

    //obtener la informacion de un estudiante especifico por dni.
    @Query("SELECT new com.desarrolladores.Query.DTO.EstudianteDTO(e.dniestudiante, e.apellido, e.nombre, e.libretaUniversitaria, e.genero, e.fechaNacimiento, e.ciudad) " +
            "FROM Estudiante e " +
            "WHERE e.dniestudiante = :dni")
    List<EstudianteDTO> getEstudiantePorDNI(@Param("dni") String dni);

    //obtener la informacion de un estudiante especifico por libreta universitaria
    @Query("SELECT new com.desarrolladores.Query.DTO.EstudianteDTO(e.dniestudiante, e.apellido, e.nombre, e.libretaUniversitaria, e.genero, e.fechaNacimiento, e.ciudad) " +
            "FROM Estudiante e " +
            "WHERE e.libretaUniversitaria = :libreta")
    List<EstudianteDTO> getEstudiantePorLibreta(@Param("libreta") String libreta);

    // obtener lista de estudiantes de una carrera ordenados por apellido
    @Query("SELECT new com.desarrolladores.Query.DTO.EstudianteDTO(e.dniestudiante, e.apellido, e.nombre, e.libretaUniversitaria, e.genero, e.fechaNacimiento, e.ciudad) " +
            "FROM Estudiante e " +
            "JOIN Inscripcion i on i.estudiante = e " +
            "WHERE i.carrera.idcarrera = :carrera " +
            "ORDER BY e.apellido")
    List<EstudianteDTO> getEstudiantesDeCarreraXApellido(@Param("carrera") Integer carrera);


}