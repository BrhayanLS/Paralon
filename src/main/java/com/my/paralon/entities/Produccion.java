/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.my.paralon.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author brhay
 */
@Entity
@Table(name = "produccion")
@NamedQueries({
    @NamedQuery(name = "Produccion.findAll", query = "SELECT p FROM Produccion p"),
    @NamedQuery(name = "Produccion.findByIdproduccion", query = "SELECT p FROM Produccion p WHERE p.idproduccion = :idproduccion"),
    @NamedQuery(name = "Produccion.findByFecha", query = "SELECT p FROM Produccion p WHERE p.fecha = :fecha")})
public class Produccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproduccion")
    private Integer idproduccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_responsable", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleados idResponsable;
    @JoinColumn(name = "id_producto", referencedColumnName = "idproductos_produccion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductosProduccion idProducto;

    public Produccion() {
    }

    public Produccion(Integer idproduccion) {
        this.idproduccion = idproduccion;
    }

    public Produccion(Integer idproduccion, Date fecha) {
        this.idproduccion = idproduccion;
        this.fecha = fecha;
    }

    public Integer getIdproduccion() {
        return idproduccion;
    }

    public void setIdproduccion(Integer idproduccion) {
        this.idproduccion = idproduccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Empleados getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Empleados idResponsable) {
        this.idResponsable = idResponsable;
    }

    public ProductosProduccion getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(ProductosProduccion idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproduccion != null ? idproduccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produccion)) {
            return false;
        }
        Produccion other = (Produccion) object;
        if ((this.idproduccion == null && other.idproduccion != null) || (this.idproduccion != null && !this.idproduccion.equals(other.idproduccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.my.paralon.entities.Produccion[ idproduccion=" + idproduccion + " ]";
    }
    
}
