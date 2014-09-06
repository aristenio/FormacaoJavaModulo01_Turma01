package br.com.cepep.formacaojava.threads;

public class BarraProgresso extends Thread{
	public synchronized 
	void rodar(){
		for (int i = 0; i < 1000000; i++) {
			System.out.println(i);
		}
	}

	@Override
	public void run() {
		this.rodar();
	}

}
