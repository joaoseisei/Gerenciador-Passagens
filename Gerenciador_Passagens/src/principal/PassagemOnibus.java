package principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class PassagemOnibus extends Itinerario{
//ATRIBUTOS
	private Boolean leito;							//LEITO
	private Integer numParadas;						//NUMERO DE PARADAS
	private Integer[] horarioParadas;				//HORARIO DAS PARADAS
	private Boolean refeicaoInclusa;				//ALMOCO INCLUSO
//CONSTRUTOR
	public PassagemOnibus(LocalDate dataInicial, LocalDate dataFinal, LocalTime horaInicial, LocalTime horaFinal,
					String pontPartida, String pontChegada, String[] escalas, Double preco, String marca, 
					Boolean leito, Integer numParadas, Integer[] horarioParadas, Boolean refeicaoInclusa){
	//SUPER
		super(dataInicial, dataFinal, horaInicial, horaFinal, pontPartida, pontChegada, escalas, preco, marca);
	//LEITO
		this.leito = leito;
	//NUMERO DE PARADAS
		this.numParadas = numParadas;
	//HORARIO DAS PARADAS
		this.horarioParadas = horarioParadas;
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
	public Integer[] getHorarioParadas() {
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
	public void setNumParadas(Integer novoNumParadas) {
		if(novoNumParadas != null && novoNumParadas >0) {
			this.numParadas = novoNumParadas;
		}
	}
	public void setHorarioParadas(Integer[] novoHorarioParadas) {
		this.horarioParadas = novoHorarioParadas != null ? novoHorarioParadas.clone() : new Integer[0] ;
	}
	public void setRefeicaoInclusa(Boolean novaRefeicaoInclusa) {
		if(novaRefeicaoInclusa != null) {
			this.refeicaoInclusa = novaRefeicaoInclusa;
		}
	}
//METODO ABSTRATO
	@Override
	public Double calculaPreco() {
		if( (super.getPreco()*2) > 0){
			if(leito) {
				if(refeicaoInclusa) {return Math.round(super.getPreco()*500)/100.0;}
					else{return Math.round(super.getPreco()*400)/100.0;}
				
			}else if(refeicaoInclusa && leito == false){return Math.round(super.getPreco()*300)/100.0;}
				else{return Math.round(super.getPreco()*200)/100.0;}
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
