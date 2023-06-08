package Controle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Modelo.Admin;
import Modelo.Memoria;
import Modelo.Usuario;
import View.Login;
import View.TelaAdmin;
import View.TelaUsuario;

public class TelaLoginControle {
//ATRIBUTOS
	private Memoria memoria;
	private Login login;
//CONSTRUTOR
	public TelaLoginControle(Memoria memoria, Login login) {
		this.memoria = memoria;
		this.login = login;
	}
//-------------------------VERIFICACAO---------------------------
	
	//Aqui verificamos se existe uma conta cadastrada com essas credenciais
	
	public boolean verificarUserRegistro(String nome, String senha) {
		for(Usuario index : memoria.getListaUsuario()) {
			if(index.getNome().equals(nome) && index.getSenha().equals(index.criptografarSenha(senha))){
				return true;
			}
		}//Vai passar objeto por objeto da listaUsuario e se algum objeto for igual vai 
		 //retornar true, e se nao tiver nenhum retornará falso.
		return false;
	}
	public boolean verificarAdminRegistro(String nome, String senha) {
		for(Admin index : memoria.getListaAdmin()) {
			if(index.getNome().equals(nome) && index.getSenha().equals(index.criptografarSenha(senha))){
				return true;
			}
		}return false;
	}
//----------------------CRIACAO DE CONTA------------------------
	public void addConta(Boolean tipo, String nome, String senha){
		ArrayList<Admin> novaListaAdmin = new ArrayList<>(memoria.getListaAdmin());
		ArrayList<Usuario> novaListaUsuario = new ArrayList<>(memoria.getListaUsuario());
		if(tipo){
			Admin novoAdmin = new Admin(tipo ,nome, senha);
			novaListaAdmin.add(novoAdmin);
			memoria.setListaAdmin(novaListaAdmin);	
		}else{
			Usuario novoUsuario = new Usuario(tipo, nome, senha);
			novaListaUsuario.add(novoUsuario);
			memoria.setListaUsuario(novaListaUsuario);
		}
	}
	public void criarConta() {
		if(login.getNome().trim().isEmpty() || login.getSenha().trim().isEmpty()){
			throw new IllegalArgumentException("NOME OU SENHA SÃO NULOS");
		}else{// as linhas nao estão nulas entao é possivel trabalhar com dados
			if((verificarUserRegistro(login.getNome(), login.getSenha()) == false || 
					memoria.getListaUsuario().isEmpty()) && login.getTipo() == false){
				//Se a lista de Usuarios esta vazia Ou o verificarUserRegistro for falso
				//E o tipo for falso (nao é adm) adicionamos esse usuario na memoria com addConta
				addConta(login.getTipo(), login.getNome(), login.getSenha());
			}else if((verificarAdminRegistro(login.getNome(), login.getSenha()) == false || 
					memoria.getListaAdmin().isEmpty()) && login.getTipo() == true){
				addConta(login.getTipo(), login.getNome(), login.getSenha());
			}else{
				JOptionPane.showMessageDialog(null, "EXISTE UMA CONTA CADASTRADA COM AS MESMAS CREDENCIAIS", 
				"ERRO", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
//----------------------FAZER LOGIN------------------------
	public String verificacaoLogin(String nome, String senha, Boolean Empresa) {
		if(Empresa) {
			for(Admin index : memoria.getListaAdmin()) {
				if(index.getNome().equals(nome) && index.getSenha().equals(index.criptografarSenha(senha))){
					return "AdminLogado";
				}
			}
		}else {
			for(Usuario index : memoria.getListaUsuario()) {
				if(index.getNome().equals(nome) && index.getSenha().equals(index.criptografarSenha(senha))){
					return "UsuarioLogado";
				}
			}
		}
		return "erro";
	}
	public void fazerLogin(){
		if(verificacaoLogin(login.getNome(), login.getSenha(), login.getTipo()).equals("UsuarioLogado")) {
			login.ocultar();
			//DEFININDO A PROXIMA TELA E COLOCANDO AS FUNCIONALIDADES QUE ELA VAI TER 
			TelaUsuario telaUser = new TelaUsuario(memoria.getUsuarioOBJ(login.getNome(), login.getSenha()));
			TelaUsuarioControle tuControle = new TelaUsuarioControle(memoria, telaUser);
			telaUser.exibir();
			tuControle.filtrarButton();
			tuControle.atualizarFavoritosButton();
			
		}else if(verificacaoLogin(login.getNome(), login.getSenha(), login.getTipo()).equals("AdminLogado")) {
			login.ocultar();
			TelaAdmin telaAdmin = new TelaAdmin(memoria.getAdminOBJ(login.getNome(), login.getSenha()));
			TelaAdminControle taControle = new TelaAdminControle(memoria, telaAdmin);
			telaAdmin.exibir();
			taControle.criarButton();
			taControle.editarButton();
			taControle.excluirButton();
			taControle.atualizarButton();
		}
	}
//------------------------BOTOES-------------------------
	public void criarContaButton() {
		login.getFazerRegistro().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                criarConta();
                System.out.println(memoria.getListaUsuario());
            }
        });
	}
	public void fazerLoginButton() {
		login.getFazerLogin().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fazerLogin();
			}
		});	
	}
}