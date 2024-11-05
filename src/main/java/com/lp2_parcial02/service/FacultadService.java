package com.lp2_parcial02.service;

import java.util.List;

import com.lp2_parcial02.entity.Facultad;

public interface FacultadService {
	
	Facultad saveFacultad(Facultad Facultad);
    List<Facultad> getAllFacultads();
    Facultad getFacultadById(Long id);
    Facultad updateFacultad(Facultad Facultad);
    void deleteFacultad(Long id);

}
