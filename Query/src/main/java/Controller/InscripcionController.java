package Controller;

import Service.InscripcionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {
    private InscripcionService inscripcionService;
    //obtener el numero de inscriptos y el numero de egresador por año de una carrera ordenadas por cantidad de egresados

    //obtener el promedio de inscriptos por año de todas las carreras, en orden.
}
