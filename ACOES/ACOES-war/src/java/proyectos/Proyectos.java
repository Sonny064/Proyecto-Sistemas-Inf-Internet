package proyectos;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import auth.Sesion;
import backend.ModeloLocal;
import objects.*;

@Named(value="proyectos")
@RequestScoped
public class Proyectos {
    @EJB
    private ModeloLocal modelo;
    
    @Inject
    private Sesion sesion;
    
    private List<Proyecto> proyectos;

    public Proyectos(){
        if(sesion.getUser() instanceof Trabajador){
            proyectos = modelo.findAll(Proyecto.class);
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
    
    public List<Proyecto> getProyectos(){
        return proyectos;
    }
    
    public void setProyectos(List<Proyecto> p){
        proyectos = p;
    }
    
    public void refresh(){
        proyectos = modelo.findAll(Proyecto.class);
    }
    
    public void update(Proyecto p){
        if(sesion.admin()){
            modelo.update(p);
        } else {
            // TODO
        }
    }
    
    public void delete(Proyecto p){
        if(sesion.admin()){
            modelo.delete(p);
        } else {
            // TODO
        }
    }
}
