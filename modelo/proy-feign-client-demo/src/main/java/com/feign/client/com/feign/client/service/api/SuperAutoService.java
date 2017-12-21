package com.feign.client.com.feign.client.service.api;

import com.feign.client.com.feign.client.model.api.SuperAuto;

import java.util.List;

public interface SuperAutoService {

    public SuperAuto consultarDetalle(int id);
    public SuperAuto listadoInventario1();
    public List<SuperAuto> listadoInventario2();
    public SuperAuto retirarAuto(int id);
}
