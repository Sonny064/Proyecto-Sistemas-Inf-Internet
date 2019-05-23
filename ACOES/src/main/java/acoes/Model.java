package acoes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import objects.*;

public class Model {

    private EntityManagerFactory emf;
    private EntityManager em;

    public Model(){
        emf = Persistence.createEntityManagerFactory("ACOES");
        em = emf.createEntityManager();
    }

    // TODO: Add all methods
    public boolean addWorker(Worker worker){
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(worker);
        tx.commit();
        return true;
    }

    public void close(){
        em.close();
        emf.close();
    }
}
