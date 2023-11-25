package argProg.models;

import java.util.Random;

public class Operador {
    private int id;
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
