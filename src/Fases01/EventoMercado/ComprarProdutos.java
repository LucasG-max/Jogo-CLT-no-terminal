package Fases01.EventoMercado;

import StyleJogo.StyleCores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ComprarProdutos {
    Scanner input = new Scanner(System.in);
    Map<String,Double> produtos;
    Map<String,Double> carrinho;
    public ComprarProdutos(){
        produtos = new HashMap<>();
        carrinho = new HashMap<>();
        produtos.put("Coca cola 350ml",2.99);
        produtos.put("Suco de uva 200ml",1.99);
        produtos.put("Monster 500ml",10.99);
        produtos.put("Recheado 150gr",1.49);
        produtos.put("Pippos 75g",2.99);
        produtos.put("Salgado",4.99);
    }

    public void comprarLanche(Map<String,Double> produtos){
        int contador = 1;
        for (Map.Entry<String,Double> entry : produtos.entrySet()){
            System.out.println(contador+ "- " + entry.getKey() + " " +  entry.getValue());
            contador++;
        }
        System.out.println(contador + "- para sair");
        while(true){
            System.out.print("Digite o número do produto para adicionar ao carrinho: ");
            int numero = input.nextInt();
            if(numero == 1){
                System.out.println(StyleCores.VERDE + "Monster 500ml adicinado com sucesso " + StyleCores.RESET);
                carrinho.put("Monster 500ml",10.99);
            } if(numero == 2){
                System.out.println(StyleCores.VERDE + "Suco de uva 200ml adicinado com sucesso " + StyleCores.RESET);
                carrinho.put("Suco de uva 200ml",1.99);
            } if(numero == 3){
                System.out.println(StyleCores.VERDE + "Pippos 75g adicinado com sucesso " + StyleCores.RESET);
                carrinho.put("Pippos 75g",2.99);
            } if(numero == 4){
                System.out.println(StyleCores.VERDE + "Recheado 150gr adicinado com sucesso " + StyleCores.RESET);
                carrinho.put("Recheado 150gr",1.49);
            } if(numero == 5){
                System.out.println(StyleCores.VERDE + "Coca cola adicinado com sucesso " + StyleCores.RESET);
                carrinho.put("Coca cola",2.99);
            } if(numero == 6){
                System.out.println(StyleCores.VERDE + "Salgado adicinado com sucesso " + StyleCores.RESET);
                carrinho.put("Salgado",4.99);
            }if (numero == 7){
                System.out.println("Fim do lanche");
                break;
            }


        }


    }

    public String calcularCarrinho(Map<String,Double> produtos){
        if(produtos.isEmpty()){
            System.out.println("Vazia");
        }
        double valorTotal = 0;
        for (Map.Entry<String,Double> produto : produtos.entrySet()){
            valorTotal += produto.getValue();
        }
        return String.format("O valor total do seu carrinho: %.2f",valorTotal);
    }



    void main(){
        comprarLanche(produtos);
        System.out.println(calcularCarrinho(carrinho));
    }
}
