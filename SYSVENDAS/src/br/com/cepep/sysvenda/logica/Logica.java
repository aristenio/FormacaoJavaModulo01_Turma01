package br.com.cepep.sysvenda.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
