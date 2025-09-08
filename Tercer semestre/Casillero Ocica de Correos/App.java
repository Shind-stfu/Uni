import java.util.Scanner;

// Esta es la clase principal donde está el menú que maneja todo
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaLockers sistema = new SistemaLockers(3, 3); // 3x3 = 9 casilleros

        int opcion;
        do {
            System.out.println("\n=== SISTEMA DE LOCKERS ===");
            System.out.println("1. Asignar paquete");
            System.out.println("2. Liberar casillero");
            System.out.println("3. Mostrar estado de casilleros");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpia el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Código del paquete: ");
                    String codigo = sc.nextLine();
                    System.out.print("Destinatario: ");
                    String destinatario = sc.nextLine();
                    System.out.print("Fecha de ingreso: ");
                    String fecha = sc.nextLine();
                    System.out.print("Tamaño (pequeño/mediano/grande): ");
                    String tamano = sc.nextLine();

                    Paquete p = new Paquete(codigo, destinatario, fecha, tamano);
                    Casillero asignado = sistema.asignarPaquete(p);

                    if (asignado != null) {
                        System.out.println("✔ Paquete asignado en casillero " + asignado.getId());
                    } else {
                        System.out.println("⚠ No hay casilleros disponibles para ese paquete.");
                    }
                    break;

                case 2:
                    System.out.print("ID del casillero a liberar: ");
                    int id = sc.nextInt();
                    if (sistema.liberarCasillero(id)) {
                        System.out.println("✔ Casillero liberado con éxito.");
                    } else {
                        System.out.println("⚠ El casillero no existe o ya estaba libre.");
                    }
                    break;

                case 3:
                    sistema.mostrarEstado();
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("⚠ Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
