package com.navent.gestion.models;

import javax.persistence.*;

@Entity
@Table(name = "pedido")
public class PedidosModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id_pedido")
    private Long idPedido;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "monto")
    private Double monto;

    @Column(name = "descuento")
    private Integer descuento;


    public Long getIdPedido() {
        return idPedido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public Integer getDescuento() {
        return descuento;
    }

}