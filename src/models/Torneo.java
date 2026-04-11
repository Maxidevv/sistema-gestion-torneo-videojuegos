package src.models;
import java.util.ArrayList;

public class Torneo {
    private String nombre;
    private ArrayList<Jugador> jugadores;
    private ArrayList<Partida> partidas;

    public Torneo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
        this.partidas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    public void agregarJugador(Jugador jugador) {
        if (!jugadores.contains(jugador)) {
            jugadores.add(jugador);
            System.out.println("Jugador " + jugador.getNombre() + " agregado al torneo.");
        } else {
            System.out.println("El jugador ya está inscrito en el torneo.");
        }
    }

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

    public Jugador buscarJugador(String nombre) {
        for (Jugador j : jugadores) {
            if (j.getNombre().equalsIgnoreCase(nombre)) {
                return j;
            }
        }
        return null;
    }

    public void simularPartida(int indice1, int indice2) {
        if (indice1 < 0 || indice1 >= jugadores.size() || 
            indice2 < 0 || indice2 >= jugadores.size()) {
            System.out.println("Índices inválidos.");
            return;
        }

        if (indice1 == indice2) {
            System.out.println("Un jugador no puede jugar contra sí mismo.");
            return;
        }

        Jugador j1 = jugadores.get(indice1);
        Jugador j2 = jugadores.get(indice2);

        Partida partida = new Partida(j1, j2);
        partida.simularResultado();
        partidas.add(partida);

        j1.agregarPartida(partida);
        j2.agregarPartida(partida);
        j1.incrementarPartida();
        j2.incrementarPartida();

        Jugador ganador = partida.getGanador();
        if (ganador != null) {
            ganador.incrementarPuntaje(3);
            System.out.println("\nPartida finalizada: " + ganador.getNombre() + " gana!");
        } else {
            j1.incrementarPuntaje(1);
            j2.incrementarPuntaje(1);
            System.out.println("\nPartida finalizada: ¡Empate!");
        }
    }

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

    public String toString() {
        return "Torneo{" +
                "nombre='" + nombre + '\'' +
                ", jugadores=" + jugadores.size() +
                ", partidas=" + partidas.size() +
                '}';
    }
}
