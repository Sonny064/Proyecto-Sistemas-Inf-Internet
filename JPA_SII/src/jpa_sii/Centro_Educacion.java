package jpa_sii;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Jesús Márquez
 */
@Entity
public class Centro_Educacion implements Serializable extends Centro {

    private static final long serialVersionUID = 1L;
    @Column(nulleable = false)
    private int alumnos;
    private String tipo;

    public Centro_Educacion(String n, Date c, String l, int a, int t){
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
