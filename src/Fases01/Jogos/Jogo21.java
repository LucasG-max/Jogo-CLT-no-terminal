package Fases01.Jogos;

import StyleJogo.StyleCores;

import java.util.Scanner;

public class Jogo21  extends Mao{
    Scanner input = new Scanner(System.in);
    static Maquina maquina = new Maquina();
   static Baralho baralho = new Baralho();
    static Mao jogador = new Mao();
    static Mao maoDamaquina = new Mao();
    static Mao jogo = new Jogo21();

public void Jogo21_Start(){
    System.out.println(StyleCores.PERGUNTA+"21 iniciando..." + StyleCores.RESET);
    jogo.jogar(jogador,maoDamaquina,baralho);
    while(true){
        System.out.print(StyleCores.PERGUNTA + "Você ainda quer jogar ?");
        char resposta = input.next().charAt(0);
        System.out.println();
        if(resposta =='s' || resposta =='S'){
            jogo.jogar(jogador,maoDamaquina,baralho);
        }else if(resposta =='n' || resposta =='N'){
            System.out.println(StyleCores.PERGUNTA + "Fim de jogo" +
                    "\n");
            break;
        }

    }
}

}