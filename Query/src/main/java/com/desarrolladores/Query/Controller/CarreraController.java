package com.desarrolladores.Query.Controller;

import com.desarrolladores.Query.DTO.CarreraInscriptosDTO;
import com.desarrolladores.Query.Service.CarreraService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/carreras")
public class CarreraController {
    @Autowired
    private CarreraService carreraService;

    //recuperar las carreras y ordenar por cantidad de inscriptos.
    @GetMapping("/informeInscriptos")
    public ResponseEntity<List<CarreraInscriptosDTO>> getInformeInscriptosCarrera(){
        return carreraService.getCarrerasInscriptos();
    }

}
