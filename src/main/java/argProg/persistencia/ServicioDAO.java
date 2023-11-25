package argProg.persistencia;

import argProg.modelos.Servicio;
import argProg.utilidades.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ServicioDAO extends OperacionesDAOBasicas{
    @Override
    public Servicio buscar(int idServicio){
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        return em.find(Servicio.class,idServicio);
    }
    @Override
    public void eliminar(int idServicio){
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Servicio servicio = em.getReference(Servicio.class,idServicio);
        if(servicio != null){
            em.remove(servicio);
        }
        transaction.commit();
    }
}
