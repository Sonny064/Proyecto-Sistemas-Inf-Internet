/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "PROYECTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")
    , @NamedQuery(name = "Proyecto.findById", query = "SELECT p FROM Proyecto p WHERE p.id = :id")
    , @NamedQuery(name = "Proyecto.findByNombreproyecto", query = "SELECT p FROM Proyecto p WHERE p.nombreproyecto = :nombreproyecto")
    , @NamedQuery(name = "Proyecto.findByFechadecreacion", query = "SELECT p FROM Proyecto p WHERE p.fechadecreacion = :fechadecreacion")
    , @NamedQuery(name = "Proyecto.findByDescripciondelproyecto", query = "SELECT p FROM Proyecto p WHERE p.descripciondelproyecto = :descripciondelproyecto")})
public class Proyecto implements Serializable {

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
    @Size(min = 1, max = 50)
    @Column(name = "NOMBREPROYECTO")
    private String nombreproyecto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHADECREACION")
    @Temporal(TemporalType.DATE)
    private Date fechadecreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESCRIPCIONDELPROYECTO")
    private String descripciondelproyecto;
    
    //Relaciones //
    @ManyToMany
    private List<Beneficiario> propietario_proyecto;

    @OneToMany(mappedBy="ingresos_proyecto")
    private List<Ingresosegresos> listaIngresos;

    @ManyToMany
    private List<Personal> personalProyecto;

  
    
    public Proyecto() {
    }

    public Proyecto(String id) {
        this.id = id;
    }

    public Proyecto(String id, String nombreproyecto, Date fechadecreacion, String descripciondelproyecto) {
        this.id = id;
        this.nombreproyecto = nombreproyecto;
        this.fechadecreacion = fechadecreacion;
        this.descripciondelproyecto = descripciondelproyecto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreproyecto() {
        return nombreproyecto;
    }

    public void setNombreproyecto(String nombreproyecto) {
        this.nombreproyecto = nombreproyecto;
    }

    public Date getFechadecreacion() {
        return fechadecreacion;
    }

    public void setFechadecreacion(Date fechadecreacion) {
        this.fechadecreacion = fechadecreacion;
    }

    public String getDescripciondelproyecto() {
        return descripciondelproyecto;
    }

    public void setDescripciondelproyecto(String descripciondelproyecto) {
        this.descripciondelproyecto = descripciondelproyecto;
    }
    
     public List<Beneficiario> getPropietario_proyecto() {
        return propietario_proyecto;
    }

    public void setPropietario_proyecto(List<Beneficiario> propietario_proyecto) {
        this.propietario_proyecto = propietario_proyecto;
    }

    public List<Ingresosegresos> getListaIngresos() {
        return listaIngresos;
    }

    public void setListaIngresos(List<Ingresosegresos> listaIngresos) {
        this.listaIngresos = listaIngresos;
    }

    public List<Personal> getPersonalProyecto() {
        return personalProyecto;
    }

    public void setPersonalProyecto(List<Personal> personalProyecto) {
        this.personalProyecto = personalProyecto;
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
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Proyecto[ id=" + id + " ]";
    }
    
}
