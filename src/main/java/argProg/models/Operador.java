package argProg.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
@Getter @Setter
@Entity
@Table(name = "Operador")
public class Operador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    @Column(name = "nombre",length = 50 )
    private String nombre;
    public int AgregarHoras(boolean complejo) {
        int horas=0;
        if (complejo) {
            // Agrega de (0-23)+1
            Random random = new Random();
            horas = random.nextInt(23)+1;
        }
        return horas;
    }
}
