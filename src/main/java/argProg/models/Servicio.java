package argProg.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Servicio {
    private int id;
    private String nombre;
    private String descripcion;
    private Cliente cliente;
}
