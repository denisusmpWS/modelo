package com.usmp.pe.com.usmp.pe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
    @RequestMapping("/")
    public String getHome(){
        return "index";
    }


}
