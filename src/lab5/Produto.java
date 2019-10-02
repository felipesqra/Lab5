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
		return nome + " - " + descrição + " - " + "R$ " + preço;
	}
	
	public String listarToString() {
		return nome + " - " + descrição + " - " + "R$ " + preço + " | ";
	}
	
	public void editar(double preço) {
		this.preço = preço;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descrição == null) ? 0 : descrição.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (descrição == null) {
			if (other.descrição != null)
				return false;
		} else if (!descrição.equals(other.descrição))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
}
