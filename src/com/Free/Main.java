package com.Free;

import java.util.Random; // I use random because I need it for enemy's hit
import java.util.Scanner; // For input actions

public class Main {
    static Scanner sc = new Scanner(System.in);

    //Starts the game, with te points and elections
    public static void juego() {
        Random random = new Random();
        int casas = 1, accion;
        Heroe heroe = new Heroe(3, 0);
        Villano villano = new Villano(3, 0);

        //This is the game's heart, an infinite loop until someone loses
        while (true) {
            if (heroe.rescatados()) villano.vida--;
            villano.atrapados();

            if (heroe.vida == 0) {
                System.out.println("""
                              /| ________________
                        O|===|* >________________> HAZ PERDIDO
                              \\|    \s""".indent(12));
                break;
            }
            if (villano.vida == 0) {
                System.out.println("""
                              /| ________________
                        O|===|* >________________> ¡HAZ GANADO!
                              \\|    \s""".indent(12));
                break;
            }
            System.out.printf("""
                            _____________________________________________________________________________
                            |Tu estado:                          |                   Estado del enemigo:|
                            |____________________________________|______________________________________|
                            |Vidas: %d, hadas rescatadas: %d       |          hadas atrapadas: %d, vidas: %d|
                            |Casas: %d                            |                       Casas: infinito|
                            |____________________________________|______________________________________|
                    """, heroe.vida, heroe.rescatados, villano.atrapado, villano.vida, casas);

            //player's actions
            System.out.println("¡Tu turno!:\n1)construir casas\n2)rescatar hada\n3)Huir\n >>> ");
            try {
                accion = sc.nextInt();
            } catch (Exception ignored) {
                System.out.println("Ese poder sólo está en la mano de ancianos ancestrales, use otros poderes");
                continue;
            }

            //Random enemy hit
            if ((random.nextInt(0, 100) >= 95)) {
                System.out.println("¡Haz reaccionado tarde!");
                heroe.recibirDanio(villano.herir());
                villano.atrapado++;
                continue;
            }

            //Player actions to input
            switch (accion) {
                case 1:
                    casas++;
                    break;

                case 2:
                    if (casas > 0) {
                        heroe.rescatados++;
                        casas--;
                    } else System.out.println("No puedes porque no hay casas, ¡Haz más!");
                    break;

                case 3:
                    System.out.println("¡Haz huido, ahora el mago controla la plaza!");
                    break;

                default:
                    System.out.println("¡Esa acción no existe o está fuera de tu alcance!");
            }
        }
        System.out.printf("""
                "Resultados:
                            Personajes:           Heroe (Tú)  |    Mago
                            __________________________________|__________
                            atrapados:                 %d      |    %d
                            Vidas:                     %d      |    %d
                """, heroe.rescatados, villano.atrapado, heroe.vida, villano.vida);
    }

    //this is the game's menu
    public static void main(String[] args) {

        int respuesta;

        System.out.println("""
                                       .
                \s
                                    .
                          /^\\     .
                     /\\   "V"
                    /__\\   I      O  o
                   //..\\\\  I     .
                   \\].`[/  I
                   /l\\/j\\  (]    .  O
                  /. ~~ ,\\/I          .
                  \\\\L__j^\\/I       o
                   \\/--v}  I     o   .
                   |    |  I   _________
                   |    |  I c(`       ')o
                   |    l  I   \\.     ,/
                 _/j  L l\\_!  _//^---^\\\\_   \s""".indent(3));

        //Player Menu
        System.out.println("¡Bienvenido al juego, noble caballero! Escoge tu opción:");
        while(true){
            System.out.println("\n1)Jugar\n2)Salir\n>>> ");

            try{
                respuesta = sc.nextInt();
            }
            catch (Exception ignored){
                System.out.println("Introduzca un numero, no letras ni símbolos, vuélvalo a intentar");
                continue;
            }
            if (respuesta == 2) {
                System.out.println("¡Hasta luego, caballero!");
                break;
            } else if (respuesta == 1) juego();
            else System.out.println("¡Esa opción es de alto rango!, sólo los ancianos saben invocarla");
        }
    }
}