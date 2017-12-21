package com.usmp.pe.com.usmp.pe.dao;

import com.usmp.pe.com.usmp.pe.model.Auto;
import com.usmp.pe.com.usmp.pe.util.MockAuto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AutoDao extends MockAuto {

    @Autowired
    MockAuto mockAuto = new MockAuto();

    public Auto consultarAuto(int id) {

        Auto auto = new Auto();
        for (int i = 0; i < autos.size(); i++) {
            if (autos.get(i).getId() == id) {
                auto = autos.get(id);
                System.out.println("objeto auto dao:"+auto);
                break;
            }
        }
        return auto;
    }


    public void llenarAutos() {
        mockAuto.llenarAutos();
    }

    public List<Auto> listarAutos(){
        llenarAutos();
        List<Auto> autos2=new ArrayList<>();
        autos2=autos;
        return autos2;
    }



    public Auto eliminarAuto(int id){

        Auto auto=new Auto();

        for(int i=0;i<autos.size();i++){
            if(autos.get(i).getId()==id){
                autos.get(i).setStatus(1);
                auto=consultarAuto(id);
                break;
            }
        }

        return auto;
    }

}
