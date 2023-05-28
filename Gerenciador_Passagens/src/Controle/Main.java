package Controle;
import java.awt.event.*;
import Modelo.Memoria;
import View.*;

public class Main {
//OBJETOS
	static Login login = new Login();
	static Memoria memoria = new Memoria();
//CRIAR UMA CONTA
	public static void criarConta() {
		if(login.getNome().trim().isEmpty() || login.getSenha().trim().isEmpty()) {
			throw new IllegalArgumentException("NOME OU SENHA SÃO NULOS");
		}else {
			if((memoria.verificarUser(login.getNome(), login.getSenha()) == false || 
					memoria.getListaUsuario().isEmpty()) && login.getTipo() == false) {
				memoria.addConta(login.getTipo(), login.getNome(), login.getSenha(), login.getSenha());
			}else if((memoria.verificarAdmin(login.getNome(), login.getSenha()) == false || 
					memoria.getListaAdmin().isEmpty()) && login.getTipo() == true){
				memoria.addConta(login.getTipo(), login.getNome(), login.getSenha(), login.getSenha());
			}else {
				throw new IllegalArgumentException("EXISTE UMA CONTA CADASTRADA COM AS MESMAS CREDENCIAIS");
			}
		}
	}
//FAZER LOGIN
	public static void fazerLogin() {
		if(memoria.fazerLogin(login.getNome(), login.getSenha(), login.getTipo()).equals("UsuarioLogado")) {
			login.ocultar();
			TelaUsuario telaUser = new TelaUsuario(memoria.getUsuarioOBJ(login.getNome(), login.getSenha()));
			telaUser.exibir();
		}else if( memoria.fazerLogin(login.getNome(), login.getSenha(), login.getTipo()).equals("AdminLogado")) {
			login.ocultar();
			TelaAdmin telaADM = new TelaAdmin(memoria.getAdminOBJ(login.getNome(), login.getSenha()));
			telaADM.exibir();
		}
	}
//METODO MAIN
	public static void main(String[] args) {
		login.exibir();
	//BOTAO FAZER REGISTRO
		login.getFazerRegistro().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                criarConta();
            }
        });
	//BOTAO FAZER LOGIN	
		login.getFazerLogin().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fazerLogin();
			}
		});
	}	
}