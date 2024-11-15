package com.desarrolladores.Query.Service;

import com.desarrolladores.Query.DTO.CarreraInscriptosDTO;
import com.desarrolladores.Query.Repository.CarreraRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CarreraService {
    @Autowired
    private CarreraRepository carreraRepository;

    //recuperar las carreras y ordenar por cantidad de inscriptos.
    public ResponseEntity<List<CarreraInscriptosDTO>> getCarrerasInscriptos(){
        try {
            ArrayList<CarreraInscriptosDTO> respuesta = new ArrayList<>(carreraRepository.getCarrerasInscriptos());
            return ResponseEntity.ok(respuesta);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(Collections.emptyList());
        }
    }


}
