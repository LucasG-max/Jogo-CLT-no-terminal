package Fases01.horaAlmoco;

import Jogador.Jogador;
import StyleJogo.StyleCores;

public class EventoAlmoco {
    Jogador jogador;
    StyleCores.StyleFrases styleFrases = new  StyleCores.StyleFrases();



    public void mesagemInicial(){
        styleFrases.fraseNarrador("Narrador: " +
                "\nO tempo passa voando quando estamos ocupados" +
                "\nSão 12:00 " +
                "\nVamos almoçar" +
                "\n");
    }





    void main(){
        mesagemInicial();
    }
}
