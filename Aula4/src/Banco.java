import java.util.Scanner;


public class Banco {
	
	public static String nome = "Banco CEPEP";
	public static Agencia[] agencias = new Agencia[5];
	public static Agencia agenciaSelecionada;
	public static ContaBancaria contaSelecionada;
	
	public static void main(String[] args) {
		criarAgencias();
		menu();
	}
	
	private static void menu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("----------------------------------");
		System.out.println("-- Bem vindo ao Banco "+nome+" ---");
		System.out.println("-- Digite sua agencia: -----------");
		String agencia = scanner.nextLine();
		
		for (int i = 0; i < agencias.length; i++) {
			if (agencias[i].numero.equals(agencia)){
				agenciaSelecionada = agencias[i];
				break;
			}
		}
		
		if(agenciaSelecionada == null)
			System.out.println("--Agencia não encontrada--");
		
		System.out.println("-- Digite numero da conta (0 para casdastrar): ---");
		int conta = scanner.nextInt();
		
		for (int i = 0; i < agenciaSelecionada.contas.length; i++) {
			if(agenciaSelecionada.contas[i].numeroConta == conta){
				contaSelecionada = agenciaSelecionada.contas[i];
				break;
			}
		}
		
		if(contaSelecionada == null){
			cadastrarConta();
		}else{
			menuContaBancaria(contaSelecionada);
		}
		
	}

	private static void menuContaBancaria(ContaBancaria contaSelecionada) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("------Bem vindo "+contaSelecionada.cliente.nome+"----");
		System.out.println("------------------------------------------------------");
		System.out.println("------Selecione uma opcao:-----");
		System.out.println("------1 - Saque:-----");
		System.out.println("------2 - Deposito:-----");
		System.out.println("------3 - Transferencia:-----");
		System.out.println("------4 - Saldo:-----");
		int opcao = scanner.nextInt();
		
		switch (opcao) {
		case 1:
			System.out.println("------Digite o valor:-----");
			int valor = scanner.nextInt();
			break;

		default:
			break;
		}
	}

	private static void cadastrarConta() {
		// TODO Auto-generated method stub
		
	}

	public static void criarAgencias(){
		Agencia agenciaCentro = new Agencia();
		agenciaCentro.numero = "001";

		Agencia agenciaBenfica = new Agencia();
		agenciaBenfica.numero = "002";
		
		agencias[0] = agenciaCentro;
		agencias[1] = agenciaBenfica;
	}
	
	public ContaBancaria criarConta(){
		ContaBancaria retorno = new ContaBancaria();
		
		
		return retorno;
	}
	
}
