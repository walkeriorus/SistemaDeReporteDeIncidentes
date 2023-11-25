package argProg.models;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import argProg.models.Servicio;

@Setter @Getter
public class Cliente {
    private int id;
    private String nombre;
    private String cuit;
    private String razonSocial;
    private ArrayList<Servicio> serviciosContratados;
}
