/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.my.paralon.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author brhay
 */
@Entity
@Table(name = "insumos_colchoneta")
@NamedQueries({
    @NamedQuery(name = "InsumosColchoneta.findAll", query = "SELECT i FROM InsumosColchoneta i"),
    @NamedQuery(name = "InsumosColchoneta.findByIdMateriaColchoneta", query = "SELECT i FROM InsumosColchoneta i WHERE i.idMateriaColchoneta = :idMateriaColchoneta"),
    @NamedQuery(name = "InsumosColchoneta.findByLaminaEspuma", query = "SELECT i FROM InsumosColchoneta i WHERE i.laminaEspuma = :laminaEspuma"),
    @NamedQuery(name = "InsumosColchoneta.findByTelaSatinTapas", query = "SELECT i FROM InsumosColchoneta i WHERE i.telaSatinTapas = :telaSatinTapas"),
    @NamedQuery(name = "InsumosColchoneta.findByTelaSatinBandas", query = "SELECT i FROM InsumosColchoneta i WHERE i.telaSatinBandas = :telaSatinBandas"),
    @NamedQuery(name = "InsumosColchoneta.findByPlastico", query = "SELECT i FROM InsumosColchoneta i WHERE i.plastico = :plastico"),
    @NamedQuery(name = "InsumosColchoneta.findByEmbono", query = "SELECT i FROM InsumosColchoneta i WHERE i.embono = :embono"),
    @NamedQuery(name = "InsumosColchoneta.findByCremallera", query = "SELECT i FROM InsumosColchoneta i WHERE i.cremallera = :cremallera")})
public class InsumosColchoneta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_materia_colchoneta")
    private Integer idMateriaColchoneta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lamina_espuma")
    private float laminaEspuma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tela_satin_tapas")
    private float telaSatinTapas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tela_satin_bandas")
    private float telaSatinBandas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plastico")
    private float plastico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "embono")
    private float embono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cremallera")
    private float cremallera;
    @JoinColumn(name = "id_producto_colchoneta", referencedColumnName = "idproductos_produccion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductosProduccion idProductoColchoneta;

    public InsumosColchoneta() {
    }

    public InsumosColchoneta(Integer idMateriaColchoneta) {
        this.idMateriaColchoneta = idMateriaColchoneta;
    }

    public InsumosColchoneta(Integer idMateriaColchoneta, float laminaEspuma, float telaSatinTapas, float telaSatinBandas, float plastico, float embono, float cremallera) {
        this.idMateriaColchoneta = idMateriaColchoneta;
        this.laminaEspuma = laminaEspuma;
        this.telaSatinTapas = telaSatinTapas;
        this.telaSatinBandas = telaSatinBandas;
        this.plastico = plastico;
        this.embono = embono;
        this.cremallera = cremallera;
    }

    public Integer getIdMateriaColchoneta() {
        return idMateriaColchoneta;
    }

    public void setIdMateriaColchoneta(Integer idMateriaColchoneta) {
        this.idMateriaColchoneta = idMateriaColchoneta;
    }

    public float getLaminaEspuma() {
        return laminaEspuma;
    }

    public void setLaminaEspuma(float laminaEspuma) {
        this.laminaEspuma = laminaEspuma;
    }

    public float getTelaSatinTapas() {
        return telaSatinTapas;
    }

    public void setTelaSatinTapas(float telaSatinTapas) {
        this.telaSatinTapas = telaSatinTapas;
    }

    public float getTelaSatinBandas() {
        return telaSatinBandas;
    }

    public void setTelaSatinBandas(float telaSatinBandas) {
        this.telaSatinBandas = telaSatinBandas;
    }

    public float getPlastico() {
        return plastico;
    }

    public void setPlastico(float plastico) {
        this.plastico = plastico;
    }

    public float getEmbono() {
        return embono;
    }

    public void setEmbono(float embono) {
        this.embono = embono;
    }

    public float getCremallera() {
        return cremallera;
    }

    public void setCremallera(float cremallera) {
        this.cremallera = cremallera;
    }

    public ProductosProduccion getIdProductoColchoneta() {
        return idProductoColchoneta;
    }

    public void setIdProductoColchoneta(ProductosProduccion idProductoColchoneta) {
        this.idProductoColchoneta = idProductoColchoneta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMateriaColchoneta != null ? idMateriaColchoneta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InsumosColchoneta)) {
            return false;
        }
        InsumosColchoneta other = (InsumosColchoneta) object;
        if ((this.idMateriaColchoneta == null && other.idMateriaColchoneta != null) || (this.idMateriaColchoneta != null && !this.idMateriaColchoneta.equals(other.idMateriaColchoneta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.my.paralon.entities.InsumosColchoneta[ idMateriaColchoneta=" + idMateriaColchoneta + " ]";
    }
    
}
