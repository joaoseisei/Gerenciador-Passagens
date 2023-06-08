package Modelo;
import java.time.*;
import java.util.*;

public abstract class Passagem {
//ATRIBUTOS
	private Itinerario itinerario;					 //ITINERARIO
    private String[] escalas;                    	 //ESCALAS
    private Integer numEscalas; 					 //NUMERO DE ESCALAS
	private Double preco;            		    	 //PREÇO
	private String marca;							 //MARCA
	private final String id;                    	 //ID DO ITINERARIO 
//CONSTRUTOR	
    public Passagem(LocalDate dataInicial, LocalDate dataFinal, LocalTime horaInicial, LocalTime horaFinal,
    				String pontPartida, String pontChegada, String[] escalas, Double preco, String marca) {
    //ITINERARIO
    	this.itinerario = new Itinerario(dataInicial, dataFinal, horaInicial, horaFinal, pontPartida, pontChegada);
    //LISTA ESCALAS
    	this.escalas = escalas != null ? escalas.clone() : new String[0];// se o array for nulo ele retorna um array vazio
	//NUMERO DE ESCALAS
    	if(escalas != null) {this.numEscalas = escalas.length;}
    		else { this.numEscalas = 0;}
	//PRECO
    	if(preco > 0) {this.preco = preco;}
    		else {throw new IllegalArgumentException("Preço não pode ser negativo");}
	//MARCA
		this.marca = marca;
	//ID
		this.id = String.format("%07d", new Random().nextInt(100000));
	}
//GETTERS   
	public Itinerario getItinerario() {
		return itinerario;
	}
	public String[] getEscalas() {
		return escalas;
	}
	public Integer getNumEscalas() {
		return numEscalas;
	}
	public Double getPreco(){
        return preco;
   	}
	public String getMarca(){
        return marca;
   	}
	public String getId() {
		return id;
	}
//SETTERS
	public void setEscalasENumEscalas(String[] novaEscala) {
		this.escalas = novaEscala != null ? novaEscala.clone() : new String[0] ;	// Nao retorna array nulo, sim um vazio
		if(novaEscala != null) {this.numEscalas = novaEscala.length;}
			else { this.numEscalas = 0;}									
	}
	public void setPreco(Double novoPreco) {
		if(novoPreco != null && novoPreco > 0) {
			this.preco = novoPreco;
		}
	}
	public void setMarca(String novaMarca){
    	if(novaMarca != null) {
    		this.marca = novaMarca;
    	}
    }
//METODO ABSTRATO
	public abstract Double calculaPreco();
//TOSTRING
	public String toString() {
		return "  Data de Partida: " + itinerario.getDataInicial() + " / " + itinerario.getHoraInicial()+ 
					" | Data de Chegada: " + itinerario.getDataFinal() + " / " + itinerario.getHoraFinal() +
			   "\n  Local de Partida: " + itinerario.getPontPartida() + " | Local de Chegada: " + 
					itinerario.getPontChegada() + " | Id da Passagem: " + id + 
			   "\n  Numero de escalas: " + numEscalas  + " | Escalas: " + Arrays.toString(escalas) ;
		// aqui estou formatando o toString para facilitar a leitura de objetos 
	}
}