package com.lp2_parcial02.dao;

import java.util.List;
import java.util.Optional;

import com.lp2_parcial02.entity.Facultad;

public interface FacultadDao {
	Facultad create(Facultad a);
	Facultad update(Facultad a);
	void delete(Long id);
	Optional<Facultad> read(Long id);
	List<Facultad> readAll();
}
