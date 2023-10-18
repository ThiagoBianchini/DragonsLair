package Metodos;

import Classes.Modelo;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Metodos implements Acoes {

    static Random random = new Random();


    public static int Iniciativa(Modelo modelo) {
        return (random.nextInt(10) + 1) + modelo.getAgilidade();
    }


    public static int Atacar(Modelo modelo) {
        return (random.nextInt(10) + 1) + modelo.getForca() + modelo.getAgilidade();
    }


    public static int Defender(Modelo modelo) {
        return (random.nextInt(10) + 1) + modelo.getAgilidade() + modelo.getDefesa();
    }


    public static void Batalhar(Modelo modelo1, Modelo modelo2) {
        int ataque1 = Atacar(modelo1);
        int defesa2 = Defender(modelo2);

        if (ataque1 >= defesa2) {
            System.out.println(modelo1.getClass().getName() + " ataca(" + ataque1 + ") e " + modelo2.getClass().getName() + " tenta defender(" + defesa2 + ") mas não consegue.");
            int dano = modelo1.Dano();
            System.out.println(modelo2.getClass().getName() + " recebe " + dano + " de dano.");
            int vida = modelo2.getPV();
            modelo2.setPV(vida - dano);
            if (modelo2.getPV() > 0) {
                System.out.println("PV restante de " + modelo2.getClass().getName() + ": " + modelo2.getPV());
            } else {
                System.out.println(modelo2.getClass().getName() + " foi morto na batalha, " + modelo1.getClass().getName() + " venceu!!!");
            }
        } else {
            System.out.println(modelo1.getClass().getName() + " ataca(" + ataque1 + "), mas " + modelo2.getClass().getName() + " defende(" + defesa2 + ").");
        }

    }
}
