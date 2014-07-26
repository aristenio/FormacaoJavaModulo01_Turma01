import java.util.Scanner;


public class TesteWhile3 {

	public static void main(String[] args) {
		
		int controle = 5;
		int contador = 0;
		
		do{
			System.out.println("Digite o numero "+controle);
			
			Scanner scanner = new Scanner(System.in);
			int digitado = scanner.nextInt();
			
			if(digitado==controle)
				break;
			else			
				System.out.println("Deixe de ser teimoso!");
			
			contador++;
			
			if(contador>3){
				System.out.println("pedi demais");
				break;
			}
				
		}while(true);

		System.out.println("Obrigado. Eu pedi "+contador+" vez(es)");

	}

}
