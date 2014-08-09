

public class Banco {
	
	String nome = "Banco CEPEP";
	Agencia[] agencias = new Agencia[5];
	
	public Banco(String nome) {
		this.nome = nome;
		this.criarAgencias();
	}

	Agencia consultarAgencia(String agencia) {
		
		for (Agencia agenciaTmp : agencias) {
			if(agenciaTmp.numero.equals(agencia))
				return agenciaTmp;
		}
		
		for (int i = 0; i < agencias.length; i++) {
			if (agencias[i] != null && agencias[i].numero.equals(agencia)){
				return agencias[i];
			}
		}
		
		return null;
	}

	void criarAgencias(){
		Agencia agenciaCentro = new Agencia();
		agenciaCentro.numero = "001";

		Agencia agenciaBenfica = new Agencia();
		agenciaBenfica.numero = "002";
		
		agencias[0] = agenciaCentro;
		agencias[1] = agenciaBenfica;
	}
	
}
