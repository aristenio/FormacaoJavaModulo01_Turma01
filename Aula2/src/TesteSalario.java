import java.util.Scanner;

class TesteSalario {

	public static void main(String[] args) {
		int salario;
		int ir;
		int salarioliq;

		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o salario:");
		salario = entrada.nextInt();
		System.out.println("Digite o IR:");
		ir = entrada.nextInt();

		salarioliq = salario - ir;

		System.out
				.println("Sal�rio � maior do que 100? " + (salarioliq >= 100));
		System.out.println("Sal�rio � menor do que 190? " + (salarioliq < 190));
		System.out.println("Sal�rio liquido: " + salarioliq);

	}

}