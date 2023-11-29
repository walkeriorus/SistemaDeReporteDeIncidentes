package argProg.utilidades;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {
    private static String PERSISTENCE_UNIT = "UP";
    private static EntityManager em = null;
    public EntityManagerUtil(){}
    public static EntityManager getEntityManager(){
        if(em == null){
            em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
        }
        return em;
    }

}
