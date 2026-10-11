package Fases01.horaAlmoco;

import StyleJogo.StyleCores;

import java.util.*;

public class Comidas {
    List<String> comidas;
    List<String> carnes;
    List<String> bebidas;
    List<String> prato;
    Scanner input = new Scanner(System.in);
        StyleCores.StyleFrases styleFrases = new StyleCores.StyleFrases();
    public Comidas(){

        comidas = new ArrayList<>();
        carnes = new ArrayList<>();
        bebidas = new ArrayList<>();
        prato = new ArrayList<>();
        comidas.add("Arroz");
        comidas.add("Feijão");
        comidas.add("Macarrão");
        carnes.add("Frango");
        carnes.add("Linguiça");
        comidas.add("Salada");
        comidas.add("Batata Frita");
        bebidas.add("Suco de Uva");
        bebidas.add("Coca Cola");
    }




    public void cardapioAlmoço(List<String> comidas){
        int contador = 1;
        for(String comida : comidas){
            System.out.println(contador + " - Comida: " +  comida);
            contador++;
        }
    }

    public void comidasPrato(List<String> comidas) {
       while(true){
           int porComida;
           try {
               System.out.println("Opções ");
               cardapioAlmoço(comidas);
               System.out.print("Adicione a comida ao seu prato ");
               while (true) {
                    porComida = input.nextInt() -1;
                   for(int i = 0; i < comidas.size(); i++){

                       if(comidas.get(i).equals(comidas.get(porComida))){
                           System.out.println( StyleCores.VERDE_ESCURO_REAL+  comidas.get(i) + " adicionada com sucesso" +  StyleCores.RESET);
                           prato.add(comidas.get(i));
                           break;
                       }
                   }
                   if(comidas.isEmpty()){
                       System.out.println("As opções acabaram");
                       break;
                   }

                   System.out.print("deseja finalizar prato ");
                   char resposta = input.next().charAt(0);
                   if (resposta == 's' ||  resposta == 'S') {
                       System.out.println("\n");
                       break;
                   }

               }
           } catch (InputMismatchException e) {

               System.out.println(StyleCores.VERMELHO+ "Erro: Jogador digitou um tipo diferente do esperado" + StyleCores.RESET);
               break;

           }catch (IndexOutOfBoundsException e){
               System.out.println(StyleCores.VERMELHO+ "Erro: Jogador tentou acessar uma opção maior que o limete" +
                       "\nLimete =" + comidas.size() + StyleCores.RESET);
              break;
           }
        break;
       }
    }


    public void comidasCarne(List<String> comidas) {
        while (true){
            try {
                System.out.println("Opções ");
                cardapioAlmoço(comidas);
                System.out.print("Adicione o tipo de carne ao seu prato ");
                while (true) {
                    int porComida = input.nextInt() -1;
                    if(comidas.isEmpty()){
                        System.out.println("As opções acabaram");
                        break;
                    }
                    for(int i = 0; i < comidas.size(); i++){


                        if(comidas.get(i).equals(comidas.get(porComida))){
                            System.out.println( StyleCores.VERDE_ESCURO_REAL+  comidas.get(i) + " adicionada com sucesso" +  StyleCores.RESET);
                            prato.add(comidas.get(i));

                            break;
                        }

                    }
                    if(comidas.isEmpty()){
                        System.out.println("As opções acabaram");
                        break;
                    }

                    System.out.print("deseja finalizar prato ");
                    char resposta = input.next().charAt(0);
                    if (resposta == 's' ||  resposta == 'S') {
                        System.out.println("\n");
                        break;
                    }

                }
            } catch (InputMismatchException e) {
                System.out.println(StyleCores.VERMELHO+ "Erro: Jogador digitou um tipo diferente do esperado" + StyleCores.RESET);
                break;
            }catch (IndexOutOfBoundsException e){
                System.out.println(StyleCores.VERMELHO+ "Erro: Jogador tentou acessar uma opção maior que o limete" +
                        "\nLimete =" + comidas.size() + StyleCores.RESET);
                break;
            }

            break;
        }

    }

    public void comidasBebidas(List<String> comidas) {
        while (true) {
            try {
                System.out.println("Opções ");
                cardapioAlmoço(comidas);
                System.out.print("Escolha o que você vai beber: ");

                int escolha = input.nextInt() - 1;

                if (escolha >= 0 && escolha < comidas.size()) {
                    String itemEscolhido = comidas.get(escolha);
                    System.out.println(StyleCores.VERDE_ESCURO_REAL + itemEscolhido + " adicionada com sucesso" + StyleCores.RESET);
                    prato.add(itemEscolhido);
                    break;
                } else {
                    System.out.println(StyleCores.VERMELHO + "Erro: opção inválida! Limite = " + comidas.size() + StyleCores.RESET);
                }
            } catch (InputMismatchException e) {
                System.out.println(StyleCores.VERMELHO + "Erro: digite apenas números!" + StyleCores.RESET);
                input.nextLine();
            } catch (IndexOutOfBoundsException e) {
                System.out.println(StyleCores.VERMELHO + "Erro: opção maior que o limite! Limite = " + comidas.size() + StyleCores.RESET);
            }
        }
    }

    public void comidasDoPrato(List<String> comidas) {
        System.out.println("Seu prato: ");
        for (String comida : comidas) {
            System.out.println(comida);
        }
    }

    public void comer(List<String> comidas) {
        for (String comida : comidas) {
            System.out.println("Voce esta consumindo " + comida);
        styleFrases.carregarJogos("\".........\"");
            System.out.println();
        }
        System.out.println("Você almoçou e agora vai dormir um pouco");

    }

    void main(){
        comidasPrato(comidas);
        comidasCarne(carnes);
       comidasBebidas(bebidas);

       comer(prato);

    }
}


