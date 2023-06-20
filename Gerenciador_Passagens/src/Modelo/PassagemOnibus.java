package Modelo;
import java.util.Arrays;
/**
 * A classe passagemOnibus é herdada da classe passagens, que por sua vez tem um itinerario. Sendo assim, 
 * nessa classe temos todos os itens a cima mais 4 atributos que definem uma passagem de ônibus.
 * 
 * @author joaoseisei
 *
 */
public class PassagemOnibus extends Passagem{
//ATRIBUTOS
	private Boolean leito;							//LEITO
	private Integer numParadas;						//NUMERO DE PARADAS
	private String[] horarioParadas;				//HORARIO DAS PARADAS
	private Boolean refeicaoInclusa;				//ALMOCO INCLUSO
//CONSTRUTOR
	/**
	 * Esse construtor é responsável por adicionar todos os atributos de uma passagem de ônibus, isso ocorre
	 * pois é importante criar uma passagem de ônibus com todos as informações definidas. Além disso existe
	 * um setter automático de numParadas através do setter "setHorarioENumParadas".
	 * @param itinerario
	 * @param escalas
	 * @param preco
	 * @param marca
	 * @param leito
	 * @param horarioParadas
	 * @param refeicaoInclusa
	 */
	public PassagemOnibus(Itinerario itinerario,String[] escalas,Double preco,String marca, 
							Boolean leito,String[] horarioParadas,Boolean refeicaoInclusa){
	//SUPER
		super(itinerario, escalas, preco, marca);
	//LEITO
		this.leito = leito;
	//HORARIO DAS PARADAS	
		setHorarioENumParadas(horarioParadas);
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
		if(novoLeito != null) this.leito = novoLeito;
	}
	/**
	 * Esse método é responsável por definir o número de paradas automaticamente sempre que for adicionado
	 * ou removido uma parada da lista de escalas "paradas".
	 * @param novoHorarioParadas Nova lista de horário de paradas.
	 */
	public void setHorarioENumParadas(String[] novoHorarioParadas) {
		this.horarioParadas = novoHorarioParadas != null ? novoHorarioParadas.clone() : new String[0] ;
		if(novoHorarioParadas == null) this.numParadas = 0;
			else this.numParadas = novoHorarioParadas.length;
	}
	public void setRefeicaoInclusa(Boolean novaRefeicaoInclusa) {
		if(novaRefeicaoInclusa != null) this.refeicaoInclusa = novaRefeicaoInclusa;
	}
//METODO ABSTRATO
	/**
	 * Esse método é herdado da classe passagem e é modificado para calcular o preço de acordo com o número de escalas,
     * ou se o ônibus é leito ou nao, esse método nunca irá retornar algo menor que 0.00.
     * @return retornará o preco calculado de acordo com a passagem de ônibus.
	 */
	@Override
	public Double calculaPreco() {
		if( ((super.getPreco()*2) - (super.getNumEscalas()*15)) > 0){
			if(leito) {
				if(refeicaoInclusa) return Math.round((super.getPreco()*500) - (super.getNumEscalas()*15))/100.0;
						else return Math.round((super.getPreco()*400) - (super.getNumEscalas()*15))/100.0;
				
			}else if(refeicaoInclusa && leito == false)return Math.round((super.getPreco()*300) - (super.getNumEscalas()*15))/100.0;
				else return Math.round((super.getPreco()*500) - (super.getNumEscalas()*15))/100.0;
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
				+ "\n  Numero de paradas: "+ numParadas + " | Horario das Paradas: " + Arrays.toString(horarioParadas) + " | Refeicao Inclusa: " + refeicaoInclusa;

	 }
}