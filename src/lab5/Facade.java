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
	public void adicionaFornecedor(String nome, String email, String telefone) {
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
	public void editaFornecedor(String nome, String email, String telefone) {
		this.controllerFornecedor.editarFornecedor(nome, email, telefone);
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
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return this.controllerCliente.cadastrarCliente(cpf, nome, email, localizacao);
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
	public void editaCliente(String cpf, String nome, String localizacao, String email) {
		this.controllerCliente.editarCliente(cpf, nome, localizacao, email);
	}
	
	public static void main(String[] args) {
		args = new String[] { "lab5.Facade", "TestesEasy/use_case_1.txt", "TestesEasy/use_case_2.txt"
	}; EasyAccept.main(args);
	}
	
	
}
