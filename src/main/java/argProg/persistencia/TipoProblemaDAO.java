package argProg.persistencia;

import argProg.modelos.TipoProblema;
import argProg.utilidades.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class TipoProblemaDAO extends OperacionesDAOBasicas{
    @Override
    public TipoProblema buscar(int idProblema){
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        return em.find(TipoProblema.class,idProblema);
    }
    @Override
    public void eliminar(int idProblema){
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TipoProblema tipoProblema = em.getReference(TipoProblema.class,idProblema);
        if(tipoProblema != null){
            em.remove(tipoProblema);
        }
        transaction.commit();
    }
}
