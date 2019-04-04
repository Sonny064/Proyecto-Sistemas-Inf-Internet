/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_sii;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Carlos
 */
@Entity
public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Short codigoPostal;
    @Column(nulleable=false)
    private String poblacion;

    @OneToMany
    private List<Centro> socios;

    public Short getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(Short codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPoblacion() {
        return poblacion;
    }
    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public List<Centro> getSocios() {
        return socios;
    }
    public void setSocios(List<Centro> socios) {
        this.socios = socios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPostal != null ? codigoPostal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        return !((this.codigoPostal == null && other.codigoPostal != null) || (this.codigoPostal != null && !this.codigoPostal.equals(other.codigoPostal)));
    }

    @Override
    public String toString() {
        return "jpa_sii.Municipio[ id=" + codigoPostal + " ]";
    }

}
