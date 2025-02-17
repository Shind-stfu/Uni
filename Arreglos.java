public class Arreglos {
    public static void main(String[] args) {
        // El número hace referencia al tamaño del arreglo

        // Declaramos y llenamos el arreglo
        int[] a = {8, 3, 10, 22, 1, 9};

        // Recorremos el arreglo e imprimimos sus elementos
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }
    }
}
