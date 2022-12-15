/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.my.paralon.controllers;

import com.my.paralon.entities.DatosPersonas;
import com.my.paralon.entities.Empleados;
import com.my.paralon.entities.Ubicacion;
import com.my.paralon.services.DatosPersonasFacade;
import com.my.paralon.services.EmpleadosFacade;
import com.my.paralon.services.UbicacionFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author brhay
 */
@Named(value = "controllerRegistroEmpleado")
@SessionScoped

public class controllerRegistroEmpleado implements Serializable {

    private Ubicacion ubicacion = new Ubicacion();
    private DatosPersonas datosPersona = new DatosPersonas();
    private Empleados empleados = new Empleados();
    @EJB
    private UbicacionFacade ubicacionFacade;
    @EJB
    private DatosPersonasFacade datosPersonasFacade;
    @EJB
    private EmpleadosFacade empleadosFacade;
    
    
    public controllerRegistroEmpleado() {
    }
    
    public void guardarEmpleado(){
        ubicacionFacade.create(ubicacion);
        datosPersona.setIdUbicacionPers(ubicacion);
        datosPersonasFacade.create(datosPersona);
        empleados.setDNIempleado(datosPersona);
        empleadosFacade.create(empleados);
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public DatosPersonas getDatosPersona() {
        return datosPersona;
    }

    public void setDatosPersona(DatosPersonas datosPersona) {
        this.datosPersona = datosPersona;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    public UbicacionFacade getUbicacionFacade() {
        return ubicacionFacade;
    }

    public void setUbicacionFacade(UbicacionFacade ubicacionFacade) {
        this.ubicacionFacade = ubicacionFacade;
    }

    public DatosPersonasFacade getDatosPersonasFacade() {
        return datosPersonasFacade;
    }

    public void setDatosPersonasFacade(DatosPersonasFacade datosPersonasFacade) {
        this.datosPersonasFacade = datosPersonasFacade;
    }

    public EmpleadosFacade getEmpleadosFacade() {
        return empleadosFacade;
    }

    public void setEmpleadosFacade(EmpleadosFacade empleadosFacade) {
        this.empleadosFacade = empleadosFacade;
    }
    
    
}
