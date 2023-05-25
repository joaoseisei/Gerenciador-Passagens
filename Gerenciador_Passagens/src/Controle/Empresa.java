package Controle;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import Modelo.*;

public class Empresa extends Conta{
//ATRIBUTOS
	private ArrayList<Itinerario> itinerario = new ArrayList<>();
	private ArrayList<PassagemAviao> passagensAviao = new ArrayList<>();
	private ArrayList<PassagemOnibus> passagensOnibus = new ArrayList<>();
//CONSTRUTOR
	public Empresa(boolean tipo, String nome, String senha, String novaSenha) {
		super(tipo, nome, senha, novaSenha);
	}
//GETTERS
	public ArrayList<Itinerario> getItinerario(){
		return itinerario;
	}
	public ArrayList<PassagemAviao> getPassagensAviao(){
		return passagensAviao;
	}
	public ArrayList<PassagemOnibus> getPassagensOnibus(){
		return passagensOnibus;
	}
//CRIAR ITINERARIO
	public void criarItinerario(LocalDate dataInicial, LocalDate dataFinal, LocalTime horaInicial, 
			  					LocalTime horaFinal,String pontPartida, String pontChegada) {
		Itinerario novoItinerario = new Itinerario(dataInicial, dataFinal, horaInicial, 
												   horaFinal, pontPartida, pontChegada);
		itinerario.add(novoItinerario);
	}
//CRIAR PASSAGEM PELO ITINERARIO
	
	
	
//TOSTRING
	public String toString() {
		return super.toString()
			+ "\n Itinerarios: " + itinerario 
			+ "\n Passagens de Avião: " + passagensAviao
			+ "\n Passagens de Onibus: " + passagensOnibus;
	}
}
