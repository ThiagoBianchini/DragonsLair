import java.util.Random;

public class Guerreiro extends Modelo implements Acoes{

    public Guerreiro(int PV, int forca, int defesa, int agilidade) {
        super(12, 4, 3, 3);
    }

    Random random = new Random();
    @Override
    public int Atacar() {
        return (random.nextInt(4) + 1) + (random.nextInt(4) + 1)+ this.getForca();
    }
}
