import java.util.Scanner;

public class Ejercicios{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario el tamaño del arreglo
        System.out.print("Ingrese el tamaño del arreglo: ");
        int n = scanner.nextInt();

        // Declarar e inicializar el arreglo
        int[] numeros = new int[n];

        // Solicitar al usuario que ingrese los números en el arreglo
        System.out.println("Ingrese " + n + " números:");
        for (int i = 0; i < n; i++) {
            numeros[i] = scanner.nextInt();
        }

        // Calcular la suma de los números en el arreglo
        int suma = 0;
        for (int i = 0; i < n; i++) {
            suma += numeros[i];
        }

        // Mostrar la suma
        System.out.println("La suma de los " + n + " números es: " + suma);
        
        // Cerrar el scanner
        scanner.close();
    }
}
