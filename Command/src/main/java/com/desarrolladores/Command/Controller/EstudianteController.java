package com.desarrolladores.Command.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.desarrolladores.Command.DTO.EstudianteDTO;
import com.desarrolladores.Command.Service.EstudianteService;

//@AllArgsConstructor
@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @PostMapping("/agregar")
    public ResponseEntity<String> postEstudiante(@RequestBody EstudianteDTO estudianteDTO){
       return estudianteService.addEstudiante(estudianteDTO);
    }

    @PutMapping("/modificarEstudiante")
    public ResponseEntity<String> modificarEstudiante(@RequestBody EstudianteDTO estudianteDTO){
        return estudianteService.addEstudiante(estudianteDTO);
    }
}
