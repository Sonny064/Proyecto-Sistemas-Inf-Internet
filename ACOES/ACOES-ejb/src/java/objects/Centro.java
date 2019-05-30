package objects;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
    @NamedQuery(name = "Centro.findAll", query = "SELECT c FROM Centro c"),
    @NamedQuery(name = "Centro.findByNombre", query = "SELECT c FROM Centro c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Centro.findByFechacreacion", query = "SELECT c FROM Centro c WHERE c.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Centro.findByLocalizacion", query = "SELECT c FROM Centro c WHERE c.localizacion = :localizacion")
})

public class Centro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 50)
    private String nombre;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechacreacion;
    
    @NotNull
    @Size(min = 1, max = 50)
    private String localizacion;
    
    // Relaciones
    @OneToMany(mappedBy = "centro")
    private List<Trabajador> personal;

    @OneToOne
    private Beneficiario propietario;
    
    @OneToMany
    private List<Beneficiario> residentes;

    @OneToMany(mappedBy="centro")
    private List<Transaccion> ingresos;

    public Centro(){}

    public Centro(String nombre, Date fechacreacion, String localizacion){
        this.nombre = nombre;
        this.fechacreacion = fechacreacion;
        this.localizacion = localizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    
    public List<Trabajador> getPersonal() {
        return personal;
    }

    public void setPersonal(List<Trabajador> personal) {
        this.personal = personal;
    }
    
    public List<Beneficiario> getResidentes() {
        return residentes;
    }

    public void setResidentes(List<Beneficiario> residentes) {
        this.residentes = residentes;
    }

    public Beneficiario getPropietario(){
        return propietario;
    }

    public void setPropietario(Beneficiario propietario) {
        this.propietario = propietario;
    }

    public List<Transaccion> getIngresos() {
        return ingresos;
    }

    public void setIngresos(List<Transaccion> ingresos) {
        this.ingresos = ingresos;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Centro)) {
            return false;
        }
        Centro other = (Centro) object;
        
        return this.id == other.id;
    }
}
