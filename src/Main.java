import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Metodos metodos = new Metodos();

        Scanner input = new Scanner(System.in);
        System.out.println("Bem-Vindo ao Dragon's Lair");
        System.out.println("Digite seu nickname:");
        String nick = input.nextLine();
        System.out.println("Escolha a sua classe:");

        while(true){
            System.out.println("1 - Guerreiro");
            System.out.println("2 - Bárbaro");
            System.out.println("3 - Paladino");
            char escolha = input.next().charAt(0);
            switch (escolha) {
                case '1':
                    Guerreiro guerreiro = new Guerreiro();
                    break;
                case '2':
                    Barbaro barbaro = new Barbaro();
                    break;
                case '3':
                    Paladino paladino = new Paladino();
                    break;
                default:
                    System.out.println("Escolha inválida, tente novamente");
                    break;
            }
        }
    }
}