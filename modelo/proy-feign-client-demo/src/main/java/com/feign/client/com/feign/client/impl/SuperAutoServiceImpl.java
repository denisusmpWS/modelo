package com.feign.client.com.feign.client.impl;

import com.feign.client.com.feign.client.model.api.SuperAuto;
import com.feign.client.com.feign.client.model.proxy.Auto;
import com.feign.client.com.feign.client.service.api.SuperAutoService;
import com.feign.client.com.feign.client.service.proxy.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuperAutoServiceImpl implements SuperAutoService {

    @Autowired
    private AutoService service;


    @Override
    public SuperAuto consultarDetalle(int id) {

        SuperAuto superAuto = new SuperAuto();
        superAuto.setSuperId(1);
        superAuto.setCategory("4x4");
        Auto auto=service.searchAuto(id);
        List<Auto> autos=new ArrayList<>();
        autos.add(auto);
        superAuto.setAutos(autos);
        superAuto.setSerial("AWT001-41F-4001P90");
        superAuto.setOrganization("CHEVROLET");
        superAuto.setAwt("A001-LIMA");
        return superAuto;
    }

    @Override
    public SuperAuto listadoInventario1() {
        SuperAuto superAuto = new SuperAuto();
        superAuto.setSuperId(1);
        superAuto.setCategory("4x4");
        superAuto.setAutos(service.findAllAuto());
        superAuto.setSerial("AWT001-41F-4001P90");
        superAuto.setOrganization("CHEVROLET");
        superAuto.setAwt("A001-LIMA");
        return superAuto;
    }

    @Override
    public List<SuperAuto> listadoInventario2() {

        List<SuperAuto> superAutos=new ArrayList<>();
        List<Auto> autos=service.findAllAuto();
        SuperAuto superAuto =null;
        //for(Auto auto:autos){
          for(int i=0;i<autos.size();i++){
              superAuto=new SuperAuto();
              superAuto.setSuperId(i+1);
              superAuto.setCategory("4x"+i+1);
              List<Auto> lista=new ArrayList<>();
              lista.add(service.searchAuto(i));
              superAuto.setAutos(lista);
              superAuto.setSerial("AWT001-41F-4001P90"+i);
              superAuto.setOrganization("CHEVROLET"+i);
              superAuto.setAwt("A001-LIMA"+i);
              superAutos.add(superAuto);
           }
        return superAutos;
    }


    @Override
    public SuperAuto retirarAuto(int id) {
        return null;
    }
}
