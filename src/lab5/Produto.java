package lab5;

/**
 * Classe representando um produto
 * 
 * @author Felipe de Souza Siqueira - 119110399
 */
public class Produto {
	/**
	 * Nome do produto
	 */
	private String nome;
	/**
	 * Descrição do produto
	 */
	private String descrição;
	/**
	 * Preço do produto
	 */
	private String preço;
	
	/**
	 * Construtor do produto
	 * 
	 * @param nome Nome do produto
	 * @param descrição DEscrição do produto
	 * @param preço Preço do produto
	 */
	public Produto(String nome, String descrição, String preço) {
		Util.validandoNull(nome, "Não é permitido um nome nulo");
		Util.validaVazia(nome, "Não é permitido um nome vazio");
		Util.validandoNull(descrição, "Não é permitido uma descrição nula");
		Util.validaVazia(descrição, "Não é permitido uma descrição vazia");
		Util.validandoNull(preço, "Não é permitido um preço nulo");
		Util.validaVazia(preço, "Não é permitido um preço vazio");
		this.nome = nome;
		this.descrição = descrição;
		this.preço = preço;
	}
	
	/**
	 * Retorna uma String com o nome, a descrição e o preço do produto
	 */
	public String toString() {
		return nome + " - " + descrição + " - " + "R$ " + preço;
	}

	/**
	 * Retorna uma String com o nome, a descrição e o preço do produto
	 */
	public String listarToString() {
		return nome + " - " + descrição + " - " + "R$ " + preço + " | ";
	}
	
	/**
	 * Edita o preço do produto
	 * 
	 * @param preço Novo preço do produto
	 */
	public void editar(String preço) {
		Util.validandoNull(preço, "Não é permitido um preço nulo");
		Util.validaVazia(preço, "Não é permitido um preço vazio");
		this.preço = preço;
	}
	
	/**
	 * Gera uma representação em inteiro para cada objeto instanciado
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descrição == null) ? 0 : descrição.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Compara objetos e retorna um boolean
	 */
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
