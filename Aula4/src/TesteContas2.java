
public class TesteContas2 {
	
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		cliente.nome = "Joao";
		cliente.sobrenome = "Silva";
		cliente.cpf = "12345678999";
		cliente.endereco.logradouro = "rua m, 546";
		
		ContaBancaria contaBancaria1 = new ContaBancaria();
		contaBancaria1.cliente = cliente;

		ContaBancaria contaBancaria2 = new ContaBancaria();
		contaBancaria2.cliente = cliente;
		
		
		System.out.println(contaBancaria1.retornaInfoConta());
		System.out.println(contaBancaria2.retornaInfoConta());
	}

}
