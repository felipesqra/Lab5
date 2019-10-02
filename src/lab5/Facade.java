package lab5;

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
	 * Método utilizado para cadastrar um Fornecedor.
	 * 
	 * @param nome Especifíca o nome do fornecedor.
	 * @param email Especifica o email do fornecedor
	 * @param telefone Especifíca o telefone do fornecedor 
	 */
	public void cadastraFornecedor(String nome, String email, String telefone) {
		this.controllerFornecedor.cadastrarFornecedor(nome, email, telefone);
	}
	
	/**
	 * Método utilizado para exibir um fornecedor específico.
	 * 
	 * @param nome Especifíca o nome do fornecedor que se ddeseja exibir.
	 */
	public void exibeFornecedor(String nome) {
		this.controllerFornecedor.exibeFornecedor(nome);
	}
	
	/**
	 * Método utilizado para retornar uma lista com todos os fornecedores cadastrados.
	 * 
	 */
	public void listaFornecedores() {
		this.controllerFornecedor.listarFornecedores();
	}
	
	/**
	 * Método utilizado para editar informações sobre um fornecedor
	 * 
	 * @param nome Especifíca o fornecedor que terá seus dados alterados
	 * @param email Especifíca o novo email que será utilizado pelo fornecedor
	 * @param telefone Especifíca o novo telefone que será utilizado pelo fornecedor
	 */
	public void editarFornecedor(String nome, String email, String telefone) {
		this.controllerFornecedor.editarFornecedor(nome, email, telefone);
	}
	
	/**
	 * Método utilizado para remover Fornecedores cadastrados
	 * 
	 * @param nome Nome do fornecedor que será exluído
	 */
	public void removerFornecedor(String nome) {
		this.controllerFornecedor.removerFornecedor(nome);
	}
	
	/**
	 * Apresenta uma lista com todos os produtos de um fornecedor
	 * 
	 * @param nomeFornecedor Especifíca o fornecedor que terá seus produtos apresentados.
	 */
	public void consultaProdutoFornecedor(String nomeFornecedor) {
		this.controllerFornecedor.consultaProdutoFornecedor(nomeFornecedor);
	}
	
	/**
	 * Apresenta uma lista com todos os produtos de todos os fornecedores
	 */
	public void listarTodosProdutosDosFornecedores() {
		this.controllerFornecedor.listarTodosProdutosDosFornecedores();
	}
	
	/**
	 * Faz o cadastro de novos clientes.
	 * 
	 * @param cpf Indica o CPF do cliente
	 * @param nome Indica o nome do cliente
	 * @param email Indica o email do cliente
	 * @param localizacao Indica a localização do cliente
	 */
	public void cadastrarCliente(String cpf, String nome, String email, String localizacao) {
		this.controllerCliente.cadastrarCliente(cpf, nome, email, localizacao);
	}
	
	/**
	 * Exibe um cliente em específico
	 * 
	 * @param cpf Indica qual cliente terá suas informações exibidas
	 */
	public void exibirCliente(String cpf) {
		this.controllerCliente.exibirCliente(cpf);
	}
	
	/**
	 * Lista todos os cliente cadastrados
	 */
	public void listarClientes() {
		this.controllerCliente.listarClientes();
	}
	
	/**
	 * Remove um cliente cadastrado
	 * @param cpf Específica qual cliente será removido.
	 */
	public void removerCliente(String cpf) {
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
	public void editarCliente(String cpf, String nome, String localizacao, String email) {
		this.controllerCliente.editarCliente(cpf, nome, localizacao, email);
	}
}
