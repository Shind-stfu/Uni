import java.util.Date;

// Clase que representa un Pedido, con agregación de Cliente y Productos.
public class Pedido {
    private Cliente cliente;
    private Producto[] productos;
    private Date fecha;
    private int numeroTarjetaCredito;

    // Constructor de la clase Pedido
    public Pedido(Cliente cliente, Producto[] productos, Date fecha, int numeroTarjetaCredito) {
        this.cliente = cliente;
        this.productos = productos;
        this.fecha = fecha;
        this.numeroTarjetaCredito = numeroTarjetaCredito;
    }

    // Método para mostrar detalles del pedido
    public void mostrarPedido() {
        System.out.println("Pedido realizado por: " + cliente.getNombre() + " (Cédula: " + cliente.getCedula() + ")");
        System.out.println("Fecha: " + fecha);
        System.out.println("Productos comprados:");
        for (Producto producto : productos) {
            producto.mostrarDetalle();
        }
        System.out.println("Número de tarjeta de crédito: " + numeroTarjetaCredito);
    }
}
