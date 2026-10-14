package Fases01.EventoMercado;

import Jogador.Jogador;
import Jogador.StatusJogador;
import StyleJogo.StyleCores;

import java.util.List;
import java.util.Scanner;

public class EventoIrPe {

    Jogador  jogador = new Jogador("Lucas");
    StyleCores.StyleFrases styleFrases = new StyleCores.StyleFrases();
    static Scanner input = new Scanner(System.in);

    public void chegadaAoMercado(){
        styleFrases.fraseNarrador("Narrador: " +
                "\nVocê ao mercado um pouco tarde " +
                "\nMas essa tarde está linda demais para não ser aproveitada " +
                "\n");

        styleFrases.frasesNpcs("Aviso:" +
                "\nA caminhada te fez perder alguns pontos em seus Status" +
                "\nPontos alterados " +
                "\n" + jogador.subtrairPontosStatus(StatusJogador.ENERGIA,15)
                + "\n" + jogador.addPontosStatus(StatusJogador.CANSACO, 5)
                + "\n" + jogador.addPontosStatus(StatusJogador.FOME, 15)
                + "\n" + jogador.addPontosStatus(StatusJogador.SEDE, 5)
                + "\n" + jogador.addPontosStatus(StatusJogador.PORTE_FISICO, 5));

    }

    public void comprarLache(List<String> laches){
        styleFrases.fraseNarrador("Opções: ");
        int contador = 1;
        for (String lache : laches){
            System.out.println(contador + "- " + lache);
            System.out.println("Digite o que voce quer para comer");
            int opcao = input.nextInt();
            if (opcao == 1){

                System.out.println(lache+ " adicinado ao carrinho");
            } if (opcao == 2){
                System.out.println(lache+ " adicinado ao carrinho");
            }
            if (opcao == 3){
                System.out.println(lache+ " adicinado ao carrinho");
            }
            if (opcao == 4){
                System.out.println(lache+ " adicinado ao carrinho");
            }
        }

    }

    void main(){
        chegadaAoMercado();
    }
}


