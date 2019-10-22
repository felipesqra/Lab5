package lab5;

import java.util.ArrayList;
import java.util.List;

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
	 */
	public void addcompra(String data, String nome, double preço) {
		Compra compra = new Compra(nome, data, preço);
		this.compras.add(compra);
	}
}
