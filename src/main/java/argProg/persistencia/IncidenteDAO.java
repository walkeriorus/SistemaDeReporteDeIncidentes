package argProg.persistencia;
import argProg.modelos.Incidente;

public class IncidenteDAO extends DAO<Incidente>{
    public IncidenteDAO(){
        this.setClaseEntidad(Incidente.class);
    }
}
