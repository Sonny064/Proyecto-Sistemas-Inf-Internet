package beans;

import entidades.Trabajador;
import entidades.Socio;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import backend.ModeloLocal;


@Named(value="login")
@RequestScoped
public class Login {   
    @EJB
    private ModeloLocal modelo;

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
            return user.getAdministrador() ? "admin.xhtml" : "trabajador.xhml";
        } else {
            Socio socio = modelo.find(Socio.class, nif);
            if(socio != null && socio.checkPassword(password)){
                return "socio.xhml";
            } else {
                return null;
            }
        }
    }
}
