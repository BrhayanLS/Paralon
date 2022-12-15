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
@Table(name = "productos_inventario")
@NamedQueries({
    @NamedQuery(name = "ProductosInventario.findAll", query = "SELECT p FROM ProductosInventario p"),
    @NamedQuery(name = "ProductosInventario.findByCodProductoInventario", query = "SELECT p FROM ProductosInventario p WHERE p.codProductoInventario = :codProductoInventario"),
    @NamedQuery(name = "ProductosInventario.findByNombreProductoInventario", query = "SELECT p FROM ProductosInventario p WHERE p.nombreProductoInventario = :nombreProductoInventario")})
public class ProductosInventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_producto_inventario")
    private Integer codProductoInventario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_producto_inventario")
    private String nombreProductoInventario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoProductoEntra", fetch = FetchType.LAZY)
    private List<EntradaProductoInventario> entradaProductoInventarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoProductoSal", fetch = FetchType.LAZY)
    private List<SalidaProductoInventario> salidaProductoInventarioList;

    public ProductosInventario() {
    }

    public ProductosInventario(Integer codProductoInventario) {
        this.codProductoInventario = codProductoInventario;
    }

    public ProductosInventario(Integer codProductoInventario, String nombreProductoInventario) {
        this.codProductoInventario = codProductoInventario;
        this.nombreProductoInventario = nombreProductoInventario;
    }

    public Integer getCodProductoInventario() {
        return codProductoInventario;
    }

    public void setCodProductoInventario(Integer codProductoInventario) {
        this.codProductoInventario = codProductoInventario;
    }

    public String getNombreProductoInventario() {
        return nombreProductoInventario;
    }

    public void setNombreProductoInventario(String nombreProductoInventario) {
        this.nombreProductoInventario = nombreProductoInventario;
    }

    public List<EntradaProductoInventario> getEntradaProductoInventarioList() {
        return entradaProductoInventarioList;
    }

    public void setEntradaProductoInventarioList(List<EntradaProductoInventario> entradaProductoInventarioList) {
        this.entradaProductoInventarioList = entradaProductoInventarioList;
    }

    public List<SalidaProductoInventario> getSalidaProductoInventarioList() {
        return salidaProductoInventarioList;
    }

    public void setSalidaProductoInventarioList(List<SalidaProductoInventario> salidaProductoInventarioList) {
        this.salidaProductoInventarioList = salidaProductoInventarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProductoInventario != null ? codProductoInventario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosInventario)) {
            return false;
        }
        ProductosInventario other = (ProductosInventario) object;
        if ((this.codProductoInventario == null && other.codProductoInventario != null) || (this.codProductoInventario != null && !this.codProductoInventario.equals(other.codProductoInventario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.my.paralon.entities.ProductosInventario[ codProductoInventario=" + codProductoInventario + " ]";
    }
    
}
