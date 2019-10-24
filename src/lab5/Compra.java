package lab5;


import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe simula uma compra
 * @author felipe
 *
 */
public class Compra {
	/**
	 * Data da compra
	 */
	private String data;
	/**
	 * Nome do produto
	 */
	private String nome;

	/**
	 * Construtor da compra
	 * @param data Data da compra
	 * @param nome Nome do produto
	 * @param preço Preço do produto
	 * @throws ParseException
	 */
	public Compra(String data, String nome, double preço) throws ParseException {
		this.data = formData(data);
		this.nome = nome;
	}
	/**
	 * Retorna nome do produto e data da compra
	 */
	public String toString() {
		return this.nome + " - " + this.data;
	}
	/**
	 * Formata a data para o formato desejado
	 * @param data data da compra
	 * @return Retorna data no formato desejado
	 * @throws ParseException
	 */
	public String formData(String data) throws ParseException {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		DateTimeFormatter formatoCerto = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
		LocalDate dataFormatada = LocalDate.parse(data, formato); 
		String resultado = dataFormatada.format(formatoCerto);

		
		return resultado;
	}
}
	
