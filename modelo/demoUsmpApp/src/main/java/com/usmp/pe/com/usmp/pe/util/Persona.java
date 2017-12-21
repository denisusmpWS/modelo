package com.usmp.pe.com.usmp.pe.util;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Persona {


    private int id;
    private String nombre;
    private int estado;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Persona(int id, String nombre, int estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Persona() {

    }
}
