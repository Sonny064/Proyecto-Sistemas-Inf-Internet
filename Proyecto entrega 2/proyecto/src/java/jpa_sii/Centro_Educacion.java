package jpa_sii;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Column;
import java.sql.Date;

/**
 *
 * @author Jesús Márquez
 */
@Entity
public class Centro_Educacion extends Centro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(nullable = false)
    private int alumnos;
    private String tipo;
    
    public Centro_Educacion(){
        
    }

    public Centro_Educacion(String n, Date c, String l, int a, String t){
      super(n, c, l);
      alumnos = a;
      tipo = t;
    }

    public int getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(int n) {
        alumnos = n;
    }

    public String getTipo(){
      return tipo;
    }

    public void setTipo(String t){
      tipo = t;
    }
}
