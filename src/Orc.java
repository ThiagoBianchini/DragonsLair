import java.util.Random;

public class Orc extends Modelo implements Modelo.Bater {

    public Orc() {

        super(20, 6, 2, 2);
    }
    Random random = new Random();
    @Override
    public int Dano() {
        return (random.nextInt(8) + 1) + this.getForca();
    }
}
