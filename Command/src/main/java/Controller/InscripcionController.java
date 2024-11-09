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

    @PostMapping("/anadirInscripcion")
    public ResponseEntity<String> addInscripcion(@PathVariable String idEstudiante,
                                                 @PathVariable Integer carrera){
        return inscripcionService.addInscripcion(idEstudiante, carrera);
    }
}
