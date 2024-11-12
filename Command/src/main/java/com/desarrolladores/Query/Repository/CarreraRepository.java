package com.desarrolladores.Query.Repository;

import com.desarrolladores.Query.Entity.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Integer> {
}
