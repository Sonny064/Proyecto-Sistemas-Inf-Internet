package backend;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

import entidades.*;

@Stateless
public class Modelo implements ModeloLocal {
    @PersistenceContext(unitName="ACOES-PU")
    private EntityManager em;
    
    // Main DB methods
    @Override
    public <T> T find(Class<T> entityClass, Object pk){
        return em.find(entityClass, pk);
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
        } else if(obj instanceof Envio) {
            em.persist((Envio)obj);
        } else if(obj instanceof Proyecto) {
            em.persist((Proyecto)obj);
        } else if(obj instanceof Socio) {
            em.persist((Socio)obj);
        } else if(obj instanceof Trabajador) {
            em.persist((Trabajador)obj);
        } else if(obj instanceof Transaccion) {
            em.persist((Transaccion)obj);
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
        } else if(obj instanceof Envio) {
            em.merge((Envio)obj);
        } else if(obj instanceof Proyecto) {
            em.merge((Proyecto)obj);
        } else if(obj instanceof Socio) {
            em.merge((Socio)obj);
        } else if(obj instanceof Trabajador) {
            em.merge((Trabajador)obj);
        } else if(obj instanceof Transaccion) {
            em.merge((Transaccion)obj);
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
        } else if(obj instanceof Envio) {
            em.remove((Envio)obj);
        } else if(obj instanceof Proyecto) {
            em.remove((Proyecto)obj);
        } else if(obj instanceof Socio) {
            em.remove((Socio)obj);
        } else if(obj instanceof Trabajador) {
            em.remove((Trabajador)obj);
        } else if(obj instanceof Transaccion) {
            em.remove((Transaccion)obj);
        }
    }
    
    // Utils 
    @Override
    public void registrar(Trabajador socio) throws Exception { 
        Trabajador user = em.find(Trabajador.class, socio.getNif());
        
        if(user == null){
            add(socio);
        } else {
            throw new CuentaExistenteException();
        }
    }
}
