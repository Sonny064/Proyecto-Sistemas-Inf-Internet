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
@Table(name = "MUNICIPIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m")
    , @NamedQuery(name = "Municipio.findByCodigopostal", query = "SELECT m FROM Municipio m WHERE m.codigopostal = :codigopostal")
    , @NamedQuery(name = "Municipio.findByPoblacion", query = "SELECT m FROM Municipio m WHERE m.poblacion = :poblacion")})
public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODIGOPOSTAL")
    private String codigopostal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "POBLACION")
    private String poblacion;

    public Municipio() {
    }

    public Municipio(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public Municipio(String codigopostal, String poblacion) {
        this.codigopostal = codigopostal;
        this.poblacion = poblacion;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigopostal != null ? codigopostal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.codigopostal == null && other.codigopostal != null) || (this.codigopostal != null && !this.codigopostal.equals(other.codigopostal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Municipio[ codigopostal=" + codigopostal + " ]";
    }
    
}
