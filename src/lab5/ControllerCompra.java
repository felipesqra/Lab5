package lab5;

/**
 * Classe simulando uma compra
 * @author Felipe de SOuza Siqueira - 119110399
 *
 */
public class ControllerCompra {
	/**
	 * Controller da classe Fornecedor
	 */
	private ControllerFornecedor controllerFornecedor;
	/**
	 * Controller da classe Cliente
	 */
	private ControllerCliente controllerCliente;
	/**
	 * Construtor da classe Controllercompra
	 */
	public ControllerCompra() {
		this.controllerFornecedor = new ControllerFornecedor();
		this.controllerCliente = new ControllerCliente();
	}
	/**
	 * Adiciona uma nova compra a conta de um cliente
	 * @param cpfCliente CPF do cliente
	 * @param fornecedor Nome do fornecedor
	 * @param data Data da compra
	 * @param nome Nome do produto
	 * @param descricao Descricao do produto
	 */
	public void addCompra(String cpfCliente, String fornecedor, String data, String nome, String descricao) {
		String cliente = this.controllerCliente.getNome(cpfCliente);
		this.controllerFornecedor.addCompra(cliente, fornecedor, data, nome, descricao);
	}
	
	
	
}


