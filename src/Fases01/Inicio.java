package Fases01;

import Fases01.Jogos.acerteONumero.AdvinheNumeros;
import Fases01.Jogos.jogo21.Jogo21;
import Jogador.Jogador;
import StyleJogo.StyleCores;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Inicio {
    Scanner input = new Scanner(System.in);
    String barra = "-".repeat(40);
    StyleCores.StyleFrases  styleFrases = new StyleCores.StyleFrases();
    Jogador jogador = new Jogador("Lucas");
    LocalDateTime dataInicioJogo = LocalDateTime.of(2000,01,01,8,0,0);

    public void iniciarEscolhas(){
        styleFrases.fraseNarrador("Narrador: " +
                "\nHoje é dia 1 de Janeiro de 2000" +
                "\nEstá cedo por volta das 8:00 da manhã" +
                "\nVocê levanta e pensa" +
                "\n ");

        styleFrases.frasesPersonagemPrincipal("Pensamentos: " +
                "\n- Sinto falta do Pedro" +
                "\n- Mas devo seguir em frente " +
                "\n- Mas tenho medo do futuro" +
                "\n ");

    styleFrases.fraseNarrador("Narrador: " +
            "\nVocê tem duas opções para hoje" +
            "\nFazer seu currículo ou jogar video game para dessestresar " +
            "\nSim - Para preparar currículo" +
            "\nNão - Para Jogar" +
            "\n ");
        System.out.print(StyleCores.PERGUNTA + "Digite a sua escolha: ");
        String escolha = input.nextLine().trim();

        if (escolha.charAt(0) == 's' || escolha.charAt(0) == 'S') {
            styleFrases.fraseNarrador(
                    "\n" +
                            "Narrador: " +
                    "\nPerfeito" +
                    "\nVamos ao trabalho" +
                    "\n");
            prepararCurriculo();
        }

        if(escolha.charAt(0) == 'n' || escolha.charAt(0) == 'N') {
            styleFrases.fraseNarrador("\n" +
                    "Narrador: " +
                    "\nCerto " +
                    "\nVamos jogar que jogo ? " +
                    "\nOpções " +
                    "\n" +
                    barra +
                    "\n\t\t\t\t21  " +
                    "\n" +
                    barra +
                    "\nVocê e a máquina em uma disputa por quem faz 21" +
                    "\nVocê tem coragem ? " +
                    "\n ");

            styleFrases.fraseNarrador( barra +
                    "\n\t\tAcerte o número oculto  " +
                    "\n" +
                    barra +
                    "\nA máquina vai sortear 3 números" +
                    "\nE você tem 5 tentativas para acerta" +
                    "\nUm desáfio em tanto né ? " +
                    "\n ");
            while(true){
                try {
                    System.out.print(StyleCores.PERGUNTA+"1 - 21 \n2 - Acerte o número " + StyleCores.RESET);
                    int opcao = input.nextInt();
                    if(opcao == 1){
                        System.out.println();
                        Jogo21 jogo = new Jogo21();
                       jogo.Jogo21_Start();

                        break;
                    }else if(opcao == 2){
                        AdvinheNumeros advinhe = new AdvinheNumeros();
                        advinhe.chuteJogador();
                        break;
                    }else{
                        System.out.println(StyleCores.AMARELO + "\n" + "Essa opção não esta dentro da lista por favor digite um número da lista "  + "\n");
                    }
                }catch (Exception e){
                    System.out.println(StyleCores.VERMELHO+ "Erro: Jogador digitou um tipo diferente do esperado" + StyleCores.RESET);
                }
            }
        }
    }


    public void prepararCurriculo(){
            String nome = "Lucas Gabriel da Silva Pereira";
            String celular = "(83)9999-9990";
            String endereco = "Rua das Rosas amarelas e vermelhas";
            String email = "Lucas@gmail.com";

            System.out.println("\n╔══════════════════════════════════════════════╗");
            System.out.println("║               C U R R Í C U L O              ║");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.println("║  Nome:     " + completar(nome, 34) + "║");
            System.out.println("║  Celular:  " + completar(celular, 34) + "║");
            System.out.println("║  Endereço: " + completar(endereco, 34) + "║");
            System.out.println("║  E-mail:   " + completar(email, 34) + "║");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.println("║  OBJETIVO                                    ║");
            System.out.println("║  Busco por experiência no mercado de trabalho║");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.println("║  FORMAÇÃO ACADÊMICA                          ║");
            System.out.println("║  • Ensino Médio completo (2000)              ║");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.println("║  EXPERIÊNCIA PROFISSIONAL                    ║");
            System.out.println("║  • Em Busca                                  ║");
            System.out.println("╚══════════════════════════════════════════════╝"
            +"\n");
            styleFrases.fraseNarrador("Narrador: " +
                    "\nA hora passa rápido quando estamos ocupados né" +
                    "\nSua mãe te chamou para almoçar");
            dataInicioJogo = dataInicioJogo.plusHours(4);
        System.out.println(StyleCores.AMARELO + dataInicioJogo.getHour() + ":00 "+  "\nHora do almoço" + StyleCores.RESET);

    }

    // Método auxiliar para completar com espaços e alinhar a borda
    public static String completar(String texto, int tamanho) {
        while (texto.length() < tamanho) texto += " ";
        return texto.substring(0, tamanho);
    }



    void main(){
        iniciarEscolhas();
    }
}

