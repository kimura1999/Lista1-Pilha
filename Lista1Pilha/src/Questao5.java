//5) Escreva um programa que leia uma sequência de caracteres e determine se os
//parênteses, colchetes e chaves estão balanceados. Se a sequência não possuir esses
//caracteres ele deve ser considerado balanceado. Exemplo:
//“{ab}[cde]” - Balanceado
//“{ab[cd]efg}” - Balanceado
//“[abcde{efg]}” - Não balanceado

import Exemplos.Pilha;

import java.util.Scanner;

public class Questao5 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("digite uma sequencia de caracteres: ");

        System.out.println(estaBalanceado(scan.nextLine()));
    }

    public static boolean estaBalanceado(String sequencia){
        Pilha pilha = new Pilha(sequencia.length());

        for(int i = 0; i < sequencia.length(); i++) {
            char c = sequencia.charAt(i);
            if (ehChaves(c) || ehColchetes(c) || ehParenteses(c)) pilha.push(sequencia.charAt(i));
        }


        while(!pilha.vazia()){
            char c1 = pilha.pop();
            char c2 = pilha.retornaTopo();

            if(((c1 == '}') && ((c2 == '{') || (c2 == ']') || (c2 == ')'))) ||
              ((c1 == ']') && ((c2 == '[') || (c2 == ')') || (c2 == '}'))) ||
              ((c1 == ')') && ((c2 == '(') || (c2 == ']') || (c2 == '}'))) ||
              ((c1 == '(') || (c1 == '[') || (c1 == '{'))){
                continue;
            }

            else return false;

        }

        return true;
    }

    public static boolean ehColchetes(char c){ return c == ']' || c == '['; }

    public static boolean ehChaves(char c){ return c == '}' || c == '{'; }

    public static boolean ehParenteses(char c){ return c == ')' || c == '('; }

    public static void imprimirPilha(Pilha pilha){
        while(!pilha.vazia()){
            System.out.println(pilha.pop());
        }
    }
}
