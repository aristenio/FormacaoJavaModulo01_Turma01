package br.com.cepep.sysvenda.entidades;

import java.util.Date;

public class Produto {
	
	private Long id;
	private String nome;
	private Double preco;
	private Double precoDesconto;
	private Float desconto;
	private String descricaoPequena;
	private String descricaoGrande;
	private String imagem;
	private int quantidadeEstoque;
	private Date dataCadastro = new Date();

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Double getPrecoDesconto() {
		return precoDesconto;
	}
	public void setPrecoDesconto(Double precoDesconto) {
		this.precoDesconto = precoDesconto;
	}
	public Float getDesconto() {
		return desconto;
	}
	public void setDesconto(Float desconto) {
		this.desconto = desconto;
	}
	public String getDescricaoPequena() {
		return descricaoPequena;
	}
	public void setDescricaoPequena(String descricaoPequena) {
		this.descricaoPequena = descricaoPequena;
	}
	public String getDescricaoGrande() {
		return descricaoGrande;
	}
	public void setDescricaoGrande(String descricaoGrande) {
		this.descricaoGrande = descricaoGrande;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}
