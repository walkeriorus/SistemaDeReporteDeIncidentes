package argProg.persistencia;

import argProg.modelos.Cliente;
import argProg.utilidades.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class ClienteDAO extends OperacionesDAOBasicas{
    @Override
    public Cliente buscar(int idCliente){
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        return em.find(Cliente.class,idCliente);
    }
    @Override
    public void eliminar(int idCliente){
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Cliente cliente = em.getReference(Cliente.class,idCliente);
        if(cliente != null){
            em.remove(cliente);
        }
        transaction.commit();
    }
    public void actualizar(Cliente cliente){
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Cliente clienteActualizado = em.merge(cliente);
        transaction.commit();
    }

    public List<Cliente> buscarTodos(){
        EntityManager em = EntityManagerUtil.getEntityManager();
        Query buscarClientes = em.createNamedQuery("Cliente_buscarTodos",Cliente.class);

        return buscarClientes.getResultList();
    }
    public Cliente buscarPorCuit(String cuitCliente){

        EntityManager em = EntityManagerUtil.getEntityManager();
        Query buscarPorCuit = em.createNamedQuery("Cliente_buscarPorCuit",Cliente.class);
        buscarPorCuit.setParameter("cuitCliente",cuitCliente);

        return (Cliente)buscarPorCuit.getSingleResult();
    }
}
