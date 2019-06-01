package auth;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.inject.Inject;

import backend.ModeloLocal;
import objects.Trabajador;
import objects.Socio;

@Named(value="login")
@RequestScoped
public class Login {   
    @EJB
    private ModeloLocal modelo;
    
    @Inject
    private Sesion sesion;

    private String nif;
    private String password;

    public Login(){}

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

    public String log(){
        Trabajador user = modelo.find(Trabajador.class, nif);
        
        if(user != null && user.checkPassword(password)){
            sesion.setUser(user);
            return "proyectos.xhtml";
        } else {
            Socio socio = modelo.find(Socio.class, nif);
            if(socio != null && socio.checkPassword(password)){
                sesion.setUser(socio);
                return "proyectos.xhtml";
            } else {
                return null;
            }
        }
    }
}
