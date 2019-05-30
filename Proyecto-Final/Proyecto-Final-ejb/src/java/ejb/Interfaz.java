/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import Entidades.Personal;
import javax.ejb.Local;
import Entidades.Socio;

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
    
    public Object refrescarUsuario(Object usuario) throws AplicacionException ;
        
    
}
