/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Entidades.Proyecto;
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
    
    private Proyecto proyecto;
    
    /* Campos de un Proyecto */
    private String id;
    private String nombreProyecto;
    private Date fechaCreacionProyecto;
    private String descripcionProyecto;
    
    public Añadir(){
        proyecto = new Proyecto();
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    
    public String añadirProyecto(){
        proyecto = new Proyecto(id, nombreProyecto, fechaCreacionProyecto, descripcionProyecto);
        
        try {
            negocio.añadirProyecto(proyecto);
            return null;
        } catch(Exception e){
            return null;
        }
    }
    
}
