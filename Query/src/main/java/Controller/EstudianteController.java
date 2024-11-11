package Controller;

import DTO.CarreraInscriptosDTO;
import DTO.EstudianteDTO;
import Service.EstudianteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    private EstudianteService estudianteService;
    // obtener lista de estudiantes de una carrera ordenados por apellido
    @GetMapping("/estudiantesDeCarreraXApellido{idCarrera}")
    public ResponseEntity<List<EstudianteDTO>> getEstudiantesDeCarreraXApellido(@PathVariable String carrera){ //TODO: el PathVariable va o no?
        return estudianteService.getEstudiantesDeCarreraXApellido(carrera);
    }

    //obtener la informacion de un estudiante especifico por dni.
    @GetMapping("/estudiantePorDNI{dni}")
    public ResponseEntity<List<EstudianteDTO>> getEstudiantePorDNI(@PathVariable String dni){ //TODO: el PathVariable va o no?
        return estudianteService.getEstudiantePorDNI(dni);
    }

    //obtener la informacion de un estudiante especifico por libreta universitaria
    @GetMapping("/estudiantePorLibreta{libreta_universitaria}")
    public ResponseEntity<List<EstudianteDTO>> getEstudiantePorLibreta(@PathVariable String libreta){ //TODO: el PathVariable va o no?
        return estudianteService.getEstudiantePorDNI(libreta);
    }
}
