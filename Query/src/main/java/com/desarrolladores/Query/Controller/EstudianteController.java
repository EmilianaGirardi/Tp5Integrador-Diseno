package com.desarrolladores.Query.Controller;

import com.desarrolladores.Query.DTO.EstudianteDTO;
import com.desarrolladores.Query.Service.EstudianteService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@AllArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    // obtener lista de estudiantes de una carrera ordenados por apellido
    @GetMapping("/estudiantesDeCarreraXApellido/{carrera}")
    public ResponseEntity<List<EstudianteDTO>> getEstudiantesDeCarreraXApellido(@PathVariable Integer carrera){ //TODO: el PathVariable va o no?
        return estudianteService.getEstudiantesDeCarreraXApellido(carrera);
    }

    //obtener la informacion de un estudiante especifico por dni.
    @GetMapping("/estudiantePorDNI/{dni}")
    public ResponseEntity<List<EstudianteDTO>> getEstudiantePorDNI(@PathVariable String dni){ //TODO: el PathVariable va o no?
        return estudianteService.getEstudiantePorDNI(dni);
    }

    //obtener la informacion de un estudiante especifico por libreta universitaria
    @GetMapping("/estudiantePorLibreta/{libreta}")
    public ResponseEntity<List<EstudianteDTO>> getEstudiantePorLibreta(@PathVariable String libreta){ //TODO: el PathVariable va o no?
        return estudianteService.getEstudiantePorDNI(libreta);
    }



}
