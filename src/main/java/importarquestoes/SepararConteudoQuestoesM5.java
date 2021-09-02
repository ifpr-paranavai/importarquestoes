package importarquestoes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class SepararConteudoQuestoesM5 {
    //Modelo 5
    //(Enunciado + Imagem + 4 alternativas texto)
    public void ConverterModelo5() {
        try {

            //Arquivo de texto que será lido e convertido nas questões
            FileReader arq = new FileReader("C:\\Users\\User\\eclipse-workspace\\importarquestoes\\src\\main\\java\\importarquestoes\\texto-questoes\\sistema-circulatorio\\entrada-modelo-5.txt");
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();

            JsonArray questoes = new JsonArray();
            int id = 1;
            while (linha != null) {

                JsonObject questao = new JsonObject();

                questao.addProperty("id", id);
                id++;
                questao.addProperty("escolhida", "não");
                linha = lerArq.readLine();
                questao.addProperty("grupo", linha.trim());
                linha = lerArq.readLine();

                linha = lerArq.readLine();
                linha = lerArq.readLine();
                questao.addProperty("modelo", linha.trim());


                linha = lerArq.readLine();
                linha = lerArq.readLine();
                linha = lerArq.readLine();
                questao.addProperty("enunciado", linha.trim());

                linha = lerArq.readLine();
                linha = lerArq.readLine();
                linha = lerArq.readLine();
                questao.addProperty("imagem", linha.trim());

                linha = lerArq.readLine();
                linha = lerArq.readLine();
                linha = lerArq.readLine();
                questao.addProperty("legendaImagem", linha.trim());

                linha = lerArq.readLine();
                linha = lerArq.readLine();
                linha = lerArq.readLine();


                String alternativa1, alternativa2, alternativa3, alternativa4;

                alternativa1 = linha.trim();
                questao.addProperty("alternativa1", alternativa1);
                linha = lerArq.readLine();

                alternativa2 = linha.trim();
                questao.addProperty("alternativa2", alternativa2);
                linha = lerArq.readLine();


                alternativa3 = linha.trim();
                questao.addProperty("alternativa3", alternativa3);
                linha = lerArq.readLine();


                alternativa4 = linha.trim();
                questao.addProperty("alternativa4", alternativa4);
                linha = lerArq.readLine();


                String[] alternativasCorretas;

                alternativasCorretas = linha.split(",");


                linha = lerArq.readLine();
                linha = lerArq.readLine();
                questao.addProperty("alternativaCorreta", linha.trim());

                linha = lerArq.readLine();
                linha = lerArq.readLine();
                linha = lerArq.readLine();
                questao.addProperty("feedBackImagem", linha.trim());

                linha = lerArq.readLine();
                linha = lerArq.readLine();
                linha = lerArq.readLine();
                questao.addProperty("feedBackLegendaImagem", linha.trim());

                linha = lerArq.readLine();
                linha = lerArq.readLine();
                linha = lerArq.readLine();
                Boolean contFeedback = true;
                String feedback = "";
                while (contFeedback) {
                    if (!linha.trim().equalsIgnoreCase("fim")) {
                        feedback += feedback.equals("") ? linha.trim() : "<br/>" + linha.trim();

                        linha = lerArq.readLine();

                    } else {
                        contFeedback = false;
                    }

                }
                questao.addProperty("feedBackTexto", feedback);
                linha = lerArq.readLine();
                linha = lerArq.readLine();

                questoes.add(questao);

            }

            //Arquivo que será alimentado com as questões
            FileWriter arqSaida2 = new FileWriter("C:\\Users\\User\\eclipse-workspace\\importarquestoes\\src\\main\\java\\importarquestoes\\sistemas\\2-sistema-circulatorio\\saida-modelo-5.txt");
            PrintWriter gravarArq = new PrintWriter(arqSaida2);

            gravarArq.printf(questoes.toString());

            gravarArq.printf("fim!!");

            gravarArq.close();


            arq.close();
        } catch (IOException e) {

            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

        System.out.println();
    }
}
