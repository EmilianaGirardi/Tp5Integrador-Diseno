package com.desarrolladores.Command.Events;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
public class EstudianteDeletedEvent extends Event {
    private String dniestudiante;
}
