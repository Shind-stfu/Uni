// Clase que representa un Cliente.
public class Cliente {
    private String cedula;
    private String nombre;

    // Constructor de la clase Cliente
    public Cliente(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    // Método para obtener la cédula del cliente
    public String getCedula() {
        return cedula;
    }

    // Método para obtener el nombre del cliente
    public String getNombre() {
        return nombre;
    }
}
