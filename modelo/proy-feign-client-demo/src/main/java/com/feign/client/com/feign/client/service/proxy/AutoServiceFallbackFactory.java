package com.feign.client.com.feign.client.service.proxy;


import com.feign.client.com.feign.client.model.proxy.Auto;
import com.feign.client.com.feign.client.service.proxy.AutoService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AutoServiceFallbackFactory implements AutoService {


    @Override
    public List<Auto> findAllAuto() {
        List<Auto> autos=new ArrayList<>();
        return autos;
    }

    @Override
    public Auto searchAuto(int id) {
        Auto auto=new Auto();
        return auto;
    }

    @Override
    public Auto deleteAuto(int id) {
        Auto auto=new Auto();
        return auto;
    }

}



