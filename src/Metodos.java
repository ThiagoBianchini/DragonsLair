import java.util.Random;

public class Metodos implements Acoes{

    Random random = new Random();

    @Override
    public int Iniciativa(Modelo modelo) {
        return (random.nextInt(10) + 1) + modelo.getAgilidade();
    }

    @Override
    public int Atacar(Modelo modelo) {
        return (random.nextInt(10) + 1) + modelo.getForca() + modelo.getAgilidade();
    }

   @Override
    public int Defender(Modelo modelo) {
        return (random.nextInt(10) + 1) + modelo.getAgilidade() + modelo.getDefesa();
    }

}
