package Fases01;

import StyleJogo.StyleCores;

public class StyleFrases {
    public  String palavrasMaiores(String texto) {
        StringBuilder sb = new StringBuilder();
        for (char c : texto.toCharArray()) {
            if (c == ' ') sb.append('\u3000');
            else if (c >= '!' && c <= '~') sb.append((char) (c + 0xFEE0));
            else sb.append(c);
        }
        return sb.toString();
    }


    public  void fraseNarrador(String texto) {
        System.out.print(StyleCores.ROXO + StyleCores.NEGRITO);
        for (char c : texto.toCharArray()) {
            System.out.print(c);
            System.out.flush();
            try { Thread.sleep(0); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
        System.out.println(StyleCores.RESET);
    }

    public  void frasesNpcs(String texto) {
        System.out.print(StyleCores.AMARELO + StyleCores.NEGRITO);
        for (char c : texto.toCharArray()) {
            System.out.print(c);
            System.out.flush();
            try { Thread.sleep(0); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
        System.out.println(StyleCores.RESET);
    }

    public  void frasesPersonagemPrincipal(String texto) {
        System.out.print(StyleCores.FALA_PERSONAGEM_P);
        for (char c : texto.toCharArray()) {
            System.out.print(c);
            System.out.flush();
            try { Thread.sleep(0); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
        System.out.println(StyleCores.RESET);
    }
}
