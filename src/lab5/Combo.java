package lab5;

import java.util.ArrayList;


public class Combo implements ProdutoGeral{
	private String nome;
	private String descricao;
	private double preço;
	private double fator;
	private ArrayList<ProdutoSimples> produtos;
	
	public Combo(String nome, String descricao, double fator, ProdutoSimples p1, ProdutoSimples p2) {
		this.nome = nome;
		this.descricao = descricao;
		this.fator = fator;
		this.produtos = new ArrayList<>();
		this.produtos.add(p1);
		this.produtos.add(p2);
	}
	@Override
	public void editar(double preço) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		
	}

}
