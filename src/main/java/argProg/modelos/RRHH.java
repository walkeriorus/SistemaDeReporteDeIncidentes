package argProg.modelos;

import argProg.persistencia.IncidenteDAO;
import argProg.persistencia.TecnicoDAO;

public class RRHH {
    //Realiza altas bajas y modificaciones de Tecnicos -> Necesita acceso a al tabla de Tecnicos
    //Debe informar el Tecnico con la mayor cantidad de Incidentes resueltos -> Tambien accede a la tabla Incidentes
    private TecnicoDAO tecnicoDAO = new TecnicoDAO();
    private IncidenteDAO incidenteDAO = new IncidenteDAO();

    public void darDeAltaTecnico(Tecnico tecnico){
        tecnicoDAO.guardar(tecnico);
    };
    public void darDeBajaTecnico(Tecnico tecnico){
        tecnicoDAO.eliminar(tecnico);
    }
    public void modificarTecnico(Tecnico tecnico){
        tecnicoDAO.actualizar(tecnico);
    }
}
