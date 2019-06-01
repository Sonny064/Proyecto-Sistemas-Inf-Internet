package controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.annotation.PostConstruct;

import auth.Sesion;
import backend.ModeloLocal;
import java.util.Date;
import objects.*;

@Named(value="personal")
@SessionScoped
public class Personal implements Serializable {
    @EJB
    private ModeloLocal modelo;
    
    @Inject
    private Sesion sesion;
    
    private List<Trabajador> list;
    
    private Boolean editor = false;
    private Trabajador trabajador;
    private List<Proyecto> proyectos;
    private int selectedProyecto;
    private List<Centro> centros;
    private int selectedCentro;
    private String admin;
    private String password;
    private String verify;

    public Personal(){}
    
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
    
    public List<Trabajador> getList(){
        return list;
    }
    
    public void setList(List<Trabajador> p){
        list = p;
    }
    
    public Trabajador getTrabajador(){
        return trabajador;
    }
    
    public void setTrabajador(Trabajador p){
        trabajador = p;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }
    
    public String getAdmin(){
        return admin;
    }
    
    public void setAdmin(String b){
        admin = b;
    }
    
    public int getSelectedProyecto(){
        return selectedProyecto;
    }
    
    public void setSelectedProyecto(int p){
        selectedProyecto = p;
    }
    
    public int getSelectedCentro(){
        return selectedCentro;
    }
    
    public void setSelectedCentro(int p){
        selectedCentro = p;
    }
    
    public List<Proyecto> getProyectos(){
        return proyectos;
    }
    
    public void setProyectos(List<Proyecto> p){
        proyectos = p;
    }
    
    public List<Centro> getCentros(){
        return centros;
    }
    
    public void setCentros(List<Centro> c){
        centros = c;
    }
    
    public Boolean getEditor(){
        return editor;
    }
    
    public void setEditor(Boolean b){
        editor = b;
    }
    
    public void refresh(){
        list = modelo.findAll(Trabajador.class);
    }
    
    public void enableEditor(){
        editor = true;
        trabajador = new Trabajador("NIF", Boolean.FALSE, "", "Nombre", "Apellidos", "email", new Date(), "Dirección", "Poblacion", "Provincia", "CP", "Telefono", "Cargo");        
        
        proyectos = modelo.findAll(Proyecto.class);       
        centros = modelo.findAll(Centro.class);
    }
    
    public void enableEditor(Trabajador p){
        editor = true;
        trabajador = p;
        
        proyectos = modelo.findAll(Proyecto.class);       
        centros = modelo.findAll(Centro.class);
    }

    public void disableEditor(){
        trabajador = null;
        editor = false;
    }
    
    public String insert(){
        if(sesion.admin() && password.equals(verify)){
            try {
                trabajador.setAdministrador(admin.equals("True")?Boolean.TRUE:Boolean.FALSE);
                trabajador.setProyecto(modelo.find(Proyecto.class, selectedProyecto));
                trabajador.setCentro(modelo.find(Centro.class, selectedCentro));
                trabajador.changePassword(password);
                modelo.add(trabajador);
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
    
    public String update(Trabajador p){
        if(sesion.admin() && password.equals(verify)){
            try {
                trabajador.setAdministrador(admin.equals("True")?Boolean.TRUE:Boolean.FALSE);
                trabajador.setProyecto(modelo.find(Proyecto.class, selectedProyecto));
                trabajador.setCentro(modelo.find(Centro.class, selectedCentro));
                trabajador.changePassword(password);
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
    
    public void delete(Trabajador p){
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
