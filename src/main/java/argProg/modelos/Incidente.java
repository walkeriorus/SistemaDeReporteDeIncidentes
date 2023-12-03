package argProg.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "incidentes")
@NamedQueries({
        @NamedQuery(name = "Incidente_buscarResueltos",query="SELECT inci FROM Incidente inci WHERE inci.estado =\"resuelto\"")
})
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id")
    private int id;

    @Column(name = "descripcion",length = 150)
    private String descripcionIncidente;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_cliente",referencedColumnName = "idCliente",foreignKey = @ForeignKey(name = "IncidenteClientePorId"))
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="id_servicio",referencedColumnName = "idServicio",foreignKey = @ForeignKey(name = "IncidenteServicioPorId"))
    private Servicio servicio;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_tecnico",referencedColumnName = "idTecnico",foreignKey = @ForeignKey(name = "IncidenteTecnicoPorId"))
    public Tecnico tecnico;

    @Column(name = "fecha_posible_resolucion")
    private LocalDate fechaPosibleResolucion;

    @Column(name = "fecha_finalizacion")
    private LocalDate fechaFinalizacion;

    @Column(name = "estado")
    private String estado;

    @Column(name="complejo")
    private boolean complejo;

    @OneToMany(cascade ={CascadeType.PERSIST} )
    @JoinColumn(name = "id_incidente",referencedColumnName = "id")
    private List<TipoProblema> tiposDeProblema;


    public Incidente(String descripcionIncidente, Tecnico tecnico, Cliente cliente, String estado, LocalDate fechaPosibleResolucion, boolean complejo) {
        this.descripcionIncidente = descripcionIncidente;
        this.tecnico = tecnico;
        this.cliente = cliente;
        this.estado = estado;
        this.fechaPosibleResolucion = fechaPosibleResolucion;
        this.complejo = complejo;
        this.tiposDeProblema = new ArrayList<>();
    }
    @Override
    public String toString(){
        String desc = String.format("id: %s, id_cliente: %s,id_tecnico:%s, \ndesc: %s, fechaFinalizacion:%s, estado: %s",
                this.getId(),this.getCliente().getIdCliente(),this.getTecnico().getIdTecnico(),this.getDescripcionIncidente(),
                this.getFechaFinalizacion(),this.getEstado());
        return desc;
    }
}
