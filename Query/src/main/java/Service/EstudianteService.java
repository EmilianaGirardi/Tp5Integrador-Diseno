package Service;

import DTO.EstudianteDTO;
import Entity.Estudiante;
import Repository.EstudianteRepository;
import Repository.InscripcionRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class EstudianteService {
    private EstudianteRepository estudianteRepository;
    private InscripcionRepository inscripcionRepository;

    // obtener lista de estudiantes de una carrera ordenados por apellido

    //obtener la informacion de un estudiante especifico por dni.

    //obtener la informacion de un estudiante especifico por libreta universitaria

}
