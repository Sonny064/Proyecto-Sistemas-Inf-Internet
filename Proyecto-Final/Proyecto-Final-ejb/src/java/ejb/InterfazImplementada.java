/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Entidades.*;
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
    public Socio buscarSocio(String nif) throws AplicacionException{
    
        Socio user = em.find(Socio.class, nif);
    
        return user;
    
    }
    
    @Override
    public Personal buscarPersonal (String id) throws AplicacionException{
    
        Personal pl = em.find(Personal.class, id);
    
        return pl;
    }
    
    @Override
    public void add(Object obj){        
        if(obj instanceof Beneficiario){
            em.persist((Beneficiario)obj);
        } else if(obj instanceof Casapopulorum){
            em.persist((Casapopulorum)obj);
        } else if(obj instanceof Centro){
            em.persist((Centro)obj);
        } else if(obj instanceof Centroeducacion){
            em.persist((Centroeducacion)obj);
        } else if(obj instanceof Envios) {
            em.persist((Envios)obj);
        } else if(obj instanceof Proyecto) {
            em.persist((Proyecto)obj);
        } else if(obj instanceof Socio) {
            em.persist((Socio)obj);
        } else if(obj instanceof Personal) {
            em.persist((Personal)obj);
        } else if(obj instanceof Ingresosegresos) {
            em.persist((Ingresosegresos)obj);
        }
    }
    
    @Override
    public void update(Object obj){        
        if(obj instanceof Beneficiario){
            em.merge((Beneficiario)obj);
        } else if(obj instanceof Casapopulorum){
            em.merge((Casapopulorum)obj);
        } else if(obj instanceof Centro){
            em.merge((Centro)obj);
        } else if(obj instanceof Centroeducacion){
            em.merge((Centroeducacion)obj);
        } else if(obj instanceof Envios) {
            em.merge((Envios)obj);
        } else if(obj instanceof Proyecto) {
            em.merge((Proyecto)obj);
        } else if(obj instanceof Socio) {
            em.merge((Socio)obj);
        } else if(obj instanceof Personal) {
            em.merge((Personal)obj);
        } else if(obj instanceof Ingresosegresos) {
            em.merge((Ingresosegresos)obj);
        }
    }
    
    @Override
    public void delete(Object obj){        
        if(obj instanceof Beneficiario){
            em.remove((Beneficiario)obj);
        } else if(obj instanceof Casapopulorum){
            em.remove((Casapopulorum)obj);
        } else if(obj instanceof Centro){
            em.remove((Centro)obj);
        } else if(obj instanceof Centroeducacion){
            em.remove((Centroeducacion)obj);
        } else if(obj instanceof Envios) {
            em.remove((Envios)obj);
        } else if(obj instanceof Proyecto) {
            em.remove((Proyecto)obj);
        } else if(obj instanceof Socio) {
            em.remove((Socio)obj);
        } else if(obj instanceof Personal) {
            em.remove((Personal)obj);
        } else if(obj instanceof Ingresosegresos) {
            em.remove((Ingresosegresos)obj);
        }
    }
    
    // Utils 
    @Override
    public void registrar(Socio socio) throws Exception { 
        Socio user = em.find(Socio.class, socio.getNif());
        
        if(user == null){
            socio.setEstado("Activo");
            socio.setRelacion("Miembro");
            socio.setSector("A");
            socio.setCertificado(Boolean.FALSE);
            socio.setFechadealta(new Date());
        
            add(socio);
        } else {
            throw new CuentaExistenteException();
        }
    }
    
    
}

