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

/**
 *
 * @author jesus
 */
@Stateless
public class InterfazImplementada implements Interfaz {
    @PersistenceContext(unitName="Proyecto-Final-ejbPU")
    private EntityManager em;
    
    @Override
    public void registrarUsuario(Socio socio){
    em.persist(socio);
    
    }
}
