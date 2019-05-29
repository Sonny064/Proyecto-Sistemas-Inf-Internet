/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Entidades.Socio;
import ejb.AplicacionException;
import ejb.Interfaz;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author javid
 */
@Named(value = "empleado")
@SessionScoped
public class Empleado implements Serializable{
    
    @EJB
    private Interfaz interfaz;
    private Socio socio ;

    /**
     * Creates a new instance of Empleado
     */
    public Empleado() {
        this.socio = new Socio();
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
    
    
    public synchronized void miusuario () throws AplicacionException{
        
        this.socio = interfaz.buscarSocio(this.socio.getNif());
    }
    
    
    
}
