package objects;

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import java.sql.Date;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Entity
public class Worker implements Serializable {
    public enum Profile {
      ADMIN,
      WORKER,
      MEMBER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    // Login info
    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String salt = "IShouldBeRandomButImFine";

    @Column(nullable = false)
    private String password = "";

    @Column(nullable = false)
    private Profile profile;

    // User data
    @Column(unique = true, nullable = false)
    private String id_card;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false)
    private Date birth_date;

    // Address
    private String address;

    private String city;

    private String province;

    private String zip_code;

    private String country;

    @ManyToOne
    private Center center;

    @OneToMany
    private List<Shipment> shipments = new ArrayList<Shipment>();

    // Constructor
    public Worker(){}
    
    public Worker(String _email, String _password, Profile _profile, String _id_card, String _first_name, String _last_name, Date _birth_date){
      email   = _email;
      changePassword("", _password);
      profile = _profile;
      
      id_card = _id_card;
      first_name = _first_name;
      last_name  = _last_name;
      birth_date = _birth_date;
    }

    // Getters
    public int getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }

    public Profile getProfile(){
        return profile;
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
        return email;
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

    public Center getCenter(){
        return center;
    }

    public List<Shipment> getShipments(){
        return shipments;
    }

    // Setters
    public void setEmail(String e){
        email = e;
    }

    public void setProfile(Profile p){
        profile = p;
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

    public void setCenter(Center c){
        center = c;
    }

    // Utils
    public boolean checkPassword(String pwd){
        try {
            String _pwd = salt + pwd;
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashInBytes = md.digest(_pwd.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            for (byte b : hashInBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString().equals(password);
        } catch(NoSuchAlgorithmException e){
            return false;
        }
    }

    public void changePassword(String old, String _new){
        if(password.length() == 0 || checkPassword(old)){
            try {
                String _pwd = salt + _new;
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hashInBytes = md.digest(_pwd.getBytes(StandardCharsets.UTF_8));

                StringBuilder sb = new StringBuilder();
                for (byte b : hashInBytes) {
                    sb.append(String.format("%02x", b));
                }

                password = sb.toString();
                
            } catch(NoSuchAlgorithmException e){}
        }
    }
}
