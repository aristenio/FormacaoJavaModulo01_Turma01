import java.util.Scanner;


public class Calculadora {

	public static void main(String[] args) {
		
		System.out.println("Bem vindo a calculadora as operações aceitas são + - * / ou 's' para sair do programa");
		w1:while(true){

			Scanner scanner = new Scanner(System.in);
			System.out.println("Digite a operação:");
			char operacao = scanner.next().charAt(0);
			
			if(operacao == 's')
				break;
			
			System.out.println("Digite o primeiro numero:");
			int primeiro = scanner.nextInt();
			System.out.println("Digite o segundo numero:");
			int segundo = scanner.nextInt();
			
			int resultado = 0;
			
			switch (operacao) {
			case '+':
				resultado = primeiro + segundo;
				break;
			case '-':
				resultado = primeiro - segundo;
				break;
			case '*':
				resultado = primeiro * segundo;
				break;
			case '/':
				resultado = primeiro / segundo;
				break;
			case 's':
				break w1;
			default:
				break;
			}
			
			System.out.println("Resultado: "+resultado);
			
		}
	}

}
