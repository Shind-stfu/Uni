// Esta clase representa un arma que puede ser usada por un personaje para atacar.
public class Arma {
    protected String nombre;    // Nombre del arma 
    protected int danoBase;     // Daño base que causa el arma

    // Constructor para inicializar el nombre y el daño base del arma
    public Arma(String nombre, int danoBase) {
        this.nombre = nombre;
        this.danoBase = danoBase;
    }

    // Método que calcula el daño total que inflige el arma
    // En este caso, se aumenta un 5% al daño base como bonificación
    public int calcularDano() {
        return (int)(danoBase * 1.05); // Se convierte a entero porque el resultado puede ser decimal
    }

    // Método para obtener el nombre del arma
    public String getNombre() {
        return nombre;
    }
}
