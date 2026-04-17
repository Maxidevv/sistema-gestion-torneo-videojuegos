package src.models;
import java.util.ArrayList;

/**
 * Representa un jugador en el torneo.
 * Almacena información personal (DNI, nombre, nacionalidad).
 * Mantiene estadísticas de partidas jugadas, puntaje y registro de partidas.
 * 
 * @author Matias, Maxi, Maximo
 * @version 1.4
 * @see Partida
 * @see Torneo
 */
public class Jugador {
    private int dni;
    private String nombre;
    private String nacionalidad;
    private int partidasJugadas;
    private int puntaje;
    private ArrayList<Partida> partidas;

    /**
     * Constructor que crea un nuevo jugador con sus datos personales.
     * Inicializa el contador de partidas en 0 y el puntaje en 0.
     *
     * @param dni Número de identificación único del jugador
     * @param nombre Nombre completo del jugador
     * @param nacionalidad País de origen del jugador
     */
    public Jugador(int dni, String nombre, String nacionalidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.partidasJugadas = 0;
        this.puntaje = 0;
        this.partidas = new ArrayList<>();
    }

    /**
     * Obtiene el número de identificación del jugador.
     *
     * @return El DNI del jugador
     */
    public int getDni() {
        return dni;
    }

    /**
     * Obtiene el nombre del jugador.
     *
     * @return El nombre completo del jugador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la nacionalidad del jugador.
     *
     * @return El país de origen del jugador
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * Obtiene la cantidad de partidas jugadas.
     *
     * @return Número de partidas jugadas por el jugador
     */
    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    /**
     * Obtiene el puntaje acumulado del jugador.
     *
     * @return Puntos totales acumulados
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * Obtiene el registro de todas las partidas del jugador.
     *
     * @return Lista de partidas en las que ha participado
     */
    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    /**
     * Actualiza el nombre del jugador.
     * Valida que el nombre no sea nulo ni vacío antes de asignarlo.
     *
     * @param nombre El nuevo nombre del jugador
     * @throws IllegalArgumentException si el nombre es nulo o está vacío
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) { // trim() detecta espacios
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    /**
     * Actualiza la nacionalidad del jugador.
     *
     * @param nacionalidad El nuevo país de origen
     * @throws IllegalArgumentException si la nacionalidad es nula o está vacío
     */
    public void setNacionalidad(String nacionalidad) {
        if (nacionalidad == null || nacionalidad.trim().isEmpty()) {
            throw new IllegalArgumentException("La nacionalidad no puede estar vacía.");
        }
        this.nacionalidad = nacionalidad;
    }

    /**
     * Actualiza el dni del jugador
     * 
     * @param dni Dni del participante
     * @throws IllegalArgumentException si el dni es negativo
     */
    public void setDni(int dni) {
        if (dni < 0) { throw new IllegalArgumentException ("El DNI no puede ser negativo."); }
        this.dni = dni;
    }

    /**
     * Incrementa el contador de partidas jugadas en 1.
     */
    public void incrementarPartida() {
        this.partidasJugadas++;
    }

    /**
     * Suma puntos al puntaje total del jugador.
     *
     * @param puntos Cantidad de puntos a sumar
     */
    public void incrementarPuntaje(int puntos) {
        this.puntaje += puntos;
    }

    /**
     * Agrega una partida al registro del jugador si no existe.
     * Evita duplicados verificando si la partida ya está en la lista.
     *
     * @param partida La partida a agregar al registro
     */
    public void agregarPartida(Partida partida) {
        if (!partidas.contains(partida)) {
            partidas.add(partida);
        }
    }

    /**
     * Genera una cadena con las estadísticas completas del jugador.
     *
     * @return String con DNI, nombre, nacionalidad, partidas jugadas y puntaje
     */
    public String getEstadisticas() {
        return "Dni: " + dni + "| Nombre: " + nombre + " | País: " + nacionalidad + " | Partidas: " + partidasJugadas + " | Puntaje: " + puntaje;
    }
}

