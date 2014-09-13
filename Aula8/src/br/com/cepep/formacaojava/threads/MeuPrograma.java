package br.com.cepep.formacaojava.threads;

public class MeuPrograma {
	public static void main(String[] args) throws InterruptedException {
		GeraPDF geraPDF = new GeraPDF();
		BarraProgresso progresso = new BarraProgresso();
		
		Thread thread1 = new Thread(progresso);
		Thread thread2 = new Thread(progresso);
		
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
	}
}
