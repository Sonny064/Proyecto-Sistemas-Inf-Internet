/**
 *
 * @author Dario Jesus Flores Sevilla
 */

package jpa_sii;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;



@Entity
public class Beneficiario implements Serializable {

    //Atributos//
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Codigo;
    @Column(nulleable=false)
    private String Nombre;
    @Column(nulleable=false)
    private String Apellidos;
    @Column(nulleable=false)
    private String Sexo;
    @Column(nulleable=false)
    private Date Fecha_de_nacimiento;
    @Column(nulleable=false)
    private String Comunidad_de_procedencia;
    @Column(nulleable=false)
    private String Comunidad_en_la_que_vive;
    @Column(nulleable=false)
    private String Beca;
    @Column(nulleable=false)
    private int Grado_del_curso;
    @Column(nulleable=false)
    private Date Fecha_de_entrada_en_acoes;
    private Date Fecha_de_salida_en_acoes;
    private String Foto;
    private String Estado;
    private String Observaciones;

    //Relaciones//
    @OneToMany (mappedby = "beneficiario")
    private List <Socios> socio;
    @OneToMany
    private List <Envios> envian;
    @ManyToMany (mappedby = "propietario_proyecto")
    private List <Proyecto> proyecto;
    @ManyToMany (mappedby = "propietario_centro")
    private List <Centro> centro;
    @ManyToMany (mappedby = "propietario_casa_populorum")
    private List <Casa_populorum> casa_populorum;

    //Constructor

    public Beneficiario(String n, String a, String s, Date f, String cp, String cv, String b, int g, Date fe){
        Nombre = n;
        Apellidos = a;
        Sexo = s;
        Fecha_de_nacimiento = f;
        Comunidad_de_procedencia = cp;
        Comunidad_en_la_que_vive = cv;
        Beca = b;
        Grado_del_curso = g;
        Fecha_de_entrada_en_acoes = fe;

    }

    //Getters y setters//

    public Long getCodigo() {
        return Codigo;
    }

    public void setCodigo(Long id) {
        this.Codigo = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public Date getFecha_de_nacimiento() {
        return Fecha_de_nacimiento;
    }

    public void setFecha_de_nacimiento(Date Fecha_de_nacimiento) {
        this.Fecha_de_nacimiento = Fecha_de_nacimiento;
    }

    public String getComunidad_de_procedencia() {
        return Comunidad_de_procedencia;
    }

    public void setComunidad_de_procedencia(String Comunidad_de_procedencia) {
        this.Comunidad_de_procedencia = Comunidad_de_procedencia;
    }

    public String getComunidad_en_la_que_vive() {
        return Comunidad_en_la_que_vive;
    }

    public void setComunidad_en_la_que_vive(String Comunidad_en_la_que_vive) {
        this.Comunidad_en_la_que_vive = Comunidad_en_la_que_vive;
    }

    public String getBeca() {
        return Beca;
    }

    public void setBeca(String Beca) {
        this.Beca = Beca;
    }

    public int getGrado_del_curso() {
        return Grado_del_curso;
    }

    public void setGrado_del_curso(int Grado_del_curso) {
        this.Grado_del_curso = Grado_del_curso;
    }

    public Date getFecha_de_entrada_en_acoes() {
        return Fecha_de_entrada_en_acoes;
    }

    public void setFecha_de_entrada_en_acoes(Date Fecha_de_entrada_en_acoes) {
        this.Fecha_de_entrada_en_acoes = Fecha_de_entrada_en_acoes;
    }

    public Date getFecha_de_salida_en_acoes() {
        return Fecha_de_salida_en_acoes;
    }

    public void setFecha_de_salida_en_acoes(Date Fecha_de_salida_en_acoes) {
        this.Fecha_de_salida_en_acoes = Fecha_de_salida_en_acoes;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (Codigo!= null ? Codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Beneficiario)) {
            return false;
        }
        Beneficiario other = (Beneficiario) object;
        if ((this.Codigo == null && other.Codigo != null) || (this.Codigo != null && !this.Codigo.equals(other.Codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa_sii.Beneficiario[ id=" + Codigo + " ]";
    }

}
