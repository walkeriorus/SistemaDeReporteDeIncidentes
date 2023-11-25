package argProg.models;

import java.util.ArrayList;
import java.util.Date;

public class Incidente {

    private Long id;
    private String DescripcionIncidente;
    private Tecnico tecnico;
    private Cliente cliente;
    private Servicio servicio;
    private String estado;
    private Date fechaPosibleResolucion;
    private Date fechaFinalizacion;
    private boolean complejo;
    private ArrayList<TipoProblema> tiposdeproblema;

}
