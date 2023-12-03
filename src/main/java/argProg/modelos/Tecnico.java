package argProg.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter @Setter
@Entity
@Table(name = "tecnico")
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "idTecnico")
    int idTecnico;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @OneToMany(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="id_tecnico",referencedColumnName = "idTecnico",foreignKey = @ForeignKey(name = "TecnicoEspecialidadPorId"))
    private List<Especialidad> especialidades;

    @Column(name = "tiempo_por_defecto")
    private Integer tiempoPorDefecto;

    public Tecnico() {
        this.especialidades = new ArrayList<>();
    }

    public Tecnico(String nombre, Integer tiempopordefecto) {
        this.setNombre(nombre);
        this.setTiempoPorDefecto(tiempopordefecto);
        this.especialidades = new ArrayList<>();
    }

    public Tecnico(String nombre, List<Especialidad> especialidades, Integer tiempoPorDefecto) {
        this.setNombre(nombre);
        this.setTiempoPorDefecto(tiempoPorDefecto);
        this.setEspecialidades(especialidades);
    }


    public void agregarEspecialidad(Especialidad nuevaEspecialidad) {
        this.especialidades.add(nuevaEspecialidad);
    }

    @Override
    public String toString() {
        return String.format("id: %s,nombre: %s",this.getIdTecnico(),this.getNombre());
    }
}