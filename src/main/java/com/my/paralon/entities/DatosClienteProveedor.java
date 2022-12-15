/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.my.paralon.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "datos_cliente_proveedor")
@NamedQueries({
    @NamedQuery(name = "DatosClienteProveedor.findAll", query = "SELECT d FROM DatosClienteProveedor d"),
    @NamedQuery(name = "DatosClienteProveedor.findByIdClienteProveedor", query = "SELECT d FROM DatosClienteProveedor d WHERE d.idClienteProveedor = :idClienteProveedor"),
    @NamedQuery(name = "DatosClienteProveedor.findByTipoCliente", query = "SELECT d FROM DatosClienteProveedor d WHERE d.tipoCliente = :tipoCliente"),
    @NamedQuery(name = "DatosClienteProveedor.findByRazonSocial", query = "SELECT d FROM DatosClienteProveedor d WHERE d.razonSocial = :razonSocial"),
    @NamedQuery(name = "DatosClienteProveedor.findByDNINITclienteproveedor", query = "SELECT d FROM DatosClienteProveedor d WHERE d.dNINITclienteproveedor = :dNINITclienteproveedor"),
    @NamedQuery(name = "DatosClienteProveedor.findByRolClienteProveedor", query = "SELECT d FROM DatosClienteProveedor d WHERE d.rolClienteProveedor = :rolClienteProveedor"),
    @NamedQuery(name = "DatosClienteProveedor.findByContacto1", query = "SELECT d FROM DatosClienteProveedor d WHERE d.contacto1 = :contacto1"),
    @NamedQuery(name = "DatosClienteProveedor.findByContacto2", query = "SELECT d FROM DatosClienteProveedor d WHERE d.contacto2 = :contacto2"),
    @NamedQuery(name = "DatosClienteProveedor.findByCorreo", query = "SELECT d FROM DatosClienteProveedor d WHERE d.correo = :correo")})
public class DatosClienteProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente_proveedor")
    private Integer idClienteProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tipo_cliente")
    private String tipoCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "razon_social")
    private String razonSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "DNI_NIT_cliente_proveedor")
    private String dNINITclienteproveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "rol_cliente_proveedor")
    private String rolClienteProveedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contacto_1")
    private long contacto1;
    @Column(name = "contacto_2")
    private BigInteger contacto2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "correo")
    private String correo;
    @JoinColumn(name = "id_ubicacion_prov", referencedColumnName = "id_ubicacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ubicacion idUbicacionProv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProveedorEntra", fetch = FetchType.LAZY)
    private List<EntradaProductoInventario> entradaProductoInventarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClientePedido", fetch = FetchType.LAZY)
    private List<PedidoProduccion> pedidoProduccionList;

    public DatosClienteProveedor() {
    }

    public DatosClienteProveedor(Integer idClienteProveedor) {
        this.idClienteProveedor = idClienteProveedor;
    }

    public DatosClienteProveedor(Integer idClienteProveedor, String tipoCliente, String razonSocial, String dNINITclienteproveedor, String rolClienteProveedor, long contacto1, String correo) {
        this.idClienteProveedor = idClienteProveedor;
        this.tipoCliente = tipoCliente;
        this.razonSocial = razonSocial;
        this.dNINITclienteproveedor = dNINITclienteproveedor;
        this.rolClienteProveedor = rolClienteProveedor;
        this.contacto1 = contacto1;
        this.correo = correo;
    }

    public Integer getIdClienteProveedor() {
        return idClienteProveedor;
    }

    public void setIdClienteProveedor(Integer idClienteProveedor) {
        this.idClienteProveedor = idClienteProveedor;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDNINITclienteproveedor() {
        return dNINITclienteproveedor;
    }

    public void setDNINITclienteproveedor(String dNINITclienteproveedor) {
        this.dNINITclienteproveedor = dNINITclienteproveedor;
    }

    public String getRolClienteProveedor() {
        return rolClienteProveedor;
    }

    public void setRolClienteProveedor(String rolClienteProveedor) {
        this.rolClienteProveedor = rolClienteProveedor;
    }

    public long getContacto1() {
        return contacto1;
    }

    public void setContacto1(long contacto1) {
        this.contacto1 = contacto1;
    }

    public BigInteger getContacto2() {
        return contacto2;
    }

    public void setContacto2(BigInteger contacto2) {
        this.contacto2 = contacto2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Ubicacion getIdUbicacionProv() {
        return idUbicacionProv;
    }

    public void setIdUbicacionProv(Ubicacion idUbicacionProv) {
        this.idUbicacionProv = idUbicacionProv;
    }

    public List<EntradaProductoInventario> getEntradaProductoInventarioList() {
        return entradaProductoInventarioList;
    }

    public void setEntradaProductoInventarioList(List<EntradaProductoInventario> entradaProductoInventarioList) {
        this.entradaProductoInventarioList = entradaProductoInventarioList;
    }

    public List<PedidoProduccion> getPedidoProduccionList() {
        return pedidoProduccionList;
    }

    public void setPedidoProduccionList(List<PedidoProduccion> pedidoProduccionList) {
        this.pedidoProduccionList = pedidoProduccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClienteProveedor != null ? idClienteProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatosClienteProveedor)) {
            return false;
        }
        DatosClienteProveedor other = (DatosClienteProveedor) object;
        if ((this.idClienteProveedor == null && other.idClienteProveedor != null) || (this.idClienteProveedor != null && !this.idClienteProveedor.equals(other.idClienteProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.my.paralon.entities.DatosClienteProveedor[ idClienteProveedor=" + idClienteProveedor + " ]";
    }
    
}
