package lab5;

public class Facade {
	private ControllerFornecedor controllerFornecedor;
	private ControllerCliente controllerCliente;
	
	public void cadastraFornecedor(String nome, String email, String telefone) {
		this.controllerFornecedor.cadastrarFornecedor(nome, email, telefone);
	}
	
	public void exibeFornecedor(String nome) {
		this.controllerFornecedor.exibeFornecedor(nome);
	}
	
	public void listaFornecedores(String nome) {
		this.controllerFornecedor.listarFornecedores();
	}
	
	public void editarFornecedor(String nome, String email, String telefone) {
		this.controllerFornecedor.editarFornecedor(nome, email, telefone);
	}
	
	public void removerFornecedor(String nome) {
		this.controllerFornecedor.removerFornecedor(nome);
	}
	
	public void consultaProdutoFornecedor(String nomeFornecedor) {
		this.controllerFornecedor.consultaProdutoFornecedor(nomeFornecedor);
	}
	
	public void listarTodosProdutosDosFornecedores() {
		this.controllerFornecedor.listarTodosProdutosDosFornecedores();
	}
	
	public void cadastrarCliente(String cpf, String nome, String email, String localizacao) {
		this.controllerCliente.cadastrarCliente(cpf, nome, email, localizacao);
	}
	
	public void exibirCliente(String cpf) {
		this.controllerCliente.exibirCliente(cpf);
	}
	
	public void listarClientes() {
		this.controllerCliente.listarClientes();
	}
	
	public void removerCliente(String cpf) {
		this.controllerCliente.removerCliente(cpf);
	}
	
	public void editarCliente(String cpf, String nome, String localizacao, String email) {
		this.controllerCliente.editarCliente(cpf, nome, localizacao, email);
	}
}
