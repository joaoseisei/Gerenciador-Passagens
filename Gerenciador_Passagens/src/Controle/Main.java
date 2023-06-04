package Controle;
import Modelo.Memoria;
import View.Login;

public class Main {	
	public static void main(String[] args) {
		Memoria memoria = new Memoria();
		Login login = new Login();
		TelaLoginControle TLControle = new TelaLoginControle(memoria, login);
		login.exibir();
		TLControle.criarContaButton();
		TLControle.fazerLoginButton();
	}	
}