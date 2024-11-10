package Controller;

import DTO.EstudianteDTO;
import Service.EstudianteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    private EstudianteService estudianteService;
    // obtener lista de estudiantes de una carrera ordenados por apellido

    //obtener la informacion de un estudiante especifico por dni.

    //obtener la informacion de un estudiante especifico por libreta universitaria

}
