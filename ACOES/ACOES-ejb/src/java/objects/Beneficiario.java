package objects;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
    @NamedQuery(name = "Beneficiario.findAll", query = "SELECT b FROM Beneficiario b"),
    @NamedQuery(name = "Beneficiario.findByNombre", query = "SELECT b FROM Beneficiario b WHERE b.nombre = :nombre"),
    @NamedQuery(name = "Beneficiario.findByApellidos", query = "SELECT b FROM Beneficiario b WHERE b.apellidos = :apellidos"),
    @NamedQuery(name = "Beneficiario.findBySexo", query = "SELECT b FROM Beneficiario b WHERE b.sexo = :sexo"),
    @NamedQuery(name = "Beneficiario.findByFechadenacimiento", query = "SELECT b FROM Beneficiario b WHERE b.fechadenacimiento = :fechadenacimiento"),
    @NamedQuery(name = "Beneficiario.findByComunidaddeprocedencia", query = "SELECT b FROM Beneficiario b WHERE b.comunidaddeprocedencia = :comunidaddeprocedencia"),
    @NamedQuery(name = "Beneficiario.findByComunidadderesidencia", query = "SELECT b FROM Beneficiario b WHERE b.comunidadderesidencia = :comunidadderesidencia"),
    @NamedQuery(name = "Beneficiario.findByBeca", query = "SELECT b FROM Beneficiario b WHERE b.beca = :beca"),
    @NamedQuery(name = "Beneficiario.findByGradodelcurso", query = "SELECT b FROM Beneficiario b WHERE b.gradodelcurso = :gradodelcurso"),
    @NamedQuery(name = "Beneficiario.findByFechadeentradaacoes", query = "SELECT b FROM Beneficiario b WHERE b.fechadeentradaacoes = :fechadeentradaacoes"),
    @NamedQuery(name = "Beneficiario.findByFechadesalidaacoes", query = "SELECT b FROM Beneficiario b WHERE b.fechadesalidaacoes = :fechadesalidaacoes"),
    @NamedQuery(name = "Beneficiario.findByEstado", query = "SELECT b FROM Beneficiario b WHERE b.estado = :estado"),
    @NamedQuery(name = "Beneficiario.findByObservaciones", query = "SELECT b FROM Beneficiario b WHERE b.observaciones = :observaciones")
})

public class Beneficiario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 50)
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50)
    private String apellidos;
    
    @NotNull
    @Size(min = 1, max = 1)
    private String sexo;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechadenacimiento;
    
    @NotNull
    @Size(min = 1, max = 50)
    private String comunidaddeprocedencia;
    
    @NotNull
    @Size(min = 1, max = 50)
    private String comunidadderesidencia;
    
    @NotNull
    @Size(min = 1, max = 30)
    private String beca;
    
    @NotNull
    @Size(min = 1, max = 30)
    private String gradodelcurso;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechadeentradaacoes;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechadesalidaacoes;

    private String foto;
    
    @Size(max = 50)
    private String estado;
    
    @Size(max = 200)
    private String observaciones;
    
    
    // Relaciones
    @ManyToOne
    private Socio padrino;

    @OneToMany(mappedBy="receptor")
    private List<Envio> envios;
    
    @ManyToOne
    private Proyecto proyecto;
    
    @ManyToOne
    private Centro centro;
    
    @OneToOne
    private Centro dirige;

    public Beneficiario(){}

    public Beneficiario(String nombre, String apellidos, String sexo, Date fechadenacimiento, String comunidaddeprocedencia, String comunidadderesidencia, String beca, String gradodelcurso, Date fechadeentradaacoes, Date fechadesalidaacoes){
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
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
    
    
    public Socio getPadrino() {
        return padrino;
    }

    public void setPadrino(Socio socio) {
        this.padrino = socio;
    }

    public List<Envio> getEnvios() {
        return envios;
    }

    public void setEnvios(List<Envio> envios) {
        this.envios = envios;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Centro getCentro() {
        return centro;
    }

    public void setCentro(Centro centro) {
        this.centro = centro;
    }
    
    public Centro getDirige() {
        return dirige;
    }

    public void setDirige(Centro centro) {
        this.dirige = centro;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof Beneficiario)) {
            return false;
        }
        Beneficiario other = (Beneficiario) object;
        
        return this.id == other.id;
    }
}
