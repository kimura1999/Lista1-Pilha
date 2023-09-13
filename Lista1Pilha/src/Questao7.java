//7) Em sala de aula, aprendemos a avaliar uma expressão aritmética que estivesse em
//notação pós-fixada, que não faz uso de parênteses por não possuir ambiguidade na sua
//avaliação. Neste exercício, você deve utilizar o conceito de Pilha para realizar a avaliação
//de expressões aritméticas em notação infixa, isto é, aquela que aprendemos e utilizamos ao
//longo do Ensino Fundamental e do Ensino Médio. Nesse contexto, vamos usar a seguinte
//definição recursiva: uma expressão aritmética é um número, ou um parêntese esquerdo
//seguido de uma expressão aritmética seguida por um operador seguido por outra expressão
//aritmética seguida de um parêntese direito. Por simplicidade, essa definição assume que a
//expressão está completamente parentizada, especificando precisamente quais operadores
//devem ser aplicados a quais operandos e removendo possíveis ambiguidades na avaliação.
//Por exemplo, a expressão ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) segue essa definição.
//Você deve então implementar um método que realize a avaliação de tais expressões
//representadas em uma String usando o conceito de Pilha. Por fim, cabe citar que o código
//que voces vão desenvolver corresponde a um exemplo simples de um interpretador: um
//programa que interpreta uma computação especificada por uma string e realiza tal
//computação para chegar ao resultado.

import Exemplos.Pilha;
import Exemplos.PilhaGenerica;
import Exemplos.Posfixada;

import java.util.Scanner;

public class Questao7 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("digite uma expressao infixa completamente parentizada e sem espacos: ");
        String expressaoPosfixa = infixToPostfix(scan.nextLine());

        System.out.println(expressaoPosfixa);

        System.out.println(calculaPosfixa(expressaoPosfixa));
    }

    public static String infixToPostfix(String expressaoInfixa){
        String postfix = "";
        Pilha pilhaDeOperadores = new Pilha(expressaoInfixa.length());

        for(int i = 0; i < expressaoInfixa.length(); i++){
            char c = expressaoInfixa.charAt(i);

            if(Character.isDigit(c)) postfix += c;

            else if(c == '(' || c == '+' || c == '-' || c == '*' || c == '/') pilhaDeOperadores.push(c);

            else if(c == ')'){
                while(pilhaDeOperadores.retornaTopo() != '(')
                    postfix += pilhaDeOperadores.pop();

                pilhaDeOperadores.pop(); // retirar '(' da pilha
            }
        }

        return postfix;
    }

    public static int calculaPosfixa(String expressaoPosfixa){
        PilhaGenerica<Integer> resultado = new PilhaGenerica<>(expressaoPosfixa.length());

        for(int i = 0; i < expressaoPosfixa.length(); i++){
            char c = expressaoPosfixa.charAt(i);

            if(Character.isDigit(c))
                resultado.push(Character.getNumericValue(c));

            else
                switch (c) {
                    case '+' -> resultado.push(resultado.pop() + resultado.pop());
                    case '-' -> resultado.push(resultado.pop() - resultado.pop());
                    case '*' -> resultado.push(resultado.pop() * resultado.pop());
                    case '/' -> resultado.push(resultado.pop() / resultado.pop());
                }

        }

        return resultado.pop();
    }
}


