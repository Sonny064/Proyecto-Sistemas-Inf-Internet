/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jesus
 */
@Entity
@Table(name = "INGRESOSEGRESOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingresosegresos.findAll", query = "SELECT i FROM Ingresosegresos i")
    , @NamedQuery(name = "Ingresosegresos.findById", query = "SELECT i FROM Ingresosegresos i WHERE i.id = :id")
    , @NamedQuery(name = "Ingresosegresos.findByTipo", query = "SELECT i FROM Ingresosegresos i WHERE i.tipo = :tipo")
    , @NamedQuery(name = "Ingresosegresos.findByFecha", query = "SELECT i FROM Ingresosegresos i WHERE i.fecha = :fecha")
    , @NamedQuery(name = "Ingresosegresos.findByFechadepago", query = "SELECT i FROM Ingresosegresos i WHERE i.fechadepago = :fechadepago")
    , @NamedQuery(name = "Ingresosegresos.findByCantidad", query = "SELECT i FROM Ingresosegresos i WHERE i.cantidad = :cantidad")
    , @NamedQuery(name = "Ingresosegresos.findByDescripcion", query = "SELECT i FROM Ingresosegresos i WHERE i.descripcion = :descripcion")})
public class Ingresosegresos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TIPO")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHADEPAGO")
    private Boolean fechadepago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CANTIDAD")
    private String cantidad;
    @Size(max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public Ingresosegresos() {
    }

    public Ingresosegresos(String id) {
        this.id = id;
    }

    public Ingresosegresos(String id, String tipo, Date fecha, Boolean fechadepago, String cantidad) {
        this.id = id;
        this.tipo = tipo;
        this.fecha = fecha;
        this.fechadepago = fechadepago;
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getFechadepago() {
        return fechadepago;
    }

    public void setFechadepago(Boolean fechadepago) {
        this.fechadepago = fechadepago;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingresosegresos)) {
            return false;
        }
        Ingresosegresos other = (Ingresosegresos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Ingresosegresos[ id=" + id + " ]";
    }
    
}
