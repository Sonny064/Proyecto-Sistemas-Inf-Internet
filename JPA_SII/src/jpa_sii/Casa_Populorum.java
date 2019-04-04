package jpa_sii;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 *
 * @author Jesús Márquez
 * TODO constructor
 */
@Entity
public class Casa_Populorum implements Serializable extends Centro {

    private static final long serialVersionUID = 1L;
    @Column(nulleable = false)
    private int camas;
    private String extension;

    @ManyToMany
    private List<Beneficiario> propietario_casa_populorum;

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
