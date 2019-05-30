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
import javax.inject.Inject;
import javax.inject.Named;


/**
 *
 * @author jesus
 */
@Named(value="login")
@RequestScoped
public class Login {
    
    private Socio socio;
    private Personal empleado;
    @Inject
    private Sesion sesion;
    
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
        empleado = new Personal();
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
        return empleado;
    }

    public void setPersonal(Personal personal) {
        this.empleado = personal;
    }
    
    //Terminar de implementar
    public String log () throws AplicacionException{
        
       empleado = interfaz.buscarPersonal(getNif());
       socio = interfaz.buscarSocio(getNif());
        
        if(empleado != null && empleado.getCargo().equals("ADMIN") && empleado.getPassword().equals(contra)){
            sesion.setUsuario(interfaz.refrescarUsuario(empleado));
            return "admin.xhtml?faces-redirect=true";
        }
        else if(empleado != null && empleado.getCargo().equals("EMPLEADO") && empleado.getPassword().equals(contra)){
            sesion.setUsuario(interfaz.refrescarUsuario(empleado));
            return "personal_asociacion.xhtml?faces-redirect=true";
        }
        else if(socio != null && socio.getPassword().equals(contra)){
            sesion.setUsuario(interfaz.refrescarUsuario(socio));
            return "socio.xhtml";
        }
        return null;
    }
}
