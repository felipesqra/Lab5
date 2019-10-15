package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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
	private HashMap<String, ProdutoGeral> produtos;
	
	/**
	 * Construtor do fornecedor
	 * 
	 * @param nome Nome do fornecedor
	 * @param email Email do fornecedor
	 * @param telefone Telefone do Fornecedor
	 */
	public Fornecedor(String nome, String email, String telefone) {
		Util.validandoNull(nome, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		Util.validaVazia(nome, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		Util.validandoNull(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		Util.validaVazia(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		Util.validandoNull(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		Util.validaVazia(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
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
	public void addProduto(String nome, String descrição, double preço) {
		ProdutoSimples produto = new ProdutoSimples(nome, descrição, preço);
		
		String chave = nome+descrição;
		
		if(produtos.containsKey(chave)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}
		produtos.put(chave, produto);
		
	}
	
	/**
	 * Edita o preço de um produto
	 * @param nome Nome do produto
	 * @param descricao Descrição do produto
	 * @param novoPreco Novo preço do produto
	 */
	public void editaProduto(String nome, String descricao, double novoPreco) {
		
		String string = nome + descricao;
		if(!this.produtos.containsKey(string)) {
			throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
		}
		this.produtos.get(string).editar(novoPreco);
	}
	
	/**
	 * Retorna o nome do fornecedor
	 * 
	 * @return Retorna uma String contendo o nome do fornecedor
	 */
	public String getNome() {
		return this.nome;
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
	 * Edita as informações dde um fornecedor existente
	 * 
	 * @param email Novo email do fornecedor
	 * @param telefone Novo telefone do fornecedor
	 */
	public void editarFornecedor(String atributo, String novoValor) {
		if(atributo.equals("email")) {
			this.email = novoValor;
		}
		if(atributo.equals("telefone")) {
			this.telefone = novoValor;
		}
	}
	
	/**
	 * Apresenta uma lista com todos od produtos do fornecedor
	 * 
	 * @return Apresenta uma String contendo uma lista com todos os produtos do fornecedor
	 */
	public String listarProdutos() {
		String string = "";
		
		if(this.produtos.size() == 0) {
			string += this.nome + " -"; 
			return string;
		}
		List<ProdutoGeral> listaProduto = new ArrayList<>(this.produtos.values());
		Ordenadora ordenaProdutos = new Ordenadora();
		Collections.sort(listaProduto, ordenaProdutos);
		
		for(int i = 0; i<listaProduto.size(); i++) {
			if(i != listaProduto.size()-1) {
				string += this.nome + " - " + listaProduto.get(i) + " | ";
			}else { 
				string += this.nome + " - " + listaProduto.get(i);
			}
		
		}
		
		return string;
	}
	
	/**
	 * Edita as informações do produto de um fornecedor.
	 * 
	 * @param nome Nome do produto
	 * @param preço Preço novo do produto
	 */
	public void editarProduto(String nome, double preço) {
		if(this.produtos.containsKey(nome)) {
			this.produtos.get(nome).editar(preço);
		}
	}
	
	/**
	 * Remove o produto de um fornecedor
	 * @param nome Específica qual o produto que será removido
	 */
	public void removerProduto(String nome, String descricao) {
		String string = nome + descricao;
		
		if(!this.produtos.containsKey(string)) {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}
		this.produtos.remove(string);
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

	public String exibeProduto(String nome, String descricao) {
		
		
		String string = nome+descricao;
		
		if(!this.produtos.containsKey(string)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		}
		return this.produtos.get(string).toString();
	}
	
	public void novoCombo(String nome_combo, String descricao_combo, double fator, String produtos) {
		String[] chaves = produtos.split(", ");
		ProdutoGeral p1 = this.produtos.get(chaves[0]);
		ProdutoGeral p2 = this.produtos.get(chaves[1]);
		Combo combo = new Combo(nome_combo, descricao_combo, fator, p1, p2);
	}
	
}
