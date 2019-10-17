package lab5;

import java.util.Comparator;

public class Ordenadora implements Comparator<Object>{
	
	@Override
	public int compare(Object obj1, Object obj2) {
		if(obj1 instanceof Cliente) {
			Cliente c1 = (Cliente) obj1;
			Cliente c2 = (Cliente) obj2;
			return c1.getNome().compareTo(c2.getNome());
		} else if(obj1 instanceof Fornecedor) {
			Fornecedor f1 = (Fornecedor) obj1;
			Fornecedor f2 = (Fornecedor) obj2;
			return f1.getNome().compareTo(f2.getNome());
		} else if (obj1 instanceof Produto) {
			Produto p1 = (Produto) obj1;
			Produto p2 = (Produto) obj2;
			return p1.getNome().compareTo(p2.getNome());
		} else if(obj1 instanceof String) {
			return ((String) obj1).compareTo((String) obj2);
		}
		return 0;
	}
}
