package argProg.persistencia;


import argProg.modelos.Incidente;
import argProg.utilidades.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class IncidenteDAO extends OperacionesDAOBasicas{
    @Override
    public Incidente buscar(int idIncidente){
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        return em.find(Incidente.class,idIncidente);
    }
    @Override
    public void eliminar(int idIncidente){
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Incidente incidente = em.getReference(Incidente.class,idIncidente);
        if(incidente != null){
            em.remove(incidente);
        }
        transaction.commit();
    }
}
