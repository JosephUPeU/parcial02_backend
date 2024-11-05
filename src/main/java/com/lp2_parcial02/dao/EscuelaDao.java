package com.lp2_parcial02.dao;

import java.util.List;
import java.util.Optional;

import com.lp2_parcial02.entity.Escuela;

public interface EscuelaDao {
	Escuela create(Escuela a);
	Escuela update(Escuela a);
	void delete(Long id);
	Optional<Escuela> read(Long id);
	List<Escuela> readAll();
}
