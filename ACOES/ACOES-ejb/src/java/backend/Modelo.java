package backend;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

import objects.*;

@Stateless
public class Modelo implements ModeloLocal {
    @PersistenceContext(unitName="ACOES-PU")
    private EntityManager em;
    
    @Override
    public <T> T find(Class<T> entityClass, Object pk){
        return em.find(entityClass, pk);
    }
    
    @Override
    public <T> List<T> findAll(Class<T> entityClass){
        String long_name  = entityClass.getName();
        String[] tokens   = long_name.split("\\.");
        String class_name = tokens[tokens.length - 1];
        
        TypedQuery<T> query = em.createNamedQuery(class_name + ".findAll", entityClass);
        return query.getResultList();
    }
        
    @Override
    public void add(Object obj) throws Exception {
        try {
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
        } catch(Exception e){
            throw e;
        }
    }
    
    @Override
    public void update(Object obj) throws Exception {
        try {
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
        } catch(Exception e) {
            throw e;
        }

    }
    
    @Override
    public void delete(Object obj) throws Exception {
        try {
            if(obj instanceof Beneficiario){
                em.remove(em.merge((Beneficiario)obj));
            } else if(obj instanceof Casapopulorum){
                em.remove(em.merge((Casapopulorum)obj));
            } else if(obj instanceof Centro){
                em.remove(em.merge((Centro)obj));
            } else if(obj instanceof Centroeducacion){
                em.remove(em.merge((Centroeducacion)obj));
            } else if(obj instanceof Envio) {
                em.remove(em.merge((Envio)obj));
            } else if(obj instanceof Proyecto) {
                em.remove(em.merge((Proyecto)obj));
            } else if(obj instanceof Socio) {
                em.remove(em.merge((Socio)obj));
            } else if(obj instanceof Trabajador) {
                em.remove(em.merge((Trabajador)obj));
            } else if(obj instanceof Transaccion) {
                em.remove(em.merge((Transaccion)obj));
            }
        } catch(Exception e) {
            throw e;
        }
    }
}
