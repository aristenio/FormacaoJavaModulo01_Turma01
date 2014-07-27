import java.util.Scanner;


public class MediaIdadeVetoresComNomes {

	/**
	 * @param Calcular a média e imprimir maior e menor idades de uma turma
	 * usando vetores
	 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		int qtdAlunos = 0;
		int somaIdades = 0;
		float mediaIdades;
		int[] idades;
		String[] nomes;
		int indiceMaiorIdade = 0;
		int indiceMenorIdade = 0;
		
		System.out.println("Quantos alunos a turma possui?");
		
		qtdAlunos = scanner.nextInt();
		idades = new int[qtdAlunos];
		nomes = new String[qtdAlunos];
		
		for (int i = 0; i < idades.length; i++) {
			System.out.println("Qual a idade do aluno "+(i+1)+" ?");
			idades[i] = scanner.nextInt();
			somaIdades += idades[i];

			System.out.println("Qual nome do aluno "+(i+1)+" ?");
			nomes[i] = scanner2.nextLine();
		}
		
		for (int i = 0; i < idades.length; i++) {
			if(idades[i] > idades[indiceMaiorIdade]){
				indiceMaiorIdade = i;
			}
			if(idades[i] < idades[indiceMenorIdade]){
				indiceMenorIdade = i;
			}
		}
		
		mediaIdades = (float) somaIdades / qtdAlunos;
		
		System.out.println("A média das idades é de "+mediaIdades+" anos");
		System.out.println("A maior idade é "+idades[indiceMaiorIdade]+" anos do "+nomes[indiceMaiorIdade]);
		System.out.println("A menor3 idade é "+idades[indiceMenorIdade]+" anos do "+nomes[indiceMenorIdade]);
		
	}

}
