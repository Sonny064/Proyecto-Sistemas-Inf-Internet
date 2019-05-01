package jpa_sii;

import java.util.List;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Column;
import java.sql.Date;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Jesús Márquez
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Centro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private Date creacion;
    @Column(nullable = false)
    private String localizacion;

    @ManyToMany (mappedBy = "listadoCentros")
    private List<Personal_Asociacion> personal;

    @ManyToMany
    private List<Beneficiario> propietario_centro;


    @OneToMany(mappedBy="ingresos_centro")
    private List<Ingresos_Egresos> ingresos;
    
    //Constructores
    
    public Centro(){
        
    }

    public Centro(String n, Date c, String l){
      nombre = n;
      creacion = c;
      localizacion = l;
    }

    
    //Getters and Setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre(){
      return nombre;
    }

    public void setNombre(String n){
      nombre = n;
    }

    public Date getCreacion(){
      return creacion;
    }

    public void setCreacion(Date c){
      creacion = c;
    }

    public String getLocalizacion(){
      return localizacion;
    }

    public void setLocalizacion(String l){
      localizacion = l;
    }
    
     public List<Personal_Asociacion> getPersonal() {
        return personal;
    }

    public void setPersonal(List<Personal_Asociacion> personal) {
        this.personal = personal;
    }

    public List<Beneficiario> getPropietario_centro() {
        return propietario_centro;
    }

    public void setPropietario_centro(List<Beneficiario> propietario_centro) {
        this.propietario_centro = propietario_centro;
    }

    public List<Ingresos_Egresos> getIngresos() {
        return ingresos;
    }

    public void setIngresos(List<Ingresos_Egresos> ingresos) {
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
        return "jpa_sii.Socios[ id=" + id + " ]";
    }

}
