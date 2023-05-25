package Controle;
import java.util.ArrayList;

import Modelo.*;

public class Usuario extends Conta{
//ATRIBUTOS
	private ArrayList<PassagemAviao> passagensAviaoF = new ArrayList<>();
	private ArrayList<PassagemOnibus> passagensOnibusF = new ArrayList<>();
//CONSTRUTOR
	public Usuario(boolean tipo, String nome, String senha, String novaSenha) {
		super(tipo, nome, senha, novaSenha);
	}
//ADICIONANDO FAVORITOS
	public void addFavoritoAviao(String id) {
		//adicionar
	}
	public void addFavoritoOnibus(String id) {
		
	}
}
