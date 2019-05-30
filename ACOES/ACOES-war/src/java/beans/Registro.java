package beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.Date;

import backend.ModeloLocal;
import backend.CuentaExistenteException;
import entidades.*;

@Named(value="registro")
@SessionScoped
public class Registro implements Serializable {
    @EJB
    private ModeloLocal modelo;
    
    private String nombre;
    private String apellidos;
    
    private String nif;    
    private String password;    
    private String verify;
    
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
    
    public String registrar(){        
        if(password.equals(verify) && nif != null && nombre != null && apellidos != null){
            Trabajador user = new Trabajador(nif, true, password, nombre, apellidos, new Date(1990, 1, 1), new Date(), "Praise kek");
            
            try {
                modelo.registrar(user);
                return "login.xhtml";
            } catch(Exception e){
                return null;
            }

        } else {
            return null;
        }
    }
}