/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import ejb.Interfaz;
import javax.ejb.EJB;
import Entidades.Personal;
import Entidades.Beneficiario;
import Entidades.Socio;
import ejb.AplicacionException;

/**
 *
 * @author marina muñoz
 */
@Named(value = "gestion")
@SessionScoped
public class GestionUsuarios implements Serializable {

    @EJB
    private Interfaz negocio;
    private Personal personal;
    private Socio socio;
    private Beneficiario beneficiario;
    private String tipo;

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public synchronized void setUsuario(Object o) throws AplicacionException {
        if (o instanceof Personal) {
            this.personal = (Personal) o;
            tipo = "personal";
        } else if (o instanceof Socio) {
            this.socio = (Socio) o;
            tipo = "socio";

        } else if (o instanceof Beneficiario) {
            this.beneficiario = (Beneficiario) o;
            tipo = "beneficiario";
        } else {
            throw new AplicacionException();
        }
    }

    public String editar(Object c) throws AplicacionException {
        setUsuario(c);
        return "edicionUsuario.xhtml?faces-redirect=true";
    }

    public String guardarEdicion(Object o) {
        negocio.update(o);
        return "gestion_usuarios.xhtml?faces-redirect=true";
    }

}
