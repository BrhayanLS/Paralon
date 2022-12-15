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
@Table(name = "insumo_espuma")
@NamedQueries({
    @NamedQuery(name = "InsumoEspuma.findAll", query = "SELECT i FROM InsumoEspuma i"),
    @NamedQuery(name = "InsumoEspuma.findByIdMateriaEspuma", query = "SELECT i FROM InsumoEspuma i WHERE i.idMateriaEspuma = :idMateriaEspuma"),
    @NamedQuery(name = "InsumoEspuma.findByPoliol", query = "SELECT i FROM InsumoEspuma i WHERE i.poliol = :poliol"),
    @NamedQuery(name = "InsumoEspuma.findByPolimerico", query = "SELECT i FROM InsumoEspuma i WHERE i.polimerico = :polimerico"),
    @NamedQuery(name = "InsumoEspuma.findByCarbonato", query = "SELECT i FROM InsumoEspuma i WHERE i.carbonato = :carbonato"),
    @NamedQuery(name = "InsumoEspuma.findByAgua", query = "SELECT i FROM InsumoEspuma i WHERE i.agua = :agua"),
    @NamedQuery(name = "InsumoEspuma.findByCloruro", query = "SELECT i FROM InsumoEspuma i WHERE i.cloruro = :cloruro"),
    @NamedQuery(name = "InsumoEspuma.findByTdi", query = "SELECT i FROM InsumoEspuma i WHERE i.tdi = :tdi"),
    @NamedQuery(name = "InsumoEspuma.findByADentre", query = "SELECT i FROM InsumoEspuma i WHERE i.aDentre = :aDentre"),
    @NamedQuery(name = "InsumoEspuma.findByADcarga", query = "SELECT i FROM InsumoEspuma i WHERE i.aDcarga = :aDcarga"),
    @NamedQuery(name = "InsumoEspuma.findBySilicona8110", query = "SELECT i FROM InsumoEspuma i WHERE i.silicona8110 = :silicona8110"),
    @NamedQuery(name = "InsumoEspuma.findBySilicona8257", query = "SELECT i FROM InsumoEspuma i WHERE i.silicona8257 = :silicona8257"),
    @NamedQuery(name = "InsumoEspuma.findByAmina", query = "SELECT i FROM InsumoEspuma i WHERE i.amina = :amina")})
public class InsumoEspuma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_materia_espuma")
    private Integer idMateriaEspuma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "poliol")
    private float poliol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "polimerico")
    private float polimerico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "carbonato")
    private float carbonato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "agua")
    private float agua;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cloruro")
    private float cloruro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TDI")
    private float tdi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AD_entre")
    private float aDentre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AD_carga")
    private float aDcarga;
    @Basic(optional = false)
    @NotNull
    @Column(name = "silicona_8110")
    private float silicona8110;
    @Basic(optional = false)
    @NotNull
    @Column(name = "silicona_8257")
    private float silicona8257;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amina")
    private float amina;
    @JoinColumn(name = "id_producto_espuma", referencedColumnName = "idproductos_produccion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductosProduccion idProductoEspuma;

    public InsumoEspuma() {
    }

    public InsumoEspuma(Integer idMateriaEspuma) {
        this.idMateriaEspuma = idMateriaEspuma;
    }

    public InsumoEspuma(Integer idMateriaEspuma, float poliol, float polimerico, float carbonato, float agua, float cloruro, float tdi, float aDentre, float aDcarga, float silicona8110, float silicona8257, float amina) {
        this.idMateriaEspuma = idMateriaEspuma;
        this.poliol = poliol;
        this.polimerico = polimerico;
        this.carbonato = carbonato;
        this.agua = agua;
        this.cloruro = cloruro;
        this.tdi = tdi;
        this.aDentre = aDentre;
        this.aDcarga = aDcarga;
        this.silicona8110 = silicona8110;
        this.silicona8257 = silicona8257;
        this.amina = amina;
    }

    public Integer getIdMateriaEspuma() {
        return idMateriaEspuma;
    }

    public void setIdMateriaEspuma(Integer idMateriaEspuma) {
        this.idMateriaEspuma = idMateriaEspuma;
    }

    public float getPoliol() {
        return poliol;
    }

    public void setPoliol(float poliol) {
        this.poliol = poliol;
    }

    public float getPolimerico() {
        return polimerico;
    }

    public void setPolimerico(float polimerico) {
        this.polimerico = polimerico;
    }

    public float getCarbonato() {
        return carbonato;
    }

    public void setCarbonato(float carbonato) {
        this.carbonato = carbonato;
    }

    public float getAgua() {
        return agua;
    }

    public void setAgua(float agua) {
        this.agua = agua;
    }

    public float getCloruro() {
        return cloruro;
    }

    public void setCloruro(float cloruro) {
        this.cloruro = cloruro;
    }

    public float getTdi() {
        return tdi;
    }

    public void setTdi(float tdi) {
        this.tdi = tdi;
    }

    public float getADentre() {
        return aDentre;
    }

    public void setADentre(float aDentre) {
        this.aDentre = aDentre;
    }

    public float getADcarga() {
        return aDcarga;
    }

    public void setADcarga(float aDcarga) {
        this.aDcarga = aDcarga;
    }

    public float getSilicona8110() {
        return silicona8110;
    }

    public void setSilicona8110(float silicona8110) {
        this.silicona8110 = silicona8110;
    }

    public float getSilicona8257() {
        return silicona8257;
    }

    public void setSilicona8257(float silicona8257) {
        this.silicona8257 = silicona8257;
    }

    public float getAmina() {
        return amina;
    }

    public void setAmina(float amina) {
        this.amina = amina;
    }

    public ProductosProduccion getIdProductoEspuma() {
        return idProductoEspuma;
    }

    public void setIdProductoEspuma(ProductosProduccion idProductoEspuma) {
        this.idProductoEspuma = idProductoEspuma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMateriaEspuma != null ? idMateriaEspuma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InsumoEspuma)) {
            return false;
        }
        InsumoEspuma other = (InsumoEspuma) object;
        if ((this.idMateriaEspuma == null && other.idMateriaEspuma != null) || (this.idMateriaEspuma != null && !this.idMateriaEspuma.equals(other.idMateriaEspuma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.my.paralon.entities.InsumoEspuma[ idMateriaEspuma=" + idMateriaEspuma + " ]";
    }
    
}
