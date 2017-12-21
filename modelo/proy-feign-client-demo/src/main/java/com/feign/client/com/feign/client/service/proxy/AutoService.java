package com.feign.client.com.feign.client.service.proxy;

;
import com.feign.client.com.feign.client.config.AutoServiceClientConfig;


import com.feign.client.com.feign.client.model.proxy.Auto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//@FeignClient(name = "demoUsmpApp", configuration = AutoServiceClientConfig.class)
/* name= si usamos a eureka como descubirdor, url= si no usamos a eureka y llamamos de forma directa la api*/
@FeignClient(name = "demoUsmpApp",
                fallbackFactory = AutoServiceFallbackFactory.class,
                configuration = AutoServiceClientConfig.class)
public interface AutoService {


    @RequestMapping(value = "/api/auto/all",method = RequestMethod.GET)
    public List<Auto> findAllAuto();

    @RequestMapping(value = "/api/auto/search/{id}",method = RequestMethod.GET)
    public Auto searchAuto(@PathVariable("id") int id);

    @RequestMapping(value = "/api/auto/delete/{id}",method = RequestMethod.GET)
    public Auto deleteAuto(@PathVariable("id") int id);



}


