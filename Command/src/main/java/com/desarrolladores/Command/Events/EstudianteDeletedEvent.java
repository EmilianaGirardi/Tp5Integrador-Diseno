package com.desarrolladores.Command.Events;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EstudianteDeletedEvent extends Event {
    private String dniestudiante;
}
