/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Entidades.Municipio;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import Entidades.Socio;

/**
 *
 * @author jesus
 */
@Named(value="registro")
@SessionScoped
public class Registro implements Serializable {

    private Socio socio;
    private Municipio municipio;

    private String reContra;
    /**
     * Creates a new instance of user
     */
    public Registro() {
     socio = new Socio() ;
     municipio =  new Municipio();
    }

    public Socio getSocio(){
     return socio;
    }
    
    public void setSocio(Socio s){
     socio = s;
    }
    
    public Municipio getMunicipio(){
    return municipio;
    }
    
    public void setMunicipio (Municipio municipio){
       this.municipio=municipio;
    }
    
    public String getReContra() {
        return reContra;
    }

    public void setReContra(String reContra) {
        this.reContra = reContra;
    }

    public String fin(){
        
        if (socio.getPassword().equals(reContra)){return "login.xhtml";}
        else{return null;}
    }
}