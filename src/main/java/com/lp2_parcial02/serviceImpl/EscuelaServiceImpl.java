package com.lp2_parcial02.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp2_parcial02.dao.EscuelaDao;
import com.lp2_parcial02.entity.Escuela;
import com.lp2_parcial02.service.EscuelaService;

@Service
public class EscuelaServiceImpl implements EscuelaService {

    @Autowired
    private EscuelaDao dao;

    @Override
    public Escuela saveEscuela(Escuela Escuela) {
        return dao.create(Escuela);
    }

    @Override
    public List<Escuela> getAllEscuelas() {
        return dao.readAll();
    }

    @Override
    public Escuela getEscuelaById(Long id) {
        return dao.read(id).orElse(null);
    }

    @Override
    public Escuela updateEscuela(Escuela Escuela) {
        return dao.update(Escuela);
    }

    @Override
    public void deleteEscuela(Long id) {
        dao.delete(id);
    }
}
