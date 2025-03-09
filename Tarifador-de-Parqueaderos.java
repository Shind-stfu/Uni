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
            if (opcion == 1) {
                registrarMoto();
            } else if (opcion == 2) {
                cobrarTarifa();
            } else if (opcion == 3) {
                System.out.println("Saliendo...");
            } else {
                System.out.println("Opción inválida");
            }
        } while (opcion != 3);
    }

    private static void registrarMoto() {
        System.out.print("Ingrese placa: ");
        String placa = sc.nextLine();
        
        // Validar si la moto ya está registrada
        for (Moto moto : puestos) {
            if (moto != null && moto.getPlaca().equals(placa)) {
                System.out.println("Esa moto ya está registrada.");
                return;
            }
        }