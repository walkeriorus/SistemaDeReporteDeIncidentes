package argProg.persistencia;
import argProg.modelos.Incidente;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Date;

public class IncidenteDAO extends DAO<Incidente>{
    public IncidenteDAO(){
        this.setClaseEntidad(Incidente.class);
    }
    public List<Incidente> buscarResueltos(){
        TypedQuery<Incidente> buscarResueltos = getEm().createNamedQuery("Incidente_buscarResueltos",Incidente.class);
        return buscarResueltos.getResultList();
    }
    public List<Incidente> buscarIncidentesEntreFechas(Date startDate, Date endDate) {
        String jpql = "SELECT inci FROM Incidente inci WHERE inci.getFechaFinalizacion() BETWEEN :startDate AND :endDate";

        Query query = getEm().createQuery(jpql);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);

        return query.getResultList();
    }
}
