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
		 Cliente cliente = this.clientes.get(cpf);
		 
		 cliente.setNome(nome);
		 cliente.setEmail(email);
		 cliente.setLocalizacao(localizacao);
	}
	
	
}
