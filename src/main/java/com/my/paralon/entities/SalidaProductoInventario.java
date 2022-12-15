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
@Table(name = "salida_producto_inventario")
@NamedQueries({
    @NamedQuery(name = "SalidaProductoInventario.findAll", query = "SELECT s FROM SalidaProductoInventario s"),
    @NamedQuery(name = "SalidaProductoInventario.findByIdsalidaProductoInven", query = "SELECT s FROM SalidaProductoInventario s WHERE s.idsalidaProductoInven = :idsalidaProductoInven"),
    @NamedQuery(name = "SalidaProductoInventario.findByCantidadSal", query = "SELECT s FROM SalidaProductoInventario s WHERE s.cantidadSal = :cantidadSal"),
    @NamedQuery(name = "SalidaProductoInventario.findByFechaSalida", query = "SELECT s FROM SalidaProductoInventario s WHERE s.fechaSalida = :fechaSalida")})
public class SalidaProductoInventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsalida_producto_inven")
    private Integer idsalidaProductoInven;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_sal")
    private int cantidadSal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @JoinColumn(name = "codigo_producto_sal", referencedColumnName = "cod_producto_inventario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductosInventario codigoProductoSal;

    public SalidaProductoInventario() {
    }

    public SalidaProductoInventario(Integer idsalidaProductoInven) {
        this.idsalidaProductoInven = idsalidaProductoInven;
    }

    public SalidaProductoInventario(Integer idsalidaProductoInven, int cantidadSal, Date fechaSalida) {
        this.idsalidaProductoInven = idsalidaProductoInven;
        this.cantidadSal = cantidadSal;
        this.fechaSalida = fechaSalida;
    }

    public Integer getIdsalidaProductoInven() {
        return idsalidaProductoInven;
    }

    public void setIdsalidaProductoInven(Integer idsalidaProductoInven) {
        this.idsalidaProductoInven = idsalidaProductoInven;
    }

    public int getCantidadSal() {
        return cantidadSal;
    }

    public void setCantidadSal(int cantidadSal) {
        this.cantidadSal = cantidadSal;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public ProductosInventario getCodigoProductoSal() {
        return codigoProductoSal;
    }

    public void setCodigoProductoSal(ProductosInventario codigoProductoSal) {
        this.codigoProductoSal = codigoProductoSal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsalidaProductoInven != null ? idsalidaProductoInven.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalidaProductoInventario)) {
            return false;
        }
        SalidaProductoInventario other = (SalidaProductoInventario) object;
        if ((this.idsalidaProductoInven == null && other.idsalidaProductoInven != null) || (this.idsalidaProductoInven != null && !this.idsalidaProductoInven.equals(other.idsalidaProductoInven))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.my.paralon.entities.SalidaProductoInventario[ idsalidaProductoInven=" + idsalidaProductoInven + " ]";
    }
    
}
