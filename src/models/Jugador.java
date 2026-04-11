package src.models;
import java.util.ArrayList;

public class Jugador {
    private int dni;
    private String nombre;
    private String nacionalidad;
    private int partidasJugadas;
    private int puntaje;
    private ArrayList<Partida> partidas;

    public Jugador(int dni, String nombre, String nacionalidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.partidasJugadas = 0;
        this.puntaje = 0;
        this.partidas = new ArrayList<>();
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void incrementarPartida() {
        this.partidasJugadas++;
    }

    public void incrementarPuntaje(int puntos) {
        this.puntaje += puntos;
    }

    public void agregarPartida(Partida partida) {
        if (!partidas.contains(partida)) {
            partidas.add(partida);
        }
    }

    public String getEstadisticas() {
        return "Dni: " + dni + "| Nombre: " + nombre + " | País: " + nacionalidad + " | Partidas: " + partidasJugadas + " | Puntaje: " + puntaje;
    }
}

