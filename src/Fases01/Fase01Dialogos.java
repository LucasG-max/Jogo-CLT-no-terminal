package Fases01;

import Jogador.Jogador;
import StyleJogo.StyleCores;

public class Fase01Dialogos {
     StyleCores.StyleFrases styleFrases = new StyleCores.StyleFrases();
     Jogador jogador = new Jogador("Lucas");
        public  void apresentacao(){
            styleFrases.fraseNarrador("\"O último sino tocou. Pela primeira vez, você não tem lição de casa para amanhã.\"\n" +
                    "\"O diploma na mão pesa menos do que o silêncio de não saber o que vem depois.\"\n" +
                    "\"Seus colegas gritam, jogam papel no ar. Você só pensa: e agora?\"\n" +
                    "\"Três anos de sala de aula. Zero respostas sobre o que fazer da vida.\"" +
                    "\n ");
            falaAmigoInicial();
            falaPersonagemInicial();
            falaAmigoMeio();
            falaPersonagemMeio();
            styleFrases.fraseNarrador("Narrador: " +
                    "\nVocês dois conversam e tem lembraças do passado que viveram " +
                    "\nBoas risadas e piadas internas " +
                    "\nPórem..." +
                    "\n ");

            falaAmigoFinal();
            falaPersonagemFinal();

            styleFrases.fraseNarrador("Narrador: " +
                    "\nUma despidida difícil" +
                    "\nMas não a última..." +
                    "\nVocê caminha áte o carro junto com Pedro" +
                    "\nE vê ele indo embora" +
                    "\nSeu professor te chama e te fala..." +
                    "\n ");

            falaProfessor();

            styleFrases.fraseNarrador("Narrador: " +
                    "\nVocê não entende muito as palavras ditas " +
                    "\nTalvez seja a dor da despedida ou o medo do futuro incerto" +
                    "\nVocê apenas concorda com um breve sorriso e vai embora ");
        }



        public void falaAmigoInicial(){
            styleFrases.frasesNpcs("Pedro: " +
                    "\n- Cara essa pode ser a última vez que a gente se vê, mas lembre-se nós dois somos irmãos" +
                    "\n- Tivessemos ótimos momentos juntos e várias lembraças" +
                    "\n- Mas toda história tem um final" +
                    "\n- Amanhã meus pais vão se mudar para outra cidade" +
                    "\n- Não sei o nome mas é muito longe daqui" +
                    "\n ");
        }

        public void falaAmigoMeio(){
            styleFrases.frasesNpcs("Pedro: " +
                    "\n- Infelizmente cara..." +
                    "\n- Mas..." +
                    "\n- Nós podemos manter contado" +
                    "\n- Mensagens ou quem sabe uma viajem de volta " +
                    "\n- Enfim... " +
                    "\n ");
        }

    public void falaAmigoFinal(){
            styleFrases.frasesNpcs("Pedro: " +
                    "\n- Meus pais chegaram " +
                    "\n- Tchau e obrigado por tudo " +
                    "\n ");
    }


        public void falaPersonagemInicial(){
            styleFrases.frasesPersonagemPrincipal("Você:" +
                    "\n-Como assim Pedro assim do nada ?" +
                    "\n ");

        }

        public void falaPersonagemMeio(){
            styleFrases.frasesPersonagemPrincipal("Você: " +
                    "\n- È..." +
                    "\n- O importante que sempre seremos amigos Pedro" +
                    "\n- Jamais vou esquecer da nossa amizade" +
                    "\n ");
        }

        public void falaPersonagemFinal(){
            styleFrases.frasesPersonagemPrincipal("Você: " +
                    "\n- Digo o mesmo para Pedro" +
                    "\n- Obrigado por tudo e áte uma próxima" +
                    "\n ");
        }

        public void falaProfessor(){
            styleFrases.frasesNpcs(" Professor:" +
                    "\n- Lembre-se " + jogador.getNome()
                    +"\n- A escola termina. A vida não dá prova recuperação." +
                    "\n ");
        }


}
