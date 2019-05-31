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
import java.util.List;
import Entidades.Personal;
import javax.persistence.Query;


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
   
    @Override
    public void registrarPersonal(Personal personal) throws Exception { 
        Personal user = em.find(Personal.class, personal.getId());
        
        if(user == null){
            add(personal);
        } else {
            throw new CuentaExistenteException();
        }
    }
    
    /**
     *
     * @param usuario
     * @return
     * @throws AplicacionException
     */
    @Override
    public synchronized Object refrescarUsuario(Object usuario) throws AplicacionException {
        
        if(usuario != null){
            if(usuario instanceof Personal){
                Personal user = em.find(Personal.class, ((Personal) usuario).getId());
                em.refresh(user);
                return user;
            }
            else if(usuario instanceof Socio){
                Socio user = em.find(Socio.class, ((Socio) usuario).getNif());
                em.refresh(user);
                return user;
            }
        }
        else throw new AplicacionException();
        return null;
    }
    
    @Override
    public List<Personal> listar_personal(){
        Query query = em.createQuery("SELECT e FROM Personal e");
        return query.getResultList();
    }

    @Override
    public List<Beneficiario> listar_beneficiarios(){
        Query query = em.createQuery("SELECT e FROM Beneficiario e");
        return (List<Beneficiario>) query.getResultList() ;
    }

    @Override
    public List<Socio> listar_socios(){
    Query query = em.createQuery("SELECT e FROM Socio e");
    return query.getResultList();
    }
    
    
    @Override
    public void añadirProyecto(Proyecto proyecto) throws Exception { 
        Proyecto project = em.find(Proyecto.class, proyecto.getId());
        
        if(project == null){
            proyecto.setFechadecreacion(new Date());
            add(proyecto);
        } else {
            throw new AplicacionException();
        }
    }
    
}

