package com.lp2_parcial02.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp2_parcial02.dao.FacultadDao;
import com.lp2_parcial02.entity.Facultad;
import com.lp2_parcial02.service.FacultadService;

@Service
public class FacultadServiceImpl implements FacultadService {

    @Autowired
    private FacultadDao dao;

    @Override
    public Facultad saveFacultad(Facultad Facultad) {
        return dao.create(Facultad);
    }

    @Override
    public List<Facultad> getAllFacultads() {
        return dao.readAll();
    }

    @Override
    public Facultad getFacultadById(Long id) {
        return dao.read(id).orElse(null);
    }

    @Override
    public Facultad updateFacultad(Facultad Facultad) {
        return dao.update(Facultad);
    }

    @Override
    public void deleteFacultad(Long id) {
        dao.delete(id);
    }
}
