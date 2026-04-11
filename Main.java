package chatbot;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario(1, "Maxi");
        Servidor servidor = new Servidor();
        Dispositivo dispositivo = new Dispositivo(1, usuario, servidor);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Te damos la bienvenida " + usuario.getNombre() + " al ChatBot. | Dispositivo con ID (" + dispositivo.getId() + ")");
        String mensaje;
        do {
            System.out.println("[1] - Consultar al ChatBot. | [2] - Salir.");
            System.out.print("A continuacion ingrese una opcion:\n> ");
            mensaje = scanner.nextLine();
            switch (mensaje) {
                case "1":
                    System.out.print("Ingrese su consulta:\n> ");
                    String consulta = scanner.nextLine();
                    String respuesta = dispositivo.enviarConsulta(consulta);
                    System.out.println("Respuesta: " + respuesta);
                    break;
                case "2":
                    System.out.println("Programa finalizado, gracias por utilizar ChatBot");
                    break;
                default:
                    System.out.println("La opcion no corresponde.");
                    break;
            }
        } while(!mensaje.equals("2"));
        scanner.close();
    }    
}
