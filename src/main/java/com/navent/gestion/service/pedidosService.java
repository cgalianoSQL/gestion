package com.navent.gestion.service;

import com.navent.gestion.dao.pedidosDAO;
import com.navent.gestion.models.PedidosModel;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class pedidosService implements pedidosDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public PedidosModel select(Long id) {
        Object value = bumexMemcached.get(String.valueOf(id));

        if (value == null) {
            return entityManager.find(PedidosModel.class, id);

        }

        return (PedidosModel) value;
    }

    @Override
    public void delete(Long id) {
        Object value = bumexMemcached.get(String.valueOf(id));

        if (value == null) {
            PedidosModel pedido = entityManager.find(PedidosModel.class, id);
            entityManager.remove(pedido);

        } else {
            entityManager.remove( (PedidosModel) value);
            bumexMemcached.delete(String.valueOf(id));

        }

    }

    @Override
    public void insertOrUpdate(PedidosModel pedido) {       
        PedidosModel pedidoCreado = entityManager.merge(pedido);
        bumexMemcached.set( String.valueOf(pedidoCreado.getIdPedido()), pedidoCreado);        
    }
    
}
