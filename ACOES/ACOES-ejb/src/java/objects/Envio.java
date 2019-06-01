package objects;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
    @NamedQuery(name = "Envio.findAll", query = "SELECT e FROM Envio e"),
    @NamedQuery(name = "Envio.findByTipodeenvio", query = "SELECT e FROM Envio e WHERE e.tipodeenvio = :tipodeenvio"),
    @NamedQuery(name = "Envio.findByContenido", query = "SELECT e FROM Envio e WHERE e.contenido = :contenido"),
    @NamedQuery(name = "Envio.findByFecha", query = "SELECT e FROM Envio e WHERE e.fecha = :fecha"),
})

public class Envio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 50)
    private String tipodeenvio;
    
    @Size(max = 200)
    private String contenido;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    // Relaciones
    @ManyToOne
    private Socio emisor;
    
    @ManyToOne
    private Beneficiario receptor;

    public Envio(){}

    public Envio(String tipodeenvio){
        this.tipodeenvio = tipodeenvio;
    }

    public Envio(String tipodeenvio, Date fecha){
        this.tipodeenvio = tipodeenvio;
        this.fecha = fecha;
    }

    public String getTipodeenvio() {
        return tipodeenvio;
    }

    public void setTipodeenvio(String tipodeenvio) {
        this.tipodeenvio = tipodeenvio;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Socio getEmisor() {
        return emisor;
    }

    public void setEmisor(Socio emisor) {
        this.emisor = emisor;
    }

    public Beneficiario getReceptor() {
        return receptor;
    }

    public void setReceptor(Beneficiario receptor) {
        this.receptor = receptor;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Envio)) {
            return false;
        }
        Envio other = (Envio) object;
        
        return this.id == other.id;
    }
}
