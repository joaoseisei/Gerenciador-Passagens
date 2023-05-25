package Controle;
import java.util.Random;

public class Conta {
//ATRIBUTOS
	private String nome;
	private String senha;
	private String idu;
	private boolean tipo;
//CONSTRUTOR
	public Conta(boolean tipo, String nome, String senha, String novaSenha) {
	//TIPO
		this.tipo = tipo;
	//NOME
		if(nome != null) {this.nome = nome;}
			else {throw new IllegalArgumentException("Nome Invalido");}
	//SENHA
		if( senha.equals(novaSenha)) {
			this.senha = criptografarSenha(senha);
			}	
			else {throw new IllegalArgumentException("Senhas diferentes :(");}
	//ID DO USUARIO
		this.idu = String.format(nome + "%07d", new Random().nextInt(100000));
	}
//GETTERS
	public boolean getTipo() {
		return tipo;
	}
	public String getNome() {
		return nome;
	}
	public String getSenha() {
		return senha;
	}
//CRIPTOGRAFIA
	public String criptografarSenha(String senha) {
		for(int j = 1; j<=10; j++) {
			String criptografia = "";
		    String letraI = "";
		    for (int i = 0; i < senha.length(); i++) {
		    	char letra = senha.charAt(i);
		        if (i % 2 == 1) {
		            letraI += letra + "Ç";
		        }else{
		            criptografia += letra + "Ñ";
		           }
		     }
		     criptografia += letraI + criptografia ;
		     if( j ==10) {
		    	 senha = "@" + criptografia;
		     }
		}return senha;
	}
//TOSTRING
	public String toString() {
		return "Nome: " + nome + " | ID usuario: " + idu + " | Senha: " + senha + " | Empresa: " + tipo;
	}
}