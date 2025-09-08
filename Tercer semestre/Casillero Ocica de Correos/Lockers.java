// Esta clase maneja todos los casilleros organizados en una matriz
public class Lockers {
    private Casillero[][] matriz;

    public Lockers(int filas, int columnas) {
        matriz = new Casillero[filas][columnas];
        inicializarCasilleros();
    }

    // Aquí se crean los casilleros con tamaños distribuidos
    private void inicializarCasilleros() {
        String[] tamanos = {"pequeño", "mediano", "grande"};
        int id = 1;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                String tamano = tamanos[(i + j) % 3]; // va cambiando el tamaño
                matriz[i][j] = new Casillero(id++, tamano);
            }
        }
    }

    // Intenta asignar un paquete en un casillero libre y que sea del tamaño correcto
    public Casillero asignarPaquete(Paquete p) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                Casillero c = matriz[i][j];
                if (!c.estaOcupado() && esCompatible(c.getTamano(), p.getTamano())) {
                    c.asignarPaquete(p);
                    return c; // aquí ya encontró lugar y lo retorna
                }
            }
        }
        return null; // si llega aquí es porque no había espacio
    }

    // Aquí revisa si el paquete cabe en el casillero
    private boolean esCompatible(String tamCasillero, String tamPaquete) {
        if (tamPaquete.equals("pequeño")) return true; // cabe en todos
        if (tamPaquete.equals("mediano")) return tamCasillero.equals("mediano") || tamCasillero.equals("grande");
        if (tamPaquete.equals("grande")) return tamCasillero.equals("grande");
        return false;
    }

    // Libera un casillero según su id
    public boolean liberarCasillero(int id) {
        Casillero c = buscarCasillero(id);
        if (c != null && c.estaOcupado()) {
            c.liberar();
            return true;
        }
        return false;
    }

    // Busca un casillero por su id
    public Casillero buscarCasillero(int id) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j].getId() == id) return matriz[i][j];
            }
        }
        return null;
    }

    // Muestra todos los casilleros en forma de tabla
    public void mostrarEstado() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " | ");
            }
            System.out.println();
        }
    }
}
