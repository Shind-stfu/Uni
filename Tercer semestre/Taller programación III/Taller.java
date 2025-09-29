import java.util.*;

public class Taller {

    // Punto 1: función que resta votos negativos a positivos
    public static int getVoteCount(int upvotes, int downvotes) {
        return upvotes - downvotes; // simplemente hago la resta
    }

    // Punto 2: comparo si dos sándwiches tienen el mismo pan al inicio y al final
    public static boolean hasSameBread(String[] sandwich1, String[] sandwich2) {
        return sandwich1[0].equals(sandwich2[0]) && // comparo primer pan
               sandwich1[sandwich1.length - 1].equals(sandwich2[sandwich2.length - 1]); // y el último
    }

    // Punto 3: reviso si la raíz cuadrada del primero es igual a la raíz cúbica del segundo
    public static boolean checkSquareAndCube(int[] arr) {
        double raizCuadrada = Math.sqrt(arr[0]); // Math.sqrt() saca la raíz cuadrada
        double raizCubica = Math.cbrt(arr[1]);   // Math.cbrt() saca la raíz cúbica (ejemplo: raíz cúbica de 8 = 2)
        // acá comparo si son iguales, o sea si el primer número al sacar raíz cuadrada
        // es lo mismo que el segundo al sacar raíz cúbica
        return raizCuadrada == raizCubica;
    }

    // Punto 4: formateo un número de 10 dígitos a estilo
    public static String formatPhoneNumber(int[] numbers) {
        // concateno los dígitos por grupos
        String area = "" + numbers[0] + numbers[1] + numbers[2];  // primeros 3 dígitos (código área)
        String first = "" + numbers[3] + numbers[4] + numbers[5]; // siguientes 3
        String second = "" + numbers[6] + numbers[7] + numbers[8] + numbers[9]; // últimos 4
        return "(" + area + ") " + first + "-" + second; // lo devuelvo formateado
    }

    // Punto 5: busco el segundo número más grande en un arreglo
    public static int secondLargest(int[] numbers) {
        int max = numbers[0]; // el mayor hasta ahora
        int secondMax = Integer.MIN_VALUE; // valor muy pequeño como inicial

        for (int n : numbers) {
            if (n > max) { // si encuentro un número más grande que el actual mayor
                secondMax = max; // el anterior mayor se vuelve el segundo
                max = n;         // actualizo el mayor
            } else if (n > secondMax && n < max) { 
                // si está entre el mayor y el segundo mayor, lo actualizo
                secondMax = n;
            }
        }
        return secondMax;
    }

    // Punto 6: creo un "nombre secreto" con la primera letra de cada palabra, en mayúscula
    public static String societyName(String[] names) {
        Arrays.sort(names); // Arrays.sort ordena alfabéticamente
        String result = "";
        for (int i = 0; i < names.length; i++) {
            result += names[i].charAt(0); // charAt(0) devuelve la primera letra de cada nombre
        }
        return result.toUpperCase(); // lo paso todo a mayúsculas
    }

    // Punto 7: me fijo qué palabras tienen exactamente 4 letras
    public static ArrayList<String> isFourLetters(String[] words) {
        ArrayList<String> result = new ArrayList<>(); // uso ArrayList para guardar las que cumplen
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 4) { // length() devuelve la cantidad de letras de la palabra
                result.add(words[i]); // si tiene 4, la agrego a la lista
            }
        }
        return result;
    }

    // Punto 8: suma números pares e impares y devuelve la diferencia absoluta
    public static int warOfNumbers(int[] numbers) {
        int pares = 0, impares = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) { // % 2 == 0 significa que es par
                pares += numbers[i];
            } else { // si no, es impar
                impares += numbers[i];
            }
        }
        return Math.abs(pares - impares); 
        // Math.abs() devuelve el valor absoluto, para que no quede negativo
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner para leer del teclado

        System.out.println("Taller de Arreglos en Java");
        System.out.println("Elige el punto a ejecutar (1 - 8): ");
        int opcion = sc.nextInt(); // leo lo que el usuario quiere probar

        switch (opcion) {
            case 1:
                System.out.println("Punto 1:");
                System.out.println(getVoteCount(13, 0));     
                System.out.println(getVoteCount(2, 33));    
                System.out.println(getVoteCount(132, 132)); 
                break;

            case 2:
                System.out.println("Punto 2:");
                // ejemplos de sandwiches para comparar
                String[] s1 = {"pan blanco", "lechuga", "pan blanco"};
                String[] s2 = {"pan blanco", "tomate", "pan blanco"};
                String[] s3 = {"pan integral", "pollo", "pan integral"};
                String[] s4 = {"pan blanco", "pollo", "pan blanco"};
                System.out.println(hasSameBread(s1, s2)); 
                System.out.println(hasSameBread(s3, s4)); 
                break;

            case 3:
                System.out.println("Punto 3:");
                // ejemplos con raíz cuadrada y cúbica
                System.out.println(checkSquareAndCube(new int[]{4, 8}));   // √4=2 y ∛8=2 → true
                System.out.println(checkSquareAndCube(new int[]{16, 48})); // √16=4 y ∛48≈3.6 → false
                System.out.println(checkSquareAndCube(new int[]{9, 27}));  // √9=3 y ∛27=3 → true
                break;

            case 4:
                System.out.println("Punto 4:");
                System.out.println(formatPhoneNumber(new int[]{1,2,3,4,5,6,7,8,9,0})); 
                System.out.println(formatPhoneNumber(new int[]{5,1,9,5,5,5,4,4,6,8})); 
                break;

            case 5:
                System.out.println("Punto 5:");
                System.out.println(secondLargest(new int[]{10, 40, 30, 20, 50})); 
                System.out.println(secondLargest(new int[]{25, 143, 89, 13, 105})); 
                System.out.println(secondLargest(new int[]{54, 23, 11, 17, 10})); 
                break;

            case 6:
                System.out.println("Punto 6:");
                System.out.println(societyName(new String[]{"Adam", "Sarah", "Malcolm"})); 
                System.out.println(societyName(new String[]{"Harry", "Newt", "Luna", "Cho"})); 
                break;

            case 7:
                System.out.println("Punto 7:");
                System.out.println(isFourLetters(new String[]{"Tomate", "Papa", "Parl"})); 
                System.out.println(isFourLetters(new String[]{"Canguro", "Oso", "Zorro"})); 
                break;

            case 8:
                System.out.println("Punto 8:");
                System.out.println(warOfNumbers(new int[]{2, 8, 7, 5}));   
                System.out.println(warOfNumbers(new int[]{12, 90, 75}));   
                System.out.println(warOfNumbers(new int[]{5,9,45,6,2,7,34,8,6,90,5,243})); 
                break;

            default:
                System.out.println("Opción inválida.");
        }

        sc.close(); // cierro el scanner
    }
}
