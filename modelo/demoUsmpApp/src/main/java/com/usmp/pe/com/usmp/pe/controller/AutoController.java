package com.usmp.pe.com.usmp.pe.controller;


import com.usmp.pe.com.usmp.pe.model.Auto;
import com.usmp.pe.com.usmp.pe.service.AutoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/auto",produces = MediaType.APPLICATION_JSON_VALUE)
public class AutoController {


    private final Logger LOG= LoggerFactory.getLogger(AutoController.class);


    @Autowired
    private AutoService service;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public ResponseEntity<List<Auto>> listarAutos(){

        List<Auto> autos=new ArrayList<Auto>();
        try{
            autos=service.listarAutos();
            if(autos.isEmpty() || autos==null){
                return new ResponseEntity<List<Auto>>(HttpStatus.NO_CONTENT);
            }
        }catch(Exception e){
            return new ResponseEntity<List<Auto>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<List<Auto>>(autos,HttpStatus.OK);
    }

    @RequestMapping(value = "/search/{id}",method = RequestMethod.GET)
   public ResponseEntity<Auto> consultarAuto(@PathVariable("id") int id, UriComponentsBuilder builder){

        Auto auto=null;


        try{

            auto=service.consultarAuto(id);
            LOG.info("AUTO CONTROLLER:"+auto);

            if(auto==null){
                return new ResponseEntity<Auto>(HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            return new ResponseEntity<Auto>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setLocation(builder.
                path("/api/auto/search/{id}").
                buildAndExpand(id).toUri());

       return new ResponseEntity<Auto>(auto,httpHeaders,HttpStatus.OK);
   }

   @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
   public ResponseEntity<Auto> eliminarLogicoAuto(@PathVariable("id") String id){

       Auto auto=null;

       try{
           int cod=Integer.parseInt(id);
       }catch(NumberFormatException e){
           return new ResponseEntity<Auto>(HttpStatus.NOT_ACCEPTABLE);
       }

       auto=service.consultarAuto(Integer.parseInt(id));
       if(auto==null){
               return new ResponseEntity<Auto>(HttpStatus.NOT_FOUND);
       }

       try{
           auto=service.eliminarAuto(Integer.parseInt(id));
       }catch(Exception e){
           return new ResponseEntity<Auto>(HttpStatus.INTERNAL_SERVER_ERROR);
       }

       if(auto.getStatus()==0){
           return new ResponseEntity<Auto>(HttpStatus.CONFLICT);
       }

       return new ResponseEntity<Auto>(auto,HttpStatus.OK);
   }

}
