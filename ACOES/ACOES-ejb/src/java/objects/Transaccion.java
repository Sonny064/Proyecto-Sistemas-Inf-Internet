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
    @NamedQuery(name = "Transaccion.findAll", query = "SELECT i FROM Transaccion i"),
    @NamedQuery(name = "Transaccion.findByFecha", query = "SELECT i FROM Transaccion i WHERE i.fecha = :fecha"),
    @NamedQuery(name = "Transaccion.findByCantidad", query = "SELECT i FROM Transaccion i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "Transaccion.findByDescripcion", query = "SELECT i FROM Transaccion i WHERE i.descripcion = :descripcion")
})

public class Transaccion implements Serializable {  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @NotNull
    private Float cantidad;
    
    @Size(max = 200)
    private String descripcion;
    
    // Relaciones
    // TODO: Check if we must list transactions by "socio"
    // @ManyToOne
    // private Socio ingresos;

    @ManyToOne
    private Proyecto proyecto;

    @ManyToOne
    private Centro centro;
    
    public Transaccion(){}

    public Transaccion(Float cantidad, Date fecha) {
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto Proyecto) {
        this.proyecto = Proyecto;
    }
    public Centro getCentro() {
        return centro;
    }

    public void setCentro(Centro centro) {
        this.centro = centro;
    }
    
    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaccion)) {
            return false;
        }
        Transaccion other = (Transaccion) object;
        
        return this.id == other.id;
    }
}
