/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;


/**
 *
 * @author jesus
 */
@Named(value = "entrada")
@ManagedBean
@SessionScoped
public class entrada {

    private String nif;
    private String contra;
    
    /**
     * Creates a new instance of entrada
     */
    public entrada() {
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
    
    public String log (){
        if (contra.equals("admin") && nif.equals("admin")){return "admin.xhtml";}
        else if (contra.equals("privilegio") && nif.equals("privilegio")){return "privilegio.xhtml";}
        else if (contra.equals("usuario") && nif.equals("usuario")){return "usuarionormal.xhtml";}
        return null;
    }
}
