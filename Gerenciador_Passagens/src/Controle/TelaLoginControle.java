package Controle;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import java.util.ArrayList;

import Modelo.Admin;
import Modelo.Memoria;
import Modelo.Usuario;
import View.*;
/**
 * A classe telaLoginControle é responsável por gerenciar o acesso as telas "TelaAdmin" e "TelaUsuario',
 * através do controle de Admin e Usuario no banco de dados "memoria".
 * 
 * @author joaoseisei
 * @since 2023
 * @version V2.1
 *
 */
public class TelaLoginControle {
//ATRIBUTOS
	private Memoria memoria;
	private TelaLogin telaLogin;
//CONSTRUTOR
	/**
	 * Esse construtor é responsável por vincular a TelaLogin e a Memoria na classe, para poder
	 * utilizar banco de dados e botoẽs.
	 * @param memoria Banco de dados
	 * @param telaLogin Botões e inputs
	 */
	public TelaLoginControle(Memoria memoria, TelaLogin telaLogin) {
		this.memoria = memoria;
		this.telaLogin = telaLogin;
	}
//-------------------------VERIFICACAO---------------------------
	/**
	 * Esse método é responsável por verificar se existe um Usuario com o mesmo nome.
	 * @param nome Nome a ser verificado.
	 * @return Retorna true se existe um usuário com o mesmo nome e false se o nome está disponivel.
	 */
	public boolean verificarUserRegistro(String nome) {
		for(Usuario index : memoria.getListaUsuario()) {
			if(index.getNome().equals(nome))return true;
			//Vai passar objeto por objeto da listaUsuario e se algum objeto tiver o 
			//nome igual retornar true, e se nao tiver nenhum retornará falso.
		}return false;
	}
	/**
	 * Esse método é responsável por verificar se existe um Admin com o mesmo nome.
	 * @param nome Nome a ser verificado.
	 * @return Retorna true se existe um usuário com o mesmo nome e false se o nome está disponivel.
	 */
	public boolean verificarAdminRegistro(String nome) {
		for(Admin index : memoria.getListaAdmin()) {
			if(index.getNome().equals(nome))return true;
		}return false;
	}
//----------------------CRIACAO DE CONTA------------------------
	/**
	 * O método addConta é responsável por adicionar uma conta no banco de dados "Memoria",
	 * essa função utiliza somente os getters e setters para adicionar na conta.
	 * @param tipo Tipo de conta, se for true é administrativa e se for false é de usuário.
	 * @param nome Nome da conta.
	 * @param senha Senha da conta.
	 */
	public void addConta(Boolean tipo, String nome, String senha){
		if(tipo){
			ArrayList<Admin> novaListaAdmin = new ArrayList<>(memoria.getListaAdmin());
			
			Admin novoAdmin = new Admin(tipo ,nome, senha);
			novaListaAdmin.add(novoAdmin);
			memoria.setListaAdmin(novaListaAdmin);	
		}else{
			ArrayList<Usuario> novaListaUsuario = new ArrayList<>(memoria.getListaUsuario());
			
			Usuario novoUsuario = new Usuario(tipo, nome, senha);
			novaListaUsuario.add(novoUsuario);
			memoria.setListaUsuario(novaListaUsuario);
		}
	}
	/**
	 * O método criar conta é responsável por vincular o método addCOnta com os valores
	 * dos inputs, para isso  ela filtra e analisa os dados recebidos não permitindo criar conta caso
	 * os inputs sejam nulos ou as senhas forem diferentes, se for diferente disso ele ira ver se já 
	 * existe um usuário com o mesmo nome e se não tiver ele cadastra utilizando a função addConta.
	 * @param nome Nome do usuário.
	 * @param senha Senha do Usuário.
	 * @param novaSenha Confirmação de senha.
	 * @param tipo Tipo, se for true é cadastra uma conta administrativa e se for falso cadastra uma conta
	 * de usuário.
	 */
	public void criarConta(String nome, String senha, String novaSenha, boolean tipo) {
		if(nome==null||senha==null||novaSenha==null||nome.trim().isEmpty()||senha.trim().isEmpty()||novaSenha.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "INPUTS NULOS","ERRO", JOptionPane.ERROR_MESSAGE);
		}else if(senha.equals(novaSenha)){
			if((verificarUserRegistro(nome)==false || memoria.getListaUsuario().isEmpty())
			&& tipo == false){
				addConta(tipo, nome, senha);
			}else if((verificarAdminRegistro(nome)==false || memoria.getListaAdmin().isEmpty())
			&& tipo == true){
				addConta(telaLogin.getTipo(), telaLogin.getNome(), telaLogin.getSenha());
			}else{
				JOptionPane.showMessageDialog(null, "Já existe um usuario cadastrado com esse nome","ERRO", JOptionPane.ERROR_MESSAGE);
			}
		}else{
			JOptionPane.showMessageDialog(null, "AS SENHAS NÃO COICIDEM","ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
//----------------------FAZER LOGIN------------------------
	/**
	 * Esse método responsável por verificar se existe um usuário existente com o mesmo nome, mesma
	 * senha e mesmo tipo no banco de dados.
	 * @param nome Nome a ser analisado.
	 * @param senha Senha a ser analisada.
	 * @param tipo Tipo de conta, se for true é administrativa e se for false e usuário.
	 * @return Se existir um usuário ou admin correspondente o retorno será "UsuarioLogado" ou "AdminLogado"
	 * respectivamente, se não tiver nenhum correspondente o resultado será "NenhumaContaEncontada".
	 */
	public String verificacaoLogin(String nome, String senha, Boolean tipo) {
		if(tipo){
			for(Admin index : memoria.getListaAdmin()) {
				if(index.getNome().equals(nome) && index.getSenha().equals(index.criptografarSenha(senha))){
					return "AdminLogado";
				}
			}
		}else{
			for(Usuario index : memoria.getListaUsuario()) {
				if(index.getNome().equals(nome) && index.getSenha().equals(index.criptografarSenha(senha))){
					return "UsuarioLogado";
				}
			}
		}return "NenhumaContaEncontrada";
	}
	/**
	 * Esse método é responsável por gerenciar o acesso a outras telas, através do metódo verificacaoLogin.
	 * @param nome Nome a ser analisado.
	 * @param senha Senha a ser analisado.
	 * @param tipo Tipo de conta, se for true é administrativa e se for false e usuário.
	 */
	public void fazerLogin(String nome, String senha, boolean tipo){
		if(verificacaoLogin(nome,senha,tipo).equals("UsuarioLogado")) {
			telaLogin.ocultar();
			TelaUsuario telaUser = new TelaUsuario(memoria.getUsuarioOBJ(nome,senha));
			TelaUsuarioControle tuControle = new TelaUsuarioControle(memoria, telaUser);
			telaUser.exibir();
			tuControle.filtrarButton();
			tuControle.filtrarFavoritos();
			
			telaUser.getSair().addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						telaUser.ocultar();
						telaLogin.exibir();
					}
				}
			);
			
		}else if(verificacaoLogin(nome,senha,tipo).equals("AdminLogado")){
			telaLogin.ocultar();
			TelaAdmin telaAdmin = new TelaAdmin(memoria.getAdminOBJ(nome,senha));
			TelaAdminControle taControle = new TelaAdminControle(memoria, telaAdmin);
			telaAdmin.exibir();
			taControle.criarButton();
			taControle.editarButton();
			taControle.excluirButton();
			taControle.atualizarButton();
		}
		else JOptionPane.showMessageDialog(null, "USARIO NÃO ENCONTRADO","ERRO", JOptionPane.ERROR_MESSAGE);
	}
//------------------------BOTOES-------------------------
	/**
	 * Essa função é responsavel por gerenciar o clique do botão de confirmação de login e cadastro de conta.
	 * Além disso, a função MouseCliked é chamada e ela executa 2 funções a de criar conta e fazer login e o
	 * que irá diferenciar se o usuario está logando ou criando conta é o boolean "Logando", 
	 * isso é util para o mesmo botao ter 2 funcionalidades diferentes. 
	 */
	public void TLControler() {
		telaLogin.getConfirmacao().addMouseListener(
			new MouseAdapter() {
				/**
				 * Detecta o clique do mouse do botão Confirmação.
				 * @param e Recebe como parametro o evento do clique do mouse
				 */
				public void mouseClicked(MouseEvent e){
					if(telaLogin.getLogando())fazerLogin(telaLogin.getNome(),telaLogin.getSenha(),telaLogin.getTipo());
					else criarConta(telaLogin.getNome(),telaLogin.getSenha(),telaLogin.getNovaSenha(),telaLogin.getTipo());	
				}
			}	
		);
	}
}