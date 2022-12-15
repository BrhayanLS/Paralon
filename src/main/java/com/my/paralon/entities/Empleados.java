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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "empleados")
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e"),
    @NamedQuery(name = "Empleados.findByIdEmpleado", query = "SELECT e FROM Empleados e WHERE e.idEmpleado = :idEmpleado")})
public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empleado")
    private Integer idEmpleado;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "contrase\u00f1a")
    private String contraseña;
    @JoinColumn(name = "DNI_empleado", referencedColumnName = "DNI")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DatosPersonas dNIempleado;
    @JoinColumn(name = "id_cargo_empleado", referencedColumnName = "id_cargo_rol")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Rol idCargoEmpleado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleadoRecibe", fetch = FetchType.LAZY)
    private List<EntradaProductoInventario> entradaProductoInventarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleadoPedidoPro", fetch = FetchType.LAZY)
    private List<PedidoProduccion> pedidoProduccionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConductor", fetch = FetchType.LAZY)
    private List<PedidoProduccion> pedidoProduccionList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResponsable", fetch = FetchType.LAZY)
    private List<Produccion> produccionList;

    public Empleados() {
    }

    public Empleados(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleados(Integer idEmpleado, String contraseña) {
        this.idEmpleado = idEmpleado;
        this.contraseña = contraseña;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public DatosPersonas getDNIempleado() {
        return dNIempleado;
    }

    public void setDNIempleado(DatosPersonas dNIempleado) {
        this.dNIempleado = dNIempleado;
    }

    public Rol getIdCargoEmpleado() {
        return idCargoEmpleado;
    }

    public void setIdCargoEmpleado(Rol idCargoEmpleado) {
        this.idCargoEmpleado = idCargoEmpleado;
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

    public List<PedidoProduccion> getPedidoProduccionList1() {
        return pedidoProduccionList1;
    }

    public void setPedidoProduccionList1(List<PedidoProduccion> pedidoProduccionList1) {
        this.pedidoProduccionList1 = pedidoProduccionList1;
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
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.my.paralon.entities.Empleados[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
