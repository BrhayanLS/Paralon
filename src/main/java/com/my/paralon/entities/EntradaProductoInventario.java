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
@Table(name = "entrada_producto_inventario")
@NamedQueries({
    @NamedQuery(name = "EntradaProductoInventario.findAll", query = "SELECT e FROM EntradaProductoInventario e"),
    @NamedQuery(name = "EntradaProductoInventario.findByIdentradaProductoInventario", query = "SELECT e FROM EntradaProductoInventario e WHERE e.identradaProductoInventario = :identradaProductoInventario"),
    @NamedQuery(name = "EntradaProductoInventario.findByCantidadProductoEntra", query = "SELECT e FROM EntradaProductoInventario e WHERE e.cantidadProductoEntra = :cantidadProductoEntra"),
    @NamedQuery(name = "EntradaProductoInventario.findByFechaEntrada", query = "SELECT e FROM EntradaProductoInventario e WHERE e.fechaEntrada = :fechaEntrada")})
public class EntradaProductoInventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "identrada_producto_inventario")
    private Integer identradaProductoInventario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_producto_entra")
    private int cantidadProductoEntra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_entrada")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrada;
    @JoinColumn(name = "id_proveedor_entra", referencedColumnName = "id_cliente_proveedor")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DatosClienteProveedor idProveedorEntra;
    @JoinColumn(name = "id_empleado_recibe", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleados idEmpleadoRecibe;
    @JoinColumn(name = "codigo_producto_entra", referencedColumnName = "cod_producto_inventario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductosInventario codigoProductoEntra;

    public EntradaProductoInventario() {
    }

    public EntradaProductoInventario(Integer identradaProductoInventario) {
        this.identradaProductoInventario = identradaProductoInventario;
    }

    public EntradaProductoInventario(Integer identradaProductoInventario, int cantidadProductoEntra, Date fechaEntrada) {
        this.identradaProductoInventario = identradaProductoInventario;
        this.cantidadProductoEntra = cantidadProductoEntra;
        this.fechaEntrada = fechaEntrada;
    }

    public Integer getIdentradaProductoInventario() {
        return identradaProductoInventario;
    }

    public void setIdentradaProductoInventario(Integer identradaProductoInventario) {
        this.identradaProductoInventario = identradaProductoInventario;
    }

    public int getCantidadProductoEntra() {
        return cantidadProductoEntra;
    }

    public void setCantidadProductoEntra(int cantidadProductoEntra) {
        this.cantidadProductoEntra = cantidadProductoEntra;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public DatosClienteProveedor getIdProveedorEntra() {
        return idProveedorEntra;
    }

    public void setIdProveedorEntra(DatosClienteProveedor idProveedorEntra) {
        this.idProveedorEntra = idProveedorEntra;
    }

    public Empleados getIdEmpleadoRecibe() {
        return idEmpleadoRecibe;
    }

    public void setIdEmpleadoRecibe(Empleados idEmpleadoRecibe) {
        this.idEmpleadoRecibe = idEmpleadoRecibe;
    }

    public ProductosInventario getCodigoProductoEntra() {
        return codigoProductoEntra;
    }

    public void setCodigoProductoEntra(ProductosInventario codigoProductoEntra) {
        this.codigoProductoEntra = codigoProductoEntra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identradaProductoInventario != null ? identradaProductoInventario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntradaProductoInventario)) {
            return false;
        }
        EntradaProductoInventario other = (EntradaProductoInventario) object;
        if ((this.identradaProductoInventario == null && other.identradaProductoInventario != null) || (this.identradaProductoInventario != null && !this.identradaProductoInventario.equals(other.identradaProductoInventario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.my.paralon.entities.EntradaProductoInventario[ identradaProductoInventario=" + identradaProductoInventario + " ]";
    }
    
}
