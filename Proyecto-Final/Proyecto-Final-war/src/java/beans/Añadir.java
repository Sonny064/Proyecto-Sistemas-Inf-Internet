/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Entidades.Beneficiario;
import Entidades.Envios;
import Entidades.Personal;
import Entidades.Proyecto;
import Entidades.Socio;
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
    
    private Proyecto proyecto;
    
    /* Campos de un Proyecto */
    private String idProyecto;
    private String nombreProyecto;
    private Date fechaCreacionProyecto;
    private String descripcionProyecto;
    
    private Personal personal;
    
    /* Campos de un Empleado */
    private String idPersonal;
    
    
    private Envios envio;
    
    /* Campos de un Envío */
    private String tipoDeEnvio;
    private String contenidoEnvio;
    private Date fechaEnvio;
    private Socio emisorEnvio;
    private Beneficiario receptorEnvio;
    
    public Añadir(){
        proyecto = new Proyecto();
        personal = new Personal();
        envio = new Envios();
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

    public Envios getEnvio() {
        return envio;
    }

    public void setEnvio(Envios envio) {
        this.envio = envio;
    }

    public String getTipoDeEnvio() {
        return tipoDeEnvio;
    }

    public void setTipoDeEnvio(String tipoDeEnvio) {
        this.tipoDeEnvio = tipoDeEnvio;
    }

    public String getContenidoEnvio() {
        return contenidoEnvio;
    }

    public void setContenidoEnvio(String contenidoEnvio) {
        this.contenidoEnvio = contenidoEnvio;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Socio getEmisorEnvio() {
        return emisorEnvio;
    }

    public void setEmisorEnvio(Socio emisorEnvio) {
        this.emisorEnvio = emisorEnvio;
    }

    public Beneficiario getReceptorEnvio() {
        return receptorEnvio;
    }

    public void setReceptorEnvio(Beneficiario receptorEnvio) {
        this.receptorEnvio = receptorEnvio;
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
        } catch(AplicacionException e){
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
    
    
    public String añadirEnvio(){
        envio = new Envios(tipoDeEnvio, fechaEnvio); 
       
        try{
            envio.setContenido(contenidoEnvio);
            envio.setEmisor(emisorEnvio);
            envio.setReceptor(receptorEnvio);
            negocio.añadirEnvio(envio);
            return "gestion_envios.xhtml?faces-redirect=true";
        } catch(AplicacionException e){
            return "gestion_envios.xhtml?faces-redirect=true";
        }
    }
    
    public String actualizarEnvio(){
        try {
            negocio.actualizarEnvio(tipoDeEnvio, contenidoEnvio, fechaEnvio);
            return "gestion_envios.xhtml?faces-redirect=true";
        } catch(AplicacionException e){
            return "gestion_envios.xhtml?faces-redirect=true";
        }
    }
    
    public String eliminarEnvio(){
        try {
            negocio.eliminarEnvio(tipoDeEnvio);
            return "gestion_envios.xhtml?faces-redirect=true";
        } catch(AplicacionException e){
            return "gestion_envios.xhtml?faces-redirect=true";
        }
    }
    
}
