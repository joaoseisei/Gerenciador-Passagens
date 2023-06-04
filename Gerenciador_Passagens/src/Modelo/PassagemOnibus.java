package Modelo;
import java.time.*;
import java.util.Arrays;

public class PassagemOnibus extends Passagem{
//ATRIBUTOS
	private Boolean leito;							//LEITO
	private Integer numParadas;						//NUMERO DE PARADAS
	private String[] horarioParadas;				//HORARIO DAS PARADAS
	private Boolean refeicaoInclusa;				//ALMOCO INCLUSO
//CONSTRUTOR
	public PassagemOnibus(LocalDate dataInicial, LocalDate dataFinal, LocalTime horaInicial, LocalTime horaFinal,
					String pontPartida, String pontChegada, String[] escalas, Double preco, String marca, 
					Boolean leito, String[] horarioParadas, Boolean refeicaoInclusa){
	//SUPER
		super(dataInicial, dataFinal, horaInicial, horaFinal, pontPartida, pontChegada, escalas, preco, marca);
	//LEITO
		this.leito = leito;
	//HORARIO DAS PARADAS	
		this.horarioParadas = horarioParadas != null ? horarioParadas.clone() : new String[0];
	//NUMERO DE PARADAS
		if(horarioParadas == null) {this.numParadas = 0;}
			else {this.numParadas = horarioParadas.length;}
	//ALMOCO INCLUSO
		this.refeicaoInclusa = refeicaoInclusa;
	}
//GETTERS
	public Boolean getLeito() {
		return leito;
	}
	public Integer getNumParadas() {
		return numParadas;
	}
	public String[] getHorarioParadas() {
		return horarioParadas;
	}
	public Boolean getRefeicaoInclusa() {
		return refeicaoInclusa;
	}
//SETTERS
	public void setLeito(Boolean novoLeito) {
		if(novoLeito != null) {
			this.leito = novoLeito;
		}
	}
	public void setHorarioENumParadas(String[] novoHorarioParadas) {
		this.horarioParadas = novoHorarioParadas != null ? novoHorarioParadas.clone() : new String[0] ;
		if(novoHorarioParadas == null) {this.numParadas = 0;}
			else {this.numParadas = novoHorarioParadas.length;}
	}
	public void setRefeicaoInclusa(Boolean novaRefeicaoInclusa) {
		if(novaRefeicaoInclusa != null) {
			this.refeicaoInclusa = novaRefeicaoInclusa;
		}
	}
//METODO ABSTRATO
	@Override
	public Double calculaPreco() {
		if( ((super.getPreco()*2) - (super.getNumEscalas()*15)) > 0){
			if(leito) {
				if(refeicaoInclusa) {return Math.round((super.getPreco()*500) - (super.getNumEscalas()*15))/100.0;}
					else{return Math.round((super.getPreco()*400) - (super.getNumEscalas()*15))/100.0;}
				
			}else if(refeicaoInclusa && leito == false){return Math.round((super.getPreco()*300) - (super.getNumEscalas()*15))/100.0;}
				else{return Math.round((super.getPreco()*500) - (super.getNumEscalas()*15))/100.0;}
		}else{
			return 0.0;
		}
	}
//TOSTRING	
	@Override
	public String toString(){
	//SUPER
	    return super.toString()
	//TOSTRING ONIBUS
	    		+ "\n  Tipo: Onibus" + " | Marca: " + getMarca() + " (ÔNIBUS)" + " | Onibus leito: " + leito + " | Preço: " + calculaPreco()  
				+ "\n  Numero de paradas: "+ numParadas + " | Horario das Paradas: " + Arrays.toString(horarioParadas) + " | Refeicao Inclusa: " + refeicaoInclusa
				+"} \n ";
	 }
}