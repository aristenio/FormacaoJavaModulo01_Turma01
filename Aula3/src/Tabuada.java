import java.util.Scanner;

public class Tabuada {

	/**
	 * @param Exercicio
	 *            para criar uma tabuada utilizando array de arrays
	 */
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite a operação:");
		char operacao = scanner.next().charAt(0);

		float[][] tabuada = new float[10][10];

		if (operacao == '/') {
			for (int i = 10, k = 0; i > 0; i--, k++) {
				for (int j = 0; j < tabuada[k].length; j++) {
					tabuada[k][j] = (float) (i) / (j + 1);
				}

			}
		} else {
			for (int i = 0; i < tabuada.length; i++) {
				for (int j = 0; j < tabuada[i].length; j++) {
					switch (operacao) {
					case '+':
						tabuada[i][j] = (i + 1) + (j + 1);
						break;
					case '-':
						tabuada[i][j] = (i + 1) - (j + 1);
						break;
					case '*':
						tabuada[i][j] = (i + 1) * (j + 1);
						break;
					default:
						break;
					}

				}
			}
		}

		if (operacao == '/') {
			for (int i = 10, k = 0; i > 0; i--, k++) {
				for (int j = 0; j < tabuada[k].length; j++) {
					if(tabuada[k][j]>1){
						System.out.println(i + " " + operacao + " " + (j + 1) + "=" + (tabuada[k][j]));
					}
				}

			}
		}else{
			for (int i = 0; i < tabuada.length; i++) {
				for (int j = 0; j < tabuada[i].length; j++) {
					System.out.println((i + 1) + " " + operacao + " " + (j + 1)	+ "=" + tabuada[i][j]);
				}
			}
		}

	}

}
