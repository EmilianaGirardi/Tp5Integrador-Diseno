package com.desarrolladores.Command.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desarrolladores.Command.Entity.Carrera;



@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Integer> {
}
