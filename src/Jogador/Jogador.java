package Jogador;

import StyleJogo.StyleCores;

import java.util.EnumMap;
import java.util.Map;

public class Jogador {
    private final String nome;
    private double saldo = 0;
    private final Map<StatusJogador, Integer> pontos = new EnumMap<>(StatusJogador.class);

    public Jogador(String nome) {
        this.nome = nome;
        // cada jogador começa com os valores iniciais do enum
        for (StatusJogador status : StatusJogador.values()) {
            pontos.put(status, status.getPontosStatus());
        }
    }

    public String getPontos(StatusJogador status) {
        return String.format(StyleCores.VERDE+ "Total de %s = %d",status,pontos.get(status));
    }

    public String addPontosStatus(StatusJogador status, int quantidade) {
        pontos.put(status, pontos.get(status) + quantidade);
        return String.format(StyleCores.VERDE_ESCURO_REAL + "+%d pontos  adicionados ao status %s" + StyleCores.RESET,
                quantidade, status);
    }

    public String subtrairPontosStatus(StatusJogador status, int quantidade) {
        int novo = Math.max(0, pontos.get(status) - quantidade); // não deixa ficar negativo
        pontos.put(status, novo);
        return String.format(StyleCores.VERMELHO + "-%d pontos removidos do status %s" + StyleCores.RESET,
                quantidade, status);
    }

    public void getStatusJogador() {
        for (StatusJogador status : StatusJogador.values()) {
            System.out.println(status + " (" + pontos.get(status) + "): " + status.getDescricaoPontos());
        }
    }
}