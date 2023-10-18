package Classes;

import Classes.Modelo;

import java.util.Random;

public class MortoVivo extends Modelo implements Modelo.Bater {

    public MortoVivo() {

        super(25, 4, 0, 1);
    }
    Random random = new Random();
    @Override
    public int Dano() {
        return (random.nextInt(4) + 1) + (random.nextInt(4) + 1) + this.getForca();
    }

}
