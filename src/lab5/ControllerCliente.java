package lab5;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;




/**
 * Controller da classe Cliente
 * 
 * @author Felipe de Souza Siqueira - 119110399
 */
public class ControllerCliente{
	/**
	 * Mapa contendo os clientes cadastrados
	 */
	private HashMap<String,Cliente> clientes;
	
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
		
		if(clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}
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
	public String exibeCliente(String cpf) {
		Util.validandoNull(cpf, "Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
		Util.validaVazia(cpf, "Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
		String string = "";

		if(!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
		
		string += clientes.get(cpf).toString();
		return string;
	}
	
	/**
	 * Lista todos os clientes cadastrados
	 * 
	 * @return Retorna uma String com informações de todos os cliente scadastrados
	 */
	public String listarClientes() {
		String string = "";
		
		Ordenadora comparador = new Ordenadora();
		
		
		List<Cliente> listaClientes = new ArrayList<>(this.clientes.values());

		Collections.sort(listaClientes, comparador);
		
		for(int i = 0; i<listaClientes.size(); i++) {
			if(i != listaClientes.size()-1) {
				string += listaClientes.get(i) + " | ";
			}else { 
				string += listaClientes.get(i);
			}
		
		}
		
		return string;
	}
	
	/**
	 * Remove um cliente a partir de seu CPF
	 * 
	 * @param cpf CPF do cliente
	 */
	public void removerCliente(String cpf) {
		Util.validandoNull(cpf, "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		Util.validaVazia(cpf, "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		if(!this.clientes.containsKey(cpf)){
			throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
		}
		
		this.clientes.remove(cpf);
		
	}
	
	/**
	 * Edita informações do cliente
	 * 
	 * @param cpf CPF do cliente
	 * @param nome Nome do cliente
	 * @param localizacao Localização do cliente
	 * @param email Email do cliente
	 */
	public void editarCliente(String cpf, String atributo, String novoValor) {
		Util.validandoNull(cpf, "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		Util.validaVazia(cpf, "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		Util.validandoNull(atributo, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		Util.validaVazia(atributo, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		Util.validandoNull(novoValor, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		Util.validaVazia(novoValor, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		
		if(!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}
		
		Cliente cliente = this.clientes.get(cpf);
		 
		if(atributo.equals("nome")) {
			cliente.setNome(novoValor);
		}
		if(atributo.equals("email")) {
			cliente.setEmail(novoValor);
		}
		if(atributo.equals("localizacao")) {
			cliente.setLocalizacao(novoValor);
		}
		if(atributo.equals("cpf")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
		}
		if(!atributo.equals("nome") & !atributo.equals("email") & !atributo.equals("localizacao")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}
	}
	/**
	 * retorna o nome do cliente através do cpf
	 * @param cpf cpf do cliente
	 * @return Retorna o nome do cliente
	 */
	public String getNome(String cpf) {
		return this.clientes.get(cpf).getNome();
	}
	/**
	 * Checa se um cliente faz parte do mapa de cliente
	 * @param cpf cpf do cliente
	 * @return Retorna um booleano caso o cliente faça parte
	 */
	public boolean containsKey(String cpf) {
		if(this.clientes.containsKey(cpf)) {
			return true;
		} else {
			return false;
		}
	}

}
