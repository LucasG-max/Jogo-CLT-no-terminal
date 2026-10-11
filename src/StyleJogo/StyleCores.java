package StyleJogo;

public class StyleCores {
    public static final String FALA_NARRADOR_CINZA = "\u001B[90m";
    public static final String FALA_PERSONAGEM_P = "\u001B[1;96m";
    public static final String RESET = "\u001B[0m";
    public static final String VERMELHO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARELO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String ROXO = "\u001B[35m";
    public static final String VERDE_ESCURO_REAL = "\u001B[38;5;22m";
    public static final String NEGRITO = "\u001B[1m";
    public static final String SUBLINHADO = " \u001B[4m";
    public static final String PERGUNTA = "\u001B[1;93m";

    public static class StyleFrases {
        public String palavrasMaiores(String texto) {
            StringBuilder sb = new StringBuilder();
            for (char c : texto.toCharArray()) {
                if (c == ' ') sb.append('\u3000');
                else if (c >= '!' && c <= '~') sb.append((char) (c + 0xFEE0));
                else sb.append(c);
            }
            return sb.toString();
        }


        public void fraseNarrador(String texto) {
            System.out.print(ROXO + NEGRITO);
            for (char c : texto.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(RESET);
        }

        public void frasesNpcs(String texto) {
            System.out.print(AMARELO + NEGRITO);
            for (char c : texto.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(RESET);
        }

        public void frasesPersonagemPrincipal(String texto) {
            System.out.print(FALA_PERSONAGEM_P);
            for (char c : texto.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(RESET);
        }

        public  void carregarJogos(String texto) {
            System.out.print(ROXO + NEGRITO);
            for (char c : texto.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                try { Thread.sleep(400); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }
            System.out.print(RESET);
        }
    }


}
