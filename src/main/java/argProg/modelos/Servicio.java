package argProg.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    private int id;
    @Column(name = "nombre",length = 50)
    private String nombre;
    @Column(name = "descripción",length=150)
    private String descripcion;
    @ManyToMany(mappedBy = "serviciosContratados")//Con esto tendriamos que un Servicio puede tener muchos Clientes
    private List<Cliente> cliente;
}
