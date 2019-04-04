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
import javax.persistence.ManyToMany;


/**
 *
 * @author Marina Muñoz
 */
@Entity
public class Personal_Asociacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itentificador;
    
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
   	private String apellidos;
    @Column(nullable = false)
    private Date fechaNacimiento;
    @Column(nullable = false)
    private Date fechaEntrada;
    @Column(nullable = false)
    private String cargo;
    private String foto;
    private String experiencia;
    private String descripcion;
    
    @ManyToMany (mappedBy ="personalProyecto")
    private List <Proyecto> proyectos;
    
    @ManyToMany
    private List<Centro> listadoCentros;
    
    public Personal_Asociacion(String n, String a, Date fn, Date fe, String c) {
    	nombre = n;
    	apellidos = a;
    	fechaNacimiento = fn;
    	fechaEntrada = fe;
    	cargo = c;
    	
    }
    
    public Long getItentificador() {
		return itentificador;
	}

	public void setItentificador(Long itentificador) {
		this.itentificador = itentificador;
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

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
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


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itentificador != null ? itentificador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personal_Asociacion)) {
            return false;
        }
        Personal_Asociacion other = (Personal_Asociacion) object;
        if ((this.itentificador == null && other.itentificador != null) || (this.itentificador != null && !this.itentificador.equals(other.itentificador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa_sii.Personal_Asociaci\u00f3n[ identificador=" + itentificador + " ]";
    }
    
}
