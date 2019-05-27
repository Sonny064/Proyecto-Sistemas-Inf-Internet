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
@Table(name = "CASAPOPULORUM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Casapopulorum.findAll", query = "SELECT c FROM Casapopulorum c")
    , @NamedQuery(name = "Casapopulorum.findById", query = "SELECT c FROM Casapopulorum c WHERE c.id = :id")
    , @NamedQuery(name = "Casapopulorum.findByNumerocamas", query = "SELECT c FROM Casapopulorum c WHERE c.numerocamas = :numerocamas")
    , @NamedQuery(name = "Casapopulorum.findByExtension", query = "SELECT c FROM Casapopulorum c WHERE c.extension = :extension")})
public class Casapopulorum implements Serializable {

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
    @Column(name = "NUMEROCAMAS")
    private String numerocamas;
    @Size(max = 20)
    @Column(name = "EXTENSION")
    private String extension;

    public Casapopulorum() {
    }

    public Casapopulorum(String id) {
        this.id = id;
    }

    public Casapopulorum(String id, String numerocamas) {
        this.id = id;
        this.numerocamas = numerocamas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumerocamas() {
        return numerocamas;
    }

    public void setNumerocamas(String numerocamas) {
        this.numerocamas = numerocamas;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
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
        if (!(object instanceof Casapopulorum)) {
            return false;
        }
        Casapopulorum other = (Casapopulorum) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Casapopulorum[ id=" + id + " ]";
    }
    
}
