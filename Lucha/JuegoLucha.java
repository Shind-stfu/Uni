import java.util.Scanner;

// Esta clase controla la pelea entre dos personajes seleccionados.
public class JuegoLucha {
    private Personaje luchador1;
    private Personaje luchador2;

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        Personaje[] personajes = {
            new Scorpion(), new SubZero(), new LiuKang(), new Kitana(), new Raiden(),
            new Sonya(), new Kano(), new Jax(), new Mileena(), new KungLao()
        };

        System.out.println("Personajes disponibles:");
        for (int i = 0; i < personajes.length; i++) {
            System.out.println(i + 1 + ". " + personajes[i].getNombre());
        }

        System.out.print("Selecciona el número del primer luchador: ");
        int opcion1 = scanner.nextInt() - 1;

        System.out.print("Selecciona el número del segundo luchador: ");
        int opcion2 = scanner.nextInt() - 1;

        luchador1 = personajes[opcion1];
        luchador2 = personajes[opcion2];

        System.out.println("\n¡Comienza la pelea entre " + luchador1.getNombre() + " y " + luchador2.getNombre() + "!");

        while (luchador1.estaVivo() && luchador2.estaVivo()) {
            turno(luchador1, luchador2);
            if (luchador2.estaVivo()) {
                turno(luchador2, luchador1);
            }
        }

        System.out.println("\nLa pelea ha terminado.");
        if (luchador1.estaVivo()) {
            System.out.println(luchador1.getNombre() + " ha ganado.");
        } else {
            System.out.println(luchador2.getNombre() + " ha ganado.");
        }
    }

    private void turno(Personaje atacante, Personaje defensor) {
        System.out.println("\nTurno de " + atacante.getNombre());
        atacante.atacar(defensor);
        System.out.println(defensor.getNombre() + " tiene " + defensor.getVida() + " puntos de vida restantes.");
    }
}
