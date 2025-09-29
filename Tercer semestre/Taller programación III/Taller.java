import java.util.*;

public class Taller {

    // PUNTO 1
    // Votos a favor vs Votos en contra
    // La idea es súper simple: votos positivos - votos negativos.
    public static int getVoteCount(int upvotes, int downvotes) {
        return upvotes - downvotes;
    }

    // PUNTO 2
    // Pan Similar
    // Comparo el primer y último pan de cada sándwich. Si coinciden --> true.
    public static boolean hasSameBread(String[] sandwich1, String[] sandwich2) {
        return sandwich1[0].equals(sandwich2[0]) &&
               sandwich1[sandwich1.length - 1].equals(sandwich2[sandwich2.length - 1]);
    }

    // PUNTO 3
    // Cuadrados y Cubos
    // Pregunta si la raíz cuadrada del primero es igual a la raíz cúbica del segundo.
    public static boolean checkSquareAndCube(int[] arr) {
        return Math.sqrt(arr[0]) == Math.cbrt(arr[1]);
    }

    // PUNTO 4 
    // Formateo de Número Telefónico
    // Toma 10 dígitos y los organiza en el formato: (123) 456-7890
    public static String formatPhoneNumber(int[] numbers) {
        // String.format coloca los números en el orden que le decimos con %d
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d",
                numbers[0], numbers[1], numbers[2],   // código de área (123)
                numbers[3], numbers[4], numbers[5],   // primera parte (456)
                numbers[6], numbers[7], numbers[8], numbers[9]); // segunda parte (7890)
    }

   }