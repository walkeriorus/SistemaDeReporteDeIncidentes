package argProg.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    private int id;
    @Column(name = "nombre",length = 80)
    private String nombre;
    @Column(name = "descripcion",length = 150)
    private String descripcion;
    //Una Espcialidad puede tener 1 o mas Tecnicos, @ManyToOne
    @ManyToOne
    @JoinColumn(name="id_tecnico", referencedColumnName="id")
    private Tecnico tecnico;
}
