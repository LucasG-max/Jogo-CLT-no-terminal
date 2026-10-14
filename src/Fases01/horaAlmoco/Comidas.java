package Fases01.horaAlmoco;

import Jogador.Jogador;
import Jogador.StatusJogador;
import StyleJogo.StyleCores;

import java.util.*;

public class Comidas {
    List<String> comidas;
    List<String> carnes;
    List<String> bebidas;
    List<String> prato;
    Jogador jogador = new Jogador("Lucas");
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
        System.out.println(StyleCores.AMARELO);
        int contador = 1;
        for(String comida : comidas){
            System.out.println(contador + " - Comida: " +  comida);
            contador++;
        }
        System.out.println(StyleCores.RESET);
    }

    public void comidasPrato(List<String> comidas) {
        System.out.println(StyleCores.AMARELO);
       while(true){
           int porComida;
           try {
               styleFrases.frasesNpcs("Opções ");
               cardapioAlmoço(comidas);
               styleFrases.frasesNpcs("Adicione a comida ao seu prato ");
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
                       styleFrases.frasesNpcs("As opções acabaram");
                       break;
                   }

                   styleFrases.frasesNpcs("deseja finalizar prato ");
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
                styleFrases.frasesNpcs("Opções ");
                cardapioAlmoço(comidas);
                styleFrases.frasesNpcs("Adicione o tipo de carne ao seu prato ");
                while (true) {
                    int porComida = input.nextInt() -1;
                    if(comidas.isEmpty()){
                        styleFrases.frasesNpcs("As opções acabaram");
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
                        styleFrases.frasesNpcs("As opções acabaram");
                        break;
                    }

                    styleFrases.frasesNpcs("deseja finalizar prato ");
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
                styleFrases.frasesNpcs("Opções ");
                cardapioAlmoço(comidas);
                styleFrases.frasesNpcs("Escolha o que você vai beber: ");

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
        styleFrases.frasesNpcs("Seu prato: ");
        for (String comida : comidas) {
            System.out.println(comida);
        }
    }

    public void comer(List<String> comidas) {
        for (String comida : comidas) {
          styleFrases.fraseNarrador("Voce esta consumindo " + comida);
        styleFrases.carregarJogos("\".........\"");
            System.out.println();
        }
        styleFrases.fraseNarrador("\n" +
                "Você almoçou e agora vai dormir um pouco");
            styleFrases.fraseNarrador("Lembrete comidas adicionam e subtraem em seus pontos de Status");
        addPontosAlmoco(comidas);

    }

    public void addPontosAlmoco(List<String> comidas){

        for (String comida : comidas) {
            if (comidas.contains("Macarrao")){
                jogador.subtrairPontosStatus(StatusJogador.PORTE_FISICO,2);
                jogador.subtrairPontosStatus(StatusJogador.FOME,1);
            }

            if (comidas.contains("Batata Frita")){
                jogador.subtrairPontosStatus(StatusJogador.PORTE_FISICO,5);
                jogador.subtrairPontosStatus(StatusJogador.FOME,1);
            }
            if (comidas.contains("Salada")){
                jogador.addPontosStatus(StatusJogador.PORTE_FISICO,1);
                jogador.addPontosStatus(StatusJogador.FOME,1);
            }
            if (comidas.contains("Coca cola")){
                jogador.subtrairPontosStatus(StatusJogador.PORTE_FISICO,3);
                jogador.addPontosStatus(StatusJogador.FOME,1);
                jogador.subtrairPontosStatus(StatusJogador.SEDE,2);
            }
        }
    }

    void main(){
        comidasPrato(comidas);
        addPontosAlmoco(prato);


    }
}


