package Fases01.Jogos.jogo21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Baralho {
    private List<String> baralhoCompleto;
    private Map<String, Integer> valores; // guarda nome → valor
    private Random aleatorio;

    public Baralho() {
        aleatorio = new Random();
        montarBaralho();
    }

    private void montarBaralho() {
        baralhoCompleto = new ArrayList<>();
        valores = new HashMap<>();

        String[] naipes = {"♥", "♦", "♠", "♣"};


        for (String n : naipes) {
            valores.put("A" + n, 11);
            baralhoCompleto.add("A" + n);
        }

        for (int num = 2; num <= 10; num++) {
            for (String n : naipes) {
                valores.put(num + n, num);
                baralhoCompleto.add(num + n);
            }
        }

        String[] figuras = {"J", "Q", "K"};
        for (String n : naipes) {
            for (String f : figuras) {
                valores.put(f + n, 10);
                baralhoCompleto.add(f + n);
            }
        }
    }

    public String pegarCartaAleatoria() {
        if (baralhoCompleto.isEmpty()) {
            montarBaralho();
        }
        int indice = aleatorio.nextInt(baralhoCompleto.size());
        return baralhoCompleto.remove(indice);
    }

    public String comprarCartaAleatoria() {
        int indice = aleatorio.nextInt(baralhoCompleto.size());
        return baralhoCompleto.remove(indice);
    }


    public int getValor(String nomeCarta) {
        return valores.get(nomeCarta);
    }


}