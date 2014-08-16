package br.com.cepep.formacaojava.tratamentoerros;

public class TesteErro4 {
	
	public static void main(String[] args) {
		try {
			metodo(3);
		} catch (RuntimeException e) {
			metodo(6);
		}
	}

	private static void metodo(int i) {
		if(i<5)
			throw new RuntimeException("Numero menor do que 5");
		else
			System.out.println("Ok"+ i);
	}

}
