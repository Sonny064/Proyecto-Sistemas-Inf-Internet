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
    @NamedQuery(name = "Casapopulorum.findAll", query = "SELECT c FROM Casapopulorum c"),
    @NamedQuery(name = "Casapopulorum.findByNumerocamas", query = "SELECT c FROM Casapopulorum c WHERE c.numerocamas = :numerocamas"),
    @NamedQuery(name = "Casapopulorum.findByExtension", query = "SELECT c FROM Casapopulorum c WHERE c.extension = :extension")
})

public class Casapopulorum implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 10)
    private String numerocamas;
    
    @Size(max = 20)
    private String extension;

    public Casapopulorum(){}
    
    public Casapopulorum(String numerocamas){
        this.numerocamas = numerocamas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumerocamas() {
        return numerocamas;
    }

    public void setNumerocamas(String numerocamas) {
        this.numerocamas = numerocamas;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public int hashCode(){
        return id;
    }

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof Casapopulorum)){
            return false;
        }
        Casapopulorum other = (Casapopulorum) object;
        
        return this.id == other.id;
    }
}
