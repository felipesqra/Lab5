package lab5;

import easyaccept.EasyAccept;

/**
 * Fachada criada para se comunicar com os controllers de cada classe.
 * @author Felipe de Souza Siqueira - 119110399
 *
 */
public class Facade {
	/**
	 * Controller da classe Fornecedor
	 */
	private ControllerFornecedor controllerFornecedor;
	/**
	 * Controller da classe Cliente
	 */
	private ControllerCliente controllerCliente;
	
	/**
	 * Construtor do facade
	 */
	public Facade() {
		this.controllerCliente = new ControllerCliente();
		this.controllerFornecedor = new ControllerFornecedor();
	}
	
	
	/**
	 * Método utilizado para cadastrar um Fornecedor.
	 * 
	 * @param nome Especifíca o nome do fornecedor.
	 * @param email Especifica o email do fornecedor
	 * @param telefone Especifíca o telefone do fornecedor 
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return this.controllerFornecedor.cadastrarFornecedor(nome, email, telefone);
	}
	
	/**
	 * Método utilizado para exibir um fornecedor específico.
	 * 
	 * @param nome Especifíca o nome do fornecedor que se deseja exibir.
	 */
	public String exibeFornecedor(String nome) {
		return this.controllerFornecedor.exibeFornecedor(nome);
	}
	
	/**
	 * Método utilizado para retornar uma lista com todos os fornecedores cadastrados.
	 * 
	 */
	public String exibeFornecedores() {
		return this.controllerFornecedor.listarFornecedores();
	}
	
	/**
	 * Método utilizado para editar informações sobre um fornecedor
	 * 
	 * @param nome Especifíca o fornecedor que terá seus dados alterados
	 * @param email Especifíca o novo email que será utilizado pelo fornecedor
	 * @param telefone Especifíca o novo telefone que será utilizado pelo fornecedor
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		this.controllerFornecedor.editarFornecedor(nome, atributo, novoValor);
	}
	
	/**
	 * Método utilizado para remover Fornecedores cadastrados
	 * 
	 * @param nome Nome do fornecedor que será exluído
	 */
	public void removeFornecedor(String nome) {
		this.controllerFornecedor.removerFornecedor(nome);
	}
	
	/**
	 * Método para a adição de novos produtos nos fornecedores.
	 * 
	 * @param fornecedor Fornecedor que receberá o novo produto
	 * @param nome Nome do produto
	 * @param descricao Descrição do produto
	 * @param preco Preço do produto
	 */
	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		this.controllerFornecedor.addProduto(fornecedor, nome, descricao, preco);
	}
	
	/**
	 * Método exibe as informações do produto pesquisado
	 * 
	 * @param nome Nome do produto
	 * @param descricao Descrição do produto
	 * @param fornecedor Nome do fornecedor
	 * @return Retorna uma String contendo as informações do produto
	 */
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		return this.controllerFornecedor.exibeProduto(nome, descricao, fornecedor);
	}

	public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
		this.controllerFornecedor.editaProduto(nome, descricao, fornecedor, novoPreco);
	}
	/**
	 * Apresenta uma lista com todos os produtos de um fornecedor
	 * 
	 * @param nomeFornecedor Especifíca o fornecedor que terá seus produtos apresentados.
	 */
	public String exibeProdutosFornecedor(String nomeFornecedor) {
		Util.validandoNull(nomeFornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		Util.validaVazia(nomeFornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		return this.controllerFornecedor.consultaProdutoFornecedor(nomeFornecedor);
	}
	
	
	
	/**
	 * Apresenta uma lista com todos os produtos de todos os fornecedores
	 */
	public String exibeProdutos() {
		return this.controllerFornecedor.listarTodosProdutosDosFornecedores();
	}
	
	/**
	 * Faz o cadastro de novos clientes.
	 * 
	 * @param cpf Indica o CPF do cliente
	 * @param nome Indica o nome do cliente
	 * @param email Indica o email do cliente
	 * @param localizacao Indica a localização do cliente
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return this.controllerCliente.cadastrarCliente(cpf, nome, email, localizacao);
	}
	
	/**
	 * Exibe um cliente em específico
	 * 
	 * @param cpf Indica qual cliente terá suas informações exibidas
	 */
	public String exibeCliente(String cpf) {
		return this.controllerCliente.exibeCliente(cpf);
	}
	
	/**
	 * Lista todos os cliente cadastrados
	 */
	public String exibeClientes() {
		return this.controllerCliente.listarClientes();
	}
	
	/**
	 * Remove um cliente cadastrado
	 * @param cpf Específica qual cliente será removido.
	 */
	public void removeCliente(String cpf) {
		this.controllerCliente.removerCliente(cpf);
	}
	
	/**
	 * Edita as informações de um determinado cliente.
	 * 
	 * @param cpf Indica qual cliente terá suas informações alteradas.
	 * @param nome Indica o novo nome do cliente
	 * @param localizacao Indica a nova localização do cliente
	 * @param email Indica o novo email do cliente
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		this.controllerCliente.editarCliente(cpf, atributo, novoValor);
	}
	/**
	 * Remove o produto de um determinado Fornecedor
	 * @param nome NOme do produto
	 * @param descricao descricao do produto
	 * @param fornecedor Fornecedor que terá seu produto removido
	 */
	public void removeProduto(String nome, String descricao, String fornecedor) {
		this.controllerFornecedor.removeProduto(nome, descricao, fornecedor);
	}
	
	public static void main(String[] args) {
		args = new String[] { "lab5.Facade", "TestesEasy/use_case_1.txt", "TestesEasy/use_case_2.txt", "TestesEasy/use_case_3.txt", "TestesEasy/use_case_4.txt",
				"TestesEasy/use_case_5.txt", "TestesEasy/use_case_6.txt"
	}; EasyAccept.main(args);
	}
	
	
}
