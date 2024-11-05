package com.lp2_parcial02.service;

import java.util.List;

import com.lp2_parcial02.entity.Escuela;

public interface EscuelaService {
	
	Escuela saveEscuela(Escuela Escuela);
    List<Escuela> getAllEscuelas();
    Escuela getEscuelaById(Long id);
    Escuela updateEscuela(Escuela Escuela);
    void deleteEscuela(Long id);

}
