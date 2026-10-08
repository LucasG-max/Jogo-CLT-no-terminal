import Fases01.Fase01;
import Jogador.Jogador;
import Jogador.StatusJogador;
import StyleJogo.StyleCores;

import java.util.ArrayList;
import java.util.List;

public class Teste {
    public static void main(String[] args) {
        Jogador jogador1 = new Jogador("Lucas");
        Fase01 fase01 = new  Fase01();
        //jogador1.addPontosStatus(StatusJogador.values()[0],5);
        fase01.apresentacao();



    }
}