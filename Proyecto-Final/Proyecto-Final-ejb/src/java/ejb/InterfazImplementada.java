/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

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
        socio.setSector("");
        socio.setCertificado(Boolean.FALSE);
        socio.setFechadealta(new Date());
        em.persist(socio);
        }
    }
    
    
}
