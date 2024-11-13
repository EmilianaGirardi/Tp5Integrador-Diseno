package com.desarrolladores.Query.Controller;

import com.desarrolladores.Query.DTO.ReporteCarreraDTO;
import com.desarrolladores.Query.DTO.ReportePromedioInscriptosDTO;
import com.desarrolladores.Query.Service.InscripcionService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {
    @Autowired
    private InscripcionService inscripcionService;

    //obtener el numero de inscriptos y el numero de egresador por año de una carrera ordenadas por cantidad de egresados
    @GetMapping("/informeIncriptosYEgresadosPorAnioCarrera")
    public ResponseEntity<List<ReporteCarreraDTO>> getInformeInscriptosEgresadosPorAnio(){
        return inscripcionService.getInscriptosYEgresadosPorAnio();
    }

}

