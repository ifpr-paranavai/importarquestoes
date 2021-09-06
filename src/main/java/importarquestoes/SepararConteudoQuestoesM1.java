package importarquestoes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.*;

public class SepararConteudoQuestoesM1 {
	//Modelo 1
	//(Enunciado + Imagem + Toque pares em texto)
	public void ConverterModelo1() {
		Separador separador = new Separador();
		try {

			//Arquivo de texto que será lido e convertido nas questões
			FileReader arq = new FileReader("C:\\Users\\User\\eclipse-workspace\\importarquestoes\\src\\main\\java\\importarquestoes\\texto-questoes\\"+ separador.sistemas[separador.i] +"\\entrada-modelo-1.txt");
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
				questao.addProperty("imagem", linha.trim());


				linha = lerArq.readLine();
				linha = lerArq.readLine();
				linha = lerArq.readLine();
				questao.addProperty("legendaImagem", linha.trim());


				linha = lerArq.readLine();
				linha = lerArq.readLine();
				linha = lerArq.readLine();

				JsonArray arrayPares = new JsonArray();
				Boolean temPar = true;
				int idPar = 1;
				while (temPar) {

					if (linha.trim().length() > 5) {

						String[] pares = linha.split("=");

						JsonObject par1 = new JsonObject();
						par1.addProperty("id", idPar);
						idPar++;
						par1.addProperty("corBorda", "#F0E68C");
						par1.addProperty("desabilitar", false);
						par1.addProperty("descricao", pares[0].trim());
						par1.addProperty("imagem", "");
						par1.addProperty("idPar", idPar);
						arrayPares.add(par1);

						JsonObject par2 = new JsonObject();
						par2.addProperty("id", idPar);
						idPar++;
						par2.addProperty("corBorda", "#F0E68C");
						par2.addProperty("desabilitar", false);
						par2.addProperty("descricao", pares[1].trim());
						par2.addProperty("imagem", "");
						par2.addProperty("idPar", idPar - 2);
						arrayPares.add(par2);
						linha = lerArq.readLine();

					} else {
						temPar = false;
					}
				}

				System.out.println(arrayPares);
				questao.add("pares", arrayPares);

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
					}else {
						contFeedback=false;
					}

				}
				questao.addProperty("feedBackTexto", feedback);
				linha = lerArq.readLine();
				linha = lerArq.readLine();


				questoes.add(questao);
				separador.setId(id);
			}

			//Arquivo que será alimentado com as questões
		    FileWriter arqSaida = new FileWriter("C:\\Users\\User\\eclipse-workspace\\importarquestoes\\src\\main\\java\\importarquestoes\\sistemas\\" + (separador.i + 1) + "-" + separador.sistemas[separador.i] + "\\saida-modelo-1.txt");
		    PrintWriter gravarArq = new PrintWriter(arqSaida);

			gravarArq.printf(questoes.toString());



		    gravarArq.close();

			arq.close();
		} catch (IOException e) {

			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

		System.out.println();
	}

}
