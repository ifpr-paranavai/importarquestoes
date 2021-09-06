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

public class SepararConteudoQuestoesM2 {
    //Modelo 2
    //(Enunciado + Várias alternativas corretas em texto)
    public void ConverterModelo2() {
        Separador separador = new Separador();
        try {

            //Arquivo de texto que será lido e convertido nas questões
            FileReader arq = new FileReader("C:\\Users\\User\\eclipse-workspace\\importarquestoes\\src\\main\\java\\importarquestoes\\texto-questoes\\" + separador.sistemas[separador.i] + "\\entrada-modelo-2.txt");
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();

            JsonArray questoes = new JsonArray();
            int id = separador.getId();
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


                String alternativa1, alternativa2, alternativa3, alternativa4, alternativa5, alternativa6;

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


                alternativa5 = linha.trim();
                questao.addProperty("alternativa5", alternativa5);
                linha = lerArq.readLine();


                alternativa6 = linha.trim();
                questao.addProperty("alternativa6", alternativa6);
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

                separador.setId(id);

            }

            //Arquivo que será alimentado com as questões
            FileWriter arqSaida2 = new FileWriter("C:\\Users\\User\\eclipse-workspace\\importarquestoes\\src\\main\\java\\importarquestoes\\sistemas\\" + (separador.i + 1) + "-" + separador.sistemas[separador.i] + "\\saida-modelo-2.txt");
            PrintWriter gravarArq = new PrintWriter(arqSaida2);

            gravarArq.printf(questoes.toString());

             

            gravarArq.close();


            arq.close();
        } catch (IOException e) {

            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

        System.out.println();
    }
}
