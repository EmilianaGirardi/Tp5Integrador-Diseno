package Controller;

import DTO.CarreraDTO;
import Service.CarreraService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/carreras")
public class CarreraController {
    private CarreraService carreraService;

    //dar de alta una carrera
    @PostMapping("/agregar")
    public ResponseEntity<String> agregarCarrera(@RequestBody CarreraDTO carreraDTO){
        return carreraService.postCarrera(carreraDTO);
    }
}
