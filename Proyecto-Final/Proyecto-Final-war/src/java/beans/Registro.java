/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Entidades.Personal;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import Entidades.Socio;
import ejb.Interfaz;
import java.util.Date;
import javax.ejb.EJB;


/**
 *
 * @author jesus
 */
@Named(value="registro")
@SessionScoped
public class Registro implements Serializable {

    @EJB
    private Interfaz negocio;
    
    private Socio socio;
    private Personal personal;
    
    private String reContra;
    private String contraseña;
    private String nif;
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private String provincia;
    private String poblacion;
    private String codigopostal;
    private String direccion;
    private String telefonofijo;
    private String telefonomovil;
    private String email;
    
    //Campos exclusivos del personal 
    private String cargo;
    private String experiencia;
    private String descripcion;
    
    /**
     * Creates a new instance of user
     */
    public Registro() {
     socio = new Socio() ;
     personal = new Personal();
    }

    public Socio getSocio(){
     return socio;
    }
    
    public void setSocio(Socio s){
     socio = s;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
    
    public String getReContra() {
        return reContra;
    }

    public void setReContra(String reContra) {
        this.reContra = reContra;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonofijo() {
        return telefonofijo;
    }

    public void setTelefonofijo(String telefonofijo) {
        this.telefonofijo = telefonofijo;
    }

    public String getTelefonomovil() {
        return telefonomovil;
    }

    public void setTelefonomovil(String telefonomovil) {
        this.telefonomovil = telefonomovil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
     public String registrar(){        
        if(contraseña.equals(reContra)){
            
            Socio user = new Socio(nif,contraseña,nombre,apellidos,fechaNacimiento,provincia,poblacion,codigopostal,direccion,telefonofijo,telefonomovil,email);
            
            try {
                negocio.registrar(user);
                return "login.xhtml";
            } catch(Exception e){
                return null;
            }

        } else {
            return null;
        }
}
     
     public String registrarPersonal(){
     
         Personal pl = new Personal(nif,nombre,apellidos,contraseña,fechaNacimiento);
         
         try {
             negocio.registrarPersonal(pl, cargo, experiencia,descripcion);
             return "INSERTAR WEB A LA QUE VOLVER";
             
         }catch(Exception e){
              return null;
            }
     
     }
}
