import java.util.Random;

public class Guerreiro extends Modelo implements Modelo.Bater {

    public Guerreiro() {
        super(12, 4, 3, 3);
    }

    Random random = new Random();

    @Override
    public int Dano() {
        return (random.nextInt(4) + 1) + (random.nextInt(4) + 1) + this.getForca();
    }

}
