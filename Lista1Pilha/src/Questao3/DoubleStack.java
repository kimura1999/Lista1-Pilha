package Questao3;

public class DoubleStack<T> {

    private T[] vet;
    private int topoPrimeiraPilha;
    private int topoSegundaPilha;

    public DoubleStack(int length){
        vet = (T[]) new Object[length];
        topoPrimeiraPilha = -1;
        topoSegundaPilha = length;
    }

    public boolean cheia() { return (topoPrimeiraPilha + 1) == topoSegundaPilha; }

    public boolean vazia() { return topoPrimeiraPilha == -1 && topoSegundaPilha == vet.length; }

    public boolean retornaTopoDaPrimeiraPilha(T elemento) {
        if(!vazia()){
            elemento = vet[topoPrimeiraPilha];
            return true;
        }

        else{
            return false;
        }
    }

    public boolean retornaTopoDaSegundaPilha(T elemento) {
        if(!vazia()){
            elemento = vet[topoSegundaPilha];
            return true;
        }

        else{
            return false;
        }
    }

    public boolean pushPrimeiraPilha(T elemento){
        if(!cheia()){
            vet[++topoPrimeiraPilha] = elemento;
            return true;
        }

        else return false;
    }

    public boolean pushSegundaPilha(T elemento){
        if(!cheia()){
            vet[--topoSegundaPilha] = elemento;
            return true;
        }

        else return false;
    }

    public T popPrimeiraPilha(){
        if(topoPrimeiraPilha != -1){
            T elemento = vet[topoPrimeiraPilha--];
            return elemento;
        }

        else return null;
    }

    public T popSegundaPilha(){
        if(topoSegundaPilha != vet.length){
            T elemento = vet[topoSegundaPilha++];
            return elemento;
        }

        else return null;
    }

    // para verificar se ta tudo certo
    @Override
    public String toString() {
        String str = "";

        str += "primeira pilha:\n";
        for(int i = topoPrimeiraPilha; i >= 0; i--)
            str += vet[i] + "\n";

        str += "\nsegunda pilha:\n";
        for(int i = topoSegundaPilha; i < vet.length; i++)
            str += vet[i] + "\n";

        return str;

    }
}
