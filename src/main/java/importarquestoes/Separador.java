package importarquestoes;

import java.util.List;

public class Separador {

    public static int id;

    public static int i = 0;

    public String[] sistemas = new String[]{
            "sistema-digestorio",
            "sistema-circulatorio",
            "sistema-respiratorio",
            "sistema-urinario",
            "sistema-reprodutor",
            "sistema-esqueletico",
            "sistema-muscular",
            "sistema-endocrino",
            "sistema-nervoso",
            "os-sentidos"
    };

    public void SepararConteudos(){

        SepararConteudoQuestoesM1 modelo1 = new SepararConteudoQuestoesM1();
        SepararConteudoQuestoesM2 modelo2 = new SepararConteudoQuestoesM2();
        SepararConteudoQuestoesM3 modelo3 = new SepararConteudoQuestoesM3();
        SepararConteudoQuestoesM4 modelo4 = new SepararConteudoQuestoesM4();
        SepararConteudoQuestoesM5 modelo5 = new SepararConteudoQuestoesM5();
        SepararConteudoQuestoesM6 modelo6 = new SepararConteudoQuestoesM6();

        for(int d=0;d<=9;d++){

            System.out.println(i);

            System.out.println("\n\n");
            System.out.println(sistemas[i].toUpperCase());

            System.out.println("\n\n");
            System.out.println("QUESTOES MODELO 1\n\n");
            modelo1.ConverterModelo1();

            System.out.println("\n\n");
            System.out.println("QUESTOES MODELO 2\n\n");
            modelo2.ConverterModelo2();

            System.out.println("\n\n");
            System.out.println("QUESTOES MODELO 3\n\n");
            modelo3.ConverterModelo3();

            System.out.println("\n\n");
            System.out.println("QUESTOES MODELO 4\n\n");
            modelo4.ConverterModelo4();

            System.out.println("\n\n");
            System.out.println("QUESTOES MODELO 5\n\n");
            modelo5.ConverterModelo5();

            System.out.println("\n\n");
            System.out.println("QUESTOES MODELO 6\n\n");
            modelo6.ConverterModelo6();

            i++;
        }
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Separador.id = id;
    }
}
