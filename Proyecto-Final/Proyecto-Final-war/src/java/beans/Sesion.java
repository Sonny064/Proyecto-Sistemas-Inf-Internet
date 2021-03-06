/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Entidades.Beneficiario;
import Entidades.Centro;
import Entidades.Envios;
import Entidades.Ingresosegresos;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ejb.Interfaz;
import Entidades.Personal;
import Entidades.Proyecto;
import Entidades.Socio;
import ejb.AplicacionException;
import java.util.List;
import java.util.ArrayList;
import javax.faces.context.FacesContext;

/**
 *
 * @author Carlos
 */
@Named(value = "sesion")
@SessionScoped
public class Sesion implements Serializable {

    @Inject
    private Interfaz negocio;
    private Personal empleado;
    private Socio socio;

    private Envios envio;

    private List<Personal> lista_personal = new ArrayList<>();
    private List<Socio> lista_socios = new ArrayList<>();
    private List<Beneficiario> lista_beneficiarios = new ArrayList<>();
    private List<Centro> lista_centros = new ArrayList<>();
     private List<Ingresosegresos> lista_ingresos = new ArrayList<>();
    private List<Socio> lista_proveedores = new ArrayList<>();

    public Sesion() {
    }

    public Personal getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Personal empleado) {
        this.empleado = empleado;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Envios getEnvio() {
        return envio;
    }

    public void setEnvio(Envios envio) {
        this.envio = envio;
    }

    public synchronized void setUsuario(Object usuario) throws AplicacionException {
        if (usuario instanceof Personal) {
            this.empleado = (Personal) usuario;
        } else if (usuario instanceof Socio) {
            this.socio = (Socio) usuario;
        } else {
            throw new AplicacionException();
        }
    }

    public synchronized Object getUsuario() throws AplicacionException {
        if (empleado != null) {
            return empleado;
        } else if (socio != null) {
            return socio;
        } else {
            throw new AplicacionException();
        }
    }

    public synchronized void eliminarUsuario(Object o) {
        negocio.delete(o);
    }

    public String invalidarSesion() {

        if (empleado != null) {
            empleado = null;
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        } else if (socio != null) {
            socio = null;
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        }
        return "login.xhtml?faces-redirect=true";
    }

    public synchronized void refrescarUsuario() throws AplicacionException {
        if (empleado != null) {
            empleado = (Personal) negocio.refrescarUsuario(empleado);
        } else if (socio != null) {
            socio = (Socio) negocio.refrescarUsuario(socio);
        } else {
            throw new AplicacionException();
        }
    }

    public synchronized boolean tipoUsuario() throws AplicacionException {
        if (empleado != null && empleado.getCargo().equals("ADMIN")) {
            return true;
        } else if (empleado != null && empleado.getCargo().equals("EMPLEADO")) {
            return false;
        }
        return false;
    }

    public synchronized String getPermiso() throws AplicacionException {
        String permiso = "sin permiso";
        if (socio != null) {
            permiso = "socio";
        } else if (empleado != null && empleado.getCargo().equalsIgnoreCase("admin")) {
            permiso = "admin";
        } else if (empleado != null) {
            permiso = "personal";
        }
        return permiso;
    }

    /* BÚSQUEDAS */
    public synchronized List<Personal> getListado_personal() {
        lista_personal = negocio.listar_personal();
        return lista_personal;
    }

    public synchronized List<Socio> getListado_socios() {
        lista_socios = negocio.listar_socios();
        return lista_socios;
    }

    public synchronized List<Beneficiario> getListado_beneficiarios() {
        lista_beneficiarios = negocio.listar_beneficiarios();
        return lista_beneficiarios;
    }

    public synchronized List<Proyecto> getProyectos() {
        return negocio.getProyectos();
    }
    
    public synchronized List<Centro> getListado_centros(){
       lista_centros = negocio.listar_centros();
       return lista_centros;
    }
    
    public synchronized List<Ingresosegresos> getListado_Ingresos() {
        lista_ingresos = negocio.listar_ingresos();
        return lista_ingresos;
    }
    
    public synchronized List<Socio> getListado_Proveedores() {
        lista_proveedores = negocio.listar_proveedores();
        return lista_proveedores;
    }

    public synchronized List<Envios> getEnvios() {
        return negocio.getEnvios();
    }

    public String eliminarCuenta(Object o) {
        invalidarSesion();
        eliminarUsuario(o);
        return "login.xhtml?faces-redirect=true";
    }

}
