/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jesus
 */
@Entity
@Table(name = "CENTROEDUCACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Centroeducacion.findAll", query = "SELECT c FROM Centroeducacion c")
    , @NamedQuery(name = "Centroeducacion.findById", query = "SELECT c FROM Centroeducacion c WHERE c.id = :id")
    , @NamedQuery(name = "Centroeducacion.findByNumeroalumnos", query = "SELECT c FROM Centroeducacion c WHERE c.numeroalumnos = :numeroalumnos")
    , @NamedQuery(name = "Centroeducacion.findByTipoeducacion", query = "SELECT c FROM Centroeducacion c WHERE c.tipoeducacion = :tipoeducacion")})
public class Centroeducacion implements Serializable {

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
    @Size(min = 1, max = 10)
    @Column(name = "NUMEROALUMNOS")
    private String numeroalumnos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TIPOEDUCACION")
    private String tipoeducacion;

    public Centroeducacion() {
    }

    public Centroeducacion(String id) {
        this.id = id;
    }

    public Centroeducacion(String id, String numeroalumnos, String tipoeducacion) {
        this.id = id;
        this.numeroalumnos = numeroalumnos;
        this.tipoeducacion = tipoeducacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumeroalumnos() {
        return numeroalumnos;
    }

    public void setNumeroalumnos(String numeroalumnos) {
        this.numeroalumnos = numeroalumnos;
    }

    public String getTipoeducacion() {
        return tipoeducacion;
    }

    public void setTipoeducacion(String tipoeducacion) {
        this.tipoeducacion = tipoeducacion;
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
        if (!(object instanceof Centroeducacion)) {
            return false;
        }
        Centroeducacion other = (Centroeducacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Centroeducacion[ id=" + id + " ]";
    }
    
}
