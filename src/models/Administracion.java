package src;
import java.util.Scanner;
public class Administracion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Torneo torneo = new Torneo("Torneo regional");


        int opcion;

        System.out.println("╔═══════════════════════╗");
        System.out.println("║   SISTEMA DE TORNEO   ║");
        System.out.println("╚═══════════════════════╝");

        do{
            System.out.println("------MENU PRINCIPAL------");
            System.out.println("1.Agregar jugadores");
            System.out.println("2.Listar jugadores");
            System.out.println("3.Buscar jugador por nombre");
            System.out.println("4.Simular partida");
            System.out.println("5.Mostrar ranking");
            System.out.println("6.Mostrar historial de partidas");
            System.out.println("7.Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del 1 al 7.");
            }
        }while(opcion != 7);
        scanner.close();
    }
}
