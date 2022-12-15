/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.my.paralon.controllers;

import com.my.paralon.entities.DatosClienteProveedor;
import com.my.paralon.entities.Ubicacion;
import com.my.paralon.services.DatosClienteProveedorFacade;
import com.my.paralon.services.UbicacionFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author brhay
 */
@Named(value = "controllerRegistroCliente")
@SessionScoped
public class controllerRegistroCliente implements Serializable {

    private DatosClienteProveedor datosCliente = new DatosClienteProveedor();
    private Ubicacion ubicacion = new Ubicacion();
    private List<String> tipoclientes = Arrays.asList("NATURAL", "JURIDICO");
    private List<String> roles = Arrays.asList("CLIENTE", "PROVEEDOR");
    @EJB
    private DatosClienteProveedorFacade datosClienteFacade;
    @EJB
    private UbicacionFacade ubicacionFacade;
    
    public controllerRegistroCliente() {
    }
    
    public void guardarCliente(){
        ubicacionFacade.create(ubicacion);
        datosCliente.setIdUbicacionProv(ubicacion);
        datosClienteFacade.create(datosCliente);
    }
    
    public List<DatosClienteProveedor> listarClientes(){
        return datosClienteFacade.findAll();
    }

    public DatosClienteProveedor getDatosCliente() {
        return datosCliente;
    }

    public void setDatosCliente(DatosClienteProveedor datosCliente) {
        this.datosCliente = datosCliente;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<String> getTipoclientes() {
        return tipoclientes;
    }

    public void setTipoclientes(List<String> tipoclientes) {
        this.tipoclientes = tipoclientes;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public DatosClienteProveedorFacade getDatosClienteFacade() {
        return datosClienteFacade;
    }

    public void setDatosClienteFacade(DatosClienteProveedorFacade datosClienteFacade) {
        this.datosClienteFacade = datosClienteFacade;
    }

    public UbicacionFacade getUbicacionFacade() {
        return ubicacionFacade;
    }

    public void setUbicacionFacade(UbicacionFacade ubicacionFacade) {
        this.ubicacionFacade = ubicacionFacade;
    }
    
    
}
