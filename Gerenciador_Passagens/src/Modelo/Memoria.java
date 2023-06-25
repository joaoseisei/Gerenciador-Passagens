package Modelo;
import java.util.ArrayList;
/**
 * A classe memoria é responsavel por armazenar todos os dados do projeto em ArrayLists.
 * 
 * @author joaoseisei
 * @since 2023
 * @version V1.2
 */
public class Memoria {
//ATRIBUTOS
	private ArrayList<Itinerario> listaItinerario = new ArrayList<>(); 		
	private ArrayList<PassagemAviao> listaAviao = new ArrayList<>();		
	private ArrayList<PassagemOnibus> listaOnibus = new ArrayList<>();		
	private ArrayList<Admin> listaAdmin = new ArrayList<>();				
	private ArrayList<Usuario> listaUsuario= new ArrayList<>();				
//GETTERS	
	public ArrayList<Itinerario> getListaItinerario(){
		return new ArrayList<>(listaItinerario);
	}
	public ArrayList<PassagemAviao> getListaAviao(){
		return new ArrayList<>(listaAviao);
	}
	public ArrayList<PassagemOnibus> getListaOnibus(){
		return new ArrayList<>(listaOnibus);
	}
	public ArrayList<Admin> getListaAdmin(){
		return new ArrayList<>(listaAdmin);
	}
	public ArrayList<Usuario> getListaUsuario(){
		return new ArrayList<>(listaUsuario);
	}
	/**
	 * O método getAdminOBJ é responsável por buscar um admin na lista de admin e retornar o objeto dele
	 * @param nome Nome do admin a ser buscado.
	 * @param senha Senha do admin a ser buscado.
	 * @return Retorna o objeto admin encontrado e se nao encontrar nenhum correspondente retorna null.
	 */
	public Admin getAdminOBJ(String nome, String senha) {
		for(Admin index : listaAdmin) {
			if(index.getNome().equals(nome) && index.getSenha().equals(index.criptografarSenha(senha))) {
				return index;
			}
		}return null;
	}
	/**
	 * O método getUsuarioOBJ é responsável por buscar um usuario na lista de usuarios e retornar o objeto dele.
	 * @param nome Nome do usuário a ser buscado.
	 * @param senha Senha do usuário a ser buscado.
	 * @return Retorna o objeto usuário encontrado se não encontrar nenhum correspondente retorna null.
	 */
	public Usuario getUsuarioOBJ(String nome, String senha) {
		for(Usuario index : listaUsuario) {
			if(index.getNome().equals(nome) && index.getSenha().equals(index.criptografarSenha(senha))) {
				return index;
			}
		}return null; 
	}	
//SETTERS
	public void setListaItinerario(ArrayList<Itinerario> novaListaItinerario){
		this.listaItinerario = novaListaItinerario;
	}
	public void setListaAviao(ArrayList<PassagemAviao> novaListaAviao){
		this.listaAviao = novaListaAviao;
	}
	public void setListaOnibus(ArrayList<PassagemOnibus> novaListaOnibus){
		this.listaOnibus = novaListaOnibus;
	}
	public void setListaAdmin(ArrayList<Admin> novaListaAdmin){
		this.listaAdmin = novaListaAdmin;
	}
	public void setListaUsuario(ArrayList<Usuario> novaListaUsuario){
		this.listaUsuario = novaListaUsuario;
	}
}