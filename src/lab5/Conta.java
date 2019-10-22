package lab5;

import java.util.ArrayList;
import java.util.List;

public class Conta {
	private String nomeCliente;
	private double debito;
	private List<Compra> compras;
	
	public Conta(String nomeCliente) {
		this.nomeCliente = nomeCliente;
		this.compras = new ArrayList<>();
	}
	
	public void addcompra(String data, String nome, double preço) {
		Compra compra = new Compra(nome, data, preço);
		this.compras.add(compra);
	}
}
