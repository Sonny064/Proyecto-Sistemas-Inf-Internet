/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jesus
 */
@Entity
@Table(name = "SOCIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Socio.findAll", query = "SELECT s FROM Socio s")
    , @NamedQuery(name = "Socio.findByNif", query = "SELECT s FROM Socio s WHERE s.nif = :nif")
    , @NamedQuery(name = "Socio.findByPassword", query = "SELECT s FROM Socio s WHERE s.password = :password")
    , @NamedQuery(name = "Socio.findByNombre", query = "SELECT s FROM Socio s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Socio.findByApellidos", query = "SELECT s FROM Socio s WHERE s.apellidos = :apellidos")
    , @NamedQuery(name = "Socio.findByEstado", query = "SELECT s FROM Socio s WHERE s.estado = :estado")
    , @NamedQuery(name = "Socio.findByProvincia", query = "SELECT s FROM Socio s WHERE s.provincia = :provincia")
    , @NamedQuery(name = "Socio.findByCodigopostal", query = "SELECT s FROM Socio s WHERE s.codigopostal = :codigopostal")
    , @NamedQuery(name = "Socio.findByDireccion", query = "SELECT s FROM Socio s WHERE s.direccion = :direccion")
    , @NamedQuery(name = "Socio.findByTelefonofijo", query = "SELECT s FROM Socio s WHERE s.telefonofijo = :telefonofijo")
    , @NamedQuery(name = "Socio.findByTelefonomovil", query = "SELECT s FROM Socio s WHERE s.telefonomovil = :telefonomovil")
    , @NamedQuery(name = "Socio.findByEmail", query = "SELECT s FROM Socio s WHERE s.email = :email")
    , @NamedQuery(name = "Socio.findByRelacion", query = "SELECT s FROM Socio s WHERE s.relacion = :relacion")
    , @NamedQuery(name = "Socio.findBySector", query = "SELECT s FROM Socio s WHERE s.sector = :sector")
    , @NamedQuery(name = "Socio.findByCertificado", query = "SELECT s FROM Socio s WHERE s.certificado = :certificado")
    , @NamedQuery(name = "Socio.findByFechadealta", query = "SELECT s FROM Socio s WHERE s.fechadealta = :fechadealta")
    , @NamedQuery(name = "Socio.findByFechadebaja", query = "SELECT s FROM Socio s WHERE s.fechadebaja = :fechadebaja")
    , @NamedQuery(name = "Socio.findByObservaciones", query = "SELECT s FROM Socio s WHERE s.observaciones = :observaciones")})
public class Socio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NIF")
    private String nif;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHADENACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechadenacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PROVINCIA")
    private String provincia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "POBLACION")
    private String poblacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODIGOPOSTAL")
    private String codigopostal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "TELEFONOFIJO")
    private String telefonofijo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "TELEFONOMOVIL")
    private String telefonomovil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "RELACION")
    private String relacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SECTOR")
    private String sector;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CERTIFICADO")
    private Boolean certificado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHADEALTA")
    @Temporal(TemporalType.DATE)
    private Date fechadealta;
    @Column(name = "FECHADEBAJA")
    @Temporal(TemporalType.DATE)
    private Date fechadebaja;
    @Size(max = 100)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    
    // Relaciones //
    @OneToMany(mappedBy="emisor")
    private List<Envios> envios;

    @OneToMany(mappedBy="socio")
    private List<Beneficiario> beneficiarios;


    @OneToMany(mappedBy="ingresos_socio")
    private List<Ingresosegresos> ingresos_egresos;
    
    public Socio(){
        
    }
  
    public Socio(String nif) {
        this.nif = nif;
    }

    public Socio(String nif, String password, String nombre, String apellidos, Date fechadenacimiento, String estado, String provincia, String poblacion, String codigopostal, String direccion, String telefonofijo, String telefonomovil, String email, String relacion, String sector, Boolean certificado, Date fechadealta) {

        this.nif = nif;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechadenacimiento = fechadenacimiento;
        this.estado = estado;
        this.provincia = provincia;
        this.poblacion=poblacion;
        this.codigopostal = codigopostal;
        this.direccion = direccion;
        this.telefonofijo = telefonofijo;
        this.telefonomovil = telefonomovil;
        this.email = email;
        this.relacion = relacion;
        this.sector = sector;
        this.certificado = certificado;
        this.fechadealta = fechadealta;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    
    public Date getFechadenacimiento(){
      return fechadenacimiento;
    }
    
    public void setFechadenacimiento(Date fechadenacimiento){
     this.fechadenacimiento = fechadenacimiento;
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
    
    public String getPoblacion (){
    return poblacion;
    }
    
    public void setPoblacion(String poblacion){
    this.poblacion=poblacion;
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

    public Boolean getCertificado() {
        return certificado;
    }

    public void setCertificado(Boolean certificado) {
        this.certificado = certificado;
    }

    public Date getFechadealta() {
        return fechadealta;
    }

    public void setFechadealta(Date fechadealta) {
        this.fechadealta = fechadealta;
    }

    public Date getFechadebaja() {
        return fechadebaja;
    }

    public void setFechadebaja(Date fechadebaja) {
        this.fechadebaja = fechadebaja;
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

    public List<Ingresosegresos> getIngresos_egresos() {
        return ingresos_egresos;
    }

    public void setIngresos_egresos(List<Ingresosegresos> ingresos_egresos) {
        this.ingresos_egresos = ingresos_egresos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nif != null ? nif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Socio)) {
            return false;
        }
        Socio other = (Socio) object;
        if ((this.nif == null && other.nif != null) || (this.nif != null && !this.nif.equals(other.nif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Socio[ id=" + nif + " ]";
    }
    
}
