package auth;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.inject.Inject;

import backend.ModeloLocal;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import objects.Trabajador;
import objects.Socio;

@Named(value="recuperacion")
@SessionScoped
public class Recuperacion implements Serializable {   
    @EJB
    private ModeloLocal modelo;
    
    @Inject
    private Sesion sesion;

    private String nif;
    private String email;
    
    private Object user;
    private Integer phase = 0;
    
    private String password;
    private String verify;

    public Recuperacion(){
    if(sesion != null && sesion.getUser() != null){
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            try {
                ec.redirect("index.html");
            } catch(Exception e) {}
        }
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    
    public Integer getPhase(){
        return phase;
    }
    
    public void setPhase(Integer p){
        phase = p;
    }
    
    public void check(){
        Trabajador t = modelo.find(Trabajador.class, nif);
        if(t != null){
            if(t.getEmail().equals(email)){
                user = t;
                phase++;
            } else {
                // TODO: Doesnt match
                System.out.println("Doesnt match");
            }
        } else {
            System.out.println("null trabajador");
            Socio s = modelo.find(Socio.class, nif);
            if(s != null){
                if(s.getEmail().equals(email)){
                    user = s;
                    phase++;
                } else {
                    // TODO: Doesnt match
                    System.out.println("Doesnt match");
                }
            } else {
                // TODO: Doesnt match
                System.out.println("unkown");
            }
        }
    }

    public String cambiar(){
        if(password.equals(verify)){
            if(user != null && user instanceof Trabajador){
                Trabajador t = (Trabajador)user;
                if(t.changePassword(password)){
                    try {
                        modelo.update(t);
                        return "login.xhtml";
                    } catch(Exception e){
                        // TODO:
                        return null;
                    }
                } else {
                    // TODO:
                    return null;
                }  
                
            } else if(user != null && user instanceof Socio){
                Socio s = (Socio)user;
                if(s.changePassword(password)){
                    try {
                        modelo.update(s);
                        return "login.xhtml";
                    } catch(Exception e){
                        // TODO:
                        return null;
                    }
                } else {
                    // TODO:
                    return null;
                }      
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
    
    public String next(){       
        switch(phase){
            case 1:
                check();
                nif = null;
                email = null;
                return null;
            case 2:
                return cambiar();
            default:
                phase++;
                return null;
        }
    }
    
    public void back(){
        if(phase == 2){
            user = null;
        }
        
        phase--;
    }
}
