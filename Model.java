package backend;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import objects.*;
import objects.Worker.Profile;

// TODO: All selects
public class Model {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ACOES");
    private static final EntityManager em = emf.createEntityManager();

    public static Personal login(String email, String password) throws Exception {
        Personal user;
        if((usuario = find(Personal.class, email)) != null){
            if(user.checkPassword(password)){
                return usuario;
            } else {
                throw new Exception("Invalid password");
            }
        } else {
            throw new Exception("Invalid user");
        }
    }

    public static void add(Object obj){
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        if(obj instanceof Beneficiario){
            em.persist((Beneficiario)obj);
        } else if(obj instanceof Centro){
            em.persist((Centro)obj);
        } else if(obj instanceof IngresosEgresos){
            em.persist((IngresosEgresos)obj);
        } else if(obj instanceof Proyecto){
            em.persist((Proyecto)obj);
        } else if(obj instanceof Envios) {
            em.persist((Envios)obj);
        } else if(obj instanceof Personal) {
            em.persist((Personal)obj);
        }

        tx.commit();
    }

    public static void update(Object obj){
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        if(obj instanceof Beneficiario){
            em.merge((Beneficiario)obj);
        } else if(obj instanceof Centro){
            em.merge((Centro)obj);
        } else if(obj instanceof IngresosEgresos){
            em.merge((IngresosEgresos)obj);
        } else if(obj instanceof Proyecto){
            em.merge((Proyecto)obj);
        } else if(obj instanceof Envios){
            em.merge((Envios)obj);
        } else if(obj instanceof Personal){
            em.merge((Personal)obj);
        }

        tx.commit();
    }

    public static void delete(Object obj){
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        if(obj instanceof Beneficiario){
            em.remove((Beneficiario)obj);
        } else if(obj instanceof Centro){
            em.remove((Centro)obj);
        } else if(obj instanceof IngresosEgresos){
            em.remove((IngresosEgresos)obj);
        } else if(obj instanceof Proyecto){
            em.remove((Proyecto)obj);
        } else if(obj instanceof Envios){
            em.remove((Envios)obj);
        } else if(obj instanceof Personal){
            em.remove((Personal)obj);
        }

        tx.commit();
    }

    public static <T> T find(Class<T> entityClass, Object pk){
        return em.find(entityClass, pk);
    }
}
