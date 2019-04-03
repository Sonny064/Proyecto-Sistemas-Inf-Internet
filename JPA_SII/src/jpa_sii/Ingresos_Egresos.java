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
 */
@Entity
public class Ingresos_Egresos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nulleable = false)
    private String tipo;
    @Column(nulleable = false)
    private Date fecha;
    @Column(nulleable = false)
    private Date fechaDePago;
    @Column(nulleable = false)
    private int cantidad;
    private String descripcion;

    public Ingresos_Egresos(String t, Date f, Date fp, int c, String d){
      tipo = t;
      fecha = f;
      fechaDePago = fp;
      cantidad = c;
      descripcion = d;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo(){
      return tipo;
    }

    public void setTipo(String t){
      tipo = t;
    }

    public Date getFecha(){
      return fecha;
    }

    public void setFecha(Date d){
      fecha = d;
    }

    public Date getFechaDePago(){
      return fechaDePago;
    }

    public void setFechaDePago(Date d){
      fechaDePago = d;
    }

    public int getCantidad(){
      return cantidad;
    }

    public void setCantidad(int c){
      cantidad = c;
    }

    public String getDescripcion(){
      return descripcion;
    }

    public void setDescripcion(String t){
      descripcion = t;
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
        if (!(object instanceof Ingresos_Egresos)) {
            return false;
        }
        Ingresos_Egresos other = (Ingresos_Egresos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa_sii.Ingresos_Egresos[ id=" + id + " ]";
    }

}
