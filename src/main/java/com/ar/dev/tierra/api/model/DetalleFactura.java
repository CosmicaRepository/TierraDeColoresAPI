package com.ar.dev.tierra.api.model;
// Generated 17/02/2016 00:47:04 by Hibernate Tools 4.3.1

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
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
 * DetalleFactura generated by hbm2java
 */
@Entity
@Table(name = "detalle_factura")
public class DetalleFactura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_detalle_factura", unique = true, nullable = false)
    private int idDetalleFactura;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_factura", nullable = false)
    private Factura factura;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @Column(name = "cantidad_detalle", nullable = false)
    private int cantidadDetalle;

    @Column(name = "total_detalle", nullable = false)
    private int totalDetalle;

    @Column(name = "descuento_detalle")
    private Integer descuentoDetalle;

    @Column(name = "estado_detalle", nullable = false)
    private boolean estadoDetalle;

    @Column(name = "usuario_creacion", nullable = false)
    private int usuarioCreacion;

    @Column(name = "usuario_modificacion")
    private Integer usuarioModificacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", nullable = false, length = 35)
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_modificacion", length = 35)
    private Date fechaModificacion;

    public DetalleFactura() {
    }

    public DetalleFactura(int idDetalleFactura, Factura factura, Producto producto, int cantidadDetalle, int totalDetalle, Integer descuentoDetalle, boolean estadoDetalle, int usuarioCreacion, Integer usuarioModificacion, Date fechaCreacion, Date fechaModificacion) {
        this.idDetalleFactura = idDetalleFactura;
        this.factura = factura;
        this.producto = producto;
        this.cantidadDetalle = cantidadDetalle;
        this.totalDetalle = totalDetalle;
        this.descuentoDetalle = descuentoDetalle;
        this.estadoDetalle = estadoDetalle;
        this.usuarioCreacion = usuarioCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    /**
     * @return the idDetalleFactura
     */
    public int getIdDetalleFactura() {
        return idDetalleFactura;
    }

    /**
     * @param idDetalleFactura the idDetalleFactura to set
     */
    public void setIdDetalleFactura(int idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    /**
     * @return the factura
     */
    public Factura getFactura() {
        return factura;
    }

    /**
     * @param factura the factura to set
     */
    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    /**
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * @return the cantidadDetalle
     */
    public int getCantidadDetalle() {
        return cantidadDetalle;
    }

    /**
     * @param cantidadDetalle the cantidadDetalle to set
     */
    public void setCantidadDetalle(int cantidadDetalle) {
        this.cantidadDetalle = cantidadDetalle;
    }

    /**
     * @return the totalDetalle
     */
    public int getTotalDetalle() {
        return totalDetalle;
    }

    /**
     * @param totalDetalle the totalDetalle to set
     */
    public void setTotalDetalle(int totalDetalle) {
        this.totalDetalle = totalDetalle;
    }

    /**
     * @return the descuentoDetalle
     */
    public Integer getDescuentoDetalle() {
        return descuentoDetalle;
    }

    /**
     * @param descuentoDetalle the descuentoDetalle to set
     */
    public void setDescuentoDetalle(Integer descuentoDetalle) {
        this.descuentoDetalle = descuentoDetalle;
    }

    /**
     * @return the estadoDetalle
     */
    public boolean isEstadoDetalle() {
        return estadoDetalle;
    }

    /**
     * @param estadoDetalle the estadoDetalle to set
     */
    public void setEstadoDetalle(boolean estadoDetalle) {
        this.estadoDetalle = estadoDetalle;
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

}
