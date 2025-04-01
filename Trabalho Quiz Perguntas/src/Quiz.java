import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {

    // Classe Cabeçalho
    public static class Cabecalho {
        private final String faculdade;
        private final String aluna;
        private final String professor;
        private final String tema;

        public Cabecalho(String faculdade, String aluna, String professor, String tema) {
            this.faculdade = faculdade;
            this.aluna = aluna;
            this.professor = professor;
            this.tema = tema;
        }

        public void exibir() {
            System.out.println("Faculdade: " + faculdade);
            System.out.println("Aluna: " + aluna);
            System.out.println("Professor: " + professor);
            System.out.println("Tema: " + tema);
            System.out.println();
        }
    }

    // Classe Questao
    public static class Questao {
        private final String pergunta;
        private final String opcaoA;
        private final String opcaoB;
        private final String opcaoC;
        private final String opcaoD;
        private final String opcaoE;
        private final String correta;

        public Questao(String pergunta, String opcaoA, String opcaoB, String opcaoC,
                       String opcaoD, String opcaoE, String correta) {
            this.pergunta = pergunta;
            this.opcaoA = opcaoA;
            this.opcaoB = opcaoB;
            this.opcaoC = opcaoC;
            this.opcaoD = opcaoD;
            this.opcaoE = opcaoE;
            this.correta = correta.toUpperCase();
        }

        public boolean isCorreta(String resposta) {
            return resposta.equalsIgnoreCase(this.correta);
        }

        public void exibirQuestao() {
            System.out.println(pergunta);
            System.out.println("A) " + opcaoA);
            System.out.println("B) " + opcaoB);
            System.out.println("C) " + opcaoC);
            System.out.println("D) " + opcaoD);
            System.out.println("E) " + opcaoE);
        }
    }

    public static void main(String[] args) {
        Cabecalho cabecalho = new Cabecalho("Unifan - Centro Universitário Alfredo Nasser", "Tannia", "Prof. Brenno", "Instrumentos Musicais");
        cabecalho.exibir();

        List<Questao> questoes = inicializarQuestoes();
        executarQuiz(questoes);
    }

    private static List<Questao> inicializarQuestoes() {
        List<Questao> questoes = new ArrayList<>();

        // Questão 1
        questoes.add(new Questao("Qual instrumento é conhecido como 'rei dos instrumentos'?",
                "Violino", "Piano", "Harpa", "Flauta", "Trompete", "B"));

        // Questão 2
        questoes.add(new Questao("Qual destes instrumentos pertence à família das cordas?",
                "Trompete", "Trombone", "Violoncelo", "Bateria", "Clarinete", "C"));

        // Questão 3
        questoes.add(new Questao("Qual instrumento é essencial em uma banda de samba?",
                "Violão", "Pandeiro", "Órgão", "Saxofone", "Tuba", "B"));

        // Questão 4
        questoes.add(new Questao("Qual destes instrumentos é de sopro?",
                "Violão", "Bateria", "Guitarra", "Flauta Doce", "Baixo", "D"));

        // Questão 5
        questoes.add(new Questao("Qual instrumento tem 88 teclas?",
                "Violino", "Acordeon", "Piano", "Órgão", "Xilofone", "C"));

        // Questão 6
        questoes.add(new Questao("Qual destes instrumentos é típico do jazz?",
                "Harpa", "Gaita de Foles", "Saxofone", "Cavaquinho", "Trompa", "C"));

        // Questão 7
        questoes.add(new Questao("Qual instrumento é tocado com arco?",
                "Piano", "Violino", "Flauta", "Trompete", "Bateria", "B"));

        // Questão 8
        questoes.add(new Questao("Qual destes instrumentos é de percussão?",
                "Violoncelo", "Trombone", "Xilofone", "Clarinete", "Oboé", "C"));

        // Questão 9
        questoes.add(new Questao("Qual instrumento é símbolo do rock?",
                "Guitarra Elétrica", "Harpa", "Clarinete", "Trombone", "Flauta", "A"));

        // Questão 10
        questoes.add(new Questao("Qual destes instrumentos é mais agudo?",
                "Tuba", "Violino", "Contrabaixo", "Trombone", "Fagote", "B"));

        // Questão 11
        questoes.add(new Questao("Qual instrumento tem formato triangular?",
                "Violão", "Piano", "Harpa", "Trompete", "Clarinete", "C"));

        // Questão 12
        questoes.add(new Questao("Qual destes instrumentos é brasileiro?",
                "Bandolim", "Cavaquinho", "Banjo", "Balalaica", "Sitar", "B"));

        // Questão 13
        questoes.add(new Questao("Qual instrumento é tocado com palhetas?",
                "Trompa", "Violoncelo", "Guitarra", "Tuba", "Flauta", "C"));

        // Questão 14
        questoes.add(new Questao("Qual destes instrumentos tem pedais?",
                "Violino", "Harpa", "Trompete", "Clarinete", "Flauta", "B"));

        // Questão 15
        questoes.add(new Questao("Qual instrumento é conhecido como 'violino chinês'?",
                "Erhu", "Koto", "Shamisen", "Taiko", "Didgeridoo", "A"));

        return questoes;
    }

    private static void executarQuiz(List<Questao> questoes) {
        Scanner scanner = new Scanner(System.in);
        int acertos = 0;

        System.out.println("Bem-vindo ao Quiz de Instrumentos Musicais!");
        System.out.println("Responda com a letra correspondente à opção correta (A, B, C, D ou E).\n");

        for (int i = 0; i < questoes.size(); i++) {
            System.out.println("Questão " + (i + 1) + ":");
            Questao questao = questoes.get(i);
            questao.exibirQuestao();

            System.out.print("Sua resposta: ");
            String resposta = scanner.nextLine().trim().toUpperCase();

            if (questao.isCorreta(resposta)) {
                System.out.println("✅ Resposta Correta!\n");
                acertos++;
            } else {
                System.out.println("❌ Resposta Incorreta! A correta é: " + questao.correta + "\n");
            }
        }

        scanner.close();
        exibirResultado(acertos, questoes.size());
    }

    private static void exibirResultado(int acertos, int totalQuestoes) {
        double percentual = (double) acertos / totalQuestoes * 100;
        System.out.println("\n=== RESULTADO FINAL ===");
        System.out.println("Você acertou " + acertos + " de " + totalQuestoes + " questões.");
        System.out.printf("Percentual de acertos: %.1f%%\n", percentual);

        if (percentual >= 90) {
            System.out.println("🎼 Excelente! Você é um expert em instrumentos musicais!");
        } else if (percentual >= 70) {
            System.out.println("👍 Bom trabalho! Você conhece bem instrumentos musicais!");
        } else if (percentual >= 50) {
            System.out.println("🤔 Não foi mal, mas pode melhorar. Estude mais!");
        } else {
            System.out.println("😅 Precisa praticar mais sobre instrumentos musicais!");
        }
    }
}