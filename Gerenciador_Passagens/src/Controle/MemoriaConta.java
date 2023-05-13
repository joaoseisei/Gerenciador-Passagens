package Controle;
import java.util.ArrayList;

public class MemoriaConta {
//ATRIBUTOS
	private ArrayList<Empresa> listaEmpresa = new ArrayList<>();		//LISTA DE CONTAS EMPRESARIAIS
	private ArrayList<Usuario> listaUsuario= new ArrayList<>();			//LISTA DE CONTAS PESSOAIS
	
	public void fazerLogin(Boolean Empresa, String nome, String senha) {
		if(Empresa) {
			for(Empresa index : listaEmpresa) {
				if(index.getNome().equals(nome) && index.getSenhaCriptografada().equals(criptografarSenha(senha))){
					
					//FAZER APARECER A TELA DE LOGIN DO USUARIO
				}	
			}
		}else {
			for(Usuario index : listaUsuario) {
				if(index.getNome().equals(nome) && index.getSenhaCriptografada().equals(criptografarSenha(senha))){
					
					//FAZER APARECER A TELA DE LOGIN DA EMPRESA
				}
			}
		}
	}
	
	public void criarConta(Boolean Empresa, String nome, String senha, String novaSenha) {
		if(Empresa) {
			Empresa novaEmpresa = new Empresa(nome, senha, novaSenha);
			listaEmpresa.add(novaEmpresa);
		}else {
			Usuario novoUsuario = new Usuario(nome, senha, novaSenha);
			listaUsuario.add(novoUsuario);
		}
	}

//Criptografia
	private String criptografarSenha(String senha) {
		char[] criptografia = senha.toCharArray();
		for(int i = criptografia.length - 1 ; i >= 0; i--) {senha += criptografia[i] + "Ç";}
		return senha.substring(0, senha.length()-1);
	}
}
