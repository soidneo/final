/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control.dto;

import java.util.List;

/**
 *
 * @author Asus
 */
public class PedidoMaestro {
    
    private List<PedidoDetalleDto> detallesPedido;
    private int mesa;//las mesas por ahora manejemoslas asi todavia no creo la tabla
    //ahi no irira descuento y iva en el maestro dices?
    //la sumatoria del descuento del detalle y el iva no cres?
    //listo
    private double descuentoTotal;
    private double ivaTotal;//por que ivan
    private double total;

    public List<PedidoDetalleDto> getDetallesPedido() {
        return detallesPedido;
    }

    public void setDetallesPedido(List<PedidoDetalleDto> detallesPedido) {
        this.detallesPedido = detallesPedido;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public double getDescuentoTotal() {
        return descuentoTotal;
    }

    public void setDescuentoTotal(double descuentoTotal) {
        this.descuentoTotal = descuentoTotal;
    }

    public double getIvaTotal() {
        return ivaTotal;
    }

    public void setIvaTotal(double ivaTotal) {
        this.ivaTotal = ivaTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }//ve en la otra clase no iba el campo del pedido? :P o eso oslo es para db por el momento toca temporal despues
    //cuando confirme la venta ya hacemos lo de bd pero despues primero que se listen los pedidos con el socket
}
