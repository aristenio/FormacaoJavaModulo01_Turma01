package br.com.cepep.formacaojava.collections;

import java.util.Comparator;

import br.com.cepep.formacaojava.sistemabancario.model.ContaBancaria;

public class ContaBancariaComparator implements Comparator<ContaBancaria> {

	@Override
	public int compare(ContaBancaria arg0, ContaBancaria arg1) {
		if(arg0.consultaSaldo() > arg1.consultaSaldo())
			return 1;

		if(arg0.consultaSaldo() < arg1.consultaSaldo())
			return -1;
		return 0;
	}	
}
