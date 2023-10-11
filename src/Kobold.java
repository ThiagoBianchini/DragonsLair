import java.util.Random;

public class Kobold extends Modelo implements Modelo.Bater{

    public Kobold() {

        super(20, 4, 2, 4);
    }
    Random random = new Random();
    @Override
    public int Dano() {
        return (random.nextInt(2) + 1) + (random.nextInt(2) + 1) + (random.nextInt(2) + 1) + this.getForca();
    }
}
