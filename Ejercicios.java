import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicios {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;

        do {
            System.out.println("\nSelecciona un ejercicio a ejecutar (1-16) o 0 para salir:");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    sumaNumeros();
                    break;
                case 2:
                    netoAPagar();
                    break;
                case 3:
                    sumaParesImpares();
                    break;
                case 4:
                    mayorEdad();
                    break;
                case 5:
                    gastosProductos();
                    break;
                case 6:
                    gananciasAlquileres();
                    break;
                case 7:
                    separarParesImpares();
                    break;
                case 8:
                    mayorMenorFrecuencia();
                    break;
                case 9:
                    contarOcurrencias();
                    break;
                case 10:
                    sumaOpuestos();
                    break;
                case 11:
                    clasificarElementos();
                    break;
                case 12:
                    posicionesValorDado();
                    break;
                case 13:
                    clasificarMayoresMenoresMedia();
                    break;
                case 14:
                    diferenciaSucesivos();
                    break;
                case 15:
                    sueldosPromedio();
                    break;
                case 16:
                    informacionProfesores();
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        } while (option != 0);

        scanner.close(); // Mover el close al final de main
    }

    // 1. Sumar N números
    public static void sumaNumeros() {
        System.out.print("Ingrese la cantidad de números: ");
        int N = scanner.nextInt();
        int suma = 0;

        for (int i = 0; i < N; i++) {
            System.out.print("Ingrese el número " + (i + 1) + ": ");
            suma += scanner.nextInt();
        }
        System.out.println("La suma de los números es: " + suma);
    }

    // 2. Neto a pagar a empleados
    public static void netoAPagar() {
        System.out.print("Ingrese la cantidad de empleados: ");
        int N = scanner.nextInt();
        double[] sueldos = new double[N];
        double[] asignaciones = new double[N];
        double[] deducciones = new double[N];
        double[] neto = new double[N];

        for (int i = 0; i < N; i++) {
            System.out.print("Ingrese el sueldo del empleado " + (i + 1) + ": ");
            sueldos[i] = scanner.nextDouble();
            System.out.print("Ingrese las asignaciones del empleado " + (i + 1) + ": ");
            asignaciones[i] = scanner.nextDouble();
            System.out.print("Ingrese las deducciones del empleado " + (i + 1) + ": ");
            deducciones[i] = scanner.nextDouble();
            neto[i] = sueldos[i] + asignaciones[i] - deducciones[i];
        }

        System.out.println("Neto a pagar a cada empleado:");
        for (double n : neto) {
            System.out.println(n);
        }
    }

    // 3. Sumar números pares e impares
    public static void sumaParesImpares() {
        int[] numeros = new int[10];
        int sumaPares = 0, sumaImpares = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese el número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
            if (numeros[i] % 2 == 0) {
                sumaPares += numeros[i];
            } else {
                sumaImpares += numeros[i];
            }
        }
        System.out.println("Suma de pares: " + sumaPares + ", Suma de impares: " + sumaImpares);
    }

    // 4. Hallar el mayor valor en un arreglo de edades
    public static void mayorEdad() {
        int[] edades = new int[10];
        int mayor = Integer.MIN_VALUE;

        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese la edad de la persona " + (i + 1) + ": ");
            edades[i] = scanner.nextInt();
            if (edades[i] > mayor) {
                mayor = edades[i];
            }
        }
        System.out.println("La mayor edad es: " + mayor);
    }

    // 5. Calcular gastos de productos
    public static void gastosProductos() {
        System.out.print("Ingrese la cantidad de productos: ");
        int N = scanner.nextInt();
        double[] precios = new double[N];
        int[] cantidades = new int[N];
        String[] descripciones = new String[N];
        double[] totales = new double[N];
        double totalGeneral = 0;
        double mayorGasto = Double.MIN_VALUE;
        int indiceMayor = 0;

        for (int i = 0; i < N; i++) {
            System.out.print("Ingrese el precio unitario del producto " + (i + 1) + ": ");
            precios[i] = scanner.nextDouble();
            System.out.print("Ingrese la cantidad comprada del producto " + (i + 1) + ": ");
            cantidades[i] = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            System.out.print("Ingrese la descripción del producto " + (i + 1) + ": ");
            descripciones[i] = scanner.nextLine();
            totales[i] = precios[i] * cantidades[i];
            totalGeneral += totales[i];

            if (totales[i] > mayorGasto) {
                mayorGasto = totales[i];
                indiceMayor = i;
            }
        }

        System.out.println("Total gastado por producto: ");
        for (double total : totales) {
            System.out.println(total);
        }
        System.out.println("Total general: " + totalGeneral);
        System.out.println("Producto con mayor gasto: " + descripciones[indiceMayor] + " con un total de " + mayorGasto);
    }

    // 6. Calcular ganancias de alquileres
    public static void gananciasAlquileres() {
        System.out.print("Ingrese la cantidad de viviendas: ");
        int N = scanner.nextInt();
        double[] alquileres = new double[N];
        double[] porcentajes = new double[N];
        double[] ganancias = new double[N];

        for (int i = 0; i < N; i++) {
            System.out.print("Ingrese el alquiler de la vivienda " + (i + 1) + ": ");
            alquileres[i] = scanner.nextDouble();
            System.out.print("Ingrese el porcentaje de ganancia de la vivienda " + (i + 1) + ": ");
            porcentajes[i] = scanner.nextDouble();
            ganancias[i] = alquileres[i] * (porcentajes[i] / 100);
        }

        System.out.println("Ganancias por vivienda:");
        for (double ganancia : ganancias) {
            System.out.println(ganancia);
        }
    }

    // 7. Separar números pares e impares
    public static void separarParesImpares() {
        int[] A = new int[10];
        ArrayList<Integer> pares = new ArrayList<>();
        ArrayList<Integer> impares = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese el número " + (i + 1) + ": ");
            A[i] = scanner.nextInt();
            if (A[i] % 2 == 0) {
                pares.add(A[i]);
            } else {
                impares.add(A[i]);
            }
        }

        System.out.println("Números pares: " + pares);
        System.out.println("Números impares: " + impares);
    }

    // 8. Mayor, menor y frecuencias
    public static void mayorMenorFrecuencia() {
        int[] numeros = new int[30];
        int mayor = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;
        int frecuenciaMayor = 0;
        int frecuenciaMenor = 0;

        for (int i = 0; i < 30; i++) {
            System.out.print("Ingrese el número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
            if (numeros[i] > mayor) {
                mayor = numeros[i];
                frecuenciaMayor = 1;
            } else if (numeros[i] == mayor) {
                frecuenciaMayor++;
            }

            if (numeros[i] < menor) {
                menor = numeros[i];
                frecuenciaMenor = 1;
            } else if (numeros[i] == menor) {
                frecuenciaMenor++;
            }
        }

        System.out.println("Mayor: " + mayor + ", Frecuencia: " + frecuenciaMayor);
        System.out.println("Menor: " + menor + ", Frecuencia: " + frecuenciaMenor);
    }

    // 9. Contar ocurrencias de un número
    public static void contarOcurrencias() {
        int[] A = new int[10];
        System.out.print("Ingrese el número a buscar: ");
        int x = scanner.nextInt();
        int count = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese el número " + (i + 1) + ": ");
            A[i] = scanner.nextInt();
            if (A[i] == x) {
                count++;
            }
        }

        System.out.println("El número " + x + " se encuentra " + count + " veces en el arreglo.");
    }

    // 10. Crear un arreglo con la suma de opuestos
    public static void sumaOpuestos() {
        int[] A = new int[7];
        int[] B = new int[3]; // Para guardar las sumas de los opuestos

        for (int i = 0; i < 7; i++) {
            System.out.print("Ingrese el número " + (i + 1) + ": ");
            A[i] = scanner.nextInt();
        }

        for (int i = 0; i < 3; i++) {
            B[i] = A[i] + A[6 - i]; // Sumar opuestos
        }

        System.out.println("Arreglo resultante B:");
        for (int b : B) {
            System.out.println(b);
        }
    }

    // 11. Clasificar elementos negativos, cero y positivos
public static void clasificarElementos() {
    int[] A = new int[10]; // Arreglo original para almacenar números
    int[] negativos = new int[10]; // Arreglo para almacenar números negativos
    int[] ceros = new int[10]; // Arreglo para almacenar ceros
    int[] positivos = new int[10]; // Arreglo para almacenar números positivos
    
    // Contadores para los arreglos de clasificación
    int countNegativos = 0;
    int countCeros = 0;
    int countPositivos = 0;

    // Leer los números y clasificarlos
    for (int i = 0; i < 10; i++) {
        System.out.print("Ingrese el número " + (i + 1) + ": ");
        A[i] = scanner.nextInt();
        if (A[i] < 0) {
            negativos[countNegativos++] = A[i]; // Almacena el número y luego incrementa el contador
        } else if (A[i] == 0) {
            ceros[countCeros++] = A[i];
        } else {
            positivos[countPositivos++] = A[i];
        }
    }

    // Imprimir resultados
    System.out.print("Negativos: ");
    for (int i = 0; i < countNegativos; i++) {
        System.out.print(negativos[i] + " ");
    }
    System.out.println();

    System.out.print("Ceros: ");
    for (int i = 0; i < countCeros; i++) {
        System.out.print(ceros[i] + " ");
    }
    System.out.println();

    System.out.print("Positivos: ");
    for (int i = 0; i < countPositivos; i++) {
        System.out.print(positivos[i] + " ");
    }
    System.out.println();
}

    // 12. Posiciones de un valor dado
    public static void posicionesValorDado() {
        int[] A = new int[8];
        ArrayList<Integer> posiciones = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            System.out.print("Ingrese el número " + (i + 1) + ": ");
            A[i] = scanner.nextInt();
        }

        System.out.print("Ingrese el valor a buscar: ");
        int x = scanner.nextInt();

        for (int i = 0; i < 8; i++) {
            if (A[i] == x) {
                posiciones.add(i);
            }
        }

        System.out.println("Posiciones del valor: " + posiciones);
    }

    // 13. Clasificar elementos mayores y menores que la media
    public static void clasificarMayoresMenoresMedia() {
        int[] A = new int[10];
        ArrayList<Integer> mayores = new ArrayList<>();
        ArrayList<Integer> menores = new ArrayList<>();
        int suma = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese el número " + (i + 1) + ": ");
            A[i] = scanner.nextInt();
            suma += A[i];
        }

        double media = suma / 10.0;

        for (int num : A) {
            if (num > media) {
                mayores.add(num);
            } else if (num < media) {
                menores.add(num);
            }
        }

        System.out.println("Mayores que la media: " + mayores);
        System.out.println("Menores que la media: " + menores);
    }

    // 14. Diferencia de elementos sucesivos
    public static void diferenciaSucesivos() {
        int[] A = new int[8];
        int[] B = new int[7]; // Para guardar las diferencias

        for (int i = 0; i < 8; i++) {
            System.out.print("Ingrese el número " + (i + 1) + ": ");
            A[i] = scanner.nextInt();
        }

        for (int i = 1; i < 8; i++) {
            B[i - 1] = A[i] - A[i - 1]; // Diferencia
        }

        System.out.println("Diferencias sucesivas:");
        for (int b : B) {
            System.out.println(b);
        }
    }

    // 15. Sueldo promedio
    public static void sueldosPromedio() {
        System.out.print("Ingrese la cantidad de trabajadores: ");
        int N = scanner.nextInt();
        String[] nombres = new String[N];
        double[] sueldos = new double[N];
        double sumaSueldos = 0;

        for (int i = 0; i < N; i++) {
            System.out.print("Ingrese el nombre del trabajador " + (i + 1) + ": ");
            nombres[i] = scanner.next();
            System.out.print("Ingrese el sueldo del trabajador " + (i + 1) + ": ");
            sueldos[i] = scanner.nextDouble();
            sumaSueldos += sueldos[i];
        }

        double sueldoPromedio = sumaSueldos / N;
        System.out.println("Sueldo promedio: " + sueldoPromedio);
        System.out.println("Trabajadores con sueldo promedio:");

        for (int i = 0; i < N; i++) {
            if (sueldos[i] == sueldoPromedio) {
                System.out.println(nombres[i]);
            }
        }
    }

    // 16. Información de profesores
    public static void informacionProfesores() {
        System.out.print("Ingrese la cantidad de profesores: ");
        int N = scanner.nextInt();
        String[] nombres = new String[N];
        int[] edades = new int[N];
        String[] sexos = new String[N];
        double sumaEdades = 0;

        for (int i = 0; i < N; i++) {
            System.out.print("Ingrese el nombre del profesor " + (i + 1) + ": ");
            nombres[i] = scanner.next();
            System.out.print("Ingrese la edad del profesor " + (i + 1) + ": ");
            edades[i] = scanner.nextInt();
            System.out.print("Ingrese el sexo del profesor " + (i + 1) + " (M/F): ");
            sexos[i] = scanner.next();
            sumaEdades += edades[i];
        }

        double edadPromedio = sumaEdades / N;
        String profesorMasJoven = nombres[0];
        String profesorMasViejo = nombres[0];

        for (int i = 1; i < N; i++) {
            if (edades[i] < edades[nombres[0].equals(profesorMasJoven) ? 0 : i]) {
                profesorMasJoven = nombres[i];
            }
            if (edades[i] > edades[nombres[0].equals(profesorMasViejo) ? 0 : i]) {
                profesorMasViejo = nombres[i];
            }
        }

        int profesorasMayorPromedio = 0;
        int profesoresMenorPromedio = 0;

        for (int i = 0; i < N; i++) {
            if (sexos[i].equalsIgnoreCase("F") && edades[i] > edadPromedio) {
                profesorasMayorPromedio++;
            }
            if (sexos[i].equalsIgnoreCase("M") && edades[i] < edadPromedio) {
                profesoresMenorPromedio++;
            }
        }

        System.out.println("Edad promedio: " + edadPromedio);
        System.out.println("Nombre del profesor más joven: " + profesorMasJoven);
        System.out.println("Nombre del profesor con mayor edad: " + profesorMasViejo);
        System.out.println("Número de profesoras con edad mayor al promedio: " + profesorasMayorPromedio);
        System.out.println("Número de profesores con edad menor al promedio: " + profesoresMenorPromedio);
    }
}
