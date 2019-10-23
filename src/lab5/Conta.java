package lab5;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Classe simulando a conta de um cliente em um fornecedor
 * @author Felipe de Souza Siqueira
 *
 */
public class Conta {
	/**
	 * Nome do cliente que comprou
	 */
	private String nomeCliente;
	/**
	 * Total de quanto já foi gasto por aquele cliente no fornecedor em questão
	 */
	private double debito;
	/**
	 * Lista com todas as compras do cliente
	 */
	private List<Compra> compras;
	
	
	/**
	 * Construtor da classe Conta
	 * @param nomeCliente Nome do cliente
	 */
	public Conta(String nomeCliente) {
		this.nomeCliente = nomeCliente;
		this.compras = new ArrayList<>();

	}
	/**
	 * Adiciona uma compra a conta
	 * @param data Data da compra
	 * @param nome Nome do produto
	 * @param preço Preço do produto
	 * @throws ParseException 
	 */
	public void addcompra(String data, String nome, double preço) throws ParseException {
		this.debito += preço;
		Compra compra = new Compra(data, nome, preço);
		this.compras.add(compra);
	}
	
	public String getdebito() {
		double debito = this.debito;
		DecimalFormat formatador = new DecimalFormat(".00", new DecimalFormatSymbols(new Locale("en", "US")));
		String result = formatador.format(debito);
		return result;
	}
	
	public String toString() {
		String string = "";
		for(int i = 0; i < compras.size(); i++) {
			if(i != compras.size()-1) {
				string += compras.get(i) + " | ";
			}else {
				string += compras.get(i);
			}
		}
		System.out.print(string);
		return string;
	}
}
