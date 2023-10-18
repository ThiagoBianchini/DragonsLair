import Classes.*;
import Metodos.Metodos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        String nickArquivo = nick + ".csv";
        File temp = new File("temp");
        if (!temp.exists()) {
            if (temp.mkdir());
            else {
                System.out.println("Falha ao criar o diretório 'temp'.");
                return;
            }
        }
        File arquivo = new File(temp, nickArquivo);
        try {
            if (arquivo.createNewFile()) {
                System.out.println("Arquivo criado com sucesso.");
            } else {
                System.out.println("O arquivo já existe.");
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro na criação do arquivo.");
            e.printStackTrace();
        }

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

        String jogadorNome = jogador.getClass().getName();
        String monstroNome = monstro.getClass().getName();

        System.out.println("Batalha iniciada: " + jogadorNome + " x " + monstroNome);

        int jogadorInit = Metodos.Iniciativa(jogador);
        int monstroInit = Metodos.Iniciativa(monstro);
        System.out.println("Inciativa do " + jogadorNome + ": " + jogadorInit);
        System.out.println("Inciativa do " + monstroNome + ": " + monstroInit);
        if (jogadorInit > monstroInit) {
            System.out.println(jogadorNome + " começa");
            while (jogador.getPV() > 0 && monstro.getPV() > 0) {
                Metodos.Batalhar(jogador, monstro);
                GerarLog(nick, jogadorNome, monstroNome);
                Metodos.Batalhar(monstro, jogador);
                GerarLog(nick, jogadorNome, monstroNome);
            }
        } else if (monstroInit > jogadorInit) {
            System.out.println(monstroNome + " começa");
            while (jogador.getPV() > 0 && monstro.getPV() > 0) {
                Metodos.Batalhar(monstro, jogador);
                GerarLog(nick, jogadorNome, monstroNome);
                Metodos.Batalhar(jogador, monstro);
                GerarLog(nick, jogadorNome, monstroNome);
            }
        }
    }
    public static void GerarLog(String nick, String jogador, String monstro) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String data = dateFormat.format(new Date());
        File tempDir = new File("temp");
        if (!tempDir.exists()) {
            tempDir.mkdirs();
        }

        try {
            FileWriter writer = new FileWriter("temp/" + nick + ".csv", true);
            writer.write(data + "; Classe: " + jogador + "; Inimigo: " + monstro + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
