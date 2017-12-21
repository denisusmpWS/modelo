package com.usmp.pe.com.usmp.pe.impl;

import com.usmp.pe.com.usmp.pe.dao.AutoDao;
import com.usmp.pe.com.usmp.pe.model.Auto;
import com.usmp.pe.com.usmp.pe.service.AutoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoServiceImpl implements AutoService {


    private AutoDao dao=new AutoDao();

    @Override
    public List<Auto> listarAutos() {
        return dao.listarAutos();
    }

    @Override
    public Auto consultarAuto(int id) {
        return dao.consultarAuto(id);
    }

    @Override
    public Auto eliminarAuto(int id) {
        return dao.eliminarAuto(id);
    }
}






