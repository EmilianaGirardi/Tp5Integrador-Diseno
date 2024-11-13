package com.desarrolladores.Query.Service;

import com.desarrolladores.Query.DTO.EstudianteDTO;
import com.desarrolladores.Query.Entity.Estudiante;
import com.desarrolladores.Query.Repository.EstudianteRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    public ResponseEntity<String> addEstudiante(EstudianteDTO estudianteDTO){
        try {
            Estudiante nuevoEstudiante = new Estudiante(estudianteDTO);
            estudianteRepository.save(nuevoEstudiante);
            return ResponseEntity.ok("Estudiante guardado con exito");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
            body("Error al guardar estudiante " + e.getMessage());
        }
    }

    public ResponseEntity<String> modificarEstudiante(EstudianteDTO estudianteDTO){
        try {
            Estudiante nuevoEstudiante = new Estudiante(estudianteDTO);
            Optional<Estudiante> estudiante = estudianteRepository.findById(estudianteDTO.getDniestudiante());
            if (estudiante.isPresent()) {
                estudianteRepository.save(nuevoEstudiante);
                return ResponseEntity.ok("Estudiante modificado con exito");
            }
            return ResponseEntity.badRequest().body("No existe el estudiante");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Error al modificar estudiante " + e.getMessage());
        }
    }
}
