package objects;

import java.util.List;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import java.sql.Date;
import javax.persistence.ManyToOne;

@Entity
public class Beneficiary implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    // User data
    @Column(unique = true, nullable = false)
    private String id_card;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false)
    private Date birth_date;

    @ManyToOne
    private Center center;

    // Address
    private String address;

    private String city;

    private String province;

    private String zip_code;

    private String country;

    // Constructor
    public Beneficiary(){}
    
    public Beneficiary(String _id_card, String _first_name, String _last_name, Date _birth_date){
        id_card = _id_card;
        first_name = _first_name;
        last_name = _last_name;
        birth_date = _birth_date;
    }
    
    // Getters
    public int getId(){
        return id;
    }

    public String getIdCard(){
        return id_card;
    }

    public String getFirstName(){
        return first_name;
    }

    public String getLastName(){
        return last_name;
    }

    public Date getBirthDate(){
        return birth_date;
    }

    public String getAddress(){
        return address;
    }

    public String getCity(){
        return city;
    }

    public String getProvince(){
        return province;
    }

    public String getZipCode(){
        return zip_code;
    }

    public String getCountry(){
        return country;
    }

    // Setters
    public void setId(int i){
        id = i;
    }

    public void setIdCard(String e){
        id_card = e;
    }

    public void setFirstName(String e){
        first_name = e;
    }

    public void setLastName(String e){
        last_name = e;
    }

    public void setBirthDate(Date e){
        birth_date = e;
    }

    public void setAddress(String e){
        address = e;
    }

    public void setCity(String e){
        city = e;
    }

    public void setProvince(String e){
        province = e;
    }

    public void setZipCode(String e){
        zip_code = e;
    }

    public void setCountry(String e){
        country = e;
    }

    public Center getCenter(){
        return center;
    }

    public void setCenter(Center _center){
        center = _center;
    }
}
