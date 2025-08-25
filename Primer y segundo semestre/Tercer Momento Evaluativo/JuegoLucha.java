import java.util.Scanner;

// Esta clase controla la pelea entre dos personajes seleccionados.
public class JuegoLucha {
    private Personaje luchador1; // Primer personaje seleccionado para pelear
    private Personaje luchador2; // Segundo personaje seleccionado para pelear

    // Método principal que inicia la lógica del juego
    public void iniciar() {
        Scanner scanner = new Scanner(System.in); // Objeto para leer la entrada del usuario

        // Arreglo de personajes disponibles en el juego 
        Personaje[] personajes = {
            new Scorpion(), new SubZero(), new LiuKang(), new Kitana(), new Raiden(),
            new Sonya(), new Kano(), new Jax(), new Mileena(), new KungLao()
        };

        // Mostrar lista de personajes disponibles
        System.out.println("Personajes disponibles:");
        for (int i = 0; i < personajes.length; i++) {
            System.out.println((i + 1) + ". " + personajes[i].getNombre()); // Mostrar número y nombre del personaje
        }

        // Pedir al usuario que seleccione al primer luchador, validando la entrada
        int opcion1 = pedirSeleccionValida(scanner, personajes.length, "Selecciona el número del primer luchador: ");

        // Pedir al usuario que seleccione al segundo luchador, validando la entrada
        int opcion2 = pedirSeleccionValida(scanner, personajes.length, "Selecciona el número del segundo luchador: ");

        // Asignar los personajes seleccionados a los luchadores
        luchador1 = personajes[opcion1];
        luchador2 = personajes[opcion2];

        // Anunciar el inicio del combate
        System.out.println("\n¡Comienza la pelea entre " + luchador1.getNombre() + " y " + luchador2.getNombre() + "!");

        // Bucle que continúa mientras ambos luchadores estén vivos
        while (luchador1.estaVivo() && luchador2.estaVivo()) {
            turno(luchador1, luchador2); // El primer luchador ataca al segundo
            if (luchador2.estaVivo()) {
                turno(luchador2, luchador1); // Si el segundo sigue vivo, ataca al primero
            }
        }

        // Mensaje final indicando quién ganó la pelea
        System.out.println("\nLa pelea ha terminado.");
        if (luchador1.estaVivo()) {
            System.out.println(luchador1.getNombre() + " ha ganado.");
        } else {
            System.out.println(luchador2.getNombre() + " ha ganado.");
        }
    }

    // Método que representa un turno de ataque entre dos personajes
    private void turno(Personaje atacante, Personaje defensor) {
        System.out.println("\nTurno de " + atacante.getNombre()); // Mostrar de quién es el turno
        atacante.atacar(defensor); // El atacante ejecuta un ataque sobre el defensor
        // Mostrar la vida restante del defensor después del ataque
        System.out.println(defensor.getNombre() + " tiene " + defensor.getVida() + " puntos de vida restantes.");
    }

    // Método auxiliar para pedir una selección válida del usuario
    private int pedirSeleccionValida(Scanner scanner, int total, String mensaje) {
        int seleccion;
        do {
            System.out.print(mensaje);
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada no válida. Debes ingresar un número.");
                System.out.print(mensaje);
                scanner.next(); // Limpiar entrada inválida
            }
            seleccion = scanner.nextInt();
            if (seleccion < 1 || seleccion > total) {
                System.out.println("Número fuera de rango. Por favor selecciona un número entre 1 y " + total + ".");
            }
        } while (seleccion < 1 || seleccion > total);
        return seleccion - 1; // Restar 1 para convertir a índice de arreglo
    }
}
