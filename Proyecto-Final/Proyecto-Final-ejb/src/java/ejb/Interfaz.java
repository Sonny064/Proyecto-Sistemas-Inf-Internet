/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import Entidades.Beneficiario;
import Entidades.Personal;
import Entidades.Proyecto;
import javax.ejb.Local;
import Entidades.Socio;
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
    
    public void registrarPersonal(Personal personal) throws Exception;
    
    public Object refrescarUsuario(Object usuario) throws AplicacionException;
    
    public List<Personal> listar_personal();

    public List<Beneficiario> listar_beneficiarios();

    public List<Socio> listar_socios();
    
    public void añadirProyecto(Proyecto proyecto) throws Exception;
    
}
