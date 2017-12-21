package com.feign.client.com.feign.client.controller;

import com.feign.client.com.feign.client.model.api.SuperAuto;
import com.feign.client.com.feign.client.model.proxy.Auto;
import com.feign.client.com.feign.client.service.api.SuperAutoService;
import com.feign.client.com.feign.client.service.proxy.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;
//${context-path} = variable config server
@RestController
@RequestMapping(value = "${context-path}",produces = MediaType.APPLICATION_JSON_VALUE)
public class SuperAutoController {

    @Autowired
    private SuperAutoService superAutoService;

    @RequestMapping(value = "/search2/{id}",method = RequestMethod.GET)
    public ResponseEntity<SuperAuto> getAuto(@PathVariable("id") int id) {
        SuperAuto superAuto=superAutoService.consultarDetalle(id);
        return new ResponseEntity<SuperAuto>(superAuto, HttpStatus.OK);
    }

    @RequestMapping(value = "/all1",method = RequestMethod.GET)
    public ResponseEntity<SuperAuto> getAuto() {
        SuperAuto superAuto=superAutoService.listadoInventario1();
        return new ResponseEntity<SuperAuto>(superAuto, HttpStatus.OK);
    }

    @RequestMapping(value = "/all2",method = RequestMethod.GET)
    public ResponseEntity<List<SuperAuto>> getAuto2(){
        List<SuperAuto> superAutos=superAutoService.listadoInventario2();
        return new ResponseEntity<List<SuperAuto>>(superAutos,HttpStatus.OK);
    }

}
