package com.example.produtos.model;

public class Produto {

	private Long id;
	private String nome;
	private String preco;
	
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
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + "]";
	}
	
	public Produto(Long id, String nome, String preco) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
	public Produto() {

	}
	
	
}
