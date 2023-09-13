//1) Escreva uma função para determinar se uma cadeia de caracteres (string) é da forma: x
//C y onde x e y são cadeias de caracteres compostas por letras ‘A’ e/ou ‘B’, e y é o inverso
//de x. Isto é, se x = “ABABBA”, y deve equivaler a “ABBABA”. Em cada ponto, você só
//poderá ler o próximo caractere da cadeia.

import Exemplos.Pilha;

import java.util.Scanner;

public class Questao1 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("digite uma string xCy: ");
        String str = scan.nextLine();

        System.out.println(verificarXCY(converterStringParaPilha(str)));
    }

    public static Pilha converterStringParaPilha(String str){
        Pilha pilhaDeCaracteres = new Pilha(str.length());
        for(int i = 0; i < str.length(); i++)
            pilhaDeCaracteres.push(str.charAt(i));

        return pilhaDeCaracteres;
    }

    public static boolean verificarXCY(Pilha pilha1){
        Pilha pilha2 = new Pilha(20);

        //loop para colocar os caracteres na pilha2 ate 'C'
        do{
            pilha2.push(pilha1.pop());
        }while(pilha1.retornaTopo() != 'C' && !pilha1.vazia());

        //nao ha 'C' na cadeia de caracteres
        if(pilha1.vazia()) return false;

        pilha1.pop(); //retirar 'C' da pilha1

        //comparar pilha1 com pilha2
        do{
            if(pilha1.pop() != pilha2.pop())
                return false; //pilhas nao sao semelhantes, logo x nao eh semelhante a y

        }while(!pilha1.vazia() && !pilha2.vazia());

        //pilhas de tamanhos diferentes; logo, x nao eh semelhante a y
        if(!(pilha1.vazia() && pilha2.vazia())) return false;

        return true;
    }
}
