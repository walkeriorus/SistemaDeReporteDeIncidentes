package argProg.persistencia;

import argProg.modelos.Especialidad;
import argProg.utilidades.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EspecialidadDAO extends OperacionesDAOBasicas {
    @Override
    public Especialidad buscar(int idEspecialidad){
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        return em.find(Especialidad.class,idEspecialidad);
    }
    @Override
    public void eliminar(int idIncidente){
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Especialidad especialidad = em.getReference(Especialidad.class,idIncidente);
        if(especialidad != null){
            em.remove(especialidad);
        }
        transaction.commit();
    }
}
