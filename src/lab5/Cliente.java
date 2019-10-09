package lab5;

/**
 * Simula o cliente de um programa
 * 
 * @author Felipe de Souza Siqueira - 119110399
 *
 */
public class Cliente {
	/**
	 * CPF dp cliente
	 */
	private String cpf;
	/**
	 * Nome do cliente
	 */
	private String nome;
	/**
	 * Email do cliente
	 */
	private String email;
	/**
	 * Localização do cliente
	 */
	private String localizacao;
	
	
	/**
	 * Contrutor do cliente
	 * 
	 * @param cpf Especifíca o CPF do cliente
	 * @param nome Especifíca o Nome do cliente
	 * @param email Especifíca o email do cliente
	 * @param localizacao Especifíca a localização do cliente.
	 */
	public Cliente(String cpf, String nome, String email, String localizacao) {
		Util.validandoNull(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		Util.validaVazia(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		Util.validandoNull(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		Util.validaVazia(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		Util.validandoNull(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		Util.validaVazia(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		Util.validandoNull(localizacao, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		Util.validaVazia(localizacao, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		if(cpf.length() > 11 || cpf.length() < 11 ) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
	}
	
	/**
	 * Retorna o CPF do cliente
	 * 
	 * @return Retorna em forma de String o CPF do cliente
	 */
	public String getCpf() {
		return this.cpf;
	}
	
	/**
	 * Retorna uma String com o nome, a localização e o email do cliente
	 * 
	 * @return Retorna uma String com o nome, a localização e o email do cliente
	 */
	public String toString() {
		return this.nome + " - " + this.localizacao + " - " + this.email;
	}
	
	/**
	 * Retorna uma String com o nome, a localização e o email do cliente
	 *  
	 * @return Retorna uma String com o nome, a localização e o email do cliente
	 */
	public String toStringListar() {
		return this.nome + " - " + this.localizacao + " - " + this.email + " | ";
	}
	
	/**
	 * Altera o nome do cliente de acordo com o parâmetro passado
	 * 
	 * @param nome Especifíca o novo nome do cliente
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Altera o email do cliente de acordo com o parâmetro passado
	 * 
	 * @param email Especifíca o novo email do cliente
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Altera a localização do cliente
	 * 
	 * @param localizacao Especifíca a localização do cliente
	 */
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	/**
	 * Gera uma representação em inteiro para cada objeto criado
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	/**
	 * Compara objetos e retorna boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
}
