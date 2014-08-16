package br.com.cepep.formacaojava.sistemabancario;
import java.util.Scanner;

import br.com.cepep.formacaojava.sistemabancario.exception.SaldoInsuficienteException;
import br.com.cepep.formacaojava.sistemabancario.model.Agencia;
import br.com.cepep.formacaojava.sistemabancario.model.Banco;
import br.com.cepep.formacaojava.sistemabancario.model.Cliente;
import br.com.cepep.formacaojava.sistemabancario.model.ContaBancaria;
import br.com.cepep.formacaojava.sistemabancario.model.Endereco;


/**
 * Classe principal do sistema
 * 
 * @author Curso Java Cepep
 *
 */
public class Programa {
	
	static Banco bancoSelecionado = new Banco("Banco CEPEP");
	public static Agencia agenciaSelecionada;
	public static ContaBancaria contaSelecionada;
	
	/**
	 * M�todo que inicia o sistema
	 * @param args
	 */
	public static void main(String[] args) {
		menuInicial();
	}
	
	private static void menuInicial() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("----------------------------------");
		System.out.println("-- Bem vindo ao Banco "+bancoSelecionado.getNome()+" ---");
		System.out.println("Você deseja:");
		System.out.println("1 - Cadastrar uma nova conta:");
		System.out.println("2 - Acessar sua conta:");
		System.out.println("3 - Sair:");

		int opcao = scanner.nextInt();
		
		switch (opcao) {
		case 1:
			cadastrarConta();
			break;
		case 2:
			acessarConta();
			break;
		case 3:
			System.exit(0);
		default:
		}
		
		menuInicial();
		
	}

	private static void acessarConta() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("-- Digite sua agencia: -----------");
		String agencia = scanner.nextLine();
		
		agenciaSelecionada = bancoSelecionado.consultarAgencia(agencia);
		
		if(agenciaSelecionada == null){
			System.out.println("Agencia nao encontrada");
			menuInicial();
		}
				
		System.out.println("-- Digite numero da conta: ---");
		int numeroConta = scanner.nextInt();
		
		contaSelecionada = agenciaSelecionada.consultarConta(numeroConta);

		if(contaSelecionada == null){
			System.out.println("Conta nao encontrada");
			menuInicial();
		}
		
		menuContaBancaria();
	}
	
	private static void menuContaBancaria() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("------Bem vindo "+contaSelecionada.getCliente().getNome()+" ----");
		System.out.println("------------------------------------------------------");
		System.out.println("------Selecione uma opcao:-----");
		System.out.println("------1 - Saque:-----");
		System.out.println("------2 - Deposito:-----");
		System.out.println("------3 - Transferencia:-----");
		System.out.println("------4 - Saldo:-----");
		System.out.println("------5 - Voltar ao menu inicial-----");
		int opcao = scanner.nextInt();
		
		switch (opcao) {
		case 1:
			efetuarSaque();
			break;
		case 2:
			efetuarDeposito();
			break;
		case 3:
			efetuarTransferencia();
			break;
		case 4:
			consultarSaldo();
			break;
		case 5:
			menuInicial();
			return;
		default:
		}

		menuContaBancaria();
	}

	private static void consultarSaldo() {
		System.out.println("------Opção Saldo selecionada:-----");
		System.out.println("------Seu saldo atual é de:-----");
		System.out.println("------R$ "+contaSelecionada.consultaSaldo()+" reais-----");
		
	}

	private static void efetuarDeposito() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("------Opção Desposito selecionada:-----");
		System.out.println("------Digite o valor do deposito:-----");
		int valor = scanner.nextInt();
		contaSelecionada.deposita(valor);
		System.out.println("Deposito de R$ "+valor+" reais efetuado com sucesso.");
	}

	private static void efetuarSaque() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("------Opção Saque selecionada:-----");
		System.out.println("------Digite o valor do saque:-----");
		int valor = scanner.nextInt();
		
		try {
			contaSelecionada.sacar(valor);
			System.out.println("Saque de R$ "+valor+" reais efetuado com sucesso.");
		} catch (Exception e) {
			System.out.println("Saque de R$ "+valor+" reais não realizado."+e.getMessage());
		}

	}

	private static void efetuarTransferencia() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("------Opção Transferencia selecionada:-----");
		System.out.println("------Digite a agencia para transferencia:-----");
		String agencia = scanner.nextLine();
		Agencia agenciaTranferencia = bancoSelecionado.consultarAgencia(agencia);
		
		if(agenciaSelecionada == null){
			System.out.println("--Agencia não encontrada--");
			return;
		}

		System.out.println("------Digite a agencia para transferencia:-----");
		int numeroContaTransferencia = scanner.nextInt();
		ContaBancaria contaTranferencia = agenciaTranferencia.consultarConta(numeroContaTransferencia);
		
		if(contaTranferencia == null){
			System.out.println("--Conta não encontrada--");
			return;
		}
		
		System.out.println("------Digite o valor da tranferencia:-----");
		int valor = scanner.nextInt();

		try {
			contaSelecionada.transfere(contaTranferencia, valor);
			System.out.println("Transferencia efetuada com sucesso!");
		} catch (SaldoInsuficienteException e) {
			System.out.println("Não foi possível efetuar a transferencia"+e.getMessage());
		}finally{
			System.out.println("Obrigado");
		}
	}

	private static void cadastrarConta() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Nome:");
		String nome = scanner.nextLine();
		System.out.println("Sobrenome:");
		String sobrenome = scanner.nextLine();
		System.out.println("CPF:");
		String cpf = scanner.nextLine();
		System.out.println("Endereco:");
		System.out.println("Tpo:");
		String tipo = scanner.nextLine();
		System.out.println("Logradouro:");
		String logradouro = scanner.nextLine();
		System.out.println("Numero:");
		int numero = scanner.nextInt();
		System.out.println("Complemento:");
		String complemento = scanner.nextLine();
		
		Endereco endereco = new Endereco(tipo,logradouro,numero,complemento);
		Cliente cliente = new Cliente(nome,sobrenome,cpf, endereco);
		
		Agencia agencia = bancoSelecionado.consultarAgencia("001");
		agenciaSelecionada = agencia;

		int numeroConta = (int)(Math.random() * 10000);
		
		ContaBancaria novaConta = new ContaBancaria(numeroConta,cliente);
		agencia.adicionarConta(novaConta);
		
		System.out.println("Cliente "+novaConta.getCliente().getNome()+" "+novaConta.getCliente().getSobrenome()+" seja bem vindo ao "+bancoSelecionado.getNome());
		System.out.println("Sua agência é a "+agencia.getNumero());
		System.out.println("Sua conta é a "+novaConta.getNumeroConta());
		
		contaSelecionada = novaConta;
		
		menuContaBancaria();
	}

}
