import java.util.Scanner;

class Comparar{

	public static void main(String[] args){
		
		Scanner entrada = new Scanner(System.in);				System.out.println("Digite o primeiro valor");
		int v1 = entrada.nextInt();
		System.out.println("Digite o segundo valor");
		int v2 = entrada.nextInt();
		
		if(v1==v2){
			System.out.println(v1+" é igual a "+v2);
		}
		
		if(v1>v2){
			System.out.println("Valor 1 é maior");
		}

		if(v1<v2){			
			System.out.println("Valor 2 é maior");
		}
	}

}