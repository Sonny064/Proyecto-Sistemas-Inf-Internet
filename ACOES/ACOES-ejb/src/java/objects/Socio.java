package objects;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
    @NamedQuery(name = "Socio.findAll", query = "SELECT s FROM Socio s"),
    @NamedQuery(name = "Socio.findByPassword", query = "SELECT s FROM Socio s WHERE s.password = :password"),
    @NamedQuery(name = "Socio.findByNombre", query = "SELECT s FROM Socio s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Socio.findByApellidos", query = "SELECT s FROM Socio s WHERE s.apellidos = :apellidos"),
    @NamedQuery(name = "Socio.findByEstado", query = "SELECT s FROM Socio s WHERE s.estado = :estado"),
    @NamedQuery(name = "Socio.findByProvincia", query = "SELECT s FROM Socio s WHERE s.provincia = :provincia"),
    @NamedQuery(name = "Socio.findByCodigopostal", query = "SELECT s FROM Socio s WHERE s.codigopostal = :codigopostal"),
    @NamedQuery(name = "Socio.findByDireccion", query = "SELECT s FROM Socio s WHERE s.direccion = :direccion"),
    @NamedQuery(name = "Socio.findByTelefonofijo", query = "SELECT s FROM Socio s WHERE s.telefonofijo = :telefonofijo"),
    @NamedQuery(name = "Socio.findByTelefonomovil", query = "SELECT s FROM Socio s WHERE s.telefonomovil = :telefonomovil"),
    @NamedQuery(name = "Socio.findByEmail", query = "SELECT s FROM Socio s WHERE s.email = :email"),
    @NamedQuery(name = "Socio.findByRelacion", query = "SELECT s FROM Socio s WHERE s.relacion = :relacion"),
    @NamedQuery(name = "Socio.findBySector", query = "SELECT s FROM Socio s WHERE s.sector = :sector"),
    @NamedQuery(name = "Socio.findByCertificado", query = "SELECT s FROM Socio s WHERE s.certificado = :certificado"),
    @NamedQuery(name = "Socio.findByFechadealta", query = "SELECT s FROM Socio s WHERE s.fechadealta = :fechadealta"),
    @NamedQuery(name = "Socio.findByFechadebaja", query = "SELECT s FROM Socio s WHERE s.fechadebaja = :fechadebaja"),
    @NamedQuery(name = "Socio.findByObservaciones", query = "SELECT s FROM Socio s WHERE s.observaciones = :observaciones")
})

public class Socio implements Serializable {
    @Id
    @Size(min = 1, max = 10)
    private String nif;
    
    @NotNull
    private String salt;
    
    @NotNull
    @Size(min = 1, max = 64)
    private String password;
    
    @NotNull
    @Size(min = 1, max = 50)
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50)
    private String apellidos;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechadenacimiento;
    
    @NotNull
    @Size(min = 1, max = 20)
    private String estado;
    
    @NotNull
    @Size(min = 1, max = 50)
    private String provincia;
    
    @NotNull
    @Size(min = 1, max = 50)
    private String poblacion;
    
    @NotNull
    @Size(min = 1, max = 10)
    private String codigopostal;
    
    @NotNull
    @Size(min = 1, max = 50)
    private String direccion;
    
    @Size(min = 1, max = 15)
    private String telefonofijo;
    
    @NotNull
    @Size(min = 1, max = 15)
    private String telefonomovil;
    
    @NotNull
    @Size(min = 1, max = 50)
    private String email;
    
    @NotNull
    @Size(min = 1, max = 30)
    private String relacion;
    
    @NotNull
    @Size(min = 1, max = 30)
    private String sector;
    
    @NotNull
    private Boolean certificado;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechadealta;
    
    @Temporal(TemporalType.DATE)
    private Date fechadebaja;
    
    @Size(max = 100)
    private String observaciones;
    
    // Relaciones //
    @OneToMany(mappedBy="emisor")
    private List<Envio> envios;

    @OneToMany(mappedBy="padrino")
    private List<Beneficiario> apadrinados;
    
    public Socio(){}
  
    public Socio(String nif) {
        this.nif = nif;
    }

    public Socio(String nif, String password, String nombre, String apellidos, Date fechadenacimiento, String estado, String provincia, String poblacion, String codigopostal, String direccion, String telefonofijo, String telefonomovil, String email, String relacion, String sector, Boolean certificado, Date fechadealta){
        // Auth info
        this.nif = nif;
        this.salt = generateRandomString(16);
        changePassword("", password);
        
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
    
     public List<Envio> getEnvios() {
        return envios;
    }

    public void setEnvios(List<Envio> envios) {
        this.envios = envios;
    }

    public List<Beneficiario> getApadrinados() {
        return apadrinados;
    }

    public void setBeneficiarios(List<Beneficiario> beneficiarios) {
        this.apadrinados = beneficiarios;
    }
    
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
        if (!(object instanceof Socio)) {
            return false;
        }
        Socio other = (Socio) object;
        
        return this.nif.equals(other.nif);
    }
}
