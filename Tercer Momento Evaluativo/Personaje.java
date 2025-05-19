// Clase base para todos los personajes del juego de lucha.
// Es una clase abstracta porque no se deben crear instancias directas de Personaje, 
// sino de sus subclases (como Scorpion, SubZero, etc.).
public abstract class Personaje {
    protected String nombre; // Nombre del personaje
    protected int vida;      // Puntos de vida del personaje
    protected Arma arma;     // Arma con la que el personaje ataca

    // Constructor para inicializar los atributos básicos del personaje
    public Personaje(String nombre, int vida, Arma arma) {
        this.nombre = nombre;
        this.vida = vida;
        this.arma = arma;
    }

    // Método que permite atacar a otro personaje usando el arma asignada
    public void atacar(Personaje oponente) {
        int dano = arma.calcularDano(); // Calcular el daño con el arma del personaje
        oponente.recibirDano(dano); // Aplicar el daño al oponente
        System.out.println(nombre + " ataca con " + arma.getNombre() + 
            " y causa " + dano + " puntos de daño a " + oponente.getNombre());
    }

    // Método que reduce la vida del personaje al recibir daño
    public void recibirDano(int dano) {
        vida -= dano;
        if (vida < 0) vida = 0; // Evitar que la vida sea negativa
    }

    // Verifica si el personaje aún tiene vida
    public boolean estaVivo() {
        return vida > 0;
    }

    // Obtener el nombre del personaje
    public String getNombre() {
        return nombre;
    }

    // Obtener la cantidad de vida actual
    public int getVida() {
        return vida;
    }
}
