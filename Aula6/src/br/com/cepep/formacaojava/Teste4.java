package br.com.cepep.formacaojava;

public class Teste4 {

	public static int num = 43;
//	public int num = 43;
	
	public static void hello(){
		System.out.println("Hello");
	}

	public static void main(String[] args) {
		System.out.println(Teste4.num);
		Teste4.hello();
		
		Teste4 t4 = new Teste4();
		t4.hello();
		System.out.println(t4.num);
	}
	
	
	

}
