package auth;

import objects.Trabajador;
import objects.Socio;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ejb.EJB;

import backend.ModeloLocal;

@Named(value="sesion")
@SessionScoped
public class Sesion implements Serializable {
    @EJB
    private ModeloLocal modelo;
    
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
    
    public void close(){
        user = null;
    }
}
