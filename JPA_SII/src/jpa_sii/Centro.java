package jpa_sii;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

/**
 *
 * @author Jesús Márquez
 * TODO relacion centros -> pagos
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Centro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nulleable = false)
    private String nombre;
    @Column(nulleable = false)
    private Date creacion;
    @Column(nulleable = false)
    private String localizacion;

    public Centro(String n, Date c, String l){
      nombre = n;
      creacion = c;
      localizacion = l;
    }

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
