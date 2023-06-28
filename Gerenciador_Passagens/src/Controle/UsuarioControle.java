package Controle;

import Modelo.Usuario;

/**
 * Essa classe é responsável por armazenar o Usuario que criará a TelaUsuario.
 * 
 * @author joaoseisei
 * @since 2023
 * @version 1.1
 *
 */
public class UsuarioControle {
//ATRIBUTO
	private Usuario usuario;

//CONSTRUTOR
	/**
	 * Construtor para inicializar o UsuarioControle.
	 * 
	 * @param user
	 */
	public UsuarioControle(Usuario user) {
		this.usuario = user;
	}

//GETTER
	public Usuario getUsuario() {
		return usuario;
	}

//SETTER
	public void setUsuario(Usuario user) {
		this.usuario = user;
	}

//ADICIONAR FAVORITO
	/**
	 * Esse método é responsável por verificar por adicionar uma informação unica na
	 * lista de favoritos, isso para não existir favoritos iguais.
	 * 
	 * @param informacao String a ser adicionada nos favoritos do usuário.
	 */
	public void addFavoritoFiltrado(String informacao) {
		if (!usuario.getFavoritos().contains(informacao))
			usuario.addFavoritos(informacao);
	}
}