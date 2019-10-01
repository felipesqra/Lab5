package lab5;

import java.util.ArrayList;

public class Fornecedor {
	private String nome;
	private String email;
	private String telefone;
	private ArrayList<Produto> produtos;
	
	public Fornecedor(String nome, String email, String telefone) {
		this.email = email;
		this.nome = nome;
		this.telefone = telefone;
		this.produtos = new ArrayList<>();
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
