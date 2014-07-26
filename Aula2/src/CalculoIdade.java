import java.util.Scanner;

class CalcularIdade{

	//static int idade = 22.5;	

	public static void main(String[] args){
		
		Scanner entrada = new Scanner(System.in);			System.out.println("Digite sua idade");
		int idade = entrada.nextInt();
		int idadeAnoQueVem = idade + 1;
		System.out.println("Sua idade ano que vem será: "+idadeAnoQueVem);

	}

}