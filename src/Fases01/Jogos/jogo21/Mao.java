package Fases01.Jogos.jogo21;

import StyleJogo.StyleCores;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mao {
    Baralho baralho = new Baralho();
    static Maquina maquina = new Maquina();
    private List<String> cartas;
    private Scanner input = new Scanner(System.in);
    StyleCores.StyleFrases styleFrases = new StyleCores.StyleFrases();

    public Mao() {
        cartas = new ArrayList<>();
    }

    public void receberCarta(String carta) {
        cartas.add(carta);
    }

    public int calcularValor(Baralho baralho) {
        int total = 0;
        int quantidadeAs = 0;

        for (String carta : cartas) {
            int valor = baralho.getValor(carta);
            total += valor;
            if (valor == 11) {
                quantidadeAs++;
            }
        }

        while (total > 21 && quantidadeAs > 0) {
            total -= 10;
            quantidadeAs--;
        }
        return total;
    }

    public List<String> cartasNaMao() {
        return new ArrayList<>(cartas);
    }

    @Override
    public String toString() {
        return String.join("  ", cartas);
    }

    public void verificarBlackjack(Mao jogador, Mao maquina, Baralho baralho) {
        int totalJogador = jogador.calcularValor(baralho);
        int totalMaquina = maquina.calcularValor(baralho);

        if (totalJogador == 21 && jogador.cartas.size() == 2) {
            System.out.println(StyleCores.VERDE + "🃏 BLACKJACK! Você ganhou! 🃏\n" + StyleCores.RESET);
        }
        if (totalMaquina == 21 && maquina.cartas.size() == 2) {
            System.out.println(StyleCores.AMARELO + "🃏 BLACKJACK da máquina! Que sorte...\n" + StyleCores.RESET);
        }
    }

    public String ganhador(Mao jogador, Mao maquina, Baralho baralho) {
        int valorJ = jogador.calcularValor(baralho);
        int valorM = maquina.calcularValor(baralho);

        System.out.println("\n--- Resultado ---");
        System.out.println("Suas cartas: " + jogador + " → Total: " + valorJ);
        System.out.println("Máquina: " + maquina + " → Total: " + valorM);

        if (valorJ > 21) {
            System.out.println(StyleCores.VERMELHO + "Você estourou! Máquina ganhou.\n" + StyleCores.RESET);
            return "Máquina";
        }
        if (valorM > 21) {
            System.out.println(StyleCores.VERDE + "Máquina estourou! Você ganhou!\n" + StyleCores.RESET);
            return "Jogador";
        }
        if (valorJ > valorM) {
            System.out.println(StyleCores.VERDE + "Você ganhou!\n" + StyleCores.RESET);
            return "Jogador";
        }
        if (valorM > valorJ) {
            System.out.println(StyleCores.VERMELHO + "Máquina ganhou!\n" + StyleCores.RESET);
            return "Máquina";
        }
        System.out.println(StyleCores.FALA_NARRADOR_CINZA + "Empate!\n" + StyleCores.RESET);
        return "Empate";
    }

    public void comprarCartas(Mao jogador, Baralho baralho) {
        while (true) {

            if (jogador.calcularValor(baralho) >= 21) {
                break;
            }

            try {
                System.out.print(StyleCores.PERGUNTA + "Você deseja comprar uma carta? (sim/não): ");
                String escolha = input.next().trim().toLowerCase();

                if (escolha.equals("sim") || escolha.equals("s")) {
                    jogador.receberCarta(baralho.comprarCartaAleatoria());
                    mensagemJogador(jogador, baralho, jogador.calcularValor(baralho));
                    if (jogador.calcularValor(baralho) >= 21) {
                        break;
                    }
                } else {
                    System.out.println("\nTurno da máquina...\n");
                    break;
                }
            } catch (Exception e) {
                System.out.println(StyleCores.VERMELHO + "Erro: digite apenas 'sim' ou 'não'" + StyleCores.RESET);
                input.nextLine();
            }
        }
    }

    public void maquinaComprar(Mao maquina, Baralho baralho) {
        while (true) {
            int pontos = maquina.calcularValor(baralho);

            if (pontos < 17) {
                maquina.receberCarta(baralho.comprarCartaAleatoria());
                System.out.println(StyleCores.AMARELO + "A máquina comprou uma carta...\n" + StyleCores.RESET);
            } else {
                System.out.println(StyleCores.AMARELO + "A máquina não comprou nesse turno " +  "\n" + StyleCores.RESET);
                break;
            }
        }
    }

    public static void mensagemJogador(Mao jogador, Baralho baralho, int calculo) {
        System.out.println(StyleCores.FALA_PERSONAGEM_P + "Suas cartas: " + jogador);
        if (calculo < 21) {
            System.out.println(StyleCores.FALA_PERSONAGEM_P + "Seu total: " + calculo + StyleCores.RESET);
        } else if (calculo == 21) {
            System.out.println(StyleCores.VERDE_ESCURO_REAL + "Seu total: " + calculo + " ✅" + StyleCores.RESET);
        } else {
            System.out.println(StyleCores.VERMELHO + "Seu total: " + calculo + " (ESTOUROU!)" + StyleCores.RESET);
        }
    }

    public void reiniciarJogo(Mao jogador, Mao maoDamaquina, Baralho baralho) {
        styleFrases.carregarJogos("Reiniciando jogo...\n");

        jogador.limpar();
        maoDamaquina.limpar();
        baralho.limpar();

        jogador.receberCarta(baralho.pegarCartaAleatoria());
        jogador.receberCarta(baralho.pegarCartaAleatoria());
        maoDamaquina.receberCarta(baralho.pegarCartaAleatoria());
        maoDamaquina.receberCarta(baralho.pegarCartaAleatoria());
    }

    public void limpar() {
        cartas.clear();
    }

    public void jogar(Mao jogador, Mao maoDamaquina, Baralho baralho) {
        while (true) {
            jogador.limpar();
            maoDamaquina.limpar();
            baralho.limpar();

            jogador.receberCarta(baralho.pegarCartaAleatoria());
            jogador.receberCarta(baralho.pegarCartaAleatoria());
            maoDamaquina.receberCarta(baralho.pegarCartaAleatoria());
            maoDamaquina.receberCarta(baralho.pegarCartaAleatoria());

            mensagemJogador(jogador, baralho, jogador.calcularValor(baralho));
            verificarBlackjack(jogador, maoDamaquina, baralho);

            if (jogador.calcularValor(baralho) != 21) {
                comprarCartas(jogador, baralho);
                maquinaComprar(maoDamaquina, baralho);
            }

            ganhador(jogador, maoDamaquina, baralho);

            System.out.print(StyleCores.PERGUNTA + "Jogar novamente? (s/n): ");
            char resposta;
            try {
                resposta = input.next().trim().charAt(0);
            } catch (Exception e) {
                System.out.println(StyleCores.VERMELHO + "Entrada inválida" + StyleCores.RESET);
                input.nextLine();
                continue;
            }

            if (resposta == 's' || resposta == 'S') {
                continue;
            } else {
                System.out.println(StyleCores.PERGUNTA + "Fim de jogo! Obrigado por jogar 🃏" + StyleCores.RESET);
                break;
            }
        }
    }
}