package argProg.models;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "Tecnico")
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    //Un(1) Tecnico puede tener muchas Especialidades, @OneToMany
    @OneToMany(mappedBy = "tecnico")//mapeado por el atributo tecnico en Especialidad
    private ArrayList<Especialidad> especialidades;
    //Un(uno) Tecnico puede tener muchos(many) Incidentes asociados
    @OneToMany
    /*@JoinColumn(name = "id_tecnico",referencedColumnName = "id")//Coloca en la tabla "incidentes" la fk id_tecnico que hace referencia a la columna id de esta tabla(Tecnico)*/
    private ArrayList<Incidente> incidentes;
    private int  tiempopordefecto;
    @Override
    public String toString() {
        return "Tecnico [id=" + id + ", especialidades=" + especialidades + ", incidentes=" + incidentes
                + ", tiempopordefecto=" + tiempopordefecto + "]";
    }
}
