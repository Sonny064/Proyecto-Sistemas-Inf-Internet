/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_sii;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * Grupo M
 */
public class Main {

    public static void main(String[] string) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Goncalves");
        EntityManager em = emf.createEntityManager();

        em.close();
        emf.close();

    }

}
