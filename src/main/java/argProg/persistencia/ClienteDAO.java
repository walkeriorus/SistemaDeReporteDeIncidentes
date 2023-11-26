package argProg.persistencia;

import argProg.modelos.Cliente;
import argProg.utilidades.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ClienteDAO extends DAO<Cliente>{

    public ClienteDAO(){
        this.setClaseEntidad(Cliente.class);
    }
    public Cliente buscarPorCuit(String cuitCliente){

        EntityManager em = EntityManagerUtil.getEntityManager();
        Query buscarPorCuit = em.createNamedQuery("Cliente_buscarPorCuit",Cliente.class);
        buscarPorCuit.setParameter("cuitCliente",cuitCliente);

        return (Cliente)buscarPorCuit.getSingleResult();
    }
}
