package com.desarrolladores.Query.Service;

import com.desarrolladores.Query.DTO.ReporteCarreraDTO;
import com.desarrolladores.Query.DTO.ReportePromedioInscriptosDTO;

import com.desarrolladores.Query.Repository.CarreraRepository;
import com.desarrolladores.Query.Repository.EstudianteRepository;
import com.desarrolladores.Query.Repository.InscripcionRepository;
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
import org.springframework.kafka.annotation.KafkaListener;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class InscripcionService {
    @Autowired
    private InscripcionRepository inscripcionRepository;
    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private CarreraRepository carreraRepository;

    //obtener el numero de inscriptos y el numero de egresador por año de una carrera ordenadas por cantidad de egresados
    public ResponseEntity<List<ReporteCarreraDTO>> getInscriptosYEgresadosPorAnio(){
        try {
            ArrayList<ReporteCarreraDTO> respuesta = new ArrayList<>(inscripcionRepository.getInscriptosEgresadosPorAnio());
            return ResponseEntity.ok(respuesta);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(Collections.emptyList());
        }
    }

    //obtener el promedio de inscriptos por año de todas las carreras, en orden.
    public ResponseEntity<List<ReportePromedioInscriptosDTO>> getPromedioInscriptosPorAnio(){
        try {
            ArrayList<ReportePromedioInscriptosDTO> respuesta = new ArrayList<>();
                    //(inscripcionRepository.getPromedioInscriptosPorAnio());
            return ResponseEntity.ok(respuesta);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(Collections.emptyList());
        }
    }


}


