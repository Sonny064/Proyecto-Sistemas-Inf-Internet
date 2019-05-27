/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "BENEFICIARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Beneficiario.findAll", query = "SELECT b FROM Beneficiario b")
    , @NamedQuery(name = "Beneficiario.findById", query = "SELECT b FROM Beneficiario b WHERE b.id = :id")
    , @NamedQuery(name = "Beneficiario.findByNombre", query = "SELECT b FROM Beneficiario b WHERE b.nombre = :nombre")
    , @NamedQuery(name = "Beneficiario.findByApellidos", query = "SELECT b FROM Beneficiario b WHERE b.apellidos = :apellidos")
    , @NamedQuery(name = "Beneficiario.findBySexo", query = "SELECT b FROM Beneficiario b WHERE b.sexo = :sexo")
    , @NamedQuery(name = "Beneficiario.findByFechadenacimiento", query = "SELECT b FROM Beneficiario b WHERE b.fechadenacimiento = :fechadenacimiento")
    , @NamedQuery(name = "Beneficiario.findByComunidaddeprocedencia", query = "SELECT b FROM Beneficiario b WHERE b.comunidaddeprocedencia = :comunidaddeprocedencia")
    , @NamedQuery(name = "Beneficiario.findByComunidadderesidencia", query = "SELECT b FROM Beneficiario b WHERE b.comunidadderesidencia = :comunidadderesidencia")
    , @NamedQuery(name = "Beneficiario.findByBeca", query = "SELECT b FROM Beneficiario b WHERE b.beca = :beca")
    , @NamedQuery(name = "Beneficiario.findByGradodelcurso", query = "SELECT b FROM Beneficiario b WHERE b.gradodelcurso = :gradodelcurso")
    , @NamedQuery(name = "Beneficiario.findByFechadeentradaacoes", query = "SELECT b FROM Beneficiario b WHERE b.fechadeentradaacoes = :fechadeentradaacoes")
    , @NamedQuery(name = "Beneficiario.findByFechadesalidaacoes", query = "SELECT b FROM Beneficiario b WHERE b.fechadesalidaacoes = :fechadesalidaacoes")
    , @NamedQuery(name = "Beneficiario.findByEstado", query = "SELECT b FROM Beneficiario b WHERE b.estado = :estado")
    , @NamedQuery(name = "Beneficiario.findByObservaciones", query = "SELECT b FROM Beneficiario b WHERE b.observaciones = :observaciones")})
public class Beneficiario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ID")
    private String id;
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
    @Size(min = 1, max = 1)
    @Column(name = "SEXO")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHADENACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechadenacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "COMUNIDADDEPROCEDENCIA")
    private String comunidaddeprocedencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "COMUNIDADDERESIDENCIA")
    private String comunidadderesidencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "BECA")
    private String beca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "GRADODELCURSO")
    private String gradodelcurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHADEENTRADAACOES")
    @Temporal(TemporalType.DATE)
    private Date fechadeentradaacoes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHADESALIDAACOES")
    @Temporal(TemporalType.DATE)
    private Date fechadesalidaacoes;
    @Lob
    @Column(name = "FOTO")
    private Serializable foto;
    @Size(max = 50)
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 200)
    @Column(name = "OBSERVACIONES")
    private String observaciones;

    public Beneficiario() {
    }

    public Beneficiario(String id) {
        this.id = id;
    }

    public Beneficiario(String id, String nombre, String apellidos, String sexo, Date fechadenacimiento, String comunidaddeprocedencia, String comunidadderesidencia, String beca, String gradodelcurso, Date fechadeentradaacoes, Date fechadesalidaacoes) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.fechadenacimiento = fechadenacimiento;
        this.comunidaddeprocedencia = comunidaddeprocedencia;
        this.comunidadderesidencia = comunidadderesidencia;
        this.beca = beca;
        this.gradodelcurso = gradodelcurso;
        this.fechadeentradaacoes = fechadeentradaacoes;
        this.fechadesalidaacoes = fechadesalidaacoes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechadenacimiento() {
        return fechadenacimiento;
    }

    public void setFechadenacimiento(Date fechadenacimiento) {
        this.fechadenacimiento = fechadenacimiento;
    }

    public String getComunidaddeprocedencia() {
        return comunidaddeprocedencia;
    }

    public void setComunidaddeprocedencia(String comunidaddeprocedencia) {
        this.comunidaddeprocedencia = comunidaddeprocedencia;
    }

    public String getComunidadderesidencia() {
        return comunidadderesidencia;
    }

    public void setComunidadderesidencia(String comunidadderesidencia) {
        this.comunidadderesidencia = comunidadderesidencia;
    }

    public String getBeca() {
        return beca;
    }

    public void setBeca(String beca) {
        this.beca = beca;
    }

    public String getGradodelcurso() {
        return gradodelcurso;
    }

    public void setGradodelcurso(String gradodelcurso) {
        this.gradodelcurso = gradodelcurso;
    }

    public Date getFechadeentradaacoes() {
        return fechadeentradaacoes;
    }

    public void setFechadeentradaacoes(Date fechadeentradaacoes) {
        this.fechadeentradaacoes = fechadeentradaacoes;
    }

    public Date getFechadesalidaacoes() {
        return fechadesalidaacoes;
    }

    public void setFechadesalidaacoes(Date fechadesalidaacoes) {
        this.fechadesalidaacoes = fechadesalidaacoes;
    }

    public Serializable getFoto() {
        return foto;
    }

    public void setFoto(Serializable foto) {
        this.foto = foto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Beneficiario)) {
            return false;
        }
        Beneficiario other = (Beneficiario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Beneficiario[ id=" + id + " ]";
    }
    
}
