package argProg;

import argProg.models.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("UP").createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Cliente andresGutierrez = new Cliente("Andres Gutierrez","27546991130","Perejil Inc.");
        em.persist(andresGutierrez);
        tx.commit();
        em.close();
    }
}