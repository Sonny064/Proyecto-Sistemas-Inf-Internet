/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_sii;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;


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
    @Column(nullable=false, unique=true)
    private Long nif;
    @Column(nullable=false)
    private String nombre;
    @Column(nullable=false)
    private String apellidos;
    @Column(nullable=false)
    private String estado;
    @Column(nullable=false)
    private String provincia;
    @Column(nullable=false)
    private Short codigoPostal;
    @Column(nullable=false)
    private String direccion;
    @Column(nullable=false, unique=true)
    private Long tlfFijo;
    @Column(nullable=false, unique=true)
    private Long tlfMovil;
    @Column(nullable=false, unique=true)
    private String email;
    @Column(nullable=false)
    private String relacion;
    @Column(nullable=false)
    private String sector;
    @Column(nullable=false)
    private String certificado;
    @Column(nullable=false)
    private Date fechaAlta;
    private Date fechaBaja;
    private String observaciones;

    // Relaciones
    @OneToMany(mappedBy="emisor")
    private List<Envios> envios;

    @OneToMany(mappedBy="socio")
    private List<Beneficiario> beneficiarios;


    @OneToMany(mappedBy="ingresos_socio")
    private List<Ingresos_Egresos> ingresos_egresos;

    @ManyToOne
    private Municipio municipio;
    
    //Constructores
    
    public Socios(){
        
    }

    public Socios(Long ni,String n, String p, String e, String pro, Short cp, String d, Long tf,
     Long tm,String em, String rel, String sec, String cert, Date fa){

      nif = ni;
      nombre = n;
      apellidos =p;
      estado = e;
      provincia = pro;
      codigoPostal = cp;
      direccion = d;
      tlfFijo = tf;
      tlfMovil = tm;
      email = em;
      relacion = rel;
      sector = sec;
      certificado = cert;
      fechaAlta = fa;

    }

    //Getters and Setters

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
    
    public List<Beneficiario> getBeneficiarios() {
        return beneficiarios;
    }

    public void setBeneficiarios(List<Beneficiario> beneficiarios) {
        this.beneficiarios = beneficiarios;
    }

    public List<Beneficiario> getBeneficiario() {
        return beneficiarios;
    }
    public void setBeneficiario(List<Beneficiario> beneficiario) {
        this.beneficiarios = beneficiario;
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
