package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTest {
	
	private Cliente cliente1;
	private Cliente cliente2;
	
	@BeforeEach
	public void test() {
		this.cliente1 = new Cliente("863869655-82", "Felipe", "felipe.siqueira@ccc.ufcg.edu.br", "LCC3");
		this.cliente2 = new Cliente("123123123-23", "Pessoa", "pessoa.anonima@ccc.ufcg.edu.br", "LCC3");		
	}
	
	@Test
	void testCliente() {
		Cliente cliente3 = new Cliente("123123", "bribu", "bribu.baixaria@ccc.ufcg.edu.br", "LCC3");
	}
	@Test
	void testHashCode() {
		assertNotEquals(cliente1.hashCode(), cliente2.hashCode());
	}
	@Test
	void testGetCpf() {
		assertEquals(cliente1.getCpf(), "863869655-82");
	}
	@Test
	void testToString() {
		assertEquals(cliente1.toString(), "Felipe - LCC3 - felipe.siqueira@ccc.ufcg.edu.br\n");
	}
	@Test
	void testToStringListar() {
		assertEquals(cliente2.toStringListar(), "Pessoa - LCC3 - pessoa.anonima@ccc.ufcg.edu.br | ");
	}
	
	
}
