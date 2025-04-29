// Clase que representa una Cámara, hereda de Producto.
public class Camara extends Producto {
    private String marca;
    private String modelo;

    // Constructor de la clase Camara
    public Camara(int numero, String marca, String modelo) {
        super(numero);
        this.marca = marca;
        this.modelo = modelo;
    }

    // Método para obtener la marca de la cámara
    public String getMarca() {
        return marca;
    }

    // Método para obtener el modelo de la cámara
    public String getModelo() {
        return modelo;
    }

    // Método para mostrar detalles de la cámara
    @Override
    public void mostrarDetalle() {
        System.out.println("Cámara - Número: " + getNumero() + ", Marca: " + marca + ", Modelo: " + modelo);
    }
}
