package Controle;
import java.awt.event.*;
import Modelo.Memoria;
import View.*;

public class Main {
//METODO MAIN
	static Login login = new Login();
	static TelaUsuario telaUser = new TelaUsuario();
	static Memoria memoria = new Memoria();
	public static void trocarTela(ActionEvent e) {
		if(login.getNomeTF().trim().isEmpty() && login.getSenhaTF().trim().isEmpty()) {
			System.out.println("erro, nome ou senha nulos");
		}else {
			login.setNome(login.getNomeTF());
			login.setSenha(login.getSenhaTF());
			System.out.println(login.getNome() + login.getSenha());
			login.ocultar();
			System.out.println("trocando de tela...");
			telaUser.exibir();
			memoria.addConta(false, login.getNome(), login.getSenha(), login.getSenha());
			System.out.println(memoria.getListaUsuario());
		}
	}
	public static String getUsuario() {
		return memoria.getListaUsuario().toString();
	}
	public static void main(String[] args) {
		login.exibir();
		telaUser.ocultar();
		login.getBC().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                trocarTela(e);
            }
        });
	}
}