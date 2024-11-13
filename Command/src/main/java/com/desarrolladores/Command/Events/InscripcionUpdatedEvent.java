package com.desarrolladores.Command.Events;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
public class InscripcionUpdatedEvent extends Event {

    private String idEstudiante;
    private Integer idCarrera;
}
