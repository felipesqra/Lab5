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
	
	public String listarProdutos() {
		String string = "";
		
		for(Produto produto: this.produtos.values()) {
			string += nome + " - " + produto.listarToString();
		}
		return string;
	}
	
	public void editarProduto(String nome, double preço) {
		if(this.produtos.containsKey(nome)) {
			this.produtos.get(nome).editar(preço);
		}
	}
	
	public void removerProduto(String nome) {
		
		if(this.produtos.containsKey(nome)) {
			this.produtos.remove(nome);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
}
