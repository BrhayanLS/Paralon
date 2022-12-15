/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.my.paralon.services;

import com.my.paralon.entities.EntradaProductoInventario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author brhay
 */
@Stateless
public class EntradaProductoInventarioFacade extends AbstractFacade<EntradaProductoInventario> {

    @PersistenceContext(unitName = "com.my_Paralon_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntradaProductoInventarioFacade() {
        super(EntradaProductoInventario.class);
    }
    
}
