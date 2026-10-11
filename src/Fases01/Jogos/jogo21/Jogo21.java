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
    styleFrases.carregarJogos("\t\t\t21\n");
    styleFrases.carregarJogos("Iniciando...... \n");
        jogar(jogador,maoDamaquina,baralho);

}

void main(){
    Jogo21_Start();
}

}