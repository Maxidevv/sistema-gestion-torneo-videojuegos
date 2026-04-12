package src.models;
import java.util.Scanner;

public class Administracion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Torneo torneo = new Torneo("Torneo regional");
        int opcion;

        System.out.println("╔═══════════════════════╗");
        System.out.println("║   SISTEMA DE TORNEO   ║");
        System.out.println("╚═══════════════════════╝");

        do {
            System.out.println("------MENU PRINCIPAL------");
            System.out.println("1. Agregar jugador");
            System.out.println("2. Listar jugadores");
            System.out.println("3. Buscar jugador por nombre");
            System.out.println("4. Simular partida");
            System.out.println("5. Mostrar ranking");
            System.out.println("6. Mostrar historial de partidas");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("DNI: ");
                    int dni = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Nacionalidad: ");
                    String nacionalidad = scanner.nextLine();
                    torneo.agregarJugador(new Jugador(dni, nombre, nacionalidad));
                    break;
                case 2:
                    torneo.listarJugadores();
                    break;
                case 3:
                    System.out.print("Ingrese el nombre a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    Jugador encontrado = torneo.buscarJugador(nombreBuscar);
                    if (encontrado != null) {
                        System.out.println("Jugador encontrado: " + encontrado.getEstadisticas());
                    } else {
                        System.out.println("No se encontro ningun jugador con ese nombre");
                    }
                    break;
                case 4:
                    if (torneo.getJugadores().size() < 4) {
                        System.out.println("Se necesitan al menos 4 jugadores para simular una partida 2vs2");
                        break;
                    }
                    torneo.listarJugadores();
                    System.out.println("\n=== EQUIPO 1 ===");
                    System.out.print("Ingrese el id del jugador 1: ");
                    int ind1 = scanner.nextInt() - 1;
                    System.out.print("Ingrese el id del jugador 2: ");
                    int ind2 = scanner.nextInt() - 1;
                    System.out.println("\n=== EQUIPO 2 ===");
                    System.out.print("Ingrese el id del jugador 3: ");
                    int ind3 = scanner.nextInt() - 1;
                    System.out.print("Ingrese el id del jugador 4: ");
                    int ind4 = scanner.nextInt() - 1;
                    scanner.nextLine();
                    torneo.simularPartida(ind1, ind2, ind3, ind4);
                    break;
                case 5:
                    torneo.mostrarRanking();
                    break;
                case 6:
                    torneo.mostrarHistorialPartidas();
                    break;
                case 7:
                    System.out.println("Saliendo del sistema");
                    break;
                default:
                    System.out.println("Opción no valida,ingrese una opción del 1 al 7");
            }

        } while (opcion != 7);
        scanner.close();
    }
}