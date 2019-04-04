package jpa_sii;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 *
 * @author Jesús Márquez
 */
@Entity
public class Casa_Populorum implements Serializable extends Centro {

    private static final long serialVersionUID = 1L;
    @Column(nulleable = false)
    private int camas;
    private String extension;

    public Casa_Populorum(String n, Date c, String l, int ca, int e){
      super(n, c, l);
      camas = ca;
      extension = e;
    }

    public int getCamas() {
        return camas;
    }

    public void setCamas(int n) {
        camas = n;
    }

    public String getextension(){
      return extension;
    }

    public void setextension(String t){
      extension = t;
    }
}
