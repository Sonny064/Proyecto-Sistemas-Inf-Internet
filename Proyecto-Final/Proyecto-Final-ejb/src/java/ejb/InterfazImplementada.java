/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import Entidades.Personal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Entidades.Socio;
import java.util.Date;


/**
 *
 * @author jesus
 */
@Stateless
public class InterfazImplementada implements Interfaz {
    @PersistenceContext(unitName="Proyecto-Final-ejbPU")
    private EntityManager em;
    
    @Override
    public void registrarUsuario(Socio socio)throws AplicacionException{
    
        Socio user = em.find(Socio.class, socio.getNif());
        
        if (user != null){
          throw new CuentaExistenteException ();
        }
        
        else{
            socio.setEstado("Activo");
            socio.setRelacion("Miembro");
            socio.setSector("A");
            socio.setCertificado(Boolean.FALSE);
            socio.setFechadealta(new Date());
            em.persist(socio);
        }
    }
    
    @Override
    public Socio buscarSocio(String nif) throws AplicacionException{
    
        Socio user = em.find(Socio.class, nif);
    
        return user;
    
    }
    
    @Override
    public Personal buscarPersonal (String id) throws AplicacionException{
    
        Personal pl = em.find(Personal.class, id);
    
        return pl;
    }
}
