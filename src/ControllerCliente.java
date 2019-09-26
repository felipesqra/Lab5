import java.util.HashMap;

public class ControllerCliente {
	private HashMap<String, Cliente> clientes;
	
	public ControllerCliente() {
		this.clientes = new HashMap<>();
	}
	
	public String cadastrarCliente(String cpf, String nome, String email, String localizacao) {
		Cliente cliente = new Cliente(cpf, nome, email, localizacao);
		
		clientes.put(cpf, cliente);
		
		return cliente.getCpf();
	}
	
	public String exibirCliente(String cpf) {
		String string = "";
		
		if(clientes.containsKey(cpf)) {
			string += clientes.get(cpf).toString();
		}
		
		return string;
	}
	
	public String listarClientes() {
		String string = "";
		
		for(Cliente cliente: this.clientes.values()) {
			string += cliente.toStringListar();
		}
		
		return string;
	}
	
	public void removerCliente(String cpf) {
		if(this.clientes.containsKey(cpf)){
			this.clientes.remove(cpf);
		}
		
	}
	
	public void editarCliente(String cpf, String nome, String localizacao, String email) {
		 Cliente cliente = this.clientes.get(cpf);
		 
		 cliente.setNome(nome);
		 cliente.setEmail(email);
		 cliente.setLocalizacao(localizacao);
	}
	
	
}
