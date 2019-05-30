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

    public Personal getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Personal empleado) {
        this.empleado = empleado;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
    
    
    
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
        return "login.xhtml?faces-redirect=true";
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
    
    public synchronized boolean tipoUsuario() throws AplicacionException{
        if(empleado != null && empleado.getCargo().equals("ADMIN")){
            return true;
        }
        else if(empleado != null && empleado.getCargo().equals("EMPLEADO")){
            return false;
        }
        return false;
    }
    
    public synchronized String getPermiso() throws AplicacionException{
        String permiso = "sin permiso";
        if(socio !=null){
            permiso = "socio";
        }else if(empleado != null && empleado.getCargo().equalsIgnoreCase("admin")){
            permiso = "admin";
        }else if(empleado !=null){
            permiso = "personal";
        }
      return permiso;
    }
}
