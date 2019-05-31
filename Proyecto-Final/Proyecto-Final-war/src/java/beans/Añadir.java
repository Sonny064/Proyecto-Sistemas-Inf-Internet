/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Entidades.Personal;
import Entidades.Proyecto;
import ejb.AplicacionException;
import ejb.Interfaz;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Carlos
 */

@Named(value="añadir")
@SessionScoped
public class Añadir implements Serializable{
    @EJB
    private Interfaz negocio;
    private Sesion sesion;
    
    private Proyecto proyecto;
    
    /* Campos de un Proyecto */
    private String idProyecto;
    private String nombreProyecto;
    private Date fechaCreacionProyecto;
    private String descripcionProyecto;
    
    private Personal personal;
    
    /* Campos de un Empleado */
    private String idPersonal;
    
    public Añadir(){
        proyecto = new Proyecto();
        personal = new Personal();
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public String getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public Date getFechaCreacionProyecto() {
        return fechaCreacionProyecto;
    }

    public void setFechaCreacionProyecto(Date fechaCreacionProyecto) {
        this.fechaCreacionProyecto = fechaCreacionProyecto;
    }

    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public String getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(String idPersonal) {
        this.idPersonal = idPersonal;
    }
    
    
    

    
    /* FUNCIONALIDADES */
    
    public String añadirProyecto(){
        proyecto = new Proyecto(idProyecto, nombreProyecto, fechaCreacionProyecto, descripcionProyecto);
        
        try {
            negocio.añadirProyecto(proyecto);
            return "gestion_proyectos.xhtml?faces-redirect=true";
        } catch(Exception e){
            return "gestion_proyectos.xhtml?faces-redirect=true";
        }
    }
    
    public String actualizarProyecto(){
        try {
            negocio.actualizarProyecto(idProyecto, nombreProyecto, descripcionProyecto);
            return "gestion_proyectos.xhtml?faces-redirect=true";
        } catch(Exception e){
            return "gestion_proyectos.xhtml?faces-redirect=true";
        }
    }
    
    public String eliminarProyecto(){
        try {
            negocio.eliminarProyecto(idProyecto);
            return "gestion_proyectos.xhtml?faces-redirect=true";
        } catch(AplicacionException e){
            return "gestion_proyectos.xhtml?faces-redirect=true";
        }
    }
    
    public String añadirPersonalAProyecto(){
        try{
            negocio.añadirPersonalAProyecto(idProyecto, idPersonal);
            return "gestion_proyectos.xhtml?faces-redirect=true";
        } catch(AplicacionException e){
            return "gestion_proyectos.xhtml?faces-redirect=true";
        }
    }
    
    public String eliminarPersonalDeProyecto(){
        try{
            negocio.eliminarPersonalDeProyecto(idProyecto, idPersonal);
            return "gestion_proyectos.xhtml?faces-redirect=true";
        } catch(AplicacionException e){
            return "gestion_proyectos.xhtml?faces-redirect=true";
        }
    }
    
    
}
