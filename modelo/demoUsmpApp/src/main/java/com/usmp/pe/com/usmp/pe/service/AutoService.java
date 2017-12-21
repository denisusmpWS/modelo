package com.usmp.pe.com.usmp.pe.service;

import com.usmp.pe.com.usmp.pe.model.Auto;

import java.util.List;

public interface AutoService {

    public List<Auto> listarAutos();
    public Auto consultarAuto(int id);
    public Auto eliminarAuto(int id);


}
