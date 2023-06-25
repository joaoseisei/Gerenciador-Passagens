package Modelo;
import java.util.ArrayList;
/**
 * A classe Usuario é uma extensão da classe Conta, nela tem uma lista de favoritos, para salvar as
 * preferências do usuario.
 * 
 * @author joaoseisei
 * @since 2023
 * @version V1.2
 */
public class Usuario extends Conta{
//ATRIBUTOS
	/**
     * Lista de favoritos do usuário.
     */
	private ArrayList<String> listaFavoritos = new ArrayList<>();
//CONSTRUTOR
	/**
	 * Construtor para inicialziar as variaveis da classe e é herdada da classe mãe Conta. 
	 * Sendo assim, o nome e senha já estão sendo tratados.
	 * @param tipo Tipo de conta, se for false é uma conta de Usuario.
	 * @param nome Nome da conta.
	 * @param senha Senha da conta.
	 */
	public Usuario(boolean tipo, String nome, String senha) {
		super(tipo, nome, senha);
	}
//ADICIONANDO FAVORITOS
	/**
	 * O método addFavoritos é responsavel por adicionar uma String no atributo "listaFavoritos".
	 * @param favorito String a ser favoritada
	 */
	public void addFavoritos(String favorito) {
		listaFavoritos.add(favorito);
	}
//GETTER
	public ArrayList<String> getFavoritos() {
		return listaFavoritos;
	}
//TOSTRING
	public String toString() {
		return super.toString() + "Favoritos : " + listaFavoritos.toString(); 
	}
}