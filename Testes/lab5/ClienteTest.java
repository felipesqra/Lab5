package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTest {
	
	private Cliente cliente1;
	private Cliente cliente2;
	
	@BeforeEach
	public void test() {
		this.cliente1 = new Cliente("86386965582", "Felipe", "felipe.siqueira@ccc.ufcg.edu.br", "LCC3");
		this.cliente2 = new Cliente("12312312323", "Pessoa", "pessoa.anonima@ccc.ufcg.edu.br", "LCC3");		
	}
	
	@Test
	void testCliente() {
		Cliente cliente3 = new Cliente("12312312382", "bribu", "bribu.baixaria@ccc.ufcg.edu.br", "LCC3");
	}
	@Test
	void testHashCode() {
		assertNotEquals(cliente1.hashCode(), cliente2.hashCode());
	}
	@Test
	void testGetCpf() {
		assertEquals(cliente1.getCpf(), "86386965582");
	}
	@Test
	void testToString() {
		assertEquals(cliente1.toString(), "Felipe - LCC3 - felipe.siqueira@ccc.ufcg.edu.br");
	}
	
}
