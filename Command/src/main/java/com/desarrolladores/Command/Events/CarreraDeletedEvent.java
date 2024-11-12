package com.desarrolladores.Command.Events;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarreraDeletedEvent extends Event {
    private Integer idcarrera;
}
