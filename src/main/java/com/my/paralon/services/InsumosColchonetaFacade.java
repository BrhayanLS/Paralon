/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.my.paralon.services;

import com.my.paralon.entities.InsumosColchoneta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author brhay
 */
@Stateless
public class InsumosColchonetaFacade extends AbstractFacade<InsumosColchoneta> {

    @PersistenceContext(unitName = "com.my_Paralon_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InsumosColchonetaFacade() {
        super(InsumosColchoneta.class);
    }
    
}
