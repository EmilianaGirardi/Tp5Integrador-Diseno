package Controller;

import Service.CarreraService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/carreras")
public class CarreraController {
    private CarreraService carreraService;
    //metodos que leen de la base
}
