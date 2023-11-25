package argProg.utilidades;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {
    private static String persistenceUnitName = "UP";
    public EntityManagerUtil(){}
    public static EntityManager getEntityManager(){
        EntityManager em = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
        return em;
    }

}
