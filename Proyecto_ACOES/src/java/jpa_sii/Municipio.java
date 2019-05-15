/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_sii;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Column;
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
    private Short codigoPostal;
    @Column(nullable=false)
    private String poblacion;

    @OneToMany(mappedBy ="municipio")
    private List<Socios> socios_municipio;
    
    //Constructores
    
    private Municipio(){
        
    }

    private Municipio(Short cp, String p){
      codigoPostal = cp;
      poblacion = p;
    }
    
    //Getters and Setters

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

    public List<Socios> getSocios() {
        return socios_municipio;
    }
    public void setSocios(List<Socios> socios) {
        this.socios_municipio = socios;
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
