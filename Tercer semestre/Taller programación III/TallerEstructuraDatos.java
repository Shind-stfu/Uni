import java.util.*;

public class TallerEstructuraDatos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner para leer la opción del usuario
        int opcion; // Variable que almacena la opción del menú

        // Bucle principal del programa: se repite hasta que el usuario elija la opción 9 (Salir)
        do {
            // Mostramos el menú con todas las opciones
            System.out.println("\n=== MENÚ DE EJERCICIOS ===");
            System.out.println("1. Votos a favor vs en contra");
            System.out.println("2. Pan similar");
            System.out.println("3. Cuadrados y cubos");
            System.out.println("4. Formato de número telefónico");
            System.out.println("5. Segundo número más grande");
            System.out.println("6. Sociedad secreta");
            System.out.println("7. Palabras de cuatro letras");
            System.out.println("8. Guerra de números");
            System.out.println("9. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt(); // Guardamos lo que escribe el usuario

            // Según la opción elegida, entramos en el "case" correspondiente
            switch (opcion) {
                case 1:
                    System.out.println("\n--- Punto 1 ---");
                    // Calculamos diferencia entre positivos y negativos
                    System.out.println("Resultado: " + getVoteCount(20, 5));   // ➝ 15
                    System.out.println("Resultado: " + getVoteCount(7, 18));  // ➝ -11
                    break;

                case 2:
                    System.out.println("\n--- Punto 2 ---");
                    // Comparamos dos sándwiches: deben tener el mismo pan al inicio y al final
                    System.out.println("Resultado: " + hasSameBread(
                        new String[]{"pan integral","queso","pan integral"},
                        new String[]{"pan integral","pollo","pan integral"}
                    ));
                    break;

                case 3:
                    System.out.println("\n--- Punto 3 ---");
                    // Revisamos si un número es el cuadrado y el otro el cubo
                    System.out.println("Resultado: " + checkSquareAndCube(new int[]{9, 27})); 
                    System.out.println("Resultado: " + checkSquareAndCube(new int[]{25, 64}));
                    break;

                case 4:
                    System.out.println("\n--- Punto 4 ---");
                    // Convertimos un arreglo de 10 números a formato telefónico
                    System.out.println("Resultado: " + formatPhoneNumber(
                        new int[]{9,8,7,6,5,4,3,2,1,0}
                    ));
                    break;

                case 5:
                    System.out.println("\n--- Punto 5 ---");
                    // Buscamos el segundo número más grande en el arreglo
                    System.out.println("Resultado: " + secondLargest(
                        new int[]{15,45,60,30,90}
                    ));
                    break;

                case 6:
                    System.out.println("\n--- Punto 6 ---");
                    // Creamos las iniciales ordenadas de los nombres
                    System.out.println("Resultado: " + societyName(
                        new String[]{"Laura","Miguel","Andres"}
                    ));
                    break;

                case 7:
                    System.out.println("\n--- Punto 7 ---");
                    // Filtramos solo palabras de 4 letras
                    System.out.println("Resultado: " + isFourLetters(
                        new String[]{"Luna","Sol","Cielo","Mar"}
                    ));
                    break;

                case 8:
                    System.out.println("\n--- Punto 8 ---");
                    // Restamos la suma de números pares e impares
                    System.out.println("Resultado: " + warOfNumbers(
                        new int[]{12, 5, 9, 20, 7}
                    ));
                    break;

                case 9:
                    System.out.println("\nSaliendo del programa...");
                    break;

                default:
                    System.out.println(" Opción no válida, intenta de nuevo.");
            }

        } while (opcion != 9); // El menú se repite hasta que se elija 9

        sc.close(); // Cerramos el Scanner al terminar
    }

    // FUNCIONES 

    // Punto 1: Diferencia entre votos positivos y negativos usando una COLA
    public static int getVoteCount(int upvotes, int downvotes) {
        Queue<Integer> cola = new LinkedList<>(); // Creamos una cola
        cola.add(upvotes);   // Primero guardamos los votos positivos
        cola.add(downvotes); // Después guardamos los votos negativos

        // poll() saca el primer elemento en entrar (FIFO)
        int positivos = cola.poll(); 
        int negativos = cola.poll(); 

        // La diferencia será el resultado
        return positivos - negativos;
    }

    // Punto 2: Verificar si dos sándwiches tienen el mismo pan en los extremos
    public static boolean hasSameBread(String[] sandwich1, String[] sandwich2) {
        Stack<String> pila1 = new Stack<>();
        Stack<String> pila2 = new Stack<>();

        // Guardamos cada ingrediente en la pila
        for (String item : sandwich1) pila1.push(item);
        for (String item : sandwich2) pila2.push(item);

        // Revisamos el primer pan (posición 0 del arreglo original)
        String primerPan1 = sandwich1[0];
        String primerPan2 = sandwich2[0];

        // Revisamos el último pan (peek en la pila = el último agregado)
        String ultimoPan1 = pila1.peek();
        String ultimoPan2 = pila2.peek();

        // Devuelve true si coinciden el primer pan y el último pan
        return primerPan1.equals(primerPan2) && ultimoPan1.equals(ultimoPan2);
    }

    // Punto 3: Comprobar si raíz cuadrada del primer número
    // es igual a raíz cúbica del segundo
    public static boolean checkSquareAndCube(int[] numeros) {
        Queue<Integer> cola = new LinkedList<>();
        for (int n : numeros) cola.add(n); // guardamos ambos números en la cola

        int num1 = cola.poll(); // primer número
        int num2 = cola.poll(); // segundo número

        // Calculamos raíz cuadrada y cúbica
        double raizCuadrada = Math.sqrt(num1);
        double raizCubica = Math.cbrt(num2);

        // Solo será true si son iguales
        return raizCuadrada == raizCubica;
    }

    // Punto 4: Convertir arreglo de 10 dígitos a un formato telefónico
    public static String formatPhoneNumber(int[] digits) {
        Queue<Integer> cola = new LinkedList<>();
        for (int d : digits) cola.add(d); // Guardamos cada dígito en la cola

        StringBuilder sb = new StringBuilder(); // String dinámico para formar el número
        sb.append("(");
        for (int i = 0; i < 3; i++) sb.append(cola.poll()); // Los 3 primeros dígitos
        sb.append(") ");
        for (int i = 0; i < 3; i++) sb.append(cola.poll()); // Los siguientes 3
        sb.append("-");
        for (int i = 0; i < 4; i++) sb.append(cola.poll()); // Los últimos 4

        return sb.toString(); // Devolvemos el número en formato XXX XXX-XXXX
    }

    // Punto 5: Encontrar el segundo número más grande usando una PILA
    public static int secondLargest(int[] numeros) {
        Stack<Integer> pila = new Stack<>();
        for (int n : numeros) pila.push(n); // Guardamos todos los números en la pila

        int mayor = Integer.MIN_VALUE;   // valor más grande
        int segundo = Integer.MIN_VALUE; // segundo más grande

        // Recorremos todos los elementos de la pila
        while (!pila.isEmpty()) {
            int actual = pila.pop(); // Sacamos un número
            if (actual > mayor) { // Si es mayor que el mayor actual
                segundo = mayor;   // el anterior mayor pasa a ser el segundo
                mayor = actual;    // actual pasa a ser el mayor
            } else if (actual > segundo && actual < mayor) {
                segundo = actual; // si está entre medio se convierte en segundo
            }
        }
        return segundo;
    }

    // Punto 6: Crear el nombre de la sociedad secreta con iniciales ordenadas
    public static String societyName(String[] nombres) {
        Queue<Character> cola = new LinkedList<>();
        for (String n : nombres) {
            cola.add(n.charAt(0)); // tomamos la primera letra de cada nombre
        }

        List<Character> letras = new ArrayList<>(cola); // pasamos las letras a lista
        Collections.sort(letras); // ordenamos alfabéticamente

        StringBuilder sb = new StringBuilder();
        for (char c : letras) sb.append(Character.toUpperCase(c)); // concatenamos mayúsculas
        return sb.toString();
    }

    // Punto 7: Filtrar las palabras de exactamente 4 letras
    public static List<String> isFourLetters(String[] palabras) {
        Stack<String> pila = new Stack<>();
        for (String p : palabras) pila.push(p); // guardamos todas las palabras

        List<String> resultado = new ArrayList<>();

        while (!pila.isEmpty()) {
            String actual = pila.pop(); // sacamos una palabra
            if (actual.length() == 4) { // si tiene 4 letras la guardamos
                resultado.add(0, actual); // se añade al inicio para mantener el orden
            }
        }
        return resultado; // devolvemos todas las palabras encontradas
    }

    // Punto 8: Guerra de números
    // Calcula diferencia absoluta entre suma de pares e impares
    public static int warOfNumbers(int[] numeros) {
        Queue<Integer> cola = new LinkedList<>();
        for (int n : numeros) cola.add(n); // guardamos todos en la cola

        int sumaPares = 0;
        int sumaImpares = 0;

        while (!cola.isEmpty()) {
            int actual = cola.poll(); // sacamos el número
            if (actual % 2 == 0) sumaPares += actual; // si es par sumamos en pares
            else sumaImpares += actual;              // si es impar sumamos en impares
        }

        return Math.abs(sumaPares - sumaImpares); // devolvemos la diferencia positiva
    }
}
