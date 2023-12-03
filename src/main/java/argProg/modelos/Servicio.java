package argProg.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
@Table(name = "servicio")
public class Servicio {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "idServicio")
    private int idServicio;


    @Column(name = "nombre",length = 50)
    private String nombre;


    @Column(name = "descripcion",length=150)
    private String descripcion;


    public Servicio(String nombre,String descripcion){
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
    }
    @Override
    public String toString(){
        return String.format("id: %s, nombre:%s",this.getIdServicio(),this.getNombre());
    }
}
