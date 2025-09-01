public class Matrices {

    // Método para llenar una matriz con números aleatorios entre 1 y 201
    public int[][] llenarmatriz(int filas, int columnas) {
        int[][] m = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                m[i][j] = (int) (Math.random() * (9-1) + 1); // Genera números entre 1 y 9
            }
        }

        return m;
    }

    // Método para convertir la matriz en una cadena de texto
    public String matrizente(int[][] m) {
        String cad = "";

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) { // Usar m[i].length para columnas
                cad += m[i][j] + " ";
            }
            cad += "\n";
        }

        return cad;
    }
}