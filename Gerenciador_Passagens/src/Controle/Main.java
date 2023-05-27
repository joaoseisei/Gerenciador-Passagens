package Controle;
import java.awt.event.*;
import Modelo.Memoria;
import View.*;

public class Main {
//OBJETOS
	static Login login = new Login();
	static Memoria memoria = new Memoria();
	static TelaUsuario telaUser = new TelaUsuario();
	static TelaAdmin telaADM = new TelaAdmin();
//CRIAR UMA CONTA
	public static void criarConta(ActionEvent e) {
		if(login.getNome().trim().isEmpty() || login.getSenha().trim().isEmpty()) {
			throw new IllegalArgumentException("NOME OU SENHA SÃO NULOS");
		}else {
			if(memoria.verificarUser(login.getNome(), login.getSenha()) == false || 
					memoria.getListaUsuario().isEmpty()) {
				
				memoria.addConta(login.getTipo(), login.getNome(), login.getSenha(), login.getSenha());
			}else {
				throw new IllegalArgumentException("EXISTE UM USUARIO CADASTRADO COM AS MESMAS CREDENCIAIS");
			}
		}
	}
//FAZER LOGIN
	public static void fazerLogin() {
		if(memoria.fazerLogin(login.getNome(), login.getSenha(), login.getTipo()).equals("UsuarioLogado")) {
			login.ocultar();
			telaUser.exibir();
		}else if( memoria.fazerLogin(login.getNome(), login.getSenha(), login.getTipo()).equals("AdminLogado")) {
			login.ocultar();
			telaADM.exibir();
		}
	}
//METODO MAIN
	public static void main(String[] args) {
		login.exibir();
		login.getFazerRegistro().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                criarConta(e);
            }
        });
		login.getFazerLogin().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fazerLogin();
			}
		});
	}
	
}