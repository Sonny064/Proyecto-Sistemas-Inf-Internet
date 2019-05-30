package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

@Entity
@NamedQueries({
    @NamedQuery(name = "Trabajador.findAll", query = "SELECT p FROM Trabajador p"),
    @NamedQuery(name = "Trabajador.findByNombre", query = "SELECT p FROM Trabajador p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Trabajador.findByApellidos", query = "SELECT p FROM Trabajador p WHERE p.apellidos = :apellidos"),
    @NamedQuery(name = "Trabajador.findByFechanacimiento", query = "SELECT p FROM Trabajador p WHERE p.fechanacimiento = :fechanacimiento"),
    @NamedQuery(name = "Trabajador.findByFechaentradaacoes", query = "SELECT p FROM Trabajador p WHERE p.fechaentradaacoes = :fechaentradaacoes"),
    @NamedQuery(name = "Trabajador.findByCargo", query = "SELECT p FROM Trabajador p WHERE p.cargo = :cargo"),
    @NamedQuery(name = "Trabajador.findByExperiencia", query = "SELECT p FROM Trabajador p WHERE p.experiencia = :experiencia"),
    @NamedQuery(name = "Trabajador.findByDescripcion", query = "SELECT p FROM Trabajador p WHERE p.descripcion = :descripcion")
})

public class Trabajador implements Serializable {
    @Id
    @Size(min = 1, max = 10)
    private String nif;
    
    @NotNull
    private Boolean administrador;
    
    @NotNull
    @Size(min = 1, max = 50)
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50)
    private String apellidos;
    
    @NotNull
    @Size(min = 1, max = 64)
    private String salt;
    
    @NotNull
    @Size(min = 1, max = 64)
    private String password;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechaentradaacoes;
    
    @NotNull
    @Size(min = 1, max = 30)
    private String cargo;
    
    private String foto;
    
    @Size(max = 200)
    private String experiencia;
    
    @Size(max = 200)
    private String descripcion;
    
    // Relaciones
    @ManyToOne
    private Proyecto proyecto;

    @ManyToOne
    private Centro centro;


    public Trabajador(){}

    public Trabajador(String nif, Boolean administrador, String password, String nombre, String apellidos, Date fechanacimiento, Date fechaentradaacoes, String cargo){
        // Auth info
        this.nif = nif;
        this.administrador = administrador;
        this.salt = generateRandomString(16);
        changePassword("", password);
        
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechanacimiento = fechanacimiento;
        this.fechaentradaacoes = fechaentradaacoes;
        this.cargo = cargo;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }
    
    public Boolean getAdministrador(){
        return administrador;
    }
    
    public void setAdministrador(Boolean administrador){
        this.administrador = administrador;
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
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password=password;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Date getFechaentradaacoes() {
        return fechaentradaacoes;
    }

    public void setFechaentradaacoes(Date fechaentradaacoes) {
        this.fechaentradaacoes = fechaentradaacoes;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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
    
    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Centro getCentro(){
        return centro;
    }

    public void setCentro(Centro centro) {
        this.centro = centro;
    }

    // Utils
    public boolean checkPassword(String pwd){
        try {
            String _pwd = salt + pwd;
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashInBytes = md.digest(_pwd.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            for (byte b : hashInBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString().equals(password);
        } catch(NoSuchAlgorithmException e){
            return false;
        }
    }

    public boolean changePassword(String old, String _new){
        if(password == null || checkPassword(old)){
            try {
                String _pwd = salt + _new;
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hashInBytes = md.digest(_pwd.getBytes(StandardCharsets.UTF_8));

                StringBuilder sb = new StringBuilder();
                for (byte b : hashInBytes) {
                    sb.append(String.format("%02x", b));
                }

                password = sb.toString();
                
            } catch(NoSuchAlgorithmException e){}
            
            return true;
        } else {
            return false;
        }
    }

    private String generateRandomString(int length){
        Random rnd = new Random(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int v = rnd.nextInt(62);
            if(v < 26){
                sb.append((char) ('a' + v));
            } else if(v < 52) {
                sb.append((char) ('A' + v - 26));
            } else {
                sb.append((char) ('0' + v - 52));
            }
        }

        return sb.toString();
    }
    
    @Override
    public int hashCode(){
        return nif.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Trabajador)) {
            return false;
        }
        Trabajador other = (Trabajador) object;
        
        return this.nif.equals(other.nif);
    }
}
