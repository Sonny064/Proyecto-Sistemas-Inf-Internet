/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.Interfaz;
import java.io.Serializable;
import javax.ejb.EJB;
import Entidades.Ingresosegresos;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
/**
 *
 * @author marina muñoz
 */
@Named(value = "gestionIngresos")
@SessionScoped
public class GestionIngresos implements Serializable {
    
    @EJB
    private Interfaz negocio;
    private Ingresosegresos ingreso;
    
   

    public Ingresosegresos getIngreso() {
        return ingreso;
    }

    public void setIngreso(Ingresosegresos ingreso) {
        this.ingreso = ingreso;
    }
    
    public String editar(Ingresosegresos i){
        setIngreso(i);
        return "edicionIngreso.xhtml?faces-redirect=true";
    }
    public String guardarEdicion(Ingresosegresos i){
        negocio.update(i);
        return "gestion_fondos.xhtml?faces-redirect=true";
    }
}
