package Modelo;
/**
 * A classe Admin é uma extensão da classe Conta, nela tem um atributo de mudanças feitas, para gerenciar
 * as mudanças que um administrador fez no codigo.
 * 
 * @author joaoseisei
 * @since 2023
 * @version V1.2
 */
public class Admin extends Conta{
//ATRIBUTOS
	private Integer mudancaFeita = 0;
//CONSTRUTOR
	/**
	 * Construtor para inicialziar as variaveis da classe e é herdada da classe mãe Conta. 
	 * Sendo assim, o nome e senha já estão sendo tratados.
	 * @param tipo Tipo de conta, se for true é uma conta Administrativa.
	 * @param nome Nome da conta.
	 * @param senha Senha da conta.
	 */
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
	/**
	 * Toda vez que executar esse método é somado 1 no atributo mudancaFeita
	 */
	public void addMudanca() {
		mudancaFeita ++;
	}
//TOSTRING
	public String toString() {
		return super.toString() + "USUARIO ADMIN" ;
	}
}