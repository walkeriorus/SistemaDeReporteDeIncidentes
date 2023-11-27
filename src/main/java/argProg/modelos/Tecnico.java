package argProg.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "tecnico")
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "nombre",length = 50)
    private String nombre;

    //Un(1) Tecnico puede tener muchas Especialidades, @OneToMany
    @OneToMany(mappedBy = "tecnico")//mapeado por el atributo tecnico en Especialidad
    private List<Especialidad> especialidades;
    //Un(uno) Tecnico puede tener muchos(many) Incidentes asociados
    @OneToMany
    /*@JoinColumn(name = "id_tecnico",referencedColumnName = "id")//Coloca en la tabla "incidentes" la fk id_tecnico que hace referencia a la columna id de esta tabla(Tecnico)*/
    private List<Incidente> incidentes;
    private int  tiempopordefecto;
    @Override
    public String toString() {
        return "Tecnico [id=" + id + ", especialidades=" + especialidades + ", incidentes=" + incidentes
                + ", tiempopordefecto=" + tiempopordefecto + "]";
    }
}
