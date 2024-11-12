package com.desarrolladores.Command.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrolladores.Command.DTO.CarreraDTO;
import com.desarrolladores.Command.Service.CarreraService;

//@AllArgsConstructor
@RestController
@RequestMapping("/carreras")
public class CarreraController {
    @Autowired
    private CarreraService carreraService;

    //dar de alta una carrera
    @PostMapping("/agregar")
    public ResponseEntity<String> agregarCarrera(@RequestBody CarreraDTO carreraDTO){
        return carreraService.postCarrera(carreraDTO);
    }
}
