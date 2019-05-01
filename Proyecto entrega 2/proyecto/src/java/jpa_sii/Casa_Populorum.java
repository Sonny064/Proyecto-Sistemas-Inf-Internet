package jpa_sii;

import java.io.Serializable;
import javax.persistence.Entity;
import java.sql.Date;
import javax.persistence.Column;

/**
 *
 * @author Jesús Márquez
 */
@Entity
public class Casa_Populorum extends Centro  implements Serializable{

    private static final long serialVersionUID = 1L;
    @Column(nullable = false)
    private int camas;
    private String extension;
    
    //Constructores
    
    public Casa_Populorum(){
        
    }

    public Casa_Populorum(String n, Date c, String l, int ca, String e){
      super(n, c, l);
      camas = ca;
      extension = e;
    }
    
    //Getters and Setters

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
