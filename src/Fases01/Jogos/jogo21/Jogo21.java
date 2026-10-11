package Fases01.Jogos.jogo21;

import StyleJogo.StyleCores;

import java.util.Scanner;

public class Jogo21  extends Mao {
    StyleCores.StyleFrases styleFrases = new StyleCores.StyleFrases();
    Scanner input = new Scanner(System.in);
    static Maquina maquina = new Maquina();
   static Baralho baralho = new Baralho();
    static Mao jogador = new Mao();
    static Mao maoDamaquina = new Mao();
    static Mao jogo = new Jogo21();

public void Jogo21_Start(){
    System.out.println(StyleCores.FALA_NARRADOR_CINZA+" Jogo 21 " + StyleCores.RESET);
    styleFrases.carregarJogos("...... \n");
        continuarJogo(jogador, maoDamaquina, baralho);
}

}