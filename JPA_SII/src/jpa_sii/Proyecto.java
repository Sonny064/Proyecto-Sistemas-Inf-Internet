/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_sii;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.sql.Date;

/**
 *
 * @author Marina Muñoz
 */
@Entity
public class Proyecto implements Serializable {
	
	

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
    @Column(nullable = false, unique=true)
    private String nombreProyecto;
    @Column(nullable = false, unique=true)
    private Date fechaCreacion;
    @Column(nullable = false)
    private String descripcionProyecto;
    
    
    @ManyToMany
    private List<Beneficiario> propietario_proyecto;
    
    @ManyToMany
    private List<Ingresos_Egresos> listaIngresos;
    
    @ManyToMany
    private List<Personal_Asociacion> personalProyecto;
    
   

    public Proyecto(String n, Date fc, String dp) {
    	nombreProyecto = n;
    	fechaCreacion = fc;
    	descripcionProyecto = dp;
    	
    }
    
    public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getDescripcionProyecto() {
		return descripcionProyecto;
	}

	public void setDescripcionProyecto(String descripcionProyecto) {
		this.descripcionProyecto = descripcionProyecto;
	}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    

	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa_sii.Proyecto[ codigo=" + codigo + " ]";
    }
    
}
