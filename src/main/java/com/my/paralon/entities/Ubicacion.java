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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "ubicacion")
@NamedQueries({
    @NamedQuery(name = "Ubicacion.findAll", query = "SELECT u FROM Ubicacion u"),
    @NamedQuery(name = "Ubicacion.findByIdUbicacion", query = "SELECT u FROM Ubicacion u WHERE u.idUbicacion = :idUbicacion"),
    @NamedQuery(name = "Ubicacion.findByDireccion", query = "SELECT u FROM Ubicacion u WHERE u.direccion = :direccion")})
public class Ubicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ubicacion")
    private Integer idUbicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direccion")
    private String direccion;
    @JoinColumn(name = "id_departamento_ubicacion", referencedColumnName = "id_departamento")
    @ManyToOne(fetch = FetchType.LAZY)
    private Departamento idDepartamentoUbicacion;
    @JoinColumn(name = "id_municipio_ubicacion", referencedColumnName = "id_municipio")
    @ManyToOne(fetch = FetchType.LAZY)
    private Municipio idMunicipioUbicacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUbicacionProv", fetch = FetchType.LAZY)
    private List<DatosClienteProveedor> datosClienteProveedorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUbicacionPers", fetch = FetchType.LAZY)
    private List<DatosPersonas> datosPersonasList;

    public Ubicacion() {
    }

    public Ubicacion(Integer idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public Ubicacion(Integer idUbicacion, String direccion) {
        this.idUbicacion = idUbicacion;
        this.direccion = direccion;
    }

    public Integer getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(Integer idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Departamento getIdDepartamentoUbicacion() {
        return idDepartamentoUbicacion;
    }

    public void setIdDepartamentoUbicacion(Departamento idDepartamentoUbicacion) {
        this.idDepartamentoUbicacion = idDepartamentoUbicacion;
    }

    public Municipio getIdMunicipioUbicacion() {
        return idMunicipioUbicacion;
    }

    public void setIdMunicipioUbicacion(Municipio idMunicipioUbicacion) {
        this.idMunicipioUbicacion = idMunicipioUbicacion;
    }

    public List<DatosClienteProveedor> getDatosClienteProveedorList() {
        return datosClienteProveedorList;
    }

    public void setDatosClienteProveedorList(List<DatosClienteProveedor> datosClienteProveedorList) {
        this.datosClienteProveedorList = datosClienteProveedorList;
    }

    public List<DatosPersonas> getDatosPersonasList() {
        return datosPersonasList;
    }

    public void setDatosPersonasList(List<DatosPersonas> datosPersonasList) {
        this.datosPersonasList = datosPersonasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUbicacion != null ? idUbicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubicacion)) {
            return false;
        }
        Ubicacion other = (Ubicacion) object;
        if ((this.idUbicacion == null && other.idUbicacion != null) || (this.idUbicacion != null && !this.idUbicacion.equals(other.idUbicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.my.paralon.entities.Ubicacion[ idUbicacion=" + idUbicacion + " ]";
    }
    
}
