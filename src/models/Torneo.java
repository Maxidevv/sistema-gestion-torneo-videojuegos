package src.models;
import java.util.ArrayList;

/**
 * Representa un torneo de videojuegos.
 * Gestiona la lista de jugadores inscritos (máximo 10).
 * Administra el registro de partidas y proporciona funcionalidades para búsqueda y ranking.
 * 
 * @author Matias, Maxi, Maximo
 * @version 1.7
 * @see Jugador
 * @see Partida
 */
public class Torneo {
    private String nombre;
    private ArrayList<Jugador> jugadores;
    private ArrayList<Partida> partidas;

    /**
     * Constructor que crea un nuevo torneo.
     * Inicializa las listas vacías de jugadores y partidas.
     *
     * @param nombre Nombre del torneo
     */
    public Torneo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
        this.partidas = new ArrayList<>();
    }

    /**
     * Obtiene el nombre del torneo.
     *
     * @return Nombre asignado al torneo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Actualiza el nombre del torneo.
     *
     * @param nombre El nuevo nombre del torneo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de jugadores registrados en el torneo.
     *
     * @return ArrayList con todos los jugadores del torneo
     */
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    /**
     * Obtiene el historial de partidas jugadas en el torneo.
     *
     * @return ArrayList con todas las partidas registradas
     */
    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    /**
     * Agrega un nuevo jugador al torneo si no excede el límite de 10.
     * Valida que el jugador no esté duplicado antes de agregarlo.
     *
     * @param jugador El jugador a agregar al torneo
     */
    public void agregarJugador(Jugador jugador) {
        if (jugadores.size() >= 10) {
            System.out.println("No se puede agregar más jugadores. Máximo 10 jugadores permitidos.");
            return;
        }
        if (!jugadores.contains(jugador)) {
            jugadores.add(jugador);
            System.out.println("Jugador " + jugador.getNombre() + " agregado al torneo.");
        } else {
            System.out.println("El jugador ya está inscrito en el torneo.");
        }
    }

    /**
     * Muestra en pantalla la lista completa de jugadores registrados.
     * Imprime un mensaje si no hay jugadores.
     */
    public void listarJugadores() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados.");
            return;
        }
        System.out.println("\n=== LISTA DE JUGADORES ===");
        for (int i = 0; i < jugadores.size(); i++) {
            System.out.println((i + 1) + ". " + jugadores.get(i).getEstadisticas());
        }
    }

    /**
     * Busca un jugador en el torneo por su nombre.
     * La búsqueda no diferencia mayúsculas de minúsculas.
     *
     * @param nombre El nombre del jugador a buscar
     * @return El Jugador si lo encuentra, null si no existe
     */
    public Jugador buscarJugador(String nombre) {
        for (Jugador j : jugadores) {
            if (j.getNombre().equalsIgnoreCase(nombre)) {
                return j;
            }
        }
        return null;
    }

    /**
     * Simula una partida 2 vs 2 entre 4 jugadores especificados.
     * Valida que los índices sean válidos y que todos sean jugadores diferentes.
     * Registra la partida y actualiza estadísticas y puntos de los jugadores.
     *
     * @param i1 Índice del jugador 1 del equipo 1
     * @param i2 Índice del jugador 2 del equipo 1
     * @param i3 Índice del jugador 1 del equipo 2
     * @param i4 Índice del jugador 2 del equipo 2
     */
    public void simularPartida(int i1, int i2, int i3, int i4) {
        // Validar índices
        int[] indices = {i1, i2, i3, i4};
        for (int idx : indices) {
            if (idx < 0 || idx >= jugadores.size()) {
                System.out.println("Índices inválidos.");
                return;
            }
        }

        // Validar que sean jugadores diferentes
        if (i1 == i2 || i1 == i3 || i1 == i4 || i2 == i3 || i2 == i4 || i3 == i4) {
            System.out.println("Los 4 jugadores deben ser diferentes.");
            return;
        }

        Jugador e1j1 = jugadores.get(i1);
        Jugador e1j2 = jugadores.get(i2);
        Jugador e2j1 = jugadores.get(i3);
        Jugador e2j2 = jugadores.get(i4);

        Partida partida = new Partida(e1j1, e1j2, e2j1, e2j2);
        partida.simularResultado();
        partidas.add(partida);

        // Registrar partida en todos los jugadores
        e1j1.agregarPartida(partida);
        e1j2.agregarPartida(partida);
        e2j1.agregarPartida(partida);
        e2j2.agregarPartida(partida);
        e1j1.incrementarPartida();
        e1j2.incrementarPartida();
        e2j1.incrementarPartida();
        e2j2.incrementarPartida();

        // Asignar puntos
        if (partida.getEquipoGanador() == 1) {
            e1j1.incrementarPuntaje(3);
            e1j2.incrementarPuntaje(3);
            System.out.println("\nPartida finalizada: ¡Equipo 1 ("+e1j1.getNombre()+" y "+e1j2.getNombre()+") gana!");
        } else if (partida.getEquipoGanador() == 2) {
            e2j1.incrementarPuntaje(3);
            e2j2.incrementarPuntaje(3);
            System.out.println("\nPartida finalizada: ¡Equipo 2 ("+e2j1.getNombre()+" y "+e2j2.getNombre()+") gana!");
        } else {
            e1j1.incrementarPuntaje(1);
            e1j2.incrementarPuntaje(1);
            e2j1.incrementarPuntaje(1);
            e2j2.incrementarPuntaje(1);
            System.out.println("\nPartida finalizada: ¡Empate!");
        }
    }

    /**
     * Muestra el ranking de jugadores ordenados por puntaje de mayor a menor.
     * Útil para visualizar la posición de cada jugador en el torneo.
     */
    public void mostrarRanking() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores para mostrar ranking.");
            return;
        }

        ArrayList<Jugador> temp = new ArrayList<>(jugadores);
        System.out.println("\n=== RANKING DE JUGADORES ===");

        for (int i = 0; i < jugadores.size(); i++) {
            Jugador maximo = temp.get(0);
            for (Jugador j : temp) {
                if (j.getPuntaje() > maximo.getPuntaje()) {
                    maximo = j;
                }
            }
            System.out.println((i + 1) + ". " + maximo.getEstadisticas());
            temp.remove(maximo);
        }
    }

    /**
     * Muestra el historial completo de todas las partidas jugadas en el torneo.
     * Imprime cada partida con sus resultados y participantes.
     */
    public void mostrarHistorialPartidas() {
        if (partidas.isEmpty()) {
            System.out.println("No hay partidas registradas.");
            return;
        }

        System.out.println("\n=== HISTORIAL DE PARTIDAS ===");
        for (int i = 0; i < partidas.size(); i++) {
            System.out.println((i + 1) + ". " + partidas.get(i).toString());
        }
    }

    /**
     * Retorna una representación en texto de la información del torneo.
     * Incluye el nombre y la cantidad de jugadores y partidas.
     *
     * @return String con el resumen del torneo
     */
    public String toString() {
        return "Torneo{" +
                "nombre='" + nombre + '\'' +
                ", jugadores=" + jugadores.size() +
                ", partidas=" + partidas.size() +
                '}';
    }
}
