package Controle;

import Modelo.Admin;
/**
 * Essa classe é responsável por armazenar o Admin que criará a TelaAdmin.
 * 
 * @author joaoseisei
 * @since 2023
 * @version 1.1
 *
 */
public class AdminControle {
//ATRIBUTO
	private Admin admin;
//CONSTRUTOR
	/**
	 * Construtor para inicializar o AdminControle.
	 * 
	 * @param adm
	 */
	public AdminControle(Admin adm) {
		this.admin = adm;
	}
//GETTER
	public Admin getAdmin() {
		return admin;
	}
//SETTER
	public void setAdmin(Admin adm) {
		this.admin = adm;
	}
//ADICIONAR MUDANCAS
	/**
	 * Esse método é responsável por adicionar +1 no objeto Admin.
	 */
	public void addMudanca() {
		admin.addMudanca();
	}
}
