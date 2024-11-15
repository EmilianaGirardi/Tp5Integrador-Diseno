package com.desarrolladores.Query.Controller;

import com.desarrolladores.Query.Service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@AllArgsConstructor
@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {
    @Autowired
    private InscripcionService inscripcionService;

    @PostMapping("/agregarInscripcion/{idEstudiante}/{carrera}")
    public ResponseEntity<String> addInscripcion(@PathVariable String idEstudiante,
                                                 @PathVariable Integer carrera){
        return inscripcionService.addInscripcion(idEstudiante, carrera);
    }

    //informar que un estudiante se graduo de una carrera.
    @PutMapping ("/actualizarGraduado/{idEstudiante}/{carrera}")
    public ResponseEntity<String> updateGraduado(@PathVariable String idEstudiante,
                                                 @PathVariable Integer carrera){
        return inscripcionService.updateGraduado(idEstudiante, carrera);
    }
}
