package com.navent.gestion.controller;

import com.navent.gestion.controller.pedidosController;

import com.navent.gestion.dao.pedidosDAO;
import com.navent.gestion.models.PedidosModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.*;

@RestController
public class pedidosController {

    @Autowired
    private pedidosDAO pedidosDAO;

    @RequestMapping(value = "api/pedidos", method = RequestMethod.POST)
    public String insertOrUpdate(@RequestBody PedidosModel pedido) {
        pedidosDAO.insertOrUpdate(pedido);
        return "Se mdoifico/creo con exito";
    }

    @RequestMapping(value = "api/pedidos/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id) {
        pedidosDAO.delete(id);
        return "Se elimino con exito";

    }

    @RequestMapping(value = "api/pedidos/{id}", method = RequestMethod.GET)
    public PedidosModel select(@PathVariable Long id) {
        return pedidosDAO.select(id);
    }
    
}
