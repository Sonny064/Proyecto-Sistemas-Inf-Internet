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

@Named(value="centros")
@SessionScoped
public class Centros implements Serializable {
    @EJB
    private ModeloLocal modelo;
    
    @Inject
    private Sesion sesion;
    
    private List<Centro> list;
    
    private Boolean editor = false;
    private Centro centro;

    public Centros(){}
    
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
    
    public List<Centro> getList(){
        return list;
    }
    
    public void setList(List<Centro> p){
        list = p;
    }
    
    public Centro getCentro(){
        return centro;
    }
    
    public void setCentro(Centro p){
        centro = p;
    }
    
    public Boolean getEditor(){
        return editor;
    }
    
    public void setEditor(Boolean b){
        editor = b;
    }
    
    public void refresh(){
        list = modelo.findAll(Centro.class);
    }
    
    public void enableEditor(){
        editor = true;
        centro = new Centro("Nombre", "Descripción");
    }
    
    public void enableEditor(Centro p){
        editor = true;
        centro = p;
    }

    public void disableEditor(){
        centro = null;
        editor = false;
    }
    
    public String insert(){
        if(sesion.admin() && !centro.getNombre().equals("Nombre")){
            try {
                modelo.add(centro);
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
    
    public String update(Centro p){
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
    
    public void delete(Centro p){
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
