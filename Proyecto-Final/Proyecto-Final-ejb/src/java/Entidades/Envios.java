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
@Table(name = "ENVIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Envios.findAll", query = "SELECT e FROM Envios e")
    , @NamedQuery(name = "Envios.findByTipodeenvio", query = "SELECT e FROM Envios e WHERE e.tipodeenvio = :tipodeenvio")
    , @NamedQuery(name = "Envios.findByContenido", query = "SELECT e FROM Envios e WHERE e.contenido = :contenido")
    , @NamedQuery(name = "Envios.findByFecha", query = "SELECT e FROM Envios e WHERE e.fecha = :fecha")})
public class Envios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TIPODEENVIO")
    private String tipodeenvio;
    @Size(max = 200)
    @Column(name = "CONTENIDO")
    private String contenido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public Envios() {
    }

    public Envios(String tipodeenvio) {
        this.tipodeenvio = tipodeenvio;
    }

    public Envios(String tipodeenvio, Date fecha) {
        this.tipodeenvio = tipodeenvio;
        this.fecha = fecha;
    }

    public String getTipodeenvio() {
        return tipodeenvio;
    }

    public void setTipodeenvio(String tipodeenvio) {
        this.tipodeenvio = tipodeenvio;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipodeenvio != null ? tipodeenvio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Envios)) {
            return false;
        }
        Envios other = (Envios) object;
        if ((this.tipodeenvio == null && other.tipodeenvio != null) || (this.tipodeenvio != null && !this.tipodeenvio.equals(other.tipodeenvio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Envios[ tipodeenvio=" + tipodeenvio + " ]";
    }
    
}
