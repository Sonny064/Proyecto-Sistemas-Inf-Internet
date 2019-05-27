/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import Entidades.Socio;
import ejb.AplicacionException;
import ejb.CuentaExistenteException;
import ejb.Interfaz;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author jesus
 */
@Named(value="registro")
@SessionScoped
public class Registro implements Serializable {

    @EJB
    private Interfaz negocio;
    
    private Socio socio;

    private String reContra;
    /**
     * Creates a new instance of user
     */
    public Registro() {
     socio = new Socio() ;
    }

    public Socio getSocio(){
     return socio;
    }
    
    public void setSocio(Socio s){
     socio = s;
    }

    public String getReContra() {
        return reContra;
    }

    public void setReContra(String reContra) {
        this.reContra = reContra;
    }

    public String fin() throws AplicacionException{
        
      try{
        
        if (socio.getPassword().equals(reContra)){
            negocio.registrarUsuario(socio);
            return "login.xhtml";
        }else{
            FacesMessage fm = new FacesMessage("Compruebe que las contraseñas sean iguales");
            FacesContext.getCurrentInstance().addMessage("registro:reContra", fm);
            return null;
        }
        
      }catch (CuentaExistenteException e){
            FacesMessage fm = new FacesMessage("Ya existe una cuenta para este nif");
            FacesContext.getCurrentInstance().addMessage("registro:socio", fm);
      }catch (AplicacionException e){}
      
      return null;
    }
}