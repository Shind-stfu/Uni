// Clase que representa una Impresión, hereda de Producto. 
// Utiliza composición con la clase Foto.
public class Impresion extends Producto {
    private String color;
    private Foto[] fotos;

    // Constructor de la clase Impresion
    public Impresion(int numero, String color, Foto[] fotos) {
        super(numero);
        this.color = color;
        this.fotos = fotos;
    }

    // Método para mostrar detalles de la impresión
    @Override
    public void mostrarDetalle() {
        System.out.println("Impresión - Número: " + getNumero() + ", Color: " + color);
        System.out.println("Fotos asociadas:");
        if (fotos != null) {
            for (Foto foto : fotos) {
                System.out.println("- " + foto.getFichero());
            }
        }
    }
}
