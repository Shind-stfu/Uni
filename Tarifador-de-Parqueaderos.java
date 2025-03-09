import java.util.Scanner;

// Clase principal del programa
public class Parqueadero {
    private static final int PLAZAS = 20; // Número total de puestos
    private static Moto[] puestos = new Moto[PLAZAS]; // Array que almacena las motos
    private static Scanner sc = new Scanner(System.in); // Scanner para entrada de datos
    
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n1. Registrar moto");
            System.out.println("2. Cobrar tarifa");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer