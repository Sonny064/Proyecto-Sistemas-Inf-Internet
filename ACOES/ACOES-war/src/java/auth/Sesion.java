package auth;

import objects.Trabajador;
import objects.Socio;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.context.FacesContext;

@Named(value="sesion")
@SessionScoped
public class Sesion implements Serializable {    
    private Object user;
    
    public Object getUser(){
        return user;
    }
    
    public void setUser(Trabajador _user){
        user = _user;
    }
    
    public void setUser(Socio _user){
        user = _user;
    }
    
    public Boolean admin(){
        if(user instanceof Trabajador){
            Trabajador t = (Trabajador) user;
            return t.getAdministrador();
        } else {
            return false;
        }
    }
    
    public String nombre(){
        if(user instanceof Trabajador){
            Trabajador t = (Trabajador) user;
            return t.getNombre();
        } else {
            if(user instanceof Socio){
                Socio s = (Socio) user;
                return s.getNombre();
            } else {
                return null;
            }
        }
    }
    
    public Boolean isTrabajador(){
        return user != null && user instanceof Trabajador;
    }
    
    public String close(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        user = null;
        return "login.xhtml";
    }
}
