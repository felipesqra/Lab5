package lab5;

import java.text.ParseException;
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
	
	/**
	 * Exibe um determinado produto
	 * @param nome Nome do produto
	 * @param descricao Descricao do produto
	 * @param fornecedor Nome do fornecedor
	 * @return Retorna uma String com informações do produto
	 */
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
	/**
	 * Remove um produto de um fornecedor
	 * @param nome Nome do produto
	 * @param descricao Descricao do produto
	 * @param fornecedor Nome do fornecedor
	 */
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
	/**
	 * Cria um novo combo
	 * @param fornecedor Nome do fornecedor
	 * @param nome_combo Nome do combo
	 * @param descricao_combo Descricao do combo
	 * @param fator Fator para desconto no preço do combo
	 * @param produtos Produtos que farão parte do combo
	 */
	public void addCombo(String fornecedor, String nome_combo, String descricao_combo, double fator, String produtos) {
		Util.validandoNull(nome_combo, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		Util.validaVazia(nome_combo, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		Util.validandoNull(descricao_combo, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		Util.validaVazia(descricao_combo, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		Util.validandoNull(fornecedor, "Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
		Util.validaVazia(fornecedor, "Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
		Util.validandoNull(produtos, "Erro no cadastro de combo: combo deve ter produtos.");
		Util.validaVazia(produtos, "Erro no cadastro de combo: combo deve ter produtos.");
		
		if(!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao existe.");
		}
		if(fator > 1 || fator < 0 || fator == 1 || fator == 0) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
		}
		this.fornecedores.get(fornecedor).novoCombo(nome_combo, descricao_combo, fator, produtos);
	}
	/**
	 * Edita o fator do combo
	 * @param nome Nome do combo
	 * @param descricao Descricao do combo
	 * @param fornecedor Nome do fornecedor
	 * @param novoFator Novo fator de promocao
	 */
	public void editaCombo(String nome, String descricao, String fornecedor, double novoFator) {
		Util.validandoNull(nome, "Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
		Util.validaVazia(nome, "Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
		Util.validandoNull(descricao, "Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
		Util.validaVazia(descricao, "Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
		Util.validandoNull(fornecedor, "Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.");
		Util.validaVazia(fornecedor, "Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.");
		if(novoFator < 0 || novoFator > 1 || novoFator == 1 || novoFator == 0) {
			throw new IllegalArgumentException("Erro na edicao de combo: fator invalido.");
		}
		
		if(!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de combo: fornecedor nao existe.");
		}
		this.fornecedores.get(fornecedor).editaCombo(nome, descricao, novoFator);
		
	}
	/**
	 * Adiciona uma nova compra a conta do cliente
	 * @param cliente Nome do cliente
	 * @param fornecedor Nome do fornecedor
	 * @param data Data da compra
	 * @param nome Nome do produto
	 * @param descricao Descricao do produto
	 * @throws ParseException 
	 */
	public void addCompra(String cpfCliente, String fornecedor, String data, String nome, String descricao, ControllerCliente contCliente) throws ParseException {
		Util.validandoNull(cpfCliente, "Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
		Util.validaVazia(cpfCliente, "Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
		if(cpfCliente.length() > 11 || cpfCliente.length() < 11) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf invalido.");
		}
		Util.validandoNull(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		Util.validaVazia(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		if(!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
		}
		Util.validandoNull(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		Util.validaVazia(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		if(data.length() > 10 || data.length() < 10) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
		}
		Util.validandoNull(descricao, "Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		Util.validaVazia(descricao, "Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		Util.validandoNull(nome, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		Util.validaVazia(nome, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		
		if(contCliente.containsKey(cpfCliente)){
			String nomeCliente = contCliente.getNome(cpfCliente);
			this.fornecedores.get(fornecedor).addCompra(nomeCliente,fornecedor, data, nome, descricao);
		} else {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
		}
	}
	/**
	 * Retorna o debito de um cliente
	 * @param cpf Cpf do cliente
	 * @param fornecedor Nome do fornecedor
	 * @param contCliente Controller do cliente
	 * @return
	 */
	public String getDebito(String cpf, String fornecedor, ControllerCliente contCliente) {
		Util.validandoNull(cpf, "Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
		Util.validaVazia(cpf, "Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
		if(cpf.length() > 11 || cpf.length() < 11) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf invalido.");
		}
		Util.validandoNull(fornecedor, "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		Util.validaVazia(fornecedor, "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		if(!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao existe.");
		}
		if(!contCliente.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao existe.");
		}
		String nomeCliente = contCliente.getNome(cpf);
		String debito = this.fornecedores.get(fornecedor).getDebito(nomeCliente);
		if(debito == "0") {
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
		}
		return debito;
	}
	/**
	 * Exibe a conta de um cliente
	 * @param cpf cpf do cliente
	 * @param fornecedor Nome do fornecedor
	 * @param contCliente Controller do cliente
	 * @return Exibe a conta de um cliente
	 */
	public String exibeContas(String cpf, String fornecedor, ControllerCliente contCliente) {
		Util.validandoNull(cpf, "Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
		Util.validaVazia(cpf, "Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
		if(cpf.length() > 11 || cpf.length()< 11) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cpf invalido.");
		}
		if(!contCliente.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao existe.");
		}
		Util.validandoNull(fornecedor, "Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		Util.validaVazia(fornecedor, "Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		if(!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao existe.");
		}
		String nomeCliente = contCliente.getNome(cpf);
		return this.fornecedores.get(fornecedor).exibeContas(nomeCliente);
	}
	
	/**
	 * Exibe as todas as contas de um cliente
	 * @param cpf Cpf do cliente
	 * @param contCliente Controller do cliente
	 * @return Retorna String ccom todas as contas do cliente
	 */
	public String exibeContasFornecedor(String cpf, ControllerCliente contCliente) {
		Util.validandoNull(cpf, "Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
		Util.validaVazia(cpf, "Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
		if(cpf.length() > 11 || cpf.length() < 11) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cpf invalido.");
		}
		if(!contCliente.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao existe.");
		}
		String nomeCliente = contCliente.getNome(cpf);
		String retorno = "Cliente: " + nomeCliente + " | "; 
		ArrayList<String> lista = new ArrayList<>();
		
		for(Fornecedor fornecedor: this.fornecedores.values()) {
			if(fornecedor.exibeContasFornecedor(nomeCliente) != "") {
				lista.add(fornecedor.exibeContasFornecedor(nomeCliente));
			}
		}
		Collections.sort(lista);
		
		for(int i = 0; i < lista.size(); i++) {
		
				if(i < lista.size()-1) {
					retorno += lista.get(i) + " | ";
				
			}else {
				retorno += lista.get(i);
				}
			}
		
		return retorno;
	}
	
	
	
	
}
