import java.util.Random;
import java.util.Scanner;

// Clase base Personaje
class Personaje {
    protected String nombre;
    protected int puntosDeVida;
    protected final int MAX_DANO = 25; // Cambio en daño máximo
    protected final int MIN_DANO = 8;  // Cambio en daño mínimo

    public Personaje(String nombre) {
        this.nombre = nombre;
        this.puntosDeVida = 100; // Puntos de vida inicial
    }

    // Método para atacar a un oponente
    public void atacar(Personaje oponente) {
        Random rand = new Random();
        int dano = rand.nextInt((MAX_DANO - MIN_DANO) + 1) + MIN_DANO; // Daño entre 8 y 25
        oponente.recibirDano(dano);
        System.out.println(this.nombre + " ataca a " + oponente.getNombre() + " causando " + dano + " puntos de daño.");
    }

    // Método para recibir daño
    public void recibirDano(int dano) {
        this.puntosDeVida -= dano;
        if (this.puntosDeVida < 0) {
            this.puntosDeVida = 0;
        }
    }

    // Verifica si el personaje está vivo
    public boolean estaVivo() {
        return this.puntosDeVida > 0;
    }

    // Obtener nombre
    public String getNombre() {
        return this.nombre;
    }

    // Obtener puntos de vida
    public int getPuntosDeVida() {
        return this.puntosDeVida;
    }
}

// Clase que puede extenderse para personajes especiales
class PersonajeEspecial extends Personaje {
    public PersonajeEspecial(String nombre) {
        super(nombre);
        // Puedes agregar atributos o métodos adicionales aquí
    }

    // Puedes sobrescribir métodos si deseas comportamientos diferentes
}

// Clase que controla la pelea
class JuegoLucha {
    private Personaje jugador1;
    private Personaje jugador2;

    public JuegoLucha(String nombre1, String nombre2) {
        this.jugador1 = new Personaje(nombre1);
        this.jugador2 = new Personaje(nombre2);
    }

    public void iniciarPelea() {
        System.out.println("La pelea comienza entre " + jugador1.getNombre() + " y " + jugador2.getNombre() + "...\n");
        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            turno(jugador1, jugador2);
            if (jugador2.estaVivo()) {
                turno(jugador2, jugador1);
            }
        }

        // Determinar ganador
        if (jugador1.estaVivo()) {
            System.out.println("\n" + jugador1.getNombre() + " ha ganado la pelea.");
        } else {
            System.out.println("\n" + jugador2.getNombre() + " ha ganado la pelea.");
        }
    }

    // Método que simula un turno de ataque
    private void turno(Personaje atacante, Personaje defensor) {
        System.out.println("Turno de " + atacante.getNombre() + ". Puntos de vida de " + defensor.getNombre() + ": " + defensor.getPuntosDeVida());
        atacante.atacar(defensor);
        System.out.println(defensor.getNombre() + " ahora tiene " + defensor.getPuntosDeVida() + " puntos de vida.\n");
    }
}

// Clase principal para ejecutar el juego
public class JuegoDeLucha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre del jugador 1: ");
        String nombre1 = scanner.nextLine();
        System.out.print("Introduce el nombre del jugador 2: ");
        String nombre2 = scanner.nextLine();

        JuegoLucha juego = new JuegoLucha(nombre1, nombre2);
        juego.iniciarPelea();

        scanner.close();
    }
}