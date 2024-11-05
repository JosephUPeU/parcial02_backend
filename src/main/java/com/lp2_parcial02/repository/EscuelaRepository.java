package com.lp2_parcial02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lp2_parcial02.entity.Escuela;

@Repository
public interface EscuelaRepository extends JpaRepository<Escuela, Long> {

}
