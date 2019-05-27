/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author jesus
 */
@Named (value="login")
@RequestScoped
public class Login {
    
    private String nif;
    private String contra;
    private String permiso;

    
    /**
     * Creates a new instance of entrada
     */
    public Login() {
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
    
    //Terminar de implementar
    public String log (){
        permiso = nif;
        if (contra.equals("admin") && nif.equals("admin")){return "admin.xhtml";}
        else if (contra.equals("personal") && nif.equals("personal")){return "personal_asociacion.xhtml";}
        else if (contra.equals("socio") && nif.equals("socio")){return "socio.xhtml";}
        return null;
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
