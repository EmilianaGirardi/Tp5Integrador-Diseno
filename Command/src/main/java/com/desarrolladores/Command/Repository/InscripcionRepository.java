package com.desarrolladores.Command.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desarrolladores.Command.Embeddable.InscripcionId;
import com.desarrolladores.Command.Entity.Inscripcion;


@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, InscripcionId> {
}
