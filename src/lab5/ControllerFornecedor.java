package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


/**
 * Controller da classe fornecedor
 * 
 * @author Felipe de Souza Siqueira - 119110399
 */
public class ControllerFornecedor {
	/**
	 * Mapa com todos os fornecedores cadastrados
	 */
	private HashMap<String, Fornecedor> fornecedores;
	
	/**
	 * Construtor do fornecedor
	 */
	public ControllerFornecedor() {
		this.fornecedores = new HashMap<>();
	}
	
	/**
	 * Cadastra novos fornecedores
	 * 
	 * @param nome Nome do fornecedor
	 * @param email Email do fornecedor
	 * @param telefone telefone do fornecedor
	 * 
	 * @return Retorna uma String contendo o nome do fornecedor
	 */
	public String cadastrarFornecedor(String nome, String email, String telefone) {
		Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
		
		String string = "";
		if(fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
		
		
		fornecedores.put(nome, fornecedor);
		string += nome;
		
		
		return string;
	}
	
	/**
	 * Exibe um determinado fornecedor
	 * 
	 * @param nome Nome do fornecedor
	 * 
	 * @return Retorna uma String com as informações de determinado fornecedor.
	 */
	public String exibeFornecedor(String nome) {
		Util.validandoNull(nome, "Não é permitido um nome nulo");

		
		if(!fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
			
		}
		String string = "";
		string += fornecedores.get(nome).toString();
		
		return string;
	}
	
	/**
	 * Apresenta uma lista com todos os fornecedores.
	 * 
	 * @return Retorna uma string com informações de todos os fornecedores.
	 */
	public String listarFornecedores() {
		String string = "";
		
		Ordenadora ordenaFornecedor = new Ordenadora();
		
		List<Fornecedor> listaFornecedor = new ArrayList<>(this.fornecedores.values());
		Collections.sort(listaFornecedor, ordenaFornecedor);
		
		for(int i = 0; i<listaFornecedor.size(); i++) {
			if(i != listaFornecedor.size()-1) {
				string += listaFornecedor.get(i) + " | ";

			}else { 
				string += listaFornecedor.get(i);
			}
		
		}
		
		return string;
	}
	/**
	 * Edita informações do fornecedor.
	 * 
	 * @param nome Indica o nome do fornecedor que terá seus dados alterados.
	 * @param email Novo email do fornecedor
	 * @param telefone Novo telefone do fornecedor
	 */
	public void editarFornecedor(String nome, String atributo, String novoValor) {
		Util.validandoNull(nome, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		Util.validaVazia(nome, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		Util.validandoNull(atributo, "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		Util.validaVazia(atributo, "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		Util.validandoNull(novoValor, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		Util.validaVazia(novoValor, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		
		
		if(atributo.equals("nome")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		}
		
		if(!atributo.equals("nome") & !atributo.equals("email") & !atributo.equals("telefone")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
		}
		
		if(!this.fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
		}
		
		Fornecedor fornecedor = this.fornecedores.get(nome);
		
		fornecedor.editarFornecedor(atributo, novoValor);
	}
	
	/**
	 * Remove um determinado fornecedor
	 * 
	 * @param nome Determina qual o fornecedor que será removido.
	 */
	public void removerFornecedor(String nome) {
		Util.validandoNull(nome, "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		Util.validaVazia(nome, "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		if(!fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
		}
		fornecedores.remove(nome);
	}
	
	/**
	 * Adiciona um novo produto a algum fornecedor
	 * @param fornecedor Especifica o fornecedor que receberá o novo produto
	 * @param nome Nome do produto
	 * @param descrição Descrição do produto
	 * @param preco Preço do produto
	 */
	public void addProduto(String fornecedor, String nome, String descrição, double preco) {
		Util.validandoNull(fornecedor, "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		Util.validaVazia(fornecedor, "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		Util.validandoNull(nome, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		Util.validaVazia(nome, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		Util.validandoNull(descrição, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		Util.validaVazia(descrição, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		
		if(!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}
		if(preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
		
		
		Fornecedor fornecedorr = this.fornecedores.get(fornecedor);
		
		fornecedorr.addProduto(nome, descrição, preco);
	}
	
	/**
	 * Edita o preço de um produto
	 * @param nome Nome do produto
	 * @param descricao Descrição do produto
	 * @param fornecedor Fornecedor que terá seu produto alterado
	 * @param novoPreco Novo preço do produto
	 */
	public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
		Util.validandoNull(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		Util.validaVazia(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		Util.validandoNull(nome, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		Util.validaVazia(nome, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		Util.validandoNull(fornecedor, "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		Util.validaVazia(fornecedor, "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		if(!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
		}
		if(novoPreco < 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		}
		this.fornecedores.get(fornecedor).editaProduto(nome, descricao, novoPreco);
	}
	/**
	 * Apresenta uma lista com todos os produtos de um determinado fornecedor
	 * 
	 * @param nomeFornecedor Especifica o fornecedor que terá seus produtos mostrados.
	 * 
	 * @return Retorna uma String com uma lista dde todos os produtos do fornecedor.
	 */
	public String consultaProdutoFornecedor(String nomeFornecedor) {
		Util.validandoNull(nomeFornecedor, "Não é permitido um nome nulo");
		Util.validaVazia(nomeFornecedor, "Não é permitido um nome vazio");
		if(!this.fornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}
		return fornecedores.get(nomeFornecedor).listarProdutos();
	}
	
	/**
	 * Lista todos os produtos de todos os fornecedores
	 * 
	 * @return Retorna uma String com informações de todos os produtos de todos os forneccedores.
	 */
	public String listarTodosProdutosDosFornecedores() {
		String string = "";
		
		Ordenadora ordenaFornecedor = new Ordenadora();
		
		List<Fornecedor> listaFornecedor = new ArrayList<>(this.fornecedores.values());
		Collections.sort(listaFornecedor, ordenaFornecedor);
		
		for(int i = 0; i<listaFornecedor.size(); i++) {
			
			if(i != listaFornecedor.size()-1) {
				string += listaFornecedor.get(i).listarProdutos() + " | ";

			}else { 
				string += listaFornecedor.get(i).listarProdutos();
			}
		
		}
		
		return string;
	}
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		Util.validandoNull(nome, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		Util.validaVazia(nome, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		Util.validandoNull(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		Util.validaVazia(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		Util.validandoNull(fornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		Util.validaVazia(fornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		if(!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}
		return this.fornecedores.get(fornecedor).exibeProduto(nome, descricao);
		
	}

	public void removeProduto(String nome, String descricao, String fornecedor) {
		Util.validandoNull(nome, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		Util.validaVazia(nome, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		Util.validandoNull(descricao, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		Util.validaVazia(descricao, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		Util.validandoNull(fornecedor, "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		Util.validaVazia(fornecedor, "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		if(!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
		}
		this.fornecedores.get(fornecedor).removerProduto(nome, descricao);
	}
	
	public void addCombo(String fornecedor, String nome_combo, String descricao_combo, double fator, String produtos) {
		Util.validandoNull(nome_combo, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		Util.validaVazia(nome_combo, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		Util.validandoNull(descricao_combo, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		Util.validaVazia(descricao_combo, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		Util.validandoNull(fornecedor, "Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
		Util.validaVazia(fornecedor, "Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
		if(!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao existe.");
		}
		if(fator > 1 || fator < 0) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
		}
		this.fornecedores.get(fornecedor).novoCombo(nome_combo, descricao_combo, fator, produtos);
	}
	
	
	
	
}
