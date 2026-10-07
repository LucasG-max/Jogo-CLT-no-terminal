package Jogador;

import StyleJogo.StyleCores;

public enum StatusJogador {
    ENERGIA(100,"Pontos de ENERGIA são necessários para participar de Eventos"),
    ALEGRIA(100,"Pontos de ALEGRIA são necessários para interação do Jogador"),
    CARISMA(100,"Pontos de CARISMA são necessários para Status do Jogador"),
    CANSACO(0,"Pontos de CANSAÇO influenciam no gasto de pontos de ENERGIA"),
    FOME(0,"Pontos de FOME influenciam no gasto de pontos de ENERGIA,ALEGRIA e aumenta os pontos de CANSAÇO"),
    SEDE(0,"Pontos de SEDE influenciam no gasto de pontos de ENERGIA"),;


    private final int pontosStatus;
    private final String descricaoPontos;

    StatusJogador(int pontosStatus, String descricaoPontos){
        this.pontosStatus = pontosStatus;
        this.descricaoPontos = descricaoPontos;

    }
    public int getPontosStatus() {
        return pontosStatus;
    }

    public String getDescricaoPontos() {
        return descricaoPontos;
    }

    public String addPontosStatus(StatusJogador statusJogador, int quantidade){
        int statusAlterado = getPontosStatus() + quantidade;
        return String.format(StyleCores.VERDE + "Pontos %d adicionado ao status %s",statusAlterado,statusJogador);
    }

    public int subtrairPontosStatus(StatusJogador statusJogador,int quantidade){
        return getPontosStatus() - quantidade;
    }

}
