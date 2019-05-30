package objects;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p"),
    @NamedQuery(name = "Proyecto.findById", query = "SELECT p FROM Proyecto p WHERE p.id = :id"),
    @NamedQuery(name = "Proyecto.findByNombre", query = "SELECT p FROM Proyecto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Proyecto.findByFechadecreacion", query = "SELECT p FROM Proyecto p WHERE p.fechadecreacion = :fechadecreacion"),
    @NamedQuery(name = "Proyecto.findByDescripcion", query = "SELECT p FROM Proyecto p WHERE p.descripcion = :descripcion")
})

public class Proyecto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 50)
    private String nombre;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechadecreacion;
    
    @NotNull
    @Size(min = 1, max = 200)
    private String descripcion;
    
    // Relaciones
    @OneToMany
    private List<Beneficiario> beneficiarios;

    @OneToMany(mappedBy="proyecto")
    private List<Transaccion> transacciones;

    @OneToMany(mappedBy="proyecto")
    private List<Trabajador> personal;
    
    public Proyecto(){}

    public Proyecto(String nombre, Date fechadecreacion, String descripcion) {
        this.nombre = nombre;
        this.fechadecreacion = fechadecreacion;
        this.descripcion = descripcion;
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

    public Date getFechadecreacion() {
        return fechadecreacion;
    }

    public void setFechadecreacion(Date fechadecreacion) {
        this.fechadecreacion = fechadecreacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
     public List<Beneficiario> getBeneficiarios() {
        return beneficiarios;
    }

    public void setBeneficiarios(List<Beneficiario> beneficiarios) {
        this.beneficiarios = beneficiarios;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public List<Trabajador> getPersonal(){
        return personal;
    }

    public void setPersonal(List<Trabajador> personal) {
        this.personal = personal;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;

        return this.id == other.id;
    }  
}
