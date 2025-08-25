// Clase que representa una Foto.
public class Foto {
    private String fichero;

    // Constructor de la clase Foto
    public Foto(String fichero) {
        this.fichero = fichero;
    }

    // Método para imprimir la foto (simulación)
    public void print() {
        System.out.println("Imprimiendo foto: " + fichero);
    }

    // Método para obtener el nombre del fichero
    public String getFichero() {
        return fichero;
    }
}
