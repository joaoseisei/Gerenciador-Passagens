package Modelo;

public class Admin extends Conta{
//ATRIBUTOS
	private Integer mudancaFeita = 0;
//CONSTRUTOR
	public Admin(boolean tipo, String nome, String senha) {
		super(tipo, nome, senha);
	}
//GETTERS
	public Integer getMudancaFeita() {
		return mudancaFeita;
	}
//SETTERS
	public void setMudancaFeita(Integer novaMudanca) {
		this.mudancaFeita = novaMudanca;
	}
//ADD MUDANCA
	public void addMudanca() {
		mudancaFeita ++;
	}
//TOSTRING
	public String toString() {
		return super.toString() + "USUARIO ADMIN" ;
	}
}