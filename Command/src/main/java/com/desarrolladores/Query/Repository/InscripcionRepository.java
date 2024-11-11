package com.desarrolladores.Query.Repository;

import com.desarrolladores.Query.Embeddable.InscripcionId;
import com.desarrolladores.Query.Entity.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, InscripcionId> {
}
