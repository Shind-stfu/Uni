import java.util.Random;

// Esta clase representa a un personaje en el juego de lucha.
// Cada personaje tiene un nombre y puntos de vida.
public class Personaje {
    private String nombre;
    private int puntosDeVida;
    private static final int MAX_DANO = 30; // daño máximo que puede causar
    private static final int MIN_DANO = 10; // daño mínimo que puede causar

    // Cuando creas un personaje, debes darle un nombre.
    // La cantidad de puntos de vida empieza en 100.
    public Personaje(String nombre) {
        this.nombre = nombre;
        this.puntosDeVida = 100; // todos empiezan con 100 puntos de vida
    }

    // Este método permite que el personaje ataque a otro.
    // El daño causado será un número aleatorio entre 10 y 30.
    public void atacar(Personaje oponente) {
        Random rand = new Random();
        int dano = rand.nextInt((MAX_DANO - MIN_DANO) + 1) + MIN_DANO; // daño entre 10 y 30
        oponente.recibirDano(dano);
        System.out.println(this.nombre + " ataca a " + oponente.getNombre() + " causando " + dano + " puntos de daño.");
    }

    // Cuando recibe daño, sus puntos de vida se reducen en esa cantidad.
    // Los puntos de vida nunca bajan de cero.
    public void recibirDano(int dano) {
        this.puntosDeVida -= dano;
        if (this.puntosDeVida < 0) {
            this.puntosDeVida = 0; // evitar que tenga puntos negativos
        }
    }

    // Verifica si el personaje todavía está vivo.
    // Es decir, si tiene puntos de vida mayores que cero.
    public boolean estaVivo() {
        return this.puntosDeVida > 0;
    }

    // Nos dice el nombre del personaje.
    public String getNombre() {
        return this.nombre;
    }

    // Nos dice cuántos puntos de vida tiene ahora.
    public int getPuntosDeVida() {
        return this.puntosDeVida;
    }
}
