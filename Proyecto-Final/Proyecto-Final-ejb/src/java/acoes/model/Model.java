package acoes.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import objects.*;

public class Model {

    private final EntityManagerFactory emf;
    private final EntityManager em;

    public Model(){
        emf = Persistence.createEntityManagerFactory("ACOES");
        em = emf.createEntityManager();
    }

    public void add(Object obj){
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        if(obj instanceof Beneficiary){
            em.persist((Beneficiary)obj);
        } else if(obj instanceof Center){
            em.persist((Center)obj);
        } else if(obj instanceof Payment){
            em.persist((Payment)obj);
        } else if(obj instanceof Project){
            em.persist((Project)obj);
        } else if(obj instanceof Shipment) {
            em.persist((Shipment)obj);
        } else if(obj instanceof Worker) {
            em.persist((Worker)obj);
        }
        
        tx.commit();
    }
    
    public void update(Object obj){
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        if(obj instanceof Beneficiary){
            em.merge((Beneficiary)obj);
        } else if(obj instanceof Center){
            em.merge((Center)obj);
        } else if(obj instanceof Payment){
            em.merge((Payment)obj);
        } else if(obj instanceof Project){
            em.merge((Project)obj);
        } else if(obj instanceof Shipment){
            em.merge((Shipment)obj);
        } else if(obj instanceof Worker){
            em.merge((Worker)obj);
        }
        
        tx.commit();
    }
    
    public void delete(Object obj){
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        if(obj instanceof Beneficiary){
            em.remove((Beneficiary)obj);
        } else if(obj instanceof Center){
            em.remove((Center)obj);
        } else if(obj instanceof Payment){
            em.remove((Payment)obj);
        } else if(obj instanceof Project){
            em.remove((Project)obj);
        } else if(obj instanceof Shipment){
            em.remove((Shipment)obj);
        } else if(obj instanceof Worker){
            em.remove((Worker)obj);
        }
        
        tx.commit();
    }
    
    public <T> T find(Class<T> entityClass, Object pk){
        return em.find(entityClass, pk);
    }

    public void close(){
        em.close();
        emf.close();
    }
}
