/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.my.paralon.controllers;

import com.my.paralon.entities.Rol;
import com.my.paralon.services.RolFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author brhay
 */
@Named(value = "controllerNuevoRol")
@SessionScoped
public class controllerNuevoRol implements Serializable {

    private Rol rol = new Rol();
    @EJB
    private RolFacade rolFacade;
    
    public controllerNuevoRol() {
    }
    
    public void guardarRol(){
        rolFacade.create(rol);
    }
    
    public List<Rol> listaRoles(){
        return rolFacade.findAll();
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public RolFacade getRolFacade() {
        return rolFacade;
    }

    public void setRolFacade(RolFacade rolFacade) {
        this.rolFacade = rolFacade;
    }
    
    
}
