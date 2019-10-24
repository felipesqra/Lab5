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
	public Conta() {
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
	/**
	 * Retorna o debito da conta
	 * @return Retorna o debito da conta
	 */
	public String getdebito() {
		double debito = this.debito;
		DecimalFormat formatador = new DecimalFormat(".00", new DecimalFormatSymbols(new Locale("en", "US")));
		String result = formatador.format(debito);
		return result;
	}
	/**
	 * Retorna um toString da conta
	 */
	public String toString() {
		String string = "";
		for(int i = 0; i < compras.size(); i++) {
			if(i != compras.size()-1) {
				string += compras.get(i) + " | ";
			}else {
				string += compras.get(i);
			}
		}
		
		return string;
	}
	/**
	 * Retorna o tamanho da lista de itens comprados
	 * @return
	 */
	public int tamanho() {
		return compras.size();
	}
}
