package proyectos;

import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.context.FacesContext;

import auth.Sesion;
import backend.ModeloLocal;
import objects.*;

@Named(value="proyectos_editor")
@RequestScoped
public class Editor {
    @EJB
    private ModeloLocal modelo;
    
    @Inject
    private Sesion sesion;
           
    private Proyecto proyecto;

    public Editor(){
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
        Integer id;
        
        try {
            id = Integer.parseInt(paramMap.get("id"));
        } catch(Exception e) {
            id = null;
        }
    
        if(sesion.getUser() instanceof Trabajador){
            if(id != null){
                proyecto = modelo.find(Proyecto.class, id);
            } else {
                // TODO: Go to proyectos
            }
        } else {
            // TODO: Go to index
        }
    }
    
    public Sesion getSesion(){
        return sesion;
    }
    
    public void setSesion(Sesion s){
        sesion = s;
    }
    
    public Proyecto getProyecto(){
        return proyecto;
    }
    
    public void setProyecto(Proyecto p){
        proyecto = p;
    }
    
    public Trabajador getUser(){
        Object user = sesion.getUser();
        if(user instanceof Trabajador){
            Trabajador t = (Trabajador) user;
            return t;
        } else {
            return null;
        }
    }
    
}