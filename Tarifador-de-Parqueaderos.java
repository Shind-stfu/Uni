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
         // Buscar un espacio libre
         for (int i = 0; i < PLAZAS; i++) {
            if (puestos[i] == null) {
                puestos[i] = new Moto(placa, System.currentTimeMillis());
                System.out.println("Moto registrada en el puesto " + (i + 1));
                return;
            }
        }
        System.out.println("No hay puestos disponibles.");
    }

    private static void cobrarTarifa() {
        System.out.print("Ingrese placa: ");
        String placa = sc.nextLine();
        
        for (int i = 0; i < PLAZAS; i++) {
            if (puestos[i] != null && puestos[i].getPlaca().equals(placa)) {
                long tiempo = (System.currentTimeMillis() - puestos[i].getHoraIngreso()) / 60000;
                int tarifa = (tiempo <= 30) ? 0 : (tiempo <= 60) ? 800 : 2000;
                System.out.println("Tiempo: " + tiempo + " min. Total: $" + tarifa);
                puestos[i] = null; // Liberar puesto
                return;
            }
        }
        System.out.println("Moto no encontrada.");
    }
}
// Clase Moto con atributos básicos
class Moto {
    private String placa;
    private long horaIngreso;

    public Moto(String placa, long horaIngreso) {
        this.placa = placa;
        this.horaIngreso = horaIngreso;
    }

    public String getPlaca() {
        return placa;
    }

    public long getHoraIngreso() {
        return horaIngreso;
    }
}
