package lab5;



/**
 * Classe para tratamento de erros
 * 
 * @author Felipe de Souza Siqueira - 119110399
 */
public class Util {

	/**
	 * Valida parametros do tipo null
	 * 
	 * @param valor Valor passado pelo usuário
	 * @param mensagem Mensagem apresentada em caso de erro
	 */
	public static void validandoNull(String valor, String mensagem) {
		if(valor == null) {
			throw new NullPointerException(mensagem);
		}
	}
	
	/**
	 * Valida parâmetros que contenham apenas espaço.
	 * 
	 * @param valor Valor passado pelo usuário
	 * @param mensagem Mensagem apresentada em caso de erro
	 */
	public static void validaVazia(String valor, String mensagem) {
		if(valor.trim().isEmpty()) {
			throw new IllegalArgumentException(mensagem);
		}
	}
}
