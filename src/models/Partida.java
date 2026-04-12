package src.models;
import java.util.Random;

public class Partida {
    private Jugador e1j1;  // Equipo 1 Jugador 1
    private Jugador e1j2;  // Equipo 1 Jugador 2
    private Jugador e2j1;  // Equipo 2 Jugador 1
    private Jugador e2j2;  // Equipo 2 Jugador 2
    private int equipoGanador;  // 1 o 2, 0 si empate
    private boolean esEmpate;

    public Partida(Jugador e1j1, Jugador e1j2, Jugador e2j1, Jugador e2j2) {
        this.e1j1 = e1j1;
        this.e1j2 = e1j2;
        this.e2j1 = e2j1;
        this.e2j2 = e2j2;
        this.equipoGanador = 0;
        this.esEmpate = false;
    }

    public Jugador getE1j1() {
        return e1j1;
    }

    public Jugador getE1j2() {
        return e1j2;
    }

    public Jugador getE2j1() {
        return e2j1;
    }

    public Jugador getE2j2() {
        return e2j2;
    }

    public int getEquipoGanador() {
        return equipoGanador;
    }

    public boolean isEsEmpate() {
        return esEmpate;
    }

    public void simularResultado() {
        Random random = new Random();
        int resultado = random.nextInt(3);

        if (resultado == 0) {
            this.equipoGanador = 1;
            this.esEmpate = false;
        } else if (resultado == 1) {
            this.equipoGanador = 2;
            this.esEmpate = false;
        } else {
            this.equipoGanador = 0;
            this.esEmpate = true;
        }
    }

    public String toString() {
        String resultado;
        String equipo1 = e1j1.getNombre() + " y " + e1j2.getNombre();
        String equipo2 = e2j1.getNombre() + " y " + e2j2.getNombre();
        
        if (esEmpate) {
            resultado = "Empate: (" + equipo1 + ") vs (" + equipo2 + ")";
        } else if (equipoGanador == 1) {
            resultado = "(" + equipo1 + ") GANA vs (" + equipo2 + ")";
        } else {
            resultado = "(" + equipo2 + ") GANA vs (" + equipo1 + ")";
        }
        return resultado;
    }
}
