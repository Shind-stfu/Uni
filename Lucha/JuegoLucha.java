// Esta clase controla todo el flujo de la pelea entre dos personajes.
public class JuegoLucha {
    private Personaje jugador1;
    private Personaje jugador2;

    // Cuando creas una pelea, debes indicar los nombres de los dos jugadores.
    public JuegoLucha(String nombre1, String nombre2) {
        this.jugador1 = new Personaje(nombre1);
        this.jugador2 = new Personaje(nombre2);
    }

    // Este método inicia la pelea y va alternando los turnos hasta que uno pierda.
    public void iniciarPelea() {
        System.out.println("¡Que comience la pelea entre " + jugador1.getNombre() + " y " + jugador2.getNombre() + "!");
        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            // Turno del primer luchador
            turno(jugador1, jugador2);
            // Si ambos siguen vivos, le toca al segundo
            if (jugador2.estaVivo()) {
                turno(jugador2, jugador1);
            }
        }

        // Anunciamos quién ganó
        if (jugador1.estaVivo()) {
            System.out.println(jugador1.getNombre() + " ha ganado la pelea, ¡felicidades!");
        } else {
            System.out.println(jugador2.getNombre() + " ha ganado la pelea, ¡bien hecho!");
        }
    }

    // Este método maneja un turno de ataque entre dos personajes.
    private void turno(Personaje atacante, Personaje defensor) {
        System.out.println("Es el turno de " + atacante.getNombre() + ". " +
                           defensor.getNombre() + " tiene " + defensor.getPuntosDeVida() + " puntos de vida.");
        atacante.atacar(defensor);
        System.out.println(defensor.getNombre() + " ahora tiene " + defensor.getPuntosDeVida() + " puntos de vida.\n");
    }
}
