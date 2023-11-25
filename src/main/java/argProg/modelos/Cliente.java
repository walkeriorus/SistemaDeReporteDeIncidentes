package argProg.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter @Getter
@Entity
@Table(name = "Cliente")
@NamedQueries(
        {
        @NamedQuery(name = "Cliente_buscarTodos",query = "SELECT cliente FROM Cliente cliente" ),
        @NamedQuery(name="Cliente_buscarPorCuit",query = "SELECT cliente FROM Cliente cliente WHERE cliente.cuit = :cuitCliente")
        }
)
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column( name = "nombre",length = 50 )
    private String nombre;
    @Column(name="cuit",length = 12)
    private String cuit;
    @Column(name = "razon_social",length = 50)
    private String razonSocial;
    @ManyToMany
    @JoinTable(name="cliente_servicio",joinColumns = @JoinColumn(name = "cliente_id"),inverseJoinColumns = @JoinColumn(name="servicio_id"))//Con esto tendriamos que un Cliente puede tener muchos Servicios
    private List<Servicio> serviciosContratados;

    public Cliente(){}
    public Cliente(String nombre,String cuit, String razonSocial){
        this.cuit = cuit;
        this.nombre = nombre;
        this.razonSocial = razonSocial;
    }
    @Override
    public String toString(){
        return "id: " + this.id + " nombre: " + this.nombre +" cuit: " + this.cuit;
    }
}
