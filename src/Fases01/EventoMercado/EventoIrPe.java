package Fases01.EventoMercado;

import Jogador.Jogador;
import Jogador.StatusJogador;
import StyleJogo.StyleCores;

import java.util.*;

public class EventoIrPe {
    Map<String,Double> carrinho = new HashMap<>();
    List<String> produtos = new ArrayList<>();
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

    public void comprarLache(){
        produtos = new ArrayList<>();
        produtos.add("Monster");
        produtos.add("Suco de uva");
        produtos.add("Salgado");
        produtos.add("Pippos");
        styleFrases.fraseNarrador("Opções: ");
        int contador = 1;
        for(String lache : produtos){
        styleFrases.fraseNarrador(contador + "- " + lache);
            contador++;
        }
        int quantidade = 0;
        while(true){
            if(quantidade == 2){
                styleFrases.fraseNarrador("Fim das escolhas ");
                break;
            }
            System.out.print(">> ");
            int op = input.nextInt();

            // Verifica se a opção existe
            if (op >= 1 && op <= produtos.size()) {
                String lacheEscolhido = produtos.get(op - 1);
                if(lacheEscolhido.equalsIgnoreCase("Monster")){
                    carrinho.put(lacheEscolhido, 10.99);
                }
                else if(lacheEscolhido.equalsIgnoreCase("Suco de uva")){
                    carrinho.put(lacheEscolhido,1.99);
                }
                else if(lacheEscolhido.equalsIgnoreCase("Salgado")){
                    carrinho.put(lacheEscolhido, 5.99);
                }
                else if(lacheEscolhido.equalsIgnoreCase("Pippos")){
                    carrinho.put(lacheEscolhido, 3.99);
                }


                System.out.println(
                        StyleCores.VERDE_ESCURO_REAL
                                + "Sucesso: " + lacheEscolhido
                                + StyleCores.RESET
                );

                quantidade++;

            } else {
                System.out.println("Opção inválida! Escolha de 1 a " + produtos.size());
            }
        }
        double valor = 0;
        for (Map.Entry<String, Double> entry : carrinho.entrySet()) {
            valor+=entry.getValue();
        }
        System.out.println("Total do carrinho " + valor);
    }

    void main(){
        comprarLache();
    }
}


