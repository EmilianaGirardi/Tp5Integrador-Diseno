package com.desarrolladores.Command.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import com.desarrolladores.Command.Events.*;
import com.desarrolladores.Command.Entity.Carrera;
import com.desarrolladores.Command.DTO.CarreraDTO;
import com.desarrolladores.Command.Repository.CarreraRepository;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class CarreraService {
    private EventStore writeRepository;

    //dar de alta una carrera
    public ResponseEntity<String> postCarrera(CarreraDTO carreraDTO){
        Event event = new CarreraCreatedEvent(carreraDTO.getIdcarrera(), carreraDTO.getNombre()); // Se crea el evento
        //Carrera nuevaCarrera = new Carrera(carreraDTO);
        try {
            writeRepository.addEvent(event); // Se agrega a la lista de eventos
            return ResponseEntity.ok().body("Carrera agregada con éxito");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Error al guardar carrera " + e.getMessage());
        }
    }
}
