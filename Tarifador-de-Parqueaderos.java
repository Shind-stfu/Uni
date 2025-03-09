import java.util.Scanner;
// Clase principal del programa
public class Parqueadero {
    private static final int PLAZAS = 20; // Número total de puestos
    private static Moto[] puestos = new Moto[PLAZAS]; // Array que almacena las motos
    private static Scanner sc = new Scanner(System.in); // Scanner para entrada de datos
    