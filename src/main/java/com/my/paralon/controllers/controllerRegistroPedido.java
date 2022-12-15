/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.my.paralon.controllers;

import com.my.paralon.entities.PedidoProduccion;
import com.my.paralon.services.PedidoProduccionFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

@Named(value = "controllerRegistroPedido")
@SessionScoped
public class controllerRegistroPedido implements Serializable {

    private PedidoProduccion pedido = new PedidoProduccion();
    @EJB
    private PedidoProduccionFacade pedidoFacade;
    
    public controllerRegistroPedido() {
    }
    
    public void guardarPedido(){
        pedidoFacade.create(pedido);
    }
}
