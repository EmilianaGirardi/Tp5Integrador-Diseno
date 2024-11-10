package Service;

import DTO.CarreraDTO;
import Entity.Carrera;
import Repository.CarreraRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class CarreraService {
    private CarreraRepository carreraRepository;

    //dar de alta una carrera
    public ResponseEntity<String> postCarrera(CarreraDTO carreraDTO){
        Carrera nuevaCarrera = new Carrera(carreraDTO);
        try {
            carreraRepository.save(nuevaCarrera);
            return ResponseEntity.ok().body("Carrera agregada con éxito");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Error al guardar carrera " + e.getMessage());
        }
    }
}
