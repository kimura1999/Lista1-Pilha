package Questao3;
public class Main {

    public static void main(String[] args) {
        DoubleStack<Character> pilhaTeste = new DoubleStack<Character>(10);

        printarPilha(pilhaTeste);

        pilhaTeste.pushPrimeiraPilha('a');
        pilhaTeste.pushPrimeiraPilha('b');
        pilhaTeste.pushPrimeiraPilha('c');

        pilhaTeste.pushSegundaPilha('d');
        pilhaTeste.pushSegundaPilha('e');
        pilhaTeste.pushSegundaPilha('f');
        pilhaTeste.pushSegundaPilha('g');
        pilhaTeste.pushSegundaPilha('h');
        pilhaTeste.pushSegundaPilha('i');
        pilhaTeste.pushSegundaPilha('k');


        printarPilha(pilhaTeste);

        pilhaTeste.popPrimeiraPilha();
        pilhaTeste.popPrimeiraPilha();
        pilhaTeste.popPrimeiraPilha();
        pilhaTeste.popPrimeiraPilha();

        printarPilha(pilhaTeste);

        pilhaTeste.popSegundaPilha();
        pilhaTeste.popSegundaPilha();
        pilhaTeste.popSegundaPilha();
        pilhaTeste.popSegundaPilha();
        pilhaTeste.popSegundaPilha();
        pilhaTeste.popSegundaPilha();
        pilhaTeste.popSegundaPilha();

        printarPilha(pilhaTeste);



    }

    private static void printarPilha(DoubleStack<Character> pilhaTeste) {
        System.out.println("Esta vazia: " + pilhaTeste.vazia());
        System.out.println("esta cheia: " + pilhaTeste.cheia());
        System.out.println(pilhaTeste);
    }


}
