package auth;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ejb.EJB;
import java.util.Date;

import backend.ModeloLocal;
import javax.inject.Inject;
import objects.Socio;

@Named(value="registro")
@RequestScoped
public class Registro implements Serializable {
    @EJB
    private ModeloLocal modelo;
    
    @Inject
    private Sesion sesion;
    
    private String nombre;
    private String apellidos;
    
    private String nif;    
    private String password;    
    private String verify;
    
    private String email;
    private String telefono;
    private Date fechadenacimiento;
    private String direccion;
    private String poblacion;
    private String provincia;
    private String codigopostal;
    
    public Registro(){}
    
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String s) {
        this.nombre = s;
    }
    
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String s) {
        this.apellidos = s;
    }
    
        
    public Date getFechadenacimiento(){
        return fechadenacimiento;
    }
    
    public void setFechadenacimiento(Date fechadenacimiento){
        this.fechadenacimiento = fechadenacimiento;
    }
    
    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    public String getPoblacion (){
        return poblacion;
    }
    
    public void setPoblacion(String poblacion){
        this.poblacion = poblacion;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String registrar(){        
        if(password.equals(verify) && nif != null && nombre != null && apellidos != null){
            Socio user = new Socio(nif, password, nombre, apellidos, email, fechadenacimiento, direccion, poblacion, provincia, codigopostal, telefono);

            try {
                modelo.add(user);
                return "login.xhtml";
            } catch(Exception e){
                return null;
            }
        } else {
            return null;
        }
    }
}