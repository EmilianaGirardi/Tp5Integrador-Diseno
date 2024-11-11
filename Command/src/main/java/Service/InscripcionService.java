package Service;

import Embeddable.InscripcionId;
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
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class InscripcionService {
    private InscripcionRepository inscripcionRepository;
    private EstudianteRepository estudianteRepository;
    private CarreraRepository carreraRepository;


    public ResponseEntity<String> addInscripcion(String idEstudiante, Integer idCarrera){
            Estudiante estudiante = estudianteRepository.getById(idEstudiante);
            if (estudiante == null){ return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El estudiante no existe");}
            else {
                Carrera carrera = carreraRepository.getById(idCarrera);
                if (carrera == null){ return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La carrera no existe");}
                else{
                    Inscripcion nuevaInscripcion = new Inscripcion(carrera, estudiante, LocalDate.now(), false);
                    try {
                        inscripcionRepository.save(nuevaInscripcion);
                        return ResponseEntity.ok("Inscripcion añadida correctamente");
                    }
                    catch (Exception e){
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar inscripcion");
                    }
                }
            }
    }

    //informar que un estudiante se graduo de una carrera.
    public ResponseEntity<String> updateGraduado(String idEstudiante, Integer idCarrera) {
        Estudiante estudiante = estudianteRepository.getById(idEstudiante);
        if (estudiante == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El estudiante no existe");
        } else {
            Carrera carrera = carreraRepository.getById(idCarrera);
            if (carrera == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La carrera no existe");
            } else {
                InscripcionId id = new InscripcionId(carrera, estudiante);
                Optional<Inscripcion> inscripcion = inscripcionRepository.findById(id);
                if (inscripcion.isPresent()) {
                    inscripcion.get().setGraduado(true);
                    try {
                        inscripcionRepository.save(inscripcion.get());
                        return ResponseEntity.ok("Actualizacion de graduado exitosa");
                    } catch (Exception e) {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al graduar estudiante");
                    }


                } else
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error encontrar la inscripcion");
            }
        }
    }
}
