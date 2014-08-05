
public class TesteContaBancaria {
	
	public static void main2(String[] args) {
		//Criação
		ContaBancaria conta1 = new ContaBancaria();
		System.out.println(conta1.retornaInfoConta());
		
		//Defição
		conta1.numeroConta = 1;
		conta1.cliente.nome = "Jose";
		conta1.saldo = 1000;
		conta1.limite = 1000;
		
		//Situação
		System.out.println(conta1.retornaInfoConta());
		
		//Operação
		conta1.deposita(1000);
		
		System.out.println("Novo saldo conta 1:" + conta1.saldo);
		
		ContaBancaria conta2 = new ContaBancaria();
		conta2.saldo = 2000;
		//Situação conta2
		System.out.println(conta2.retornaInfoConta());
		
		conta1.saldo = 0;
		
		System.out.println(conta1.retornaInfoConta());
		System.out.println(conta2.retornaInfoConta());

		conta1.deposita(1500);
		if(conta2.sacar(500)){
			System.out.println("Saque de 500 da conta2 realizado com sucesso");
		}else{
			System.out.println("Saque de 500 da conta2 não foi realizado");
		}

		if(conta1.sacar(2000)){
			System.out.println("Saque de 2000 da conta1 realizado com sucesso");
		}else{
			System.out.println("Saque de 2000 da conta1 não foi realizado");
		}
	}
	
	
	public static void main3(String[] args) {
		ContaBancaria conta1 = new ContaBancaria();
		
		//Defição
		conta1.numeroConta = 1;
		conta1.cliente.nome = "Jose";
		conta1.saldo = 1000;
		conta1.limite = 1000;
		
		//Situação
		System.out.println(conta1.retornaInfoConta());

		ContaBancaria conta2 = new ContaBancaria();
		
		//Defição
		conta2.numeroConta = 2;
		conta2.cliente.nome = "Joao";
		conta2.saldo = 2000;
		conta2.limite = 2000;
		
		//Situação
		System.out.println(conta2.retornaInfoConta());

		conta2.transfere(conta1, 1000);
		
		System.out.println(conta1.retornaInfoConta());
		System.out.println(conta2.retornaInfoConta());
		
	}	
	
}
