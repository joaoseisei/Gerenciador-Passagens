	package Modelo;
import java.util.ArrayList;

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
	public Admin getAdminOBJ(String nome, String senha) {
		for(Admin index : listaAdmin) {
			if(index.getNome().equals(nome) && index.getSenha().equals(index.criptografarSenha(senha))) {
				return index;
			}
		}return null;
	}
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