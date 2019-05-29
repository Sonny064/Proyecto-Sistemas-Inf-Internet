/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Entidades.Personal;
import Entidades.Socio;
import ejb.AplicacionException;
import ejb.Interfaz;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/**
 *
 * @author jesus
 */
@Named(value="login")
@RequestScoped
public class Login {
    
    private Socio socio;
    private Personal personal;
    
    @EJB
    private Interfaz interfaz;
    
    
    private String nif;
    private String contra;
    private String permiso;


    /**
     * Creates a new instance of entrada
     */
    public Login() {
        socio = new Socio();
        personal = new Personal();
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    
    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
    
    //Terminar de implementar
    public String log () throws AplicacionException{
        
        Socio user = interfaz.buscarSocio(getNif());
        Personal pl = interfaz.buscarPersonal(getNif());
        
        if (contra.equals("admin") && nif.equals("admin")){return "admin.xhtml";}
        else if (user != null && user.getPassword().equals(contra)){return "socio.xhtml";}
        else if (pl != null && pl.getPassword().equals(contra)){return "personal_asociacion.xhtml";}
        else {return null;}

    }
    
    public String invalidarSesion()
    {
        if (nif != null)
        {
            nif = null;
            permiso = null;
            contra = null;
            //Terminar de implementar
        }
        return "login.xhtml";
    }
}
