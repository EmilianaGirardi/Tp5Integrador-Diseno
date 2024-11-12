package com.desarrolladores.Command.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.desarrolladores.Command.Service.InscripcionService;

//@AllArgsConstructor
@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {
    @Autowired
    private InscripcionService inscripcionService;

    @PostMapping("/agregar-inscripcion/id-estudiante/{idEstudiante}/id-carrera/{carrera}")
    public ResponseEntity<String> addInscripcion(@PathVariable String idEstudiante,
                                                 @PathVariable Integer carrera){
        return inscripcionService.addInscripcion(idEstudiante, carrera);
    }

    //informar que un estudiante se graduo de una carrera.
    @PutMapping ("/actualizar-graduado/id-estudiante/{idEstudiante}/id-carrera/{carrera}")
    public ResponseEntity<String> updateGraduado(@PathVariable String idEstudiante,
                                                 @PathVariable Integer carrera){
        return inscripcionService.updateGraduado(idEstudiante, carrera);
    }
}
