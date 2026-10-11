package Fases01.Jogos.acerteONumero;

import StyleJogo.StyleCores;

import java.util.*;

public class AdvinheNumeros {
    Scanner input = new Scanner(System.in);
    Random random = new Random();
   StyleCores.StyleFrases styleFrases = new StyleCores.StyleFrases();
    List<Integer> numeros;

    public AdvinheNumeros(){
        numeros = new ArrayList<Integer>();
    }

    public List numerosSorteados(){
        for(int i = 0; i < 3; i++){
           int numero = random.nextInt(0,11);
           numeros.add(numero);
        }
        return numeros;
    }

    public List semNumerosIguais(List<Integer> numeros){
        for(int i = 0; i < numeros.size(); i++){
            for(int j = 0; j < numeros.size()-1; j++){
                if(numeros.get(j)==numeros.get(j+1)){
                    System.out.println(numeros.get(j) + " " +  numeros.get(j+1));
                    int novoNumero = numeros.get(j)+1;
                    numeros.set(j, novoNumero);
                }

            }
        }
        return numeros;
    }

    public void chuteJogador() {
        numerosSorteados();
        semNumerosIguais(numeros);
        int chute;
        int tentativa = 5;
        System.out.println(StyleCores.FALA_NARRADOR_CINZA + "Jogo Acerte os Números "+ StyleCores.RESET);
        styleFrases.carregarJogos("......\n");
        System.out.println(StyleCores.FALA_NARRADOR_CINZA + "A máquina já escolheu os numeros" +
                "\n" + StyleCores.RESET);
     while(true){
         try {
             if(tentativa == 0){
                 System.out.println( StyleCores.VERMELHO+"Jogo acabou por falta de tentativas"+ StyleCores.RESET);
                 System.out.println(StyleCores.PERGUNTA + semNumerosIguais(numeros) + StyleCores.RESET);
                 break;

             }
             if(numeros.isEmpty()){
                 System.out.println(StyleCores.AZUL+"Você acertou todos os números" + StyleCores.RESET);
                 System.out.println(StyleCores.PERGUNTA + semNumerosIguais(numeros) + StyleCores.RESET);
                 break;
             }
             System.out.print(StyleCores.PERGUNTA + "Digite um número e tente a sorte: " +  StyleCores.RESET);
             chute = input.nextInt();


             for (int i = 0; i < numeros.size(); i++) {
                 if (numeros.get(i) == chute) {
                     numeros.remove(i);
                     break;
                 }else{
                 tentativa--;
                 break;
                 }
             }
             System.out.println(tentativa);

             input.nextLine();
         } catch (InputMismatchException e) {
             System.out.println(StyleCores.VERMELHO + "Erro: digite apenas números!" + StyleCores.RESET);
             input.nextLine(); // 🔑 essencial: descarta entrada inválida
         }

         System.out.println(StyleCores.PERGUNTA + "Tentativas restantes -> " + tentativa + StyleCores.RESET);
     }

    }

}
