/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.dev.tierra.api.model.stock;

import com.ar.dev.tierra.api.model.Producto;
import com.ar.dev.tierra.api.model.Sucursal;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author PauloGaldo
 */
@Entity
@Table(name = "stock_libertador")
public class StockLibertador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_stock", unique = true, nullable = false)
    private int idStock;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto idProducto;

    @Column(name = "estado", nullable = false)
    private boolean estado;

    @Column(name = "usuario_creacion", nullable = false)
    private int usuarioCreacion;

    @Column(name = "usuario_modificacion")
    private Integer usuarioModificacion;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_creacion", nullable = false, length = 13)
    private Date fechaCreacion;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_modificacion", length = 13)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_sucursal", nullable = false)
    private Sucursal idSucursal;

    public StockLibertador() {
    }

    public StockLibertador(int idStock, int cantidad, Producto idProducto, boolean estado, int usuarioCreacion, Integer usuarioModificacion, Date fechaCreacion, Date fechaModificacion, Sucursal idSucursal) {
        this.idStock = idStock;
        this.cantidad = cantidad;
        this.idProducto = idProducto;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.idSucursal = idSucursal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idStock;
        hash = 59 * hash + this.cantidad;
        hash = 59 * hash + Objects.hashCode(this.idProducto);
        hash = 59 * hash + (this.estado ? 1 : 0);
        hash = 59 * hash + this.usuarioCreacion;
        hash = 59 * hash + Objects.hashCode(this.usuarioModificacion);
        hash = 59 * hash + Objects.hashCode(this.fechaCreacion);
        hash = 59 * hash + Objects.hashCode(this.fechaModificacion);
        hash = 59 * hash + Objects.hashCode(this.idSucursal);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StockLibertador other = (StockLibertador) obj;
        if (this.idStock != other.idStock) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (this.usuarioCreacion != other.usuarioCreacion) {
            return false;
        }
        if (!Objects.equals(this.idProducto, other.idProducto)) {
            return false;
        }
        if (!Objects.equals(this.usuarioModificacion, other.usuarioModificacion)) {
            return false;
        }
        if (!Objects.equals(this.fechaCreacion, other.fechaCreacion)) {
            return false;
        }
        if (!Objects.equals(this.fechaModificacion, other.fechaModificacion)) {
            return false;
        }
        if (!Objects.equals(this.idSucursal, other.idSucursal)) {
            return false;
        }
        return true;
    }

    /**
     * @return the idStock
     */
    public int getIdStock() {
        return idStock;
    }

    /**
     * @param idStock the idStock to set
     */
    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the idProducto
     */
    public Producto getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the usuarioCreacion
     */
    public int getUsuarioCreacion() {
        return usuarioCreacion;
    }

    /**
     * @param usuarioCreacion the usuarioCreacion to set
     */
    public void setUsuarioCreacion(int usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    /**
     * @return the usuarioModificacion
     */
    public Integer getUsuarioModificacion() {
        return usuarioModificacion;
    }

    /**
     * @param usuarioModificacion the usuarioModificacion to set
     */
    public void setUsuarioModificacion(Integer usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    /**
     * @return the fechaCreacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * @return the fechaModificacion
     */
    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    /**
     * @param fechaModificacion the fechaModificacion to set
     */
    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    /**
     * @return the idSucursal
     */
    public Sucursal getIdSucursal() {
        return idSucursal;
    }

    /**
     * @param idSucursal the idSucursal to set
     */
    public void setIdSucursal(Sucursal idSucursal) {
        this.idSucursal = idSucursal;
    }

}
