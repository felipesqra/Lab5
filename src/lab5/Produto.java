package lab5;

public class Produto {
	private String nome;
	private String descrição;
	private double preço;
	
	public Produto(String nome, String descrição, double preço) {
		this.nome = nome;
		this.descrição = descrição;
		this.preço = preço;
	}
	
	
	public String toString() {
		return nome + " - " + descrição + " - " + "R$" + preço;
	}
	
	public String listarToString() {
		return nome + " - " + descrição + " - " + "R$" + preço + " | ";
	}
	
	public void editar(double preço) {
		this.preço = preço;
	}
	
}
