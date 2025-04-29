// Clase abstracta que representa un producto genérico.
public abstract class Producto {
    protected int numero;

    // Constructor de la clase Producto
    public Producto(int numero) {
        this.numero = numero;
    }

    // Método para obtener el número del producto
    public int getNumero() {
        return numero;
    }

    // Método abstracto para mostrar detalles del producto
    public abstract void mostrarDetalle();
}
