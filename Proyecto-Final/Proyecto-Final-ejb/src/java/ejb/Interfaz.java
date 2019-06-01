/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import Entidades.Beneficiario;
import Entidades.Envios;
import Entidades.Personal;
import Entidades.Proyecto;
import javax.ejb.Local;
import Entidades.Socio;
import java.util.Date;
import java.util.List;
/**
 *
 * @author jesus
 */
@Local
public interface Interfaz {
    
    public Socio buscarSocio (String nif) throws AplicacionException;
    
    public Personal buscarPersonal (String id) throws AplicacionException;
    
    public void add(Object obj);
    
    public void update(Object obj);
    
    public void delete(Object obj);
    
    public void registrar(Socio socio)throws Exception;
    
    public void registrarUsuario(Object o)throws Exception;
    
    public Object refrescarUsuario(Object usuario) throws AplicacionException;
    
    public Proyecto refrescarProyecto(Proyecto proyecto) throws AplicacionException;
    
    public List<Personal> listar_personal();

    public List<Beneficiario> listar_beneficiarios();

    public List<Socio> listar_socios();

    public List<Proyecto> getProyectos();
    
    public List<Envios> getEnvios();
    
    public void añadirProyecto(Proyecto proyecto) throws Exception;
    
    public void actualizarProyecto(String idProyecto, String nombreProyecto, String descripcionProyecto) throws AplicacionException;
    
    public void eliminarProyecto(String idProyecto) throws AplicacionException;    

    public void añadirPersonalAProyecto(String idProyecto, String idPersonal) throws AplicacionException;
    
    public void eliminarPersonalDeProyecto(String idProyecto, String idPersonal) throws AplicacionException;

    
    public void añadirEnvio(Envios envio) throws AplicacionException;
    
    public void actualizarEnvio(String tipoDeEnvio, String contenidoEnvio, Date fechaEnvio) throws AplicacionException;
    
    public void eliminarEnvio(String tipoDeEnvio) throws AplicacionException;

}
