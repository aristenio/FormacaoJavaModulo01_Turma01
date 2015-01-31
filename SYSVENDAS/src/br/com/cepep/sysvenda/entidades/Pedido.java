package br.com.cepep.sysvenda.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
	
	private Long id;
	private Cliente cliente;
	private Date data;
	private Double valorTotal;
	private List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}
	public void setIntensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
