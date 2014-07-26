import java.util.Date;
import java.util.Scanner;

class TesteSalario2 {

	public static void main(String[] args) {

		int salario;
		int ir;
		int salarioliq;
		
		Date data = new Date();
		data.getHours();
		
		
		int valorLimiteFinanciamento = 1900;

		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o salario:");
		salario = entrada.nextInt();
		System.out.println("Digite o IR:");
		ir = entrada.nextInt();

		salarioliq = salario - ir;
		
		if(salarioliq > valorLimiteFinanciamento){
			System.out.println("Financiamento aprovado");
		}else{
			System.out.println("Financiamento reprovado");
			System.out.println("Solicita emprestimo?");
			
			Scanner entrada2 = new Scanner(System.in);
			String resposta = entrada2.nextLine();
			
			if(resposta.equals("s") || resposta.equals("S")){
				System.out.println("Valor do emprestimo?");
				int emprestimo = entrada.nextInt();	
				System.out.println("Emprestimo de "+ emprestimo +" solicitado");
			}else{
				System.out.println("Financiamento negado");	
			}
			
		}

	}

}