import java.util.Scanner;


public class EscolheTenis {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Qual o numero do tenis?");
		int numeroTenis = entrada.nextInt();
		
		System.out.print("Cor disponivel:");
		switch (numeroTenis) {
		case 40:
			System.out.print("Branco,");
		case 41:
			System.out.print("Preto,");
			break;
		case 42:
			System.out.print("Azul");
			break;
		default:
			System.out.println("Amarelo");
			break;
		}

	}

}
