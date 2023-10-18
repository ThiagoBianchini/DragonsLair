package Classes;

import Classes.Modelo;

import java.util.Random;

public class Paladino extends Modelo implements Modelo.Bater {

    public Paladino() {

        super(15, 2, 5, 1);
    }
    Random random = new Random();
    @Override
    public int Dano() {
        return (random.nextInt(4) + 1) + (random.nextInt(4) + 1) + this.getForca();
    }
}
