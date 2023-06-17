package Controle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Modelo.Admin;
import Modelo.Memoria;
import Modelo.Usuario;
import View.*;

public class TelaLoginControle {
//ATRIBUTOS
	private Memoria memoria;
	private TelaLogin telaLogin;
//CONSTRUTOR
	public TelaLoginControle(Memoria memoria, TelaLogin telaLogin) {
		this.memoria = memoria;
		this.telaLogin = telaLogin;
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
		if(telaLogin.getNome() == null || telaLogin.getSenha() == null || telaLogin.getNovaSenha() == null 
		   || telaLogin.getNome().trim().isEmpty() || telaLogin.getSenha().trim().isEmpty() || telaLogin.getNovaSenha().trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "INPUTS NULOS","ERRO", JOptionPane.ERROR_MESSAGE);
		}else{// as linhas nao estão nulas entao é possivel trabalhar com dados
			if((verificarUserRegistro(telaLogin.getNome(), telaLogin.getSenha()) == false || memoria.getListaUsuario().isEmpty())
			&& telaLogin.getSenha().equals(telaLogin.getNovaSenha()) && telaLogin.getTipo() == false){
				//Se a lista de Usuarios esta vazia Ou o verificarUserRegistro for falso
				//E o tipo for falso (nao é adm) adicionamos esse usuario na memoria com addConta
				addConta(telaLogin.getTipo(), telaLogin.getNome(), telaLogin.getSenha());
			}else if((verificarAdminRegistro(telaLogin.getNome(), telaLogin.getSenha()) == false || memoria.getListaAdmin().isEmpty())
			&& telaLogin.getSenha().equals(telaLogin.getNovaSenha()) && telaLogin.getTipo() == true){
				addConta(telaLogin.getTipo(), telaLogin.getNome(), telaLogin.getSenha());
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
		if(verificacaoLogin(telaLogin.getNome(), telaLogin.getSenha(), telaLogin.getTipo()).equals("UsuarioLogado")) {
			telaLogin.ocultar();
			//DEFININDO A PROXIMA TELA E COLOCANDO AS FUNCIONALIDADES QUE ELA VAI TER 
			TelaUsuario telaUser = new TelaUsuario(memoria.getUsuarioOBJ(telaLogin.getNome(), telaLogin.getSenha()));
			TelaUsuarioControle tuControle = new TelaUsuarioControle(memoria, telaUser);
			telaUser.exibir();
			tuControle.filtrarButton();
			tuControle.atualizarFavoritosButton();
			
		}else if(verificacaoLogin(telaLogin.getNome(), telaLogin.getSenha(), telaLogin.getTipo()).equals("AdminLogado")) {
			telaLogin.ocultar();
			TelaAdmin telaAdmin = new TelaAdmin(memoria.getAdminOBJ(telaLogin.getNome(), telaLogin.getSenha()));
			TelaAdminControle taControle = new TelaAdminControle(memoria, telaAdmin);
			telaAdmin.exibir();
			taControle.criarButton();
			taControle.editarButton();
			taControle.excluirButton();
			taControle.atualizarButton();
		}
	}
//------------------------BOTOES-------------------------
	public void TLControler() {
		telaLogin.getConfirmacao().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(telaLogin.getLogando()) {
					fazerLogin();
				}else{
					criarConta();
				}
			}
		});
	}
}