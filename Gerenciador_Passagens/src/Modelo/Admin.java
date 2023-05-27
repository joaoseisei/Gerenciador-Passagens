package Modelo;

public class Admin extends Conta{
//CONSTRUTOR
	public Admin(boolean tipo, String nome, String senha, String novaSenha) {
		super(tipo, nome, senha, novaSenha);
	}
//TOSTRING
	public String toString() {
		return super.toString() + "USUARIO ADMIN" ;
	}
}