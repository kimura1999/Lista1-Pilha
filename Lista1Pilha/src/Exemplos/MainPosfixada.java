package Exemplos;

public class MainPosfixada
{
	public static void main(String args[])
	{
		Posfixada pos = new Posfixada(100);
		
		pos.leExpressao("13+");
		
		pos.avaliaExpressao();
		
		pos.imprimeResposta();
	}
}
