/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_sii;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Carlos
 */
@Entity
public class Socios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_Socio;
    private Long nif;
    private String nombre;
    private String apellidos;
    private String estado;
    private String provincia;
    private Short codigoPostal;
    private String direccion;
    private Long tlfFijo;
    private Long tlfMovil;
    private String email;
    private String relacion;
    private String sector;
    private String certificado;
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;
    private String observaciones;

    @OneToMany
    private List<Envios> envios;
    @OneToMany
    private List<Beneficiario> beneficiario;
    @OneToMany
    private List<Ingresos_Egresos> ingresos_egresos;
    
    public Long getId_Socio() {
        return id_Socio;
    }
    public void setId_Socio(Long id_Socio) {
        this.id_Socio = id_Socio;
    }

    public Long getNif() {
        return nif;
    }
    public void setNif(Long nif) {
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

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Short getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(Short codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getTlfFijo() {
        return tlfFijo;
    }
    public void setTlfFijo(Long tlfFijo) {
        this.tlfFijo = tlfFijo;
    }

    public Long getTlfMovil() {
        return tlfMovil;
    }
    public void setTlfMovil(Long tlfMovil) {
        this.tlfMovil = tlfMovil;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getRelacion() {
        return relacion;
    }
    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    public String getSector() {
        return sector;
    }
    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getCertificado() {
        return certificado;
    }
    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }
    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<Envios> getEnvios() {
        return envios;
    }
    public void setEnvios(List<Envios> envios) {
        this.envios = envios;
    }

    public List<Beneficiario> getBeneficiario() {
        return beneficiario;
    }
    public void setBeneficiario(List<Beneficiario> beneficiario) {
        this.beneficiario = beneficiario;
    }

    public List<Ingresos_Egresos> getIngresos_egresos() {
        return ingresos_egresos;
    }
    public void setIngresos_egresos(List<Ingresos_Egresos> ingresos_egresos) {
        this.ingresos_egresos = ingresos_egresos;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_Socio != null ? id_Socio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id_Socio fields are not set
        if (!(object instanceof Socios)) {
            return false;
        }
        Socios other = (Socios) object;
        if ((this.id_Socio == null && other.id_Socio != null) || (this.id_Socio != null && !this.id_Socio.equals(other.id_Socio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa_sii.Centro[ id=" + id_Socio + " ]";
    }
    
}
