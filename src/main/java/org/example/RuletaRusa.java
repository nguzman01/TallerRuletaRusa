package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RuletaRusa {
 // atributos
    private List<Integer> tambor;
    private int bala;
    private int posicionActual;
    private Random random;

    // constructor
    public RuletaRusa() {
        tambor = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            tambor.add(i);
        }
        random = new Random();
        reiniciarJuego();
    }

    // metodo para disparar
    public boolean disparar() {
        boolean resultado = (posicionActual == bala);
        if (resultado) {
            System.out.println("Se disparó la bala y el jugador perdio.");
        } else {
            System.out.println("Disparo fallido el jugador sovrevivio.");
        }
        posicionActual = (posicionActual + 1) % tambor.size();
        return resultado;
    }
    // metodo para reiniciar el juego

    public void reiniciarJuego() {
        bala = random.nextInt(tambor.size());
        posicionActual = 0;
        System.out.println("El juego se reinicia.");
    }
}
