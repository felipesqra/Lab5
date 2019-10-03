package lab5;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FornecedorTest {

	Fornecedor fornecedor;
	Fornecedor fornecedor2;
	Produto produto1;
	Produto produto2;
	
	@BeforeEach
	void test() {
		this.fornecedor = new Fornecedor("Felipe", "felipe@ccc.com", "7499996565");
		this.fornecedor2 = new Fornecedor("Fornecedor", "email.com", "7412341234");
		this.fornecedor.addProduto("Pão", "Feito no forno", "2.5");
		this.fornecedor2.addProduto("Pão", "Feito na brasa", "4");

	}
	@Test
	void testaddProduto() {
		this.fornecedor.addProduto("Pão", "Feito no forno", "2.5");
	}
	
	
	@Test
	void testFornecedor() {
		Fornecedor fornecedor3 = new Fornecedor("Bruno", "bruno.com", "6558222");
	}
	
	@Test
	void testToString() {
		assertEquals(fornecedor2.toString(), "Fornecedor - email.com - 7412341234");
	}
	
	@Test
	void testlistarToString() {
		assertEquals(fornecedor2.listarToString(), "Fornecedor - email.com - 7412341234 | ");
	}
	
	@Test
	void testlistarProdutos() {
		assertEquals(fornecedor.listarProdutos(), "Felipe - Pão - Feito no forno - R$ 2.5 | ");
	}
	
	@Test
	void testeditarFornecedor() {
		fornecedor.editarFornecedor("felipe.s@gmail.com", "36414988");
	}
	@Test
	void testeditarProduto() {
		fornecedor2.editarProduto("Pão", "3.6");
	}
	@Test
	void testremoverProduto() {
		fornecedor.removerProduto("Pão");
	}
	
}
