//Clase que representa una Foto.

public class Foto {
    private String fichero; // Nombre del archivo

    public Foto(String fichero) {
        this.fichero = fichero;
    }

    public void print() {
        System.out.println("Imprimiendo foto: " + fichero);
    }

    public String getFichero() {
        return fichero;
    }
}