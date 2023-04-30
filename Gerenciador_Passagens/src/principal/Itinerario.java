package principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Random;

public abstract class Itinerario {
//ATRIBUTOS
	private LocalDate dataInicial, dataFinal;   	 //DATAS
	private LocalTime horaInicial, horaFinal; 		 //HORAS
	private String pontPartida, pontChegada;   		 //DECOLAGEM E POUSO
    private String[] escalas;                    	 //ESCALAS
    private Integer numEscalas; 					 //NUMERO DE ESCALAS
	private Double preco;            		    	 //PREÇO
	private String marca;							 //MARCA
	private final String id;                    	 //ID DO ITINERARIO 
//CONSTRUTOR	
    public Itinerario(LocalDate dataInicial, LocalDate dataFinal, LocalTime horaInicial, LocalTime horaFinal,
    				String pontPartida, String pontChegada, String[] escalas, Double preco, String marca) {
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
    //LISTA ESCALAS
    	this.escalas = escalas != null ? escalas.clone() : new String[0];// se o array for nulo ele retorna um array vazio
	//NUMERO DE ESCALAS
		this.numEscalas = escalas.length;
	//PRECO
    	if(preco > 0) {this.preco = preco;}
    		else {throw new IllegalArgumentException("Preço não pode ser negativo");}
	//MARCA
		this.marca = marca;
	//ID
		this.id = String.format("%07d", new Random().nextInt(100000));
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
	public void setEscalasENumEscalas(String[] novaEscala) {
		this.escalas = novaEscala != null ? novaEscala.clone() : new String[0] ;	// Nao retorna array nulo, sim um vazio
		this.numEscalas = escalas.length; 											// Atualiza o numero de escalas automaticamente
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
		return "\n {Data de Partida: " + dataInicial + " / " + horaInicial+ " | Data de Chegada: " + dataFinal + " / " + horaFinal +
			   "\n  Local de Partida: " + pontPartida + " | Local de Chegada: " + pontChegada + " | Id da Passagem: " + id + 
			   "\n  Numero de escalas: " + numEscalas  + " | Escalas: " + Arrays.toString(escalas) ;
		// aqui estou formatando o toString para facilitar a leitura de objetos 
	}
}