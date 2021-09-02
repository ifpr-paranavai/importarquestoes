package importarquestoes;

public class Main {

    public static void main(String[] args) {
        SepararConteudoQuestoesM1 modelo1 = new SepararConteudoQuestoesM1();
        SepararConteudoQuestoesM2 modelo2 = new SepararConteudoQuestoesM2();
        SepararConteudoQuestoesM3 modelo3 = new SepararConteudoQuestoesM3();
        SepararConteudoQuestoesM4 modelo4 = new SepararConteudoQuestoesM4();
        SepararConteudoQuestoesM5 modelo5 = new SepararConteudoQuestoesM5();


        System.out.printf("\n\n");
        System.out.printf("QUESTOES MODELO 1\n\n");
        modelo1.ConverterModelo1();

        System.out.printf("\n\n");
        System.out.printf("QUESTOES MODELO 2\n\n");
        modelo2.ConverterModelo2();

        System.out.printf("\n\n");
        System.out.printf("QUESTOES MODELO 3\n\n");
        modelo3.ConverterModelo3();

        System.out.printf("\n\n");
        System.out.printf("QUESTOES MODELO 4\n\n");
        modelo4.ConverterModelo4();

        System.out.printf("\n\n");
        System.out.printf("QUESTOES MODELO 5\n\n");
        modelo5.ConverterModelo5();
    }
}
