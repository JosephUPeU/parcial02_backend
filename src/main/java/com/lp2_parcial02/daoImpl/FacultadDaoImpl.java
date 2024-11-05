package com.lp2_parcial02.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lp2_parcial02.dao.FacultadDao;
import com.lp2_parcial02.entity.Facultad;
import com.lp2_parcial02.repository.FacultadRepository;

@Component
public class FacultadDaoImpl implements FacultadDao{

	@Autowired
	private FacultadRepository repository;
	
	@Override
	public Facultad create(Facultad a) {
		// TODO Auto-generated method stub
		return repository.save(a);
	}

	@Override
	public Facultad update(Facultad a) {
		// TODO Auto-generated method stub
		return repository.save(a);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public Optional<Facultad> read(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<Facultad> readAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
}
