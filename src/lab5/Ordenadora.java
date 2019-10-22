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
		} else if (obj1 instanceof Produto && obj2 instanceof Produto) {
			Produto p1 = (Produto) obj1;
			Produto p2 = (Produto) obj2;
			return p1.getNome().compareTo(p2.getNome());
		} else if(obj1 instanceof String) {
			return ((String) obj1).compareTo((String) obj2);
		} else if(obj1 instanceof Produto && obj2 instanceof Combo) {
			Produto p1 = (Produto) obj1;
			Combo c1 = (Combo) obj2;
			return p1.getNome().compareTo(c1.getNome());
		} else if(obj1 instanceof Combo && obj2 instanceof Combo) {
			Combo p1 = (Combo) obj1;
			Combo c1 = (Combo) obj2;
			return p1.getNome().compareTo(c1.getNome());
		} else if(obj1 instanceof Combo && obj2 instanceof Produto) {
			Combo p1 = (Combo) obj1;
			Produto c1 = (Produto) obj2;
			return p1.getNome().compareTo(c1.getNome());
		}
		return 0;
	}
}
