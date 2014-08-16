package br.com.cepep.formacaojava.tratamentoerros;


public class TesteErro2 {
	public static void main(String[] args) {
		System.out.println("inicio do main");
		metodo1();
		System.out.println("Fim do main");
	}

	private static void metodo1() {
		System.out.println("inicio do metodo 1");
		metodo2();
		System.out.println("fim do metodo 1");
	}

	private static void metodo2() {
		System.out.println("inicio do metodo 2");
		int[] arr = new int[10];
		
		try{
			for (int i = 0; i <= 15; i++) {
				int j = arr[i];
				System.out.println(i);
			}
		}catch(ArrayIndexOutOfBoundsException ex){
			ex.printStackTrace();
		}
		
		System.out.println("fim do metodo 2");
	}
}
