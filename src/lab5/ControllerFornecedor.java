package lab5;

import java.util.HashMap;

public class ControllerFornecedor {
	private HashMap<String, Fornecedor> fornecedores;
	
	
	public ControllerFornecedor() {
		this.fornecedores = new HashMap<>();
	}
	
	public String cadastrarFornecedor(String nome, String email, String telefone) {
		Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
		String string = "";
		
		if(!fornecedores.containsKey(nome)) {
			fornecedores.put(nome, fornecedor);
		}else {
			
		}
		
		return string;
	}
	
	public String exibeFornecedor(String nome) {
		String string = "";
		
		if(fornecedores.containsKey(nome)) {
			string += fornecedores.get(nome).toString();
		}
		
		return string;
	}
	
	public String listarFornecedores() {
		String string = "";
		
		
		for(Fornecedor fornecedor: this.fornecedores.values()) {
			string += fornecedor.listarToString();
		}
		
		return string;
	}
	
	public void editarFornecedor(String nome, String email, String telefone) {
		Fornecedor fornecedor = this.fornecedores.get(nome);
		
		fornecedor.editarFornecedor(email, telefone);
	}
	
	public void removerFornecedor(String nome) {
		if(fornecedores.containsKey(nome)) {
			fornecedores.remove(nome);
		}
	}
	
	public String consultaProdutoFornecedor(String nomeFornecedor) {
		return fornecedores.get(nomeFornecedor).listarProdutos();
	}
	
	public String listarTodosProdutosDosFornecedores() {
		String string = "";
		
		for(Fornecedor fornecedor: fornecedores.values()) {
			string += fornecedor.listarProdutos();
		}
		return string;
	}
}
