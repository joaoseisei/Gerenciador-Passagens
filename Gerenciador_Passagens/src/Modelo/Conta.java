package Modelo;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import java.util.Arrays;
/**
 * A classe conta é uma classe abstrada que possui atributos basicos de uma conta
 * como nome, senha e o tipo de conta e irá servir para ser herdada pelas classes:
 * Usuario e Admin
 * 
 * @author joaoseisei
 * @since 2023
 * @version V1.2
 *
 */
public abstract class Conta {
//ATRIBUTOS
	private String nome;
	private String senha;
	private boolean tipo;
//CONSTRUTOR
	/**
	 * Construtor para inicialziar as variaveis da classe, nele existe uma verificação para não 
	 * deixar o nome nulo e uma função que salva a senha como uma senha criptografada.
	 * @param tipo Tipo de conta, se for false é uma conta de Usuario.
	 * @param nome Nome da conta.
	 * @param senha Senha da conta, íra passar pela função criptografarSenha e salvará 
	 * o retorno da função como o parametro senha.
	 */
	public Conta(boolean tipo, String nome, String senha) {
	//TIPO
		this.tipo = tipo;
	//NOME
		if(nome != null) this.nome = nome;
			else throw new IllegalArgumentException("Nome Invalido");
	//SENHA
		this.senha = criptografarSenha(senha);	
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
	/**
	 * Essa função funçao recebe uma String e criptografa ela e em seguida faz o retorno da sstring criptografada.
	 * @param senha String que será encriptada.
	 * @return O retorno é uma criptografia do parametro senha.
	 * @throws Esse método pode gerar 2 possíveis erros o InvalidKeySpecExcetion e o NoSuchAlgorithmException,
	 * entretanto como o código é hardcode nunca dará erro, é extremamente confiável. Sendo assim, como nunca 
	 * acontecerá eu retorno a própria função.
	 */
	public String criptografarSenha(String senha) {
		byte[] sal = new byte[16];
		KeySpec spec = new PBEKeySpec(senha.toCharArray(), sal, 65536, 128);
		try {
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			byte[] senhaHash = factory.generateSecret(spec).getEncoded();
			return Arrays.toString(senhaHash);
		} catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
//TOSTRING
	public String toString() {
		return "Nome: "+nome+" | Senha: "+senha+" | Empresa: "+tipo+"\n";
	}
}