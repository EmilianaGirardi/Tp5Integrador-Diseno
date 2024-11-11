package com.desarrolladores.Query.Service;

import com.desarrolladores.Query.DTO.CarreraDTO;
import com.desarrolladores.Query.Entity.Carrera;
import com.desarrolladores.Query.Repository.CarreraRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class CarreraService {
    @Autowired
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
