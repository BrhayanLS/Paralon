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
import javax.validation.constraints.Size;

/**
 *
 * @author brhay
 */
@Entity
@Table(name = "actualizacion_pedido")
@NamedQueries({
    @NamedQuery(name = "ActualizacionPedido.findAll", query = "SELECT a FROM ActualizacionPedido a"),
    @NamedQuery(name = "ActualizacionPedido.findByIdPedidoCambios", query = "SELECT a FROM ActualizacionPedido a WHERE a.idPedidoCambios = :idPedidoCambios"),
    @NamedQuery(name = "ActualizacionPedido.findByFecha", query = "SELECT a FROM ActualizacionPedido a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "ActualizacionPedido.findByIdEmpleadoAntes", query = "SELECT a FROM ActualizacionPedido a WHERE a.idEmpleadoAntes = :idEmpleadoAntes"),
    @NamedQuery(name = "ActualizacionPedido.findByIdClienteAntes", query = "SELECT a FROM ActualizacionPedido a WHERE a.idClienteAntes = :idClienteAntes"),
    @NamedQuery(name = "ActualizacionPedido.findByNumeroFacturaAntes", query = "SELECT a FROM ActualizacionPedido a WHERE a.numeroFacturaAntes = :numeroFacturaAntes"),
    @NamedQuery(name = "ActualizacionPedido.findByValorAntes", query = "SELECT a FROM ActualizacionPedido a WHERE a.valorAntes = :valorAntes"),
    @NamedQuery(name = "ActualizacionPedido.findByIdConductorAntes", query = "SELECT a FROM ActualizacionPedido a WHERE a.idConductorAntes = :idConductorAntes")})
public class ActualizacionPedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pedido_cambios")
    private Integer idPedidoCambios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_empleado_antes")
    private int idEmpleadoAntes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cliente_antes")
    private int idClienteAntes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "numero_factura_antes")
    private String numeroFacturaAntes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_antes")
    private int valorAntes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_conductor_antes")
    private int idConductorAntes;
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PedidoProduccion idPedido;

    public ActualizacionPedido() {
    }

    public ActualizacionPedido(Integer idPedidoCambios) {
        this.idPedidoCambios = idPedidoCambios;
    }

    public ActualizacionPedido(Integer idPedidoCambios, Date fecha, int idEmpleadoAntes, int idClienteAntes, String numeroFacturaAntes, int valorAntes, int idConductorAntes) {
        this.idPedidoCambios = idPedidoCambios;
        this.fecha = fecha;
        this.idEmpleadoAntes = idEmpleadoAntes;
        this.idClienteAntes = idClienteAntes;
        this.numeroFacturaAntes = numeroFacturaAntes;
        this.valorAntes = valorAntes;
        this.idConductorAntes = idConductorAntes;
    }

    public Integer getIdPedidoCambios() {
        return idPedidoCambios;
    }

    public void setIdPedidoCambios(Integer idPedidoCambios) {
        this.idPedidoCambios = idPedidoCambios;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdEmpleadoAntes() {
        return idEmpleadoAntes;
    }

    public void setIdEmpleadoAntes(int idEmpleadoAntes) {
        this.idEmpleadoAntes = idEmpleadoAntes;
    }

    public int getIdClienteAntes() {
        return idClienteAntes;
    }

    public void setIdClienteAntes(int idClienteAntes) {
        this.idClienteAntes = idClienteAntes;
    }

    public String getNumeroFacturaAntes() {
        return numeroFacturaAntes;
    }

    public void setNumeroFacturaAntes(String numeroFacturaAntes) {
        this.numeroFacturaAntes = numeroFacturaAntes;
    }

    public int getValorAntes() {
        return valorAntes;
    }

    public void setValorAntes(int valorAntes) {
        this.valorAntes = valorAntes;
    }

    public int getIdConductorAntes() {
        return idConductorAntes;
    }

    public void setIdConductorAntes(int idConductorAntes) {
        this.idConductorAntes = idConductorAntes;
    }

    public PedidoProduccion getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(PedidoProduccion idPedido) {
        this.idPedido = idPedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedidoCambios != null ? idPedidoCambios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActualizacionPedido)) {
            return false;
        }
        ActualizacionPedido other = (ActualizacionPedido) object;
        if ((this.idPedidoCambios == null && other.idPedidoCambios != null) || (this.idPedidoCambios != null && !this.idPedidoCambios.equals(other.idPedidoCambios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.my.paralon.entities.ActualizacionPedido[ idPedidoCambios=" + idPedidoCambios + " ]";
    }
    
}
