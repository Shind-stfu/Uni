import java.util.Scanner;

// Este es el punto de entrada del programa.
// Aquí pedimos los nombres y lanzamos la pelea.
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Por favor, ingresa el nombre del primer luchador: ");
        String nombre1 = scanner.nextLine();

        System.out.print("Ahora, ingresa el nombre del segundo luchador: ");
        String nombre2 = scanner.nextLine();

        // Creamos la pelea y la comenzamos
        JuegoLucha juego = new JuegoLucha(nombre1, nombre2);
        juego.iniciarPelea();

        scanner.close();
    }
}
