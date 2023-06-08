package Modelo;
import java.util.Random;

public class Conta {
//ATRIBUTOS
	private String nome;
	private String senha;
	private boolean tipo;
	private final String idu;
//CONSTRUTOR
	public Conta(boolean tipo, String nome, String senha) {
	//TIPO
		this.tipo = tipo;
	//NOME
		if(nome != null) {this.nome = nome;}
			else {throw new IllegalArgumentException("Nome Invalido");}
	//SENHA
		this.senha = criptografarSenha(senha);
	//ID DO USUARIO
		this.idu = String.format(nome + "%07d", new Random().nextInt(100000));
	}
//GETTERS
	public String getNome() {
		return nome;
	}
	public String getSenha() {
		return senha;
	}
	public boolean getTipo() {
		return tipo;
	}
	public String getIDU() {
		return idu;
	}
//CRIPTOGRAFIA
	public String criptografarSenha(String senha) {
		String criptografia = "";
	    String letraI = "";
		for(int j = 1; j<=2; j++) {
		    for (int i = 0; i < senha.length(); i++) {
		    	char letra = senha.charAt(i);
		        if (i % 2 == 1) {
		            letraI += letra + "WÇ";
		        }else{
		            criptografia += letra + "ÇÑ";
		           }
		     }
		     criptografia += letraI + criptografia ;
		     if( j == 2) {
		    	 senha = "@" + criptografia;
		     }
		}return senha;
	}
//TOSTRING
	public String toString() {
		return "Nome: " + nome + " | ID usuario: " + idu + " | Senha: " + senha + " | Empresa: " + tipo + "\n";
	}
}