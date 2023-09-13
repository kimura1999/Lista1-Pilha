//4) Utilizando as operações de manipulação de pilhas vistas em aula, assim como o código
//de PilhaGenerica visto, use uma pilha auxiliar e uma variável do tipo T, para desenvolver
//um procedimento que remova um dado objeto do tipo T de uma posição qualquer de uma
//pilha. Para saber se dois objetos do tipo T são iguais, você deve usar o método equals (ou
//compareTo). Note que você não pode acessar diretamente a estrutura interna da pilha
//(atributos), devendo usar apenas as operações (métodos) de manipulação.

import Exemplos.PilhaGenerica;

import java.util.Scanner;

public class Questao4 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("digite quantidade de elementos da pilha: ");
        int qtdElementos = scan.nextInt();

        PilhaGenerica<Character> pilha = new PilhaGenerica<>(qtdElementos);

        System.out.println("digite os caracteres da pilha:");

        for(int i = 0; i < qtdElementos; i++){
            System.out.print((i+1) + ". ");
            pilha.push(scan.next().charAt(0));
        }

        System.out.println("digite o elemento que sera removido da pilha: ");
        removerElementoDaPilha(pilha, scan.next().charAt(0));

        System.out.println("Elementos da pilha:");
        while(!pilha.vazia())
            System.out.println(pilha.pop());
    }

    public static <T> boolean removerElementoDaPilha(PilhaGenerica<T> pilha, T elementoQueDeveSerRemovido){
        PilhaGenerica<T> pilhaAuxiliar = new PilhaGenerica<>(10);
        boolean achouElementoQueDeveSerRemovido = false;

        while(!pilha.vazia() && !achouElementoQueDeveSerRemovido){
            T topoDaPilha = pilha.pop();

            if(!topoDaPilha.equals(elementoQueDeveSerRemovido)) pilhaAuxiliar.push(topoDaPilha);

            else achouElementoQueDeveSerRemovido = true;
        }

        while(!pilhaAuxiliar.vazia()){
            pilha.push(pilhaAuxiliar.pop());
        }

        return achouElementoQueDeveSerRemovido;
    }
}
