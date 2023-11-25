package argProg.models;

import java.util.ArrayList;

public class Tecnico {
    private Long id;
    private ArrayList<Especialidad> especialidades;
    private ArrayList<Incidente> incidentes;
    private int  tiempopordefecto;
    @Override
    public String toString() {
        return "Tecnico [id=" + id + ", especialidades=" + especialidades + ", incidentes=" + incidentes
                + ", tiempopordefecto=" + tiempopordefecto + "]";
    }
}
