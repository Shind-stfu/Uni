import java.util.Scanner;

//Clase Principal - SistemaBancario
//Contiene el flujo general del programa y el menú principal.
 
public class SistemaBancario{
    
    // Objeto Banco que administra toda la información de las cuentas
    private static Banco banco = new Banco();
    
    // Scanner para capturar datos desde consola
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Cargar datos almacenados previamente en archivo (si existen)
        if (banco.cargarDesdeArchivo()) {
            System.out.println("✓ Datos cargados correctamente.");
        }

        boolean salir = false; // Controla la salida del menú
        
        // Bucle principal del menú
        while (!salir) {
            mostrarMenu(); // Mostrar opciones
            int opcion = leerEntero("Seleccione una opción: "); // Leer opción
            
            // Procesar opción seleccionada
            switch (opcion) {
                case 1:
                    crearCuenta();
                    break;
                case 2:
                    consultarSaldo();
                    break;
                case 3:
                    depositar();
                    break;
                case 4:
                    retirar();
                    break;
                case 5:
                    transferir();
                    break;
                case 6:
                    banco.mostrarCuentas();
                    break;
                case 7:
                    ordenarCuentas();
                    break;
                case 8:
                    buscarPorSaldo();
                    break;
                case 9:
                    guardarDatos();
                    break;
                case 0:
                    salir = true;
                    System.out.println("\n¡Gracias por usar el Sistema Bancario!");
                    break;
                default:
                    System.out.println("❌ Opción no válida.");
            }
            
            // Pausar antes de volver al menú
            if (!salir) {
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine();
            }
        }
        
        scanner.close(); // Cerrar el lector
    }

    // Mostrar menú principal al usuario
    private static void mostrarMenu() {
        limpiarPantalla();
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║     SISTEMA BANCARIO - MENÚ PRINCIPAL  ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("1. Crear cuenta");
        System.out.println("2. Consultar saldo");
        System.out.println("3. Depositar");
        System.out.println("4. Retirar");
        System.out.println("5. Transferir entre cuentas");
        System.out.println("6. Ver todas las cuentas");
        System.out.println("7. Ordenar cuentas por saldo");
        System.out.println("8. Buscar cuenta por saldo (Búsqueda Binaria)");
        System.out.println("9. Guardar datos");
        System.out.println("0. Salir");
        System.out.println("─────────────────────────────────────────");
    }

    // Crear una nueva cuenta bancaria
    private static void crearCuenta() {
        System.out.println("\n=== CREAR NUEVA CUENTA ===");

        System.out.print("Número de cuenta: ");
        String numero = scanner.nextLine();
        
        System.out.print("Nombre del titular: ");
        String titular = scanner.nextLine();
        
        // Leer saldo inicial validado
        double saldoInicial = leerDouble("Saldo inicial: $");
        
        // Intentar crear la cuenta
        if (banco.crearCuenta(numero, titular, saldoInicial)) {
            System.out.println("✓ Cuenta creada exitosamente.");
        } else {
            System.out.println("❌ Error: El número de cuenta ya existe.");
        }
    }

    // Consultar el saldo de una cuenta existente
    private static void consultarSaldo() {
        System.out.println("\n=== CONSULTAR SALDO ===");
        System.out.print("Número de cuenta: ");
        String numero = scanner.nextLine();
        
        Double saldo = banco.consultarSaldo(numero);
        
        if (saldo != null) {
            System.out.printf("Saldo actual: $%.2f\n", saldo);
        } else {
            System.out.println("❌ Cuenta no encontrada.");
        }
    }

    // Realizar un depósito en una cuenta
    private static void depositar() {
        System.out.println("\n=== DEPOSITAR ===");
        System.out.print("Número de cuenta: ");
        String numero = scanner.nextLine();
        
        double monto = leerDouble("Monto a depositar: $");
        
        if (banco.depositar(numero, monto)) {
            System.out.println("✓ Depósito realizado exitosamente.");
            Double nuevoSaldo = banco.consultarSaldo(numero);
            System.out.printf("Nuevo saldo: $%.2f\n", nuevoSaldo);
        } else {
            System.out.println("❌ Error al depositar. Verifique los datos.");
        }
    }

    // Retirar dinero de una cuenta
    private static void retirar() {
        System.out.println("\n=== RETIRAR ===");
        System.out.print("Número de cuenta: ");
        String numero = scanner.nextLine();
        
        double monto = leerDouble("Monto a retirar: $");
        
        if (banco.retirar(numero, monto)) {
            System.out.println("✓ Retiro realizado exitosamente.");
            Double nuevoSaldo = banco.consultarSaldo(numero);
            System.out.printf("Nuevo saldo: $%.2f\n", nuevoSaldo);
        } else {
            System.out.println("❌ Error: Fondos insuficientes o cuenta no encontrada.");
        }
    }

    // Transferir dinero entre dos cuentas
    private static void transferir() {
        System.out.println("\n=== TRANSFERIR ===");

        System.out.print("Cuenta origen: ");
        String origen = scanner.nextLine();
        
        System.out.print("Cuenta destino: ");
        String destino = scanner.nextLine();
        
        double monto = leerDouble("Monto a transferir: $");
        
        if (banco.transferir(origen, destino, monto)) {
            System.out.println("✓ Transferencia realizada exitosamente.");
        } else {
            System.out.println("❌ Error: Fondos insuficientes o cuentas no válidas.");
        }
    }

    // Ordenar las cuentas por saldo usando distintos algoritmos
    private static void ordenarCuentas() {
        System.out.println("\n=== ORDENAR CUENTAS ===");
        System.out.println("1. Merge Sort");
        System.out.println("2. Quick Sort");// Mostrar opciones de algoritmos de ordenamiento.
                                            // Merge Sort y Quick Sort son dos formas distintas de ordenar las cuentas por saldo.
                                            // Los muestro aquí para que el usuario elija cuál quiere usar.

        int opcion = leerEntero("Seleccione algoritmo: ");
        
        if (opcion == 1) {
            banco.ordenarPorSaldoMergeSort();
            System.out.println("✓ Cuentas ordenadas con Merge Sort.");
        } else if (opcion == 2) {
            banco.ordenarPorSaldoQuickSort();
            System.out.println("✓ Cuentas ordenadas con Quick Sort.");
        } else {
            System.out.println("❌ Opción no válida.");
            return;
        }
        
        banco.mostrarCuentas(); // Mostrar resultado del ordenamiento
    }

    // Buscar una cuenta por saldo mediante búsqueda binaria
    private static void buscarPorSaldo() {
        System.out.println("\n=== BÚSQUEDA BINARIA POR SALDO ===");
        System.out.println("⚠ La lista debe estar ordenada primero.");
        
        double saldo = leerDouble("Ingrese el saldo a buscar: $");
        
        Cuenta encontrada = banco.busquedaBinariaPorSaldo(saldo);
        
        if (encontrada != null) {
            System.out.println("✓ Cuenta encontrada:");
            System.out.println(encontrada);
        } else {
            System.out.println("❌ No se encontró una cuenta con ese saldo.");
        }
    }

    // Guardar todas las cuentas en archivo
    private static void guardarDatos() {
        if (banco.guardarEnArchivo()) {
            System.out.println("✓ Datos guardados exitosamente.");
        } else {
            System.out.println("❌ Error al guardar los datos.");
        }
    }

    // Leer enteros con validación
    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        
        while (!scanner.hasNextInt()) {
            System.out.print("❌ Ingrese un número válido: ");
            scanner.next();
        }
        
        int valor = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        return valor;
    }

    // Leer números decimales con validación
    private static double leerDouble(String mensaje) {
        System.out.print(mensaje);
        
        while (!scanner.hasNextDouble()) {
            System.out.print("❌ Ingrese un número válido: ");
            scanner.next();
        }
        
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer
        return valor;
    }

    // Simulación de limpieza de pantalla
    private static void limpiarPantalla() {
        // Se imprimen líneas vacías para simular una "pantalla limpia"
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
