package src.models;
import java.util.Random;

public class Partida {
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador ganador;
    private boolean esEmpate;

    public Partida(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.ganador = null;
        this.esEmpate = false;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public Jugador getGanador() {
        return ganador;
    }

    public boolean isEsEmpate() {
        return esEmpate;
    }

    public void simularResultado() {
        Random random = new Random();
        int resultado = random.nextInt(3);

        if (resultado == 0) {
            this.ganador = jugador1;
            this.esEmpate = false;
        } else if (resultado == 1) {
            this.ganador = jugador2;
            this.esEmpate = false;
        } else {
            this.ganador = null;
            this.esEmpate = true;
        }
    }

    public String toString() {
        String resultado;
        if (esEmpate) {
            resultado = "Empate entre " + jugador1.getNombre() + " y " + jugador2.getNombre();
        } else {
            resultado = jugador1.getNombre() + " vs " + jugador2.getNombre() + " → Ganador: " + ganador.getNombre();
        }
        return resultado;
    }
}
