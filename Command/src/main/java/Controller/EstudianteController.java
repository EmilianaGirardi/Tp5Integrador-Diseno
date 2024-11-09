package Controller;

import DTO.EstudianteDTO;
import Service.EstudianteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    private EstudianteService estudianteService;

    @PostMapping("/anadir")
    public ResponseEntity<String> postEstudiante(@RequestBody EstudianteDTO estudianteDTO){
       return estudianteService.addEstudiante(estudianteDTO);
    }

    @PutMapping("/modificarEstudiante")
    public ResponseEntity<String> modificarEstudiante(@RequestBody EstudianteDTO estudianteDTO){
        return estudianteService.addEstudiante(estudianteDTO);
    }
}
