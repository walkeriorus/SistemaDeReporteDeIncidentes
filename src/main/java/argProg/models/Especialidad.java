package argProg.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;


@Entity
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    private int id;
    private String nombre;
    private String descripcion;
    //Una Espcialidad puede tener 1 o mas Tecnicos, @ManyToOne
    @ManyToOne
    @JoinColumn(name="id_tecnico", referencedColumnName="id")
    private Tecnico tecnico;
}
