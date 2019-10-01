package lab5;

public class Cliente {
	private String cpf;
	private String nome;
	private String email;
	private String localizacao;
	
	
	public Cliente(String cpf, String nome, String email, String localizacao) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String toString() {
		return this.nome + " - " + this.localizacao + " - " + this.email + "\n";
	}
	
	public String toStringListar() {
		return this.nome + " - " + this.localizacao + " - " + this.email + " | ";
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
}
