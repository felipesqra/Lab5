package lab5;
import java.util.HashMap;

/**
 * Controller da classe Cliente
 * 
 * @author Felipe de Souza Siqueira - 119110399
 */
public class ControllerCliente {
	/**
	 * Mapa contendo os clientes cadastrados
	 */
	private HashMap<String, Cliente> clientes;
	
	/**
	 * Construtor do ControllerCliente
	 */
	public ControllerCliente() {
		this.clientes = new HashMap<>();
	}
	
	/**
	 * Realiza o cadastro de novos clientes
	 * 
	 * @param cpf CPF do cliente
	 * @param nome Nome do cliente
	 * @param email Email do cliente
	 * @param localizacao Localização do cliente
	 * 
	 * @return Retorna uma String contendo o CPF do cliente
	 */
	public String cadastrarCliente(String cpf, String nome, String email, String localizacao) {
		Util.validandoNull(nome, "Não é permitido um nome nulo");
		Util.validaVazia(nome, "Não é permitido um nome vazio");
		Util.validandoNull(email, "Não é permitido um email nulo");
		Util.validaVazia(email, "Não é permitido um email vazio");
		Util.validandoNull(localizacao, "Não é permitido uma localização nula");
		Util.validaVazia(localizacao, "Não é permitido uma localização vazia");
		Cliente cliente = new Cliente(cpf, nome, email, localizacao);
		
		this.clientes.put(cpf, cliente);
		
		return cliente.getCpf();
	}
	
	/**
	 * Exibe as informações de um cliente em expecífico
	 * 
	 * @param cpf CPF do cliente
	 * 
	 * @return Retorna uma String contendo as informações do cliente
	 */
	public String exibirCliente(String cpf) {
		Util.validandoNull(cpf, "Não é permitido um CPF nulo");
		Util.validaVazia(cpf, "Não é permitido um CPF vazio");
		String string = "";
		
		if(clientes.containsKey(cpf)) {
			string += clientes.get(cpf).toString();
		}
		
		return string;
	}
	
	/**
	 * Lista todos os clientes cadastrados
	 * 
	 * @return Retorna uma String com informações de todos os cliente scadastrados
	 */
	public String listarClientes() {
		String string = "";
		
		for(Cliente cliente: this.clientes.values()) {
			string += cliente.toStringListar();
		}
		
		return string;
	}
	
	/**
	 * Remove um cliente a partir de seu CPF
	 * 
	 * @param cpf CPF do cliente
	 */
	public void removerCliente(String cpf) {
		Util.validandoNull(cpf, "Não é permitido um CPF nulo");
		Util.validaVazia(cpf, "Não é permitido um CPF vazio");
		if(this.clientes.containsKey(cpf)){
			this.clientes.remove(cpf);
		}
		
	}
	
	/**
	 * Edita informações do cliente
	 * 
	 * @param cpf CPF do cliente
	 * @param nome Nome do cliente
	 * @param localizacao Localização do cliente
	 * @param email Email do cliente
	 */
	public void editarCliente(String cpf, String nome, String localizacao, String email) {
		Util.validandoNull(cpf, "Não é permitido um CPF nulo");
		Util.validaVazia(cpf, "Não é permitido um CPF vazio");
		Util.validandoNull(localizacao, "Não é permitido um localização nulo");
		Util.validaVazia(localizacao, "Não é permitido um localização vazio");
		Util.validandoNull(email, "Não é permitido um email nulo");
		Util.validaVazia(email, "Não é permitido um email vazio");
		Util.validandoNull(nome, "Não é permitido um nome nulo");
		Util.validaVazia(nome, "Não é permitido um nome vazio");
		
		Cliente cliente = this.clientes.get(cpf);
		 
		 cliente.setNome(nome);
		 cliente.setEmail(email);
		 cliente.setLocalizacao(localizacao);
	}
	
	
}
