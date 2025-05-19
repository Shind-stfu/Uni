// Clase base Arma
public abstract class Arma {
    protected String nombre;
    protected double multiplicadorDanio;

    public Arma(String nombre) {
        this.nombre = nombre;
        this.multiplicadorDanio = 1.05; // Aumenta el daño un 5%
    }

    public String getNombre() {
        return nombre;
    }

    // Este método retorna cuánto se multiplica el daño base
    public double obtenerMultiplicadorDanio() {
        return multiplicadorDanio;
    }

    // Método abstracto para mostrar tipo de arma
    public abstract String getTipo();
}




