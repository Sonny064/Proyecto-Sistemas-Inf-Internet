package objects;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import java.sql.Date;
import javax.persistence.ManyToOne;

@Entity
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private float value;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Date date;

    @ManyToOne
    private Center center;

    // Constructor
    public Payment(){}
    
    public Payment(Center _center, float _value, String _name, String _description, Date _date){
        center = _center;
        value  = _value;
        name   = _name;
        description = _description;
        date = _date;
    }

    // Getters and Setters
    public int getId(){
        return id;
    }

    public float getValue(){
        return value;
    }

    public void setValue(float _value){
        value = _value;
    }

    public String getName(){
        return name;
    }

    public void setName(String _name){
        name = _name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String _description){
        description = _description;
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date _date){
        date = _date;
    }

    public Center getCenter(){
        return center;
    }
}
