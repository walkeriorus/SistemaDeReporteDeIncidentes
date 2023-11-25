package argProg.modelos;

import jakarta.persistence.*;

import java.util.List;
import java.util.Date;

@Entity
@Table(name = "Incidentes")
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "descripcion",length = 150)
    private String DescripcionIncidente;

    @ManyToOne//Muchos Incidentes se asocian a un(1) Tecnico
    @JoinColumn(name = "id_tecnico",referencedColumnName = "id")
    private Tecnico tecnico;

    @OneToOne//Un(uno) Incidente se asocia con un(uno) Cliente
    @JoinColumn(name = "id_cliente",referencedColumnName = "id")//Referencio a la columna id en Cliente
    private Cliente cliente;

    /*private Servicio servicio;*/
    @Column(name = "estado")
    private String estado;

    private Date fechaPosibleResolucion;
    private Date fechaFinalizacion;
    private boolean complejo;

    //Un(uno) Incidente puede tener muchos TiposProblema --> @OneToMany
    @OneToMany
    @JoinColumn(name = "id_incidente",referencedColumnName = "id")
    private List<TipoProblema> tiposdeproblema;

}
