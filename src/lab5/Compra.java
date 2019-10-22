package lab5;

public class Compra {
	private String data;
	private String nome;
	private double preço;
	
	public Compra(String data, String nome, double preço) {
		this.data = data;
		this.nome = nome;
		this.preço = preço;
	}
	
	public String toString() {
		return this.nome + " - " + this.data;
	}
	
	
	
	
}
