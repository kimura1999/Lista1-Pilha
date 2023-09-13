//2) Escreva uma função para determinar se uma cadeia de caracteres (string) é da forma: a
//D b D c D ... D z onde cada cadeia de caracteres, a, b, ..., z, é da forma do exercício
//descrito acima. Portanto, uma cadeia de caracteres estará no formato correto se consistir
//em qualquer número de cadeias deste tipo ( x C y ), separadas pelo caractere ‘D’. Em cada
//ponto, você só poderá ler o próximo caractere da cadeia (é mandatório o uso de pilha).

import Exemplos.Pilha;

import java.util.Scanner;

public class Questao2 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("digite uma string aDbDcD...: ");

        System.out.println(verificarADB(scan.nextLine()));
    }

    private static boolean verificarADB(String str){
        if(!str.contains("D")) return false;

        Pilha pilha1 = Questao1.converterStringParaPilha(str);

        while(!pilha1.vazia()){
            Pilha pilha2 = new Pilha(20);
            while(pilha1.retornaTopo() != 'D' && !pilha1.vazia()){
                pilha2.push(pilha1.pop());
            }
            pilha1.pop(); //retirar 'D' para proxima iteracao
            if(!Questao1.verificarXCY(pilha2)) return false;
        }

        return true;
    }
}
