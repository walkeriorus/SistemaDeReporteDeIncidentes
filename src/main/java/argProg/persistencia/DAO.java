package argProg.persistencia;

import argProg.utilidades.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class DAO<T> {
    private Class<T> claseEntidad;
    public void guardar(T entidad) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entidad);
        transaction.commit();
    }
    public
    void actualizar(T entidad){
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        T entidadActualizada = em.merge(entidad);
        transaction.commit();
    };

    public
    void eliminar(T entidad){
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(entidad);
        transaction.commit();
    };

    public
    T buscar(int id){
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        return em.find(this.claseEntidad,id);
    };

    public List<T> buscarTodos(){
        EntityManager em = EntityManagerUtil.getEntityManager();
        String sql = "SELECT c FROM " + this.claseEntidad.getSimpleName() + " c";
        System.out.println(sql);
        Query buscarTodos = em.createQuery(sql);
        return buscarTodos.getResultList();
    };

    public void setClaseEntidad(Class<T> clase ){
        this.claseEntidad = clase;
    };
}
