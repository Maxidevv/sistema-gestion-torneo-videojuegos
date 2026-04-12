package src.models;
import java.util.Random;

/**
 * Representa una partida de 2 vs 2 entre dos equipos.
 * Cada equipo está compuesto por 2 jugadores.
 * Gestiona el resultado de la partida y determina el ganador o empate.
 * 
 * @author Matias, Maxi, Maximo
 * @version 1.4
 * @see Jugador
 * @see Torneo
 */
public class Partida {
    private Jugador e1j1;  // Equipo 1 Jugador 1
    private Jugador e1j2;  // Equipo 1 Jugador 2
    private Jugador e2j1;  // Equipo 2 Jugador 1
    private Jugador e2j2;  // Equipo 2 Jugador 2
    private int equipoGanador;  // 1 o 2, 0 si empate
    private boolean esEmpate;

    /**
     * Constructor que crea una nueva partida 2 vs 2.
     * Inicializa los 4 jugadores (2 por equipo) y establece
     * los resultados iniciales como no jugado.
     *
     * @param e1j1 Primer jugador del equipo 1
     * @param e1j2 Segundo jugador del equipo 1
     * @param e2j1 Primer jugador del equipo 2
     * @param e2j2 Segundo jugador del equipo 2
     */
    public Partida(Jugador e1j1, Jugador e1j2, Jugador e2j1, Jugador e2j2) {
        this.e1j1 = e1j1;
        this.e1j2 = e1j2;
        this.e2j1 = e2j1;
        this.e2j2 = e2j2;
        this.equipoGanador = 0;
        this.esEmpate = false;
    }

    /**
     * Obtiene el primer jugador del equipo 1.
     *
     * @return Jugador 1 del equipo 1
     */
    public Jugador getE1j1() {
        return e1j1;
    }

    /**
     * Obtiene el segundo jugador del equipo 1.
     *
     * @return Jugador 2 del equipo 1
     */
    public Jugador getE1j2() {
        return e1j2;
    }

    /**
     * Obtiene el primer jugador del equipo 2.
     *
     * @return Jugador 1 del equipo 2
     */
    public Jugador getE2j1() {
        return e2j1;
    }

    /**
     * Obtiene el segundo jugador del equipo 2.
     *
     * @return Jugador 2 del equipo 2
     */
    public Jugador getE2j2() {
        return e2j2;
    }

    /**
     * Obtiene el equipo ganador de la partida.
     *
     * @return 1 si ganó el equipo 1, 2 si ganó el equipo 2, 0 si fue empate
     */
    public int getEquipoGanador() {
        return equipoGanador;
    }

    /**
     * Verifica si la partida terminó en empate.
     *
     * @return true si fue empate, false si hubo ganador
     */
    public boolean isEsEmpate() {
        return esEmpate;
    }

    /**
     * Simula el resultado de la partida de forma aleatoria.
     * Genera un número aleatorio del 0 al 2 para determinar ganador.
     * Actualiza los atributos equipoGanador y esEmpate según el resultado.
     */
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

    /**
     * Retorna una representación en texto del resultado de la partida.
     * Muestra los nombres de los jugadores y el resultado (ganador o empate).
     *
     * @return String con el formato del resultado de la partida
     */
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
