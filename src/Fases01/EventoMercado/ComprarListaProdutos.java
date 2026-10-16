package Fases01.EventoMercado;

import StyleJogo.StyleCores;

import java.lang.classfile.instruction.ReturnInstruction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComprarListaProdutos {
    StyleCores.StyleFrases styleFrases = new StyleCores.StyleFrases();
    Map<String, Double> carrinho;
    Map<Integer,Map<String,Double>> mapa = new HashMap<>();
    List<String> listaProdutos = new ArrayList<>();
    public ComprarListaProdutos() {
        listaProdutos = new ArrayList<>();
        carrinho = new HashMap<>();
        listaProdutos.add("Arroz");
        listaProdutos.add("Tomate");
        listaProdutos.add("Batata");
        listaProdutos.add("Agua sanitária");
    }

    public void comprarProdutosLista(List<String> listaProdutos){
        System.out.println("Fazendo as compras");
        styleFrases.carregarJogos(".".repeat(20));
        System.out.println("\nFim da compras \nProdutos");
        for (String produto : listaProdutos) {
            System.out.println(produto);
        }
    }

    public String totalDoCarrinho(){
        carrinho.put(listaProdutos.get(0),4.99);
        carrinho.put(listaProdutos.get(1),6.99);
        carrinho.put(listaProdutos.get(2),4.99);
        carrinho.put(listaProdutos.get(3),1.99);
        double totalCarrinho = 0.0;
        for (Map.Entry<String, Double> entry : carrinho.entrySet()) {
            totalCarrinho += entry.getValue();
        }
        return String.format("Total do carrinho %.2f: ", totalCarrinho);
    }

    void main(){
        comprarProdutosLista(listaProdutos);
        System.out.println(totalDoCarrinho());
    }
}