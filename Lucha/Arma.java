import java.util.Random;

public abstract class Arma {
    protected String nombre;
    protected int danoBase;

    public Arma(String nombre, int danoBase) {
        this.nombre = nombre;
        this.danoBase = danoBase;
    }

    public int calcularDano() {
        Random rand = new Random();
        return (int) ((rand.nextInt(11) + danoBase) * 1.05); // aumento del 5%
    }

    public String getNombre() {
        return nombre;
    }
}
