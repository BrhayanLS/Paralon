/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.my.paralon.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author brhay
 */
@Entity
@Table(name = "pedido_produccion")
@NamedQueries({
    @NamedQuery(name = "PedidoProduccion.findAll", query = "SELECT p FROM PedidoProduccion p"),
    @NamedQuery(name = "PedidoProduccion.findByIdPedido", query = "SELECT p FROM PedidoProduccion p WHERE p.idPedido = :idPedido"),
    @NamedQuery(name = "PedidoProduccion.findByFecha", query = "SELECT p FROM PedidoProduccion p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "PedidoProduccion.findByNumeroFactura", query = "SELECT p FROM PedidoProduccion p WHERE p.numeroFactura = :numeroFactura"),
    @NamedQuery(name = "PedidoProduccion.findByValor", query = "SELECT p FROM PedidoProduccion p WHERE p.valor = :valor")})
public class PedidoProduccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pedido")
    private Integer idPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "numero_factura")
    private String numeroFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private int valor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPedido", fetch = FetchType.LAZY)
    private List<ActualizacionPedido> actualizacionPedidoList;
    @JoinColumn(name = "id_cliente_pedido", referencedColumnName = "id_cliente_proveedor")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DatosClienteProveedor idClientePedido;
    @JoinColumn(name = "id_empleado_pedido_pro", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleados idEmpleadoPedidoPro;
    @JoinColumn(name = "id_conductor", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleados idConductor;

    public PedidoProduccion() {
    }

    public PedidoProduccion(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public PedidoProduccion(Integer idPedido, Date fecha, String numeroFactura, int valor) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.numeroFactura = numeroFactura;
        this.valor = valor;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public List<ActualizacionPedido> getActualizacionPedidoList() {
        return actualizacionPedidoList;
    }

    public void setActualizacionPedidoList(List<ActualizacionPedido> actualizacionPedidoList) {
        this.actualizacionPedidoList = actualizacionPedidoList;
    }

    public DatosClienteProveedor getIdClientePedido() {
        return idClientePedido;
    }

    public void setIdClientePedido(DatosClienteProveedor idClientePedido) {
        this.idClientePedido = idClientePedido;
    }

    public Empleados getIdEmpleadoPedidoPro() {
        return idEmpleadoPedidoPro;
    }

    public void setIdEmpleadoPedidoPro(Empleados idEmpleadoPedidoPro) {
        this.idEmpleadoPedidoPro = idEmpleadoPedidoPro;
    }

    public Empleados getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Empleados idConductor) {
        this.idConductor = idConductor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoProduccion)) {
            return false;
        }
        PedidoProduccion other = (PedidoProduccion) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.my.paralon.entities.PedidoProduccion[ idPedido=" + idPedido + " ]";
    }
    
}
