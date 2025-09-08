// Esta clase representa un casillero (locker) donde se meten los paquetes
public class Casillero {
    private int id;
    private String tamano;
    private Paquete paquete; // si está vacío, esto queda en null

    public Casillero(int id, String tamano) {
        this.id = id;
        this.tamano = tamano.toLowerCase();
        this.paquete = null;
    }

    // Métodos para consultar el casillero
    public int getId() { return id; }
    public String getTamano() { return tamano; }
    public Paquete getPaquete() { return paquete; }

    // Esto sirve para saber si el casillero ya tiene un paquete
    public boolean estaOcupado() {
        return paquete != null;
    }

    // Aquí se intenta meter un paquete al casillero
    // Si ya está ocupado, devuelve false y no deja meter otro (evita solapamientos)
    public boolean asignarPaquete(Paquete p) {
        if (estaOcupado()) return false;
        paquete = p;
        return true;
    }

    // Esto libera el casillero, o sea, lo deja vacío
    public void liberar() {
        paquete = null;
    }

    // Muestra el casillero como un texto cuando lo imprimimos
    @Override
    public String toString() {
        return "Casillero{" +
                "id=" + id +
                ", tamano='" + tamano + '\'' +
                ", ocupado=" + (estaOcupado() ? "sí" : "no") +
                '}';
    }
}
