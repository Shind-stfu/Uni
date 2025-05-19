// Clase base para todos los personajes.
public abstract class Personaje {
    protected String nombre;
    protected int vida;
    protected Arma arma;

    public Personaje(String nombre, int vida, Arma arma) {
        this.nombre = nombre;
        this.vida = vida;
        this.arma = arma;
    }

    // Ataca a otro personaje con el arma asignada.
    public void atacar(Personaje oponente) {
        int dano = arma.calcularDano();
        oponente.recibirDano(dano);
        System.out.println(nombre + " ataca con " + arma.getNombre() + " y causa " + dano + " puntos de daño a " + oponente.getNombre());
    }

    // Recibe daño y reduce la vida.
    public void recibirDano(int dano) {
        vida -= dano;
        if (vida < 0) vida = 0;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }
}
