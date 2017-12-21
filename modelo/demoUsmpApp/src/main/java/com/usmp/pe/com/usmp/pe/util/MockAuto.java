package com.usmp.pe.com.usmp.pe.util;

import com.usmp.pe.com.usmp.pe.model.Auto;

import java.util.ArrayList;
import java.util.List;

public class MockAuto {

    public final static List<Auto> autos=new ArrayList<>();
    Auto auto=null;
    public void llenarAutos(){

        for(int i=0;i<20;i++){
            auto=new Auto();
            auto.setId(i);
            auto.setName("Auto " + i);
            auto.setStatus(0);
            auto.setCode("A000-"+i);
            auto.setMark("MARCA-"+i);

            autos.add(auto);


        }

    }
}
