
public class MediaIdade {

	/**
	 * Programa que calcula a média de idade de 5 alunos
	 */
	public static void main(String[] args) {
		
		int[] idades = new int[]{1,2,3};
		
		int idadeAluno1 = 15;
		int idadeAluno2 = 12;
		int idadeAluno3 = 17;
		int idadeAluno4 = 18;
		int idadeAluno5 = 21;
		
		int maiorIdade = 0;
		int menorIdade = 200;
		
		int somaIdades = idadeAluno1 + idadeAluno2 + idadeAluno3 + idadeAluno4 + idadeAluno5;
		float mediaIdades = somaIdades / 5;
		
		System.out.println("A média de idade da turma é de "+mediaIdades+ " anos");
		
		if(idadeAluno1 > maiorIdade)
			maiorIdade = idadeAluno1;

		if(idadeAluno2 > maiorIdade)
			maiorIdade = idadeAluno2;

		if(idadeAluno3 > maiorIdade)
			maiorIdade = idadeAluno3;
		
		if(idadeAluno4 > maiorIdade)
			maiorIdade = idadeAluno4;
		
		if(idadeAluno5 > maiorIdade)
			maiorIdade = idadeAluno5;

		if(idadeAluno1 < menorIdade)
			menorIdade = idadeAluno1;

		if(idadeAluno2 < menorIdade)
			menorIdade = idadeAluno2;
		
		if(idadeAluno3 < menorIdade)
			menorIdade = idadeAluno3;
		
		if(idadeAluno4 < menorIdade)
			menorIdade = idadeAluno4;

		if(idadeAluno5 < menorIdade)
			menorIdade = idadeAluno5;
		
		
		System.out.println("A maior idade da turma é: "+maiorIdade);
		System.out.println("A menor idade da turma é: "+menorIdade);
	}

}
