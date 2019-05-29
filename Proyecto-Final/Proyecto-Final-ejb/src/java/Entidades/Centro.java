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
@Table(name = "CENTRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Centro.findAll", query = "SELECT c FROM Centro c")
    , @NamedQuery(name = "Centro.findById", query = "SELECT c FROM Centro c WHERE c.id = :id")
    , @NamedQuery(name = "Centro.findByNombre", query = "SELECT c FROM Centro c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Centro.findByFechacreacion", query = "SELECT c FROM Centro c WHERE c.fechacreacion = :fechacreacion")
    , @NamedQuery(name = "Centro.findByLocalizacion", query = "SELECT c FROM Centro c WHERE c.localizacion = :localizacion")})
public class Centro implements Serializable {

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
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHACREACION")
    @Temporal(TemporalType.DATE)
    private Date fechacreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LOCALIZACION")
    private String localizacion;
    
    //Relaciones//
    @ManyToMany (mappedBy = "listadoCentros")
    private List<Personal> personal;

    @ManyToMany
    private List<Beneficiario> propietario_centro;


    @OneToMany(mappedBy="ingresos_centro")
    private List<Ingresosegresos> ingresos;

   
    
    

    public Centro() {
    }

    public Centro(String id) {
        this.id = id;
    }

    public Centro(String id, String nombre, Date fechacreacion, String localizacion) {
        this.id = id;
        this.nombre = nombre;
        this.fechacreacion = fechacreacion;
        this.localizacion = localizacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }
    
    public List<Personal> getPersonal() {
        return personal;
    }

    public void setPersonal(List<Personal> personal) {
        this.personal = personal;
    }

    public List<Beneficiario> getPropietario_centro() {
        return propietario_centro;
    }

    public void setPropietario_centro(List<Beneficiario> propietario_centro) {
        this.propietario_centro = propietario_centro;
    }

    public List<Ingresosegresos> getIngresos() {
        return ingresos;
    }

    public void setIngresos(List<Ingresosegresos> ingresos) {
        this.ingresos = ingresos;
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
        if (!(object instanceof Centro)) {
            return false;
        }
        Centro other = (Centro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Centro[ id=" + id + " ]";
    }
    
}
