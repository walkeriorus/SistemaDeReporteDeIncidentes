package argProg.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "incidentes")
@NamedQueries({
        @NamedQuery(name = "Incidente_buscarResueltos",query="SELECT inci FROM Incidente inci WHERE = inci.getEstado()=\"resuelto\"")
})
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "descripcion",length = 150)
    private String DescripcionIncidente;

    @ManyToOne//Muchos Incidentes se asocian a un(1) Tecnico
    @JoinColumn(name = "id_tecnico",referencedColumnName = "id")
    public Tecnico tecnico;

    /*@OneToOne//Un(uno) Incidente se asocia con un(uno) Cliente
    @JoinColumn(name = "id_cliente",referencedColumnName = "id")//Referencio a la columna id en Cliente
    private Cliente cliente;*/
    @ManyToOne//Muchos(N) Incidentes se asocian con un(1) Cliente
    @JoinColumn(name = "id_cliente",referencedColumnName = "id")//Referencio a la columna id en Cliente
    private Cliente cliente;


    /*private Servicio servicio;*/
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecha_posible_resolucion")
    private Date fechaPosibleResolucion;
    @Column(name = "fecha_finalizacion")
    private Date fechaFinalizacion;
    @Column(name="complejo")
    private boolean complejo;

    //Un(uno) Incidente puede tener muchos TiposProblema --> @OneToMany
    @OneToMany
    @JoinColumn(name = "id_incidente",referencedColumnName = "id")
    private List<TipoProblema> tiposdeproblema;

    public Incidente(String descripcionIncidente, Tecnico tecnico, Cliente cliente, String estado, Date fechaPosibleResolucion, boolean complejo) {
        DescripcionIncidente = descripcionIncidente;
        this.tecnico = tecnico;
        this.cliente = cliente;
        this.estado = estado;
        this.fechaPosibleResolucion = fechaPosibleResolucion;
        this.complejo = complejo;
        this.tiposdeproblema = new ArrayList<>();
    }
}
