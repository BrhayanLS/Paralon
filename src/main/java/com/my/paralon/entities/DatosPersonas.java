/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.my.paralon.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author brhay
 */
@Entity
@Table(name = "datos_personas")
@NamedQueries({
    @NamedQuery(name = "DatosPersonas.findAll", query = "SELECT d FROM DatosPersonas d"),
    @NamedQuery(name = "DatosPersonas.findByDni", query = "SELECT d FROM DatosPersonas d WHERE d.dni = :dni"),
    @NamedQuery(name = "DatosPersonas.findByPrimerNombre", query = "SELECT d FROM DatosPersonas d WHERE d.primerNombre = :primerNombre"),
    @NamedQuery(name = "DatosPersonas.findBySegundoNombre", query = "SELECT d FROM DatosPersonas d WHERE d.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "DatosPersonas.findByPrimerApellido", query = "SELECT d FROM DatosPersonas d WHERE d.primerApellido = :primerApellido"),
    @NamedQuery(name = "DatosPersonas.findBySegundoApellido", query = "SELECT d FROM DatosPersonas d WHERE d.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "DatosPersonas.findByContacto1", query = "SELECT d FROM DatosPersonas d WHERE d.contacto1 = :contacto1"),
    @NamedQuery(name = "DatosPersonas.findByContacto2", query = "SELECT d FROM DatosPersonas d WHERE d.contacto2 = :contacto2"),
    @NamedQuery(name = "DatosPersonas.findByCorreo", query = "SELECT d FROM DatosPersonas d WHERE d.correo = :correo")})
public class DatosPersonas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "DNI")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "primer_nombre")
    private String primerNombre;
    @Size(max = 20)
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Size(max = 20)
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "contacto_1")
    private String contacto1;
    @Size(max = 12)
    @Column(name = "contacto_2")
    private String contacto2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "correo")
    private String correo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dNIempleado", fetch = FetchType.LAZY)
    private List<Empleados> empleadosList;
    @JoinColumn(name = "id_ubicacion_pers", referencedColumnName = "id_ubicacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ubicacion idUbicacionPers;

    public DatosPersonas() {
    }

    public DatosPersonas(String dni) {
        this.dni = dni;
    }

    public DatosPersonas(String dni, String primerNombre, String primerApellido, String contacto1, String correo) {
        this.dni = dni;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.contacto1 = contacto1;
        this.correo = correo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getContacto1() {
        return contacto1;
    }

    public void setContacto1(String contacto1) {
        this.contacto1 = contacto1;
    }

    public String getContacto2() {
        return contacto2;
    }

    public void setContacto2(String contacto2) {
        this.contacto2 = contacto2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Empleados> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleados> empleadosList) {
        this.empleadosList = empleadosList;
    }

    public Ubicacion getIdUbicacionPers() {
        return idUbicacionPers;
    }

    public void setIdUbicacionPers(Ubicacion idUbicacionPers) {
        this.idUbicacionPers = idUbicacionPers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatosPersonas)) {
            return false;
        }
        DatosPersonas other = (DatosPersonas) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.my.paralon.entities.DatosPersonas[ dni=" + dni + " ]";
    }
    
}
