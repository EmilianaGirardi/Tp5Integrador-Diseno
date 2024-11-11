package Service;

import DTO.CarreraInscriptosDTO;
import DTO.EstudianteDTO;
import Entity.Estudiante;
import Repository.EstudianteRepository;
import Repository.InscripcionRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class EstudianteService {
    private EstudianteRepository estudianteRepository;
    private InscripcionRepository inscripcionRepository;

    // obtener lista de estudiantes de una carrera ordenados por apellido
    public ResponseEntity<List<EstudianteDTO>> getEstudiantesDeCarreraXApellido(String carrera){
        try {
            ArrayList<EstudianteDTO> respuesta = new ArrayList<>(estudianteRepository.getEstudiantesDeCarreraXApellido(carrera));
            return ResponseEntity.ok(respuesta);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(Collections.emptyList());
        }
    }


    //obtener la informacion de un estudiante especifico por dni.
    public ResponseEntity<List<EstudianteDTO>> getEstudiantePorDNI(String dni){
        try {
            ArrayList<EstudianteDTO> respuesta = new ArrayList<>(estudianteRepository.getEstudiantePorDNI(dni));
            return ResponseEntity.ok(respuesta);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(Collections.emptyList());
        }
    }

    //obtener la informacion de un estudiante especifico por libreta universitaria
    public ResponseEntity<List<EstudianteDTO>> getEstudiantePorLibreta(String libreta){
        try {
            ArrayList<EstudianteDTO> respuesta = new ArrayList<>(estudianteRepository.getEstudiantePorLibreta(libreta));
            return ResponseEntity.ok(respuesta);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(Collections.emptyList());
        }
    }
}
