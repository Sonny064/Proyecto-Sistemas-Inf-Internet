package controller;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.annotation.PostConstruct;

import auth.Sesion;
import backend.ModeloLocal;
import objects.*;

@Named(value="proyectos")
@SessionScoped
public class Proyectos implements Serializable {
    @EJB
    private ModeloLocal modelo;
    
    @Inject
    private Sesion sesion;
    
    private List<Proyecto> list;
    
    private Boolean editor = false;
    private Proyecto proyecto;

    public Proyectos(){}
    
    @PostConstruct
    public void init(){
        refresh();
    }
    
    public Sesion getSesion(){
        return sesion;
    }
    
    public void setSesion(Sesion s){
        sesion = s;
    }
    
    public List<Proyecto> getList(){
        return list;
    }
    
    public void setList(List<Proyecto> p){
        list = p;
    }
    
    public Proyecto getProyecto(){
        return proyecto;
    }
    
    public void setProyecto(Proyecto p){
        proyecto = p;
    }
    
    public Boolean getEditor(){
        return editor;
    }
    
    public void setEditor(Boolean b){
        editor = b;
    }
    
    public void refresh(){
        list = modelo.findAll(Proyecto.class);
    }
    
    public void enableEditor(){
        editor = true;
        proyecto = new Proyecto("Nombre", "Descripción");
    }
    
    public void enableEditor(Proyecto p){
        editor = true;
        proyecto = p;
    }

    public void disableEditor(){
        proyecto = null;
        editor = false;
    }
    
    public String insert(){
        if(sesion.admin() && !proyecto.getNombre().equals("Nombre")){
            try {
                modelo.add(proyecto);
                editor = false;
                refresh();
            } catch (Exception e) {
                // TODO
            }
        } else {
            // TODO
        }
        
        return null;
    }
    
    public String update(Proyecto p){
        if(sesion.admin()){
            try {
                modelo.update(p);
                editor = false;
                refresh();
            } catch (Exception e) {
                // TODO
            }
        } else {
            // TODO
        }
        
        return null;
    }
    
    public void delete(Proyecto p){
        if(sesion.admin()){
            try {
                modelo.delete(p);
                refresh();
            } catch (Exception e) {
                // TODO
            }
        } else {
            // TODO
        }
    }
}
