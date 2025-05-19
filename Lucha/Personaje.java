public abstract class Personaje {
    protected String nombre;
    protected int puntosDeVida;
    protected double multiplicadorDano;

    public Personaje(String nombre, int vida, double multiplicadorDano) {
        this.nombre = nombre;
        this.puntosDeVida = vida;
        this.multiplicadorDano = multiplicadorDano;
    }

    public void atacar(Personaje oponente) {
        int danoBase = (int)(Math.random() * 21) + 10; // daño entre 10 y 30
        int danoFinal = (int)(danoBase * multiplicadorDano);
        oponente.recibirDano(danoFinal);
        System.out.println(this.nombre + " ataca a " + oponente.getNombre() + " causando " + danoFinal + " puntos de daño.");
    }

    public void recibirDano(int dano) {
        this.puntosDeVida -= dano;
        if (this.puntosDeVida < 0) {
            this.puntosDeVida = 0;
        }
    }

    public boolean estaVivo() {
        return this.puntosDeVida > 0;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPuntosDeVida() {
        return this.puntosDeVida;
    }
}
