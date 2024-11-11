package Controller;

import DTO.ReporteCarreraDTO;
import DTO.ReportePromedioInscriptosDTO;
import Service.InscripcionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {
    private InscripcionService inscripcionService;
    //obtener el numero de inscriptos y el numero de egresador por año de una carrera ordenadas por cantidad de egresados
    @GetMapping("/informeIncriptosYEgresadosPorAnioCarrera")
    public ResponseEntity<List<ReporteCarreraDTO>> getInformeInscriptosEgresadosPorAnio(){
        return inscripcionService.getInscriptosYEgresadosPorAnio();
    }

    //obtener el promedio de inscriptos por año de todas las carreras, en orden.
    @GetMapping("/informePromedioIncriptosPorAnioCarrera")
    public ResponseEntity<List<ReportePromedioInscriptosDTO>> getInformeInscriptosAnioCarrera(){
        return inscripcionService.getPromedioInscriptosPorAnio();
    }
}

