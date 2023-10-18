package Classes;

import java.util.Random;

public class Barbaro extends Modelo implements Modelo.Bater {

    public Barbaro() {

        super(13, 6, 1, 3);
    }
    Random random = new Random();
    @Override
    public int Dano() {
        return (random.nextInt(6) + 1) + (random.nextInt(6) + 1) + this.getForca();
    }

}
