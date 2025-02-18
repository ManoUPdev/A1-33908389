import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeituraArquivo {
    public static List<Aluno> lerArquivo(String caminhoArquivo) {
        List<Aluno> listaDeAlunos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            System.out.println("Lendo arquivo: " + caminhoArquivo);
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println("Lendo linha: " + linha); // Adicionado para debug
                String[] dados = linha.split("\t");
                if (dados.length >= 3) {
                    String matricula = dados[0];
                    String nome = dados[1];
                    double nota1 = Double.parseDouble(dados[2]);
                    double nota2 = dados.length > 3 ? Double.parseDouble(dados[3]) : -1;

                    Aluno aluno = new Aluno(matricula, nome, nota1, nota2);
                    listaDeAlunos.add(aluno);
                }
            }
            System.out.println("Total de alunos lidos: " + listaDeAlunos.size());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaDeAlunos;
    }
}
