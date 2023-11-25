package argProg.persistencia;

import argProg.modelos.Tecnico;
import argProg.utilidades.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class TecnicoDAO extends OperacionesDAOBasicas{

    @Override
    public Tecnico buscar(int idTecnico){
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        return em.find(Tecnico.class,idTecnico);
    }
    @Override
    public void eliminar(int idTecnico){
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Tecnico cliente = em.getReference(Tecnico.class,idTecnico);
        if(cliente != null){
            em.remove(cliente);
        }
        transaction.commit();
    }
}