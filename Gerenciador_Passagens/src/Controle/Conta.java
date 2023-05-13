package Controle;
import java.util.Random;

public class Conta {
//Atributos
	private String nome;
	private String senhaCriptografada = "";
	private String idu;
	private char[] criptografia;
//Construtor
	public Conta(String nome, String senha, String novaSenha) {
	//NOME
		if(nome != null) {this.nome = nome;}
			else {throw new IllegalArgumentException("Nome Invalido");}
	//SENHA
		if( senha.equals(novaSenha)) {criptografarSenha(senha);}	
			else {throw new IllegalArgumentException("Senhas diferentes :(");}
	//ID DO USUARIO
		this.idu = String.format(nome + "%07d", new Random().nextInt(100000));
	}
//GETTERS
	public String getNome() {
		return nome;
	}
	public String getSenhaCriptografada() {
		return senhaCriptografada;
	}
//Criptografia
	private void criptografarSenha(String senha) {
		for(int i = criptografia.length - 1 ; i >= 0; i--) {
			senhaCriptografada += criptografia[i] + "Ç";
		}
		senhaCriptografada = senhaCriptografada.substring(0, senhaCriptografada.length()-1);
	}
}
