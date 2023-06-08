package Modelo;
import java.util.ArrayList;

public class Usuario extends Conta{
//ATRIBUTOS
	private ArrayList<String> listaFavoritos = new ArrayList<>();
//CONSTRUTOR
	public Usuario(boolean tipo, String nome, String senha) {
		super(tipo, nome, senha);
	}
//ADICIONANDO FAVORITOS
	public void addFavoritos(String favorito) {
		listaFavoritos.add(favorito);
	}
//GETTER
	public ArrayList<String> getFavoritos() {
		return listaFavoritos;
	}
//TOSTRING
	public String toString() {
		return super.toString() + "Favoritos : " + listaFavoritos.toString(); 
	}
}