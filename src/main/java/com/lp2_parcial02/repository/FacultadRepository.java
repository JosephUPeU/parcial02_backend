package com.lp2_parcial02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lp2_parcial02.entity.Facultad;

@Repository
public interface FacultadRepository extends JpaRepository<Facultad, Long> {
	
}
