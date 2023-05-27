package Modelo;
import java.util.ArrayList;

public class Usuario extends Conta{
//ATRIBUTOS
	private ArrayList<PassagemAviao> passagensAviaoF = new ArrayList<>();
	private ArrayList<PassagemOnibus> passagensOnibusF = new ArrayList<>();
//CONSTRUTOR
	public Usuario(boolean tipo, String nome, String senha, String novaSenha) {
		super(tipo, nome, senha, novaSenha);
	}
//ADICIONANDO FAVORITOS
	public void addFavoritoAviao(PassagemAviao passagemFavorita) {
		passagensAviaoF.add(passagemFavorita);
	}
	public void addFavoritoOnibus(PassagemOnibus passagemFavorita) {
		passagensOnibusF.add(passagemFavorita);
	}
//GETTER
	public ArrayList<PassagemAviao> getPassagemAviaoF(){
		return new ArrayList<>(passagensAviaoF);
	}
	public ArrayList<PassagemOnibus> getPassagemOnibusF(){
		return new ArrayList<>(passagensOnibusF);
	}
}