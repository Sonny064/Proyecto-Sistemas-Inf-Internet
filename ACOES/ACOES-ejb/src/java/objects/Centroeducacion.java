package objects;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
    @NamedQuery(name = "Centroeducacion.findAll", query = "SELECT c FROM Centroeducacion c"),
    @NamedQuery(name = "Centroeducacion.findByNumeroalumnos", query = "SELECT c FROM Centroeducacion c WHERE c.numeroalumnos = :numeroalumnos"),
    @NamedQuery(name = "Centroeducacion.findByTipoeducacion", query = "SELECT c FROM Centroeducacion c WHERE c.tipoeducacion = :tipoeducacion")
})

public class Centroeducacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 10)
    private String numeroalumnos;
    
    @NotNull
    @Size(min = 1, max = 50)
    private String tipoeducacion;

    public Centroeducacion(){}

    public Centroeducacion(String numeroalumnos, String tipoeducacion) {
        this.numeroalumnos = numeroalumnos;
        this.tipoeducacion = tipoeducacion;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroalumnos() {
        return numeroalumnos;
    }

    public void setNumeroalumnos(String numeroalumnos) {
        this.numeroalumnos = numeroalumnos;
    }

    public String getTipoeducacion() {
        return tipoeducacion;
    }

    public void setTipoeducacion(String tipoeducacion) {
        this.tipoeducacion = tipoeducacion;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Centroeducacion)) {
            return false;
        }
        Centroeducacion other = (Centroeducacion) object;
        
        return this.id == other.id;
    }
}
