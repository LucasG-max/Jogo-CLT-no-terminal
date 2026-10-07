import Jogador.Jogador;
import Jogador.StatusJogador;

import java.util.ArrayList;
import java.util.List;

public class Teste {
    public static void main(String[] args) {
        Jogador jogador1 = new Jogador("Lucas");
        //jogador1.addPontosStatus(StatusJogador.values()[0],5);
        jogador1.getStatusJogador();
        System.out.println(jogador1.addPontosStatus(StatusJogador.ENERGIA,5));
        System.out.println(jogador1.getPontos(StatusJogador.ENERGIA));
        System.out.println(jogador1.subtrairPontosStatus(StatusJogador.ENERGIA,5));
        System.out.println(jogador1.getPontos(StatusJogador.ENERGIA));
    }
}