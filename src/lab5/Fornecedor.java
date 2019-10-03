package lab5;

import java.util.HashMap;

/**
 * Simula o fornecedor cadastrado no programa
 * 
 * @author Felipe de Souza Siqueira - 119110399
 */
public class Fornecedor {
	/**
	 * Especifíca o nome do fornecedor
	 */
	private String nome;
	/**
	 * Especifíca o email do cliente
	 */
	private String email;
	/**
	 * Especifíca o telefone do cliente
	 */
	private String telefone;
	/**
	 * Mapa contendo todos os produtos de um fornecedor
	 */
	private HashMap<String, Produto> produtos;
	
	/**
	 * Construtor do fornecedor
	 * 
	 * @param nome Nome do fornecedor
	 * @param email Email do fornecedor
	 * @param telefone Telefone do Fornecedor
	 */
	public Fornecedor(String nome, String email, String telefone) {
		this.email = email;
		this.nome = nome;
		this.telefone = telefone;
		this.produtos = new HashMap<>();
	}
	
	/**
	 * Adiciona um produto ao catálogo do fornecedor
	 * 
	 * @param nome nome do produto
	 * @param descrição Descrição do produto
	 * @param preço Preço do produto
	 */
	public void addProduto(String nome, String descrição, String preço) {
		Produto produto = new Produto(nome, descrição, preço);
		
		String chave = nome+descrição;
		
		if(!produtos.containsKey(chave)) {
			produtos.put(chave, produto);
		}
		
		
	}
	
	/**
	 * Retorna o nome do fornecedor
	 * 
	 * @return Retorna uma String contendo o nome do fornecedor
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Retorna uma String contendo o nome, o email e o telefone do fornecedor
	 * 
	 * @return Retorna uma String contendo o nome, o email e o telefone do fornecedor
	 */
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}
	
	/**
	 * Retorna uma String contendo o nome, o email e o telefone do fornecedor
	 * 
	 * @return Retorna uma String contendo o nome, o email e o telefone do fornecedor
	 */
	public String listarToString() {
		return this.nome + " - " + this.email + " - " + this.telefone + " | ";
	}
	
	/**
	 * Edita as informações dde um fornecedor existente
	 * 
	 * @param email Novo email do fornecedor
	 * @param telefone Novo telefone do fornecedor
	 */
	public void editarFornecedor(String email, String telefone) {
		this.email = email;
		this.telefone = telefone;
	}
	
	/**
	 * Apresenta uma lista com todos od produtos do fornecedor
	 * 
	 * @return Apresenta uma String contendo uma lista com todos os produtos do fornecedor
	 */
	public String listarProdutos() {
		String string = "";
		
		for(Produto produto: this.produtos.values()) {
			string += nome + " - " + produto.listarToString();
		}
		return string;
	}
	
	/**
	 * Edita as informações do produto de um fornecedor.
	 * 
	 * @param nome Nome do produto
	 * @param preço Preço novo do produto
	 */
	public void editarProduto(String nome, String preço) {
		if(this.produtos.containsKey(nome)) {
			this.produtos.get(nome).editar(preço);
		}
	}
	
	/**
	 * Remove o produto de um fornecedor
	 * @param nome Específica qual o produto que será removido
	 */
	public void removerProduto(String nome) {
		
		if(this.produtos.containsKey(nome)) {
			this.produtos.remove(nome);
		}
	}
	/**
	 * Gera uma representação em inteiro do objeto
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	/**
	 * Compara dois objetos
	 */
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
