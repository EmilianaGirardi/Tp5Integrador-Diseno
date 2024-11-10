package Controller;

import DTO.CarreraInscriptosDTO;
import Service.CarreraService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/carreras")
public class CarreraController {
    private CarreraService carreraService;

    //recuperar las carreras y ordenar por cantidad de inscriptos.
    @GetMapping("/informeIncriptos")
    public ResponseEntity<List<CarreraInscriptosDTO>> getInformeInscriptosCarrera(){
        return carreraService.getCarrerasInscriptos();
    }
}
