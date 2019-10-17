 package lab5;

import java.util.List;


public class Combo {
	private String nome;
	private String descricao;
	private double preço;
	private double fator;
	private List<Produto> produtos;
	
	public Combo(String nome, String descricao, double fator, List<Produto> produtos) {
		this.nome = nome;
		this.descricao = descricao;
		this.fator = fator;
		this.produtos = produtos;
		this.preço = calculaPreco(produtos);
	}
	
	public void editar(double preço) {
		this.preço = preço;
	}

	
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public String toString() {
		return String.format("%s - %s - R$%.2f", this.nome, this.descricao, this.preço); 
	}
	
	public double getPreço() {
		return this.preço - (this.preço*this.fator);
	}
	
	public double calculaPreco(List<Produto> produtos) {
		for(Produto produto: produtos) {
			preço += produto.getPreço();
		}
		this.preço = this.preço - this.preço * this.fator;
		return preço;
	}

}
