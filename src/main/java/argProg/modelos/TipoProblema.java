package argProg.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_problema")
public class TipoProblema {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "nombre",length = 50)
    private String nombre;
    @Column(name = "descripcion",length = 150 )
    private String descripcion;
    @Column(name = "tiempo_max_resolucion",length = 2 )
    private int tiempoMaximoDeResolucion;
}
