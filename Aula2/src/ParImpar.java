import java.util.Scanner;

class ParImpar{

	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);				System.out.println("Digite um numero");
		int numero = entrada.nextInt();
		int resto = numero%2;
		if(resto>0){
			System.out.println("Impar");
		}else{
			System.out.println("Par");	
		}
	}

}