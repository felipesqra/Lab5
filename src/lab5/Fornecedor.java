package lab5;

import java.util.HashMap;

public class Fornecedor {
	private String nome;
	private String email;
	private String telefone;
	private HashMap<String, Produto> produtos;
	
	public Fornecedor(String nome, String email, String telefone) {
		this.email = email;
		this.nome = nome;
		this.telefone = telefone;
		this.produtos = new HashMap<>();
	}
	
	public void addProduto(String nome, String descrição, double preço) {
		Produto produto = new Produto(nome, descrição, preço);
		
		String chave = nome+descrição;
		
		if(!produtos.containsKey(chave)) {
			produtos.put(chave, produto);
		}
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}
	
	public String listarToString() {
		return this.nome + " - " + this.email + " - " + this.telefone + " | ";
	}
	
	public void editarFornecedor(String email, String telefone) {
		this.email = email;
		this.telefone = telefone;
	}
	
	
}
