package argProg.persistencia;

import argProg.utilidades.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public abstract class OperacionesDAOBasicas {

    public void guardar(Object entidad){
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entidad);
        transaction.commit();
    }
    public abstract void eliminar(int idEntidad);
    public abstract Object buscar(int idEntidad);
}
