/**
 *
 * @author Dario Jesus Flores Sevilla
 */

@Entity
package jpa_sii;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TemporalType;
import javax.persistence.ManyToOne;


public class Envios implements Serializable {

    //Atributos
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Tipo_de_envio;
    private String Contenido;
    @Temporal(TemporalType.DATE)
    private Date Fecha;
    
    //Relación 
    @ManyToOne(mappedby = "envios")
    private List <Socios> emisores;
    @ManyToOne
    private List <Beneficiario> receptores;

    
    //Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo_de_envio() {
        return Tipo_de_envio;
    }

    public void setTipo_de_envio(String Tipo_de_envio) {
        this.Tipo_de_envio = Tipo_de_envio;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String Contenido) {
        this.Contenido = Contenido;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
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
        if (!(object instanceof Envios)) {
            return false;
        }
        Envios other = (Envios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa_sii.Envios[ id=" + id + " ]";
    }
    
}

