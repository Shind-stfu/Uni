import java.util.Date;

// Clase principal para ejecutar el programa
public class Principal {
    public static void main(String[] args) {
        // Crear fotos
        Foto foto1 = new Foto("foto_vacaciones.jpg");
        Foto foto2 = new Foto("foto_familia.jpg");
        Foto[] fotos = { foto1, foto2 };

        // Crear productos
        Camara camara = new Camara(101, "Canon", "EOS 90D");
        Impresion impresion = new Impresion(202, "Color", fotos);

        // Crear cliente
        Cliente cliente = new Cliente("123456789", "Juan Pérez");

        // Crear pedido
        Producto[] productos = { camara, impresion };
        Pedido pedido = new Pedido(cliente, productos, new Date(), 987654321);

        // Mostrar detalles del pedido
        pedido.mostrarPedido();
    }
}
