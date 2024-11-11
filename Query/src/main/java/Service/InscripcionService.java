package Service;

import DTO.ReporteCarreraDTO;
import DTO.ReportePromedioInscriptosDTO;

import Repository.CarreraRepository;
import Repository.EstudianteRepository;
import Repository.InscripcionRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class InscripcionService {
    private InscripcionRepository inscripcionRepository;
    private EstudianteRepository estudianteRepository;
    private CarreraRepository carreraRepository;

    //obtener el numero de inscriptos y el numero de egresador por año de una carrera ordenadas por cantidad de egresados
    public ResponseEntity<List<ReporteCarreraDTO>> getInscriptosYEgresadosPorAnio(){
        try {
            ArrayList<ReporteCarreraDTO> respuesta = new ArrayList<>(inscripcionRepository.getInscriptosEgresadosPorAnio());
            return ResponseEntity.ok(respuesta);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(Collections.emptyList());
        }
    }

    //obtener el promedio de inscriptos por año de todas las carreras, en orden.
    public ResponseEntity<List<ReportePromedioInscriptosDTO>> getPromedioInscriptosPorAnio(){
        try {
            ArrayList<ReportePromedioInscriptosDTO> respuesta = new ArrayList<>(inscripcionRepository.getPromedioInscriptosPorAnio());
            return ResponseEntity.ok(respuesta);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(Collections.emptyList());
        }
    }

}


