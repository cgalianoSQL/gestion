package com.navent.gestion.dao;

import com.navent.gestion.models.PedidosModel;


public interface pedidosDAO {

    PedidosModel select(Long id);

    void delete(Long id);

    void insertOrUpdate(PedidosModel pedido);
    
}
