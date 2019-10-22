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
	private HashMap<String, Produto> produtos;
	
	private HashMap<String, Combo> combos;
	
	private HashMap<String, Conta> contas;
	
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
		this.combos = new HashMap<>();
		this.contas = new HashMap<>();
	}
	
	/**
	 * Adiciona um produto ao catálogo do fornecedor
	 * 
	 * @param nome nome do produto
	 * @param descrição Descrição do produto
	 * @param preço Preço do produto
	 */
	public void addProduto(String nome, String descrição, double preço) {
		Produto produto = new Produto(nome, descrição, preço);
		
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
		List<Object> listaProduto = new ArrayList<>(this.produtos.values());
		
		if(this.combos.size() != 0) {
			for(Combo combo: this.combos.values()) {
				listaProduto.add(combo);
			}
		}
		
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
		
		if(!this.produtos.containsKey(string) && !this.combos.containsKey(string)) {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}
		if(this.produtos.containsKey(string) && !this.combos.containsKey(string)) {
			this.produtos.remove(string);
		}
		if(!this.produtos.containsKey(string) && this.combos.containsKey(string)) {
			this.combos.remove(string);
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

	public String exibeProduto(String nome, String descricao) {
		String retorno = "";
		
		
		String string = nome+descricao;
		
		
		if(!this.produtos.containsKey(string) && !this.combos.containsKey(string)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		}
		if(this.produtos.containsKey(string) && !this.combos.containsKey(string)) {
			retorno += this.produtos.get(string).toString();
		}
		if(this.combos.containsKey(string) && !this.produtos.containsKey(string)) {
			retorno += this.combos.get(string).toString();
		}
		
		return retorno;
	}
	
	public void novoCombo(String nome_combo, String descricao_combo, double fator, String produtos) {
		List<Produto> produtosObj = new ArrayList<Produto>();

		
		if(this.combos.containsKey(nome_combo+descricao_combo)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: combo ja existe.");
		}
		
		for(String produto: produtos.split(", ")) {
			String nomeProduto = produto.split(" - ")[0];
			String descricaoProduto = produto.split(" - ")[1];
			if(this.combos.containsKey(nomeProduto + descricaoProduto)) {
				throw new IllegalArgumentException("Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.");
			}
			if(!this.produtos.containsKey(nomeProduto + descricaoProduto)) {
				throw new IllegalArgumentException("Erro no cadastro de combo: produto nao existe.");
			}
			Produto p = this.produtos.get(nomeProduto + descricaoProduto);
			

			produtosObj.add(p);
		}
		
		
		Combo combo = new Combo(nome_combo, descricao_combo, fator, produtosObj);
		
		this.combos.put(nome_combo+descricao_combo, combo);
	}

	public void editaCombo(String nome2, String descricao, double novoFator) {
		String chave = nome2 + descricao;
		if(!this.combos.containsKey(chave)) {
			throw new IllegalArgumentException("Erro na edicao de combo: produto nao existe.");
		}
		this.combos.get(chave).editar(novoFator);
	}

	public void addCompra(String cliente, String fornecedor, String data, String nome, String descricao) {
		if(this.contas.containsKey(cliente)) {
			String idProduto = nome + descricao;
			double preço = this.produtos.get(idProduto).getPreço();
			this.contas.get(cliente).addcompra(data, nome, preço);
		} else { 
			Conta conta = new Conta(cliente);
			this.contas.put(cliente, conta);
			String idProduto = nome + descricao;
			double preço = this.produtos.get(idProduto).getPreço();
			this.contas.get(cliente).addcompra(data, nome, preço);
		} 
	}
	
}