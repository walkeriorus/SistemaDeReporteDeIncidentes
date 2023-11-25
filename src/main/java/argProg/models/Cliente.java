package argProg.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import argProg.models.Servicio;

@Setter @Getter
@Entity
@Table(name = "Cliente")
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
    private ArrayList<Servicio> serviciosContratados;

    public Cliente(String nombre,String cuit, String razonSocial){
        this.cuit = cuit;
        this.nombre = nombre;
        this.razonSocial = razonSocial;
    }
}
