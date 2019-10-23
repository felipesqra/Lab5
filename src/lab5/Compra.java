package lab5;


import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Compra {
	private String data;
	private String nome;
	private double preço;
	
	public Compra(String data, String nome, double preço) throws ParseException {
		this.data = formData(data);
		this.nome = nome;
		this.preço = preço;
	}
	
	public String toString() {
		return this.nome + " - " + this.data;
	}
	
	public String formData(String data) throws ParseException {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		DateTimeFormatter formatoCerto = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
		LocalDate dataFormatada = LocalDate.parse(data, formato); 
		String resultado = dataFormatada.format(formatoCerto);

		
		return resultado;
	}
}
	
