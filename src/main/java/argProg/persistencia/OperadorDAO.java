package argProg.persistencia;

import argProg.modelos.Operador;
import argProg.utilidades.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class OperadorDAO extends OperacionesDAOBasicas {

    @Override
    public void eliminar(int idOperador) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Operador operador = em.getReference(Operador.class,idOperador);
        if(operador != null){
            em.remove(operador);
        }
        transaction.commit();
    }

    @Override
    public Operador buscar(int idOperador) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        return em.find(Operador.class,idOperador);
    }
}
