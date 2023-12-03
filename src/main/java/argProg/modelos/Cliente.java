package argProg.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter @Getter
@Entity
@Table(name = "Cliente")
@NamedQueries(
        {
                @NamedQuery(name = "Cliente_buscarPorCuit", query = "SELECT cliente FROM Cliente cliente WHERE cliente.cuit = :cuitCliente"),
                @NamedQuery(name="Cliente_buscarPorRazonSocial",query="SELECT cliente FROM Cliente cliente WHERE cliente.razonSocial = :razonSocial")
        }
)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private int idCliente;


    @Column(name = "nombre", length = 50)
    private String nombre;


    @Column(name = "cuit", length = 12)
    private String cuit;


    @Column(name = "razon_social", length = 50)
    private String razonSocial;


    @OneToMany(cascade = CascadeType.PERSIST )
    @JoinColumn(name = "id_cliente", referencedColumnName = "idCliente",foreignKey = @ForeignKey(name = "ClienteServicioPorId"))
    private List<Servicio> serviciosContratados;


    public Cliente() {
    }

    public Cliente(String nombre, String cuit, String razonSocial) {
        this.cuit = cuit;
        this.nombre = nombre;
        this.razonSocial = razonSocial;
        this.serviciosContratados = new ArrayList<>();
    }
    public void agregarServicio(Servicio nuevoServicio){
        this.serviciosContratados.add(nuevoServicio);
    }

    @Override
    public String toString() {
        return "id: " + this.idCliente + " nombre: " + this.nombre + " cuit: " + this.cuit + " razon_social: " + this.razonSocial;
    }
}
