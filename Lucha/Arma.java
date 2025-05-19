// Esta clase representa un arma con nombre y daño base.
public class Arma {
    protected String nombre;
    protected int danoBase;

    public Arma(String nombre, int danoBase) {
        this.nombre = nombre;
        this.danoBase = danoBase;
    }

    // Calcula el daño total (5% más del daño base)
    public int calcularDano() {
        return (int)(danoBase * 1.05);
    }

    public String getNombre() {
        return nombre;
    }
}
