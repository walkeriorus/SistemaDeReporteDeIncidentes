package argProg.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "especialidad")
public class Especialidad {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int idEspecialidad;


    @Column(name = "nombre",length = 80)
    private String nombre;


    @Column(name = "descripcion",length = 150)
    private String descripcion;


    public Especialidad(String nombre, String descripcion) {
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
    }

    @Override
    public String toString() {
        return String.format("id: %s, nombre: %s, desc: %s",this.getIdEspecialidad(),this.getNombre(),this.getDescripcion());
    }
}
