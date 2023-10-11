import java.sql.SQLOutput;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Modelo jogador = null;
        Modelo monstro = null;

        Scanner input = new Scanner(System.in);
        System.out.println("Bem-Vindo ao Dragon's Lair");
        System.out.println("Digite seu nickname:");
        String nick = input.nextLine();
        System.out.println("Escolha a sua classe:");

        while (true) {
            System.out.println("1 - Guerreiro");
            System.out.println("2 - Bárbaro");
            System.out.println("3 - Paladino");
            char escolha = input.next().charAt(0);
            switch (escolha) {
                case '1':
                    jogador = new Guerreiro();
                    break;
                case '2':
                    jogador = new Barbaro();
                    break;
                case '3':
                    jogador = new Paladino();
                    break;
                default:
                    System.out.println("Escolha inválida, tente novamente");
                    break;
            }
            break;
        }

        Random random = new Random();
        int monstroNum = random.nextInt(3) + 1;
        monstro = switch (monstroNum) {
            case 1 -> new MortoVivo();
            case 2 -> new Orc();
            case 3 -> new Kobold();
            default -> monstro;
        };

        System.out.println("Batalha iniciada: " + jogador.getClass().getName() + " x " + monstro.getClass().getName());

        int jogadorInit = Metodos.Iniciativa(jogador);
        int monstroInit = Metodos.Iniciativa(monstro);
        System.out.println("Inciativa do " + jogador.getClass().getName() + ": " + jogadorInit);
        System.out.println("Inciativa do " + monstro.getClass().getName() + ": " + monstroInit);
        if (jogadorInit > monstroInit) {
            System.out.println(jogador.getClass().getName() + " começa");
            while (jogador.getPV() > 0 && monstro.getPV() > 0) {
                Metodos.Batalhar(jogador, monstro);
                Metodos.Batalhar(monstro, jogador);
            }
        } else if (monstroInit > jogadorInit) {
            System.out.println(monstro.getClass().getName() + " começa");
            while (jogador.getPV() > 0 && monstro.getPV() > 0) {
                Metodos.Batalhar(monstro, jogador);
                Metodos.Batalhar(jogador, monstro);
            }
        }
    }
}