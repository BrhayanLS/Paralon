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
@Table(name = "productos_produccion")
@NamedQueries({
    @NamedQuery(name = "ProductosProduccion.findAll", query = "SELECT p FROM ProductosProduccion p"),
    @NamedQuery(name = "ProductosProduccion.findByIdproductosProduccion", query = "SELECT p FROM ProductosProduccion p WHERE p.idproductosProduccion = :idproductosProduccion"),
    @NamedQuery(name = "ProductosProduccion.findByNombre", query = "SELECT p FROM ProductosProduccion p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "ProductosProduccion.findByCosto", query = "SELECT p FROM ProductosProduccion p WHERE p.costo = :costo"),
    @NamedQuery(name = "ProductosProduccion.findByCategoria", query = "SELECT p FROM ProductosProduccion p WHERE p.categoria = :categoria")})
public class ProductosProduccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproductos_produccion")
    private Integer idproductosProduccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private int costo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "categoria")
    private String categoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProductoEspuma", fetch = FetchType.LAZY)
    private List<InsumoEspuma> insumoEspumaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProductoColchoneta", fetch = FetchType.LAZY)
    private List<InsumosColchoneta> insumosColchonetaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto", fetch = FetchType.LAZY)
    private List<Produccion> produccionList;

    public ProductosProduccion() {
    }

    public ProductosProduccion(Integer idproductosProduccion) {
        this.idproductosProduccion = idproductosProduccion;
    }

    public ProductosProduccion(Integer idproductosProduccion, String nombre, int costo, String categoria) {
        this.idproductosProduccion = idproductosProduccion;
        this.nombre = nombre;
        this.costo = costo;
        this.categoria = categoria;
    }

    public Integer getIdproductosProduccion() {
        return idproductosProduccion;
    }

    public void setIdproductosProduccion(Integer idproductosProduccion) {
        this.idproductosProduccion = idproductosProduccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<InsumoEspuma> getInsumoEspumaList() {
        return insumoEspumaList;
    }

    public void setInsumoEspumaList(List<InsumoEspuma> insumoEspumaList) {
        this.insumoEspumaList = insumoEspumaList;
    }

    public List<InsumosColchoneta> getInsumosColchonetaList() {
        return insumosColchonetaList;
    }

    public void setInsumosColchonetaList(List<InsumosColchoneta> insumosColchonetaList) {
        this.insumosColchonetaList = insumosColchonetaList;
    }

    public List<Produccion> getProduccionList() {
        return produccionList;
    }

    public void setProduccionList(List<Produccion> produccionList) {
        this.produccionList = produccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproductosProduccion != null ? idproductosProduccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosProduccion)) {
            return false;
        }
        ProductosProduccion other = (ProductosProduccion) object;
        if ((this.idproductosProduccion == null && other.idproductosProduccion != null) || (this.idproductosProduccion != null && !this.idproductosProduccion.equals(other.idproductosProduccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.my.paralon.entities.ProductosProduccion[ idproductosProduccion=" + idproductosProduccion + " ]";
    }
    
}
