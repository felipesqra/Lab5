package lab5;

import java.util.HashMap;


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
	 * Construtor do controllerFornecedor
	 */
	public ControllerFornecedor() {
		this.fornecedores = new HashMap<>();
	}
	
	/**
	 * Cdastra novos fornecedores
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
		
		if(!fornecedores.containsKey(nome)) {
			fornecedores.put(nome, fornecedor);
			string += nome;
		}else {
			
		}
		
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
		String string = "";
		
		if(fornecedores.containsKey(nome)) {
			string += fornecedores.get(nome).toString();
		}
		
		return string;
	}
	
	/**
	 * Apresenta uma lista com todos os fornecedores.
	 * 
	 * @return Retorna uma string com informações de todos os fornecedores.
	 */
	public String listarFornecedores() {
		String string = "";
		
		
		for(Fornecedor fornecedor: this.fornecedores.values()) {
			string += fornecedor.listarToString();
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
	public void editarFornecedor(String nome, String email, String telefone) {
		Fornecedor fornecedor = this.fornecedores.get(nome);
		
		fornecedor.editarFornecedor(email, telefone);
	}
	
	/**
	 * Remove um determinado fornecedor
	 * 
	 * @param nome Determina qual o fornecedor que será removido.
	 */
	public void removerFornecedor(String nome) {
		if(fornecedores.containsKey(nome)) {
			fornecedores.remove(nome);
		}
	}
	
	/**
	 * Apresenta uma lista com todos os produtos de um determinado fornecedor
	 * 
	 * @param nomeFornecedor Especifica o fornecedor que terá seus produtos mostrados.
	 * 
	 * @return Retorna uma String com uma lista dde todos os produtos do fornecedor.
	 */
	public String consultaProdutoFornecedor(String nomeFornecedor) {
		return fornecedores.get(nomeFornecedor).listarProdutos();
	}
	
	/**
	 * Lista todos os produtos de todos os fornecedores
	 * 
	 * @return Retorna uma String com informações de todos os produtos de todos os forneccedores.
	 */
	public String listarTodosProdutosDosFornecedores() {
		String string = "";
		
		for(Fornecedor fornecedor: fornecedores.values()) {
			string += fornecedor.listarProdutos();
		}
		return string;
	}
}
