import java.util.Scanner;


public class MediaIdadeVetores {

	/**
	 * @param Calcular a média e imprimir maior e menor idades de uma turma
	 * usando vetores
	 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int qtdAlunos = 0;
		int maiorIdade = 0;
		int menorIdade = 200;
		int somaIdades = 0;
		float mediaIdades;
		int[] idades;
		
		System.out.println("Quantos alunos a turma possui?");
		
		qtdAlunos = scanner.nextInt();
		idades = new int[qtdAlunos];
		
		for (int i = 0; i < idades.length; i++) {
			System.out.println("Qual a idade do aluno "+(i+1)+" ?");
			idades[i] = scanner.nextInt();
			somaIdades += idades[i];
		}
		
		for (int i = 0; i < idades.length; i++) {
			if(idades[i] > maiorIdade)
				maiorIdade = idades[i];
			if(idades[i] < menorIdade)
				menorIdade = idades[i];
		}
		
		mediaIdades = (float) somaIdades / qtdAlunos;
		
		System.out.println("A média das idades é de "+mediaIdades+" anos");
		System.out.println("A maior idade é "+maiorIdade+" anos");
		System.out.println("A menor3 idade é "+menorIdade+" anos");
		
	}

}
