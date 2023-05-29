package Modelo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

public class Itinerario {
//ATRIBUTOS
	private LocalDate dataInicial, dataFinal;   	 //DATAS
	private LocalTime horaInicial, horaFinal; 		 //HORAS
	private String pontPartida, pontChegada;   		 //DECOLAGEM E POUSO
	private final String idItinerario;				 //ID ITINERARIO
//CONSTRUTOR
	public Itinerario(LocalDate dataInicial, LocalDate dataFinal, LocalTime horaInicial, 
					  LocalTime horaFinal,String pontPartida, String pontChegada) {
	//DATA INICIAL
    	this.dataInicial = dataInicial;
    //DATA FINAL
    	if(dataFinal.isAfter(dataInicial) || dataFinal.equals(dataInicial)) {this.dataFinal = dataFinal;}
    		else {throw new IllegalArgumentException("Data final é anterior a inicial");}
    //HORA INICIAL
    	this.horaInicial = horaInicial;
    //HORA FINAL
    	if(dataFinal.isAfter(dataInicial) || dataFinal.equals(dataInicial) && horaFinal.isAfter(horaInicial)) {this.horaFinal = horaFinal;}
    		else {throw new IllegalArgumentException("Data final é anterior a inicial");}
    //PONTO DE PARTIDA
		this.pontPartida = pontPartida;
	//PONTO DE CHEGADA
		if(pontChegada.equals(pontPartida)) {throw new IllegalArgumentException("Local de decolagem igual ao de pouso");}
			else {this.pontChegada = pontChegada;}
	//ID ITINERARIO
		this.idItinerario = String.format("%07d", new Random().nextInt(100000));
	}
//GETTERS
	public LocalDate getDataInicial() {
		return dataInicial;
	}
	public LocalDate getDataFinal() {
		return dataFinal;
	}
	public LocalTime getHoraInicial() {
		return horaInicial;
	}
	public LocalTime getHoraFinal() {
		return horaFinal;
	}
	public String getPontPartida() {
		return pontPartida;
	}
	public String getPontChegada() {
		return pontChegada;
	}
	public String getIdItinerario() {
		return idItinerario;
	}
//SETTERS
	public void setDataInicial(LocalDate novoInicio) {
		if(novoInicio != null) {
			this.dataInicial = novoInicio;
		}
	}
	public void setDataFinal(LocalDate novoFinal) {
		if(novoFinal != null) {
			this.dataFinal = novoFinal;
		}
	}
	public void setHoraInicial(LocalTime novaHoraInicial) {
		if(novaHoraInicial != null) {
			this.horaInicial = novaHoraInicial;
		}
	}
	public void setHoraFinal(LocalTime novaHoraFinal) {
		if(novaHoraFinal != null) {
			this.horaFinal = novaHoraFinal;
		}
	}
	public void setPontPartida(String novoPontPartida) {
		if(novoPontPartida != null && novoPontPartida != pontChegada) {
			this.pontPartida = novoPontPartida;
		}
	}
	public void setPontChegada(String novoPontChegada) {
		if(novoPontChegada != null && novoPontChegada != pontPartida) {
			this.pontChegada = novoPontChegada;
		}
	}
//ToString
	public String toString() {
		return "ITINERARIO:"+dataInicial+" / "+horaInicial+" | "+dataFinal+" / "+horaFinal+" | "+pontPartida+" | "+pontChegada;
	}
}