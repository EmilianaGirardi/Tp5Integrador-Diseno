package Service;

import Entity.Carrera;
import Entity.Estudiante;
import Entity.Inscripcion;
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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class InscripcionService {
    private InscripcionRepository inscripcionRepository;
    private EstudianteRepository estudianteRepository;
    private CarreraRepository carreraRepository;
}
