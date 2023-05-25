package Controle;
import java.util.ArrayList;

public class MemoriaConta {
//ATRIBUTOS
	private ArrayList<Empresa> listaEmpresa = new ArrayList<>();		//LISTA DE CONTAS EMPRESARIAIS
	private ArrayList<Usuario> listaUsuario= new ArrayList<>();			//LISTA DE CONTAS PESSOAIS
//CRIAR CONTA
	public void criarConta(Boolean tipo, String nome, String senha, String novaSenha) {
		if(tipo) {
			Empresa novaEmpresa = new Empresa(tipo ,nome, senha, novaSenha);
			listaEmpresa.add(novaEmpresa);
		}else {
			Usuario novoUsuario = new Usuario(nome, senha, novaSenha);
			listaUsuario.add(novoUsuario);
		}
	}
	public ArrayList<Usuario> getListaUsuario() {
		return listaUsuario;
	}
//FAZER LOGIN
	public String fazerLogin(String nome, String senha, Boolean Empresa) {
		String resultadoLogin = "r";
		if(Empresa) {
			for(Empresa index : listaEmpresa) {
				if(index.getNome().equals(nome) && index.getSenha().equals(index.criptografarSenha(senha))){
					resultadoLogin = "EmpresaLogada";
		}}}else {
			for(Usuario index : listaUsuario) {
				if(index.getNome().equals(nome) && index.getSenha().equals(index.criptografarSenha(senha))){
					resultadoLogin = "UsuarioLogado";
		}}}return resultadoLogin;
	}
}
