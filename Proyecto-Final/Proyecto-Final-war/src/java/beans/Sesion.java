/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ejb.Interfaz;
import Entidades.Personal;
import Entidades.Socio;
import ejb.AplicacionException;
import javax.faces.context.FacesContext;
/**
 *
 * @author Carlos
 */

@Named(value = "sesion")
@SessionScoped
public class Sesion implements Serializable {
    
    @Inject
    private Interfaz negocio;
    private Personal empleado;
    private Socio socio;
    
    public Sesion(){}
    
    public synchronized void setUsuario(Object usuario) throws AplicacionException {
        if(usuario instanceof Personal){
            this.empleado = (Personal) usuario;
        }
        else if (usuario instanceof Socio){
            this.socio = (Socio) usuario;
        }
        else throw new AplicacionException();
    }
    
    public synchronized Object getUsuario() throws AplicacionException {
        if(empleado != null){
            return empleado;
        }
        else if(socio != null){
            return socio;
        }
        else throw new AplicacionException();
    }
    
        
    public String invalidarSesion(){

        if(empleado != null){
            empleado = null;
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        }
        else if(socio != null){
            socio = null;
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        }
        return "login.xhtml";
    }
    
    public synchronized void refrescarUsuario() throws AplicacionException {
        if (empleado != null){
            empleado = (Personal) negocio.refrescarUsuario(empleado);
        }
        else if(socio != null){
            socio = (Socio) negocio.refrescarUsuario(socio);
        }
        else throw new AplicacionException();
    }
    
    public synchronized String tipoUsuario() throws AplicacionException{
        if(empleado != null && empleado.getCargo().equals("ADMIN")){
            return "ADMIN";
        }
        else if(empleado != null && empleado.getCargo().equals("EMPLEADO")){
            return "EMPLEADO";
        }
        else if(socio != null){
            return "SOCIO";
        }
        else throw new AplicacionException();
    }
}
