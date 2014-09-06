package br.com.cepep.formacaojava.threads;

public class GeraPDF implements Runnable{
	
	public void gerar(){
		for (int i = 8000; i < 9000; i++) {
			System.out.println(i);
		}
	}

	@Override
	public void run() {
		this.gerar();
	}
}
