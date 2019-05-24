package objects;

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Center implements Serializable {
    public enum Type {
        POPULORUM,
        SCHOOL
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private Type type;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private String province;

    @Column(nullable = false)
    private String country;

    @ManyToOne
    private Project project;

    @OneToMany(mappedBy = "center")
    private List<Beneficiary> beneficiaries = new ArrayList<Beneficiary>();

    @OneToMany(mappedBy = "center")
    private List<Worker> workers = new ArrayList<Worker>();

    // Constructor
    public Center(){}
    
    public Center(Type _type, String _name, String _address, String _city, String _zipCode, String _province, String _country){
      type = _type;
      name = _name;
      city = _city;
      zipCode  = _zipCode;
      province = _province;
      country  = _country;
    }

    // Getters and setters
    public int getId(){
        return id;
    }

    public Type getType(){
        return type;
    }

    public void setId(Type _type){
        type = _type;
    }

    public String getName(){
        return name;
    }

    public void setName(String _name){
        name = _name;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String _address){
        address = _address;
    }

    public String getCity(){
        return city;
    }

    public void setCuty(String _city){
        city = _city;
    }

    public String getZipCode(){
        return zipCode;
    }

    public void setZipCode(String _zipCode){
        zipCode = _zipCode;
    }

    public String getProvince(){
        return province;
    }

    public void setProvince(String _province){
        province = _province;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String _country){
        country = _country;
    }

    public Project getProject(){
        return project;
    }

    public List<Beneficiary> getBeneficiaries(){
        return beneficiaries;
    }

    public List<Worker> getWorkers(){
        return workers;
    }
}
