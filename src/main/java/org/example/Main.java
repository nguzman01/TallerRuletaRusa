package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("JUEGO DE LA RULETA RUSA: ");
        System.out.print("Cuantas personas van a jugar): ");
        int numJugadores = Integer.parseInt(scanner.nextLine()); //  el usuario ingrese el número de jugadores

        // almacenar los nombres de los jugadores
        String[] nombresJugadores = new String[numJugadores];

        // Aqui  se piden los nombres de los jugadores
        for (int i = 0; i < numJugadores; i++) {
            System.out.print("Indique el nombre del Jugador " + (i + 1) + ": ");
            nombresJugadores[i] = scanner.nextLine();
        }

        int jugadorActual = 0; // indica el jugador actual
        RuletaRusa ruleta = new RuletaRusa(); // crea una instancia

        while (true) {
            // Mostrar el menú de la ruleta
            System.out.println("Menú:");
            System.out.println("1. Jugar");
            System.out.println("2. Salir");
            System.out.print("Selecciona una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    // aqui se iniciar el juego
                    while (true) {
                        System.out.println("Turno de " + nombresJugadores[jugadorActual] + ":");
                        System.out.println("Presiona 'd' para disparar o 's' para que el jugador salaga del juego:");
                        String input = scanner.nextLine();

                        if (input.equalsIgnoreCase("d")) {
                            if (ruleta.disparar()) {
                                System.out.println(nombresJugadores[jugadorActual] + " ha perdido.");
                                break;
                            }
                            jugadorActual = (jugadorActual + 1) % numJugadores; // se cambia al siguiente jugador
                        } else if (input.equalsIgnoreCase("s")) {
                            System.out.println(nombresJugadores[jugadorActual] + " salido del juego.");
                            break;
                        } else {
                            System.out.println("Entrada no válida. Vuelva a intentarlo.");
                        }
                    }
                    break;

                case "2": // se sale del juego
                    System.out.println("Saliendo de todo el juego.");
                    scanner.close();
                    return; // se termina el programa

                default:
                    System.out.println("Opción no válida. Vuelva a intentarlo.");
                    break;
            }
        }
    }
}
