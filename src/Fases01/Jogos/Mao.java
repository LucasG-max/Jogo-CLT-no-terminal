package Fases01.Jogos;

import StyleJogo.StyleCores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Fases01.Jogos.Jogo21.jogo;
import static Fases01.Jogos.Jogo21.maoDamaquina;

public class Mao {
    static Maquina maquina = new Maquina();
    private List<String> cartas;
    private Scanner input = new Scanner(System.in);
    public Mao() {
        cartas = new ArrayList<>();
    }

    public void receberCarta(String carta) {
        cartas.add(carta);
    }

    public int calcularValor(Baralho baralho) {
        int total = 0;
        int quantidadeAs = 0;


        for (String carta : cartas) {
            int valor = baralho.getValor(carta);
            total += valor;

            if (valor == 11) {
                quantidadeAs++;
            }
        }

        // ✅ Ajuste do Ás: se passou de 21, transforma Ás de 11 em 1
        while (total > 21 && quantidadeAs > 0) {
            total -= 10;
            quantidadeAs--;
        }

        return total;
    }

    public List<String> cartasNaMao() {
        return new ArrayList<>(cartas);
    }

    @Override
    public String toString() {
        return String.join("  ", cartas);
    }

    public void verificarBlackjack(Mao jogador, Mao maquina, Baralho baralho) {
        int totalJogador = jogador.calcularValor(baralho); // usa o método que já ajusta o Ás!
        int totalMaquina = maquina.calcularValor(baralho);
        if (totalJogador == 21 &&cartas.size() != 2) {
            System.out.println(StyleCores.VERDE +"🃏 BLACKJACK! \nO jogador ganhou" +
                    "\n");
            reiniciarJogo(jogador, maquina, baralho);

        }
        if (totalMaquina == 21 && cartas.size() != 2) {
            System.out.println(StyleCores.AMARELO +"🃏 BLACKJACK! \nA máquina ganhou \nQue falta de sorte a sua " +
                    "\n");
            reiniciarJogo(jogador, maquina, baralho);
        }
    }

    public String ganhador(Mao jogador,Mao maquina,Baralho baralho) {
     int valorJogador = jogador.calcularValor(baralho);
     int valorMaquina= maquina.calcularValor(baralho);
    int target = 21;
        if(valorJogador == target && valorMaquina > target || valorJogador < target
                || valorJogador < target
                || valorJogador > valorMaquina
                ||valorJogador > target && valorMaquina > valorJogador ){
            System.out.println(StyleCores.VERDE + "O jogador ganhou !!! \nPontos: " + jogador.calcularValor(baralho) +
                    "\n");
            reiniciarJogo(jogador, maquina, baralho);
        }

        if(valorMaquina == target &&  valorJogador > target
                || valorMaquina < target
                || valorMaquina < target && valorMaquina > valorJogador
                || valorMaquina > target && valorJogador > valorMaquina){
            System.out.println(StyleCores.VERMELHO + "Maquina ganhou !!! \nPontos: " + maquina.calcularValor(baralho) +
                    "\n");
            reiniciarJogo(jogador, maquina, baralho);
        }

        return "Empate";
    }

    public void comprarCartas(Mao jogador,Baralho baralho) {
        while (true) {
            try {
                System.out.print(StyleCores.PERGUNTA + "Voce deseja comprar uma carta ? ");
                String escolha = input.next().trim();
                if(escolha.equalsIgnoreCase("sim")){
                    String cartaCompra = baralho.comprarCartaAleatoria();
                    jogador.receberCarta(cartaCompra);

                    break;
                }else{
                    System.out.println("Turno da máquina " +
                            "\n");

                    break;
                }
            }catch (Exception e) {
                System.out.println(StyleCores.VERMELHO+ "Erro: Jogador digitou um tipo diferente do esperado" + StyleCores.RESET);
            }
        }

    }

    public void maquinaComprar(Mao maquina, Baralho baralho){
        if(maquina.calcularValor(baralho) < 21 && maquina.calcularValor(baralho) >=10){
            String cartaCompra = baralho.comprarCartaAleatoria();
            maquina.receberCarta(cartaCompra);
            System.out.println(StyleCores.AMARELO + "A maquina comprou uma carta " +
                    "\nO que será que ela está aprontando" +
                    "\n");
        }else if(maquina.calcularValor(baralho ) >=21){
            System.out.println(StyleCores.AMARELO + "A máquina passou o turno " +
                    "\nSerá que ele vai ganhar ou estourou a mão ?" +
                    "\n");
        }
    }

    public static void mensagemJogador(Mao jogador,Baralho baralho,int calculo){
        System.out.println(StyleCores.FALA_PERSONAGEM_P +"Suas cartas: " + jogador);
        if(calculo < 21){
            System.out.println(StyleCores.FALA_PERSONAGEM_P +"Seu total: " + jogador.calcularValor(baralho) + StyleCores.RESET);
        }else if(calculo == 21){
            System.out.println(StyleCores.VERDE_ESCURO_REAL +"Seu total: " + jogador.calcularValor(baralho)+ StyleCores.RESET);
        }else{
            System.out.println(StyleCores.VERMELHO +"Seu total: " + jogador.calcularValor(baralho)+ StyleCores.RESET);
        }
    }

    public void jogar(Mao jogador,Mao maquina, Baralho baralho) {
        jogador.receberCarta(baralho.pegarCartaAleatoria());
        jogador.receberCarta(baralho.pegarCartaAleatoria());
        maoDamaquina.receberCarta(baralho.pegarCartaAleatoria());
        maoDamaquina.receberCarta(baralho.pegarCartaAleatoria());
        while(true){
            mensagemJogador(jogador,baralho,jogador.calcularValor(baralho));
            jogo.verificarBlackjack(jogador,maoDamaquina,baralho);
            jogo.comprarCartas(jogador,baralho);
            mensagemJogador(jogador,baralho,jogador.calcularValor(baralho));
            maquina.maquinaComprar(maoDamaquina,baralho);
            jogo.ganhador(jogador,maoDamaquina,baralho);
            break;

        }
        reiniciarJogo(jogador, maquina, baralho);
    }


    public void reiniciarJogo(Mao jogador, Mao maoDamaquina, Baralho baralho) {
        System.out.println(StyleCores.AMARELO + "Reiniciando jogo...\n" + StyleCores.RESET);


        jogador.limpar();
        maoDamaquina.limpar();


        baralho = new Baralho();

        jogar(jogador, maoDamaquina, baralho);
    }
    public void limpar() {
        cartas.clear();
    }
}