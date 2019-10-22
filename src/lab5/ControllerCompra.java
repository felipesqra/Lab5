package lab5;

public class ControllerCompra {
	private ControllerFornecedor controllerFornecedor;
	private ControllerCliente controllerCliente;
	
	public ControllerCompra() {
		this.controllerFornecedor = new ControllerFornecedor();
		this.controllerCliente = new ControllerCliente();
	}

	public void addCompra(String cpfCliente, String fornecedor, String data, String nome, String descricao) {
		String cliente = this.controllerCliente.getNome(cpfCliente);
		this.controllerFornecedor.addCompra(cliente, fornecedor, data, nome, descricao);
	}
	
	
	
}


