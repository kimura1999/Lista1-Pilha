//6) Elabore um método que retorne as letras invertidas das palavras de uma frase recebida
//por parâmetro, preservando a ordem das palavras na frase. Por exemplo “a maçã está
//podre”, deve ter como saída: “a ãçam átse erdop”. As operações básicas de uma pilha,
//push e pop, devem ser usadas.

import Exemplos.Pilha;

import java.util.Scanner;

public class Questao6 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite uma frase: ");
        String frase = scan.nextLine();

        System.out.println("frase com palavras invertidas:\n" + inverterPalavras(frase));
    }

    public static String inverterPalavras(String frase){
        frase = " " + frase;
        String frasePalavrasInvertidas = "";

        {
            int i = 0;
            while(i < frase.length()){
                Pilha pilha = new Pilha(20);
                if(frase.charAt(i) == ' ') {
                    i++;
                    while(i < frase.length() && frase.charAt(i) != ' '){
                        pilha.push(frase.charAt(i++));
                    }
                }

                while(!pilha.vazia())
                    frasePalavrasInvertidas += pilha.pop();

                frasePalavrasInvertidas += ' ';

            }
        }

        return frasePalavrasInvertidas;
    }
}
