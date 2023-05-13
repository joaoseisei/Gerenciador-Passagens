package Modelo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Memoria {
//ATRIBUTOS
	private ArrayList<PassagemAviao> listaAviao= new ArrayList<>();			//LISTA PASSAGENS DE AVIAO
	private ArrayList<PassagemOnibus> listaOnibus = new ArrayList<>();		//LISTA PASSAGENS DE ONIBUS
//ADICIONAR PASSAGEM	
	public void addPassagemAviao( LocalDate dataInicial, LocalDate dataFinal, LocalTime horaInicial,
				LocalTime horaFinal,String pontPartida, String pontChegada, String[] escalas, Double preco, 
				String marca, Integer classe, Integer pesoBagagem, String tipoVoo, Integer alturaVoo) {
		
		PassagemAviao novaPA = new PassagemAviao (dataInicial, dataFinal, horaInicial, horaFinal, 
				pontPartida, pontChegada, escalas, preco, marca, classe, pesoBagagem, tipoVoo, alturaVoo);
		if(dataInicial.isAfter(LocalDate.now())|| dataInicial.isEqual(LocalDate.now())) {
			listaAviao.add(novaPA);
		}
	}
	public void addPassagemOnibus(LocalDate dataInicial, LocalDate dataFinal, LocalTime horaInicial, 
				LocalTime horaFinal,String pontPartida, String pontChegada, String[] escalas, Double preco, 
				String marca, Boolean leito, Integer[] horarioParadas, Boolean refeicaoInclusa){
		
		PassagemOnibus novaPO = new PassagemOnibus (dataInicial, dataFinal, horaInicial, horaFinal, 
				pontPartida, pontChegada, escalas, preco, marca, leito, horarioParadas, refeicaoInclusa);
		if(dataInicial.isAfter(LocalDate.now())|| dataInicial.isEqual(LocalDate.now())) {
			listaOnibus.add(novaPO);
}
	}
//DELETAR PASSAGEM
	public void deletePassagem(Boolean aviao, String id){
		if (aviao) {
			for(PassagemAviao index : listaAviao) {	// passando linha por linha da listagem
				if(index.getId().equals(id)) {		// se o id do index for igual ao parametro id passou
					listaAviao.remove(index);		// removendo o voo index da lista, tipo o 3 voo da lista...
					break;							// parando o for, pois ja achou o index correspondente ao id
				}
			} 
		}else {
			for (PassagemOnibus index : listaOnibus) {
		        if (index.getId().equals(id)) {
		            listaOnibus.remove(index);
		            return;
		        }
		    }
		}
	}
//EDITAR PASSAGEM	
	public void editPassagemAviao(String id,  LocalDate dataInicial, LocalDate dataFinal,
				LocalTime horaInicial, LocalTime horaFinal, String pontPartida, String pontChegada, 
				String[] escalas, Double preco, String marca, Integer classe, Integer pesoBagagem, 
				String tipoVoo, Integer alturaVoo) {
		for(PassagemAviao index : listaAviao) {
			//passando linha por linha da listagem
			if(index.getId().equals(id)) {
			//CRUD ITINERARIO
				index.getItinerario().setDataInicial(dataInicial);
				index.getItinerario().setDataFinal(dataFinal);
				index.getItinerario().setHoraInicial(horaInicial);
				index.getItinerario().setHoraFinal(horaFinal);
				index.getItinerario().setPontPartida(pontPartida);
				index.getItinerario().setPontChegada(pontChegada);
			//CRUD PASSAGEM
				index.setEscalasENumEscalas(escalas);
				index.setPreco(preco);
				index.setMarca(marca);
				index.setClasse(classe);
				index.setPesoBagagem(pesoBagagem);
				index.setTipoVoo(tipoVoo);
				index.setAlturaVoo(alturaVoo);
			//VERIFICADOR DE DATAS
				if(index.getItinerario().getDataInicial().isAfter(index.getItinerario().getDataFinal())){
					deletePassagem(true, index.getId());
					throw new IllegalArgumentException("CONFLITO DE DATA (DIA), DELETANDO PASSAGEM");
				}else if(index.getItinerario().getDataInicial().equals(index.getItinerario().getDataFinal()) &&
						index.getItinerario().getHoraInicial().isAfter(index.getItinerario().getHoraFinal())) {
					deletePassagem(true, index.getId());
					throw new IllegalArgumentException("CONFLITO DE DATA (HORA), DELETANDO PASSAGEM");
				}break;					// parando o for, pois ja achou o index correspondente do id
			}
		}
		
	}
	public void editPassagemOnibus(String id,  LocalDate dataInicial, LocalDate dataFinal,
				LocalTime horaInicial, LocalTime horaFinal, String pontPartida, String pontChegada, 
				String[] escalas, Double preco, String marca, Boolean leito, 
				Integer[] horarioParadas, Boolean refeicaoInclusa) {
		for(PassagemOnibus index : listaOnibus) {
			if(index.getId().equals(id)) {
			//CRUD ITINERARIO
				index.getItinerario().setDataInicial(dataInicial);
				index.getItinerario().setDataFinal(dataFinal);
				index.getItinerario().setHoraInicial(horaInicial);
				index.getItinerario().setHoraFinal(horaFinal);
				index.getItinerario().setPontPartida(pontPartida);
				index.getItinerario().setPontChegada(pontChegada);
			//CRUD PASSAGEM
				index.setEscalasENumEscalas(escalas);
				index.setPreco(preco);
				index.setMarca(marca);
				index.setLeito(leito);
				index.setHorarioENumParadas(horarioParadas);
				index.setRefeicaoInclusa(refeicaoInclusa);
			//VERIFICADOR DATAS
				if(index.getItinerario().getDataInicial().isAfter(index.getItinerario().getDataFinal())){
					deletePassagem(false, index.getId());
					throw new IllegalArgumentException("ERRO DE DATAS, DELETANDO PASSAGEM");
				}else if(index.getItinerario().getDataInicial().equals(index.getItinerario().getDataFinal()) && 
						index.getItinerario().getHoraInicial().isAfter(index.getItinerario().getHoraFinal())) {
					deletePassagem(true, index.getId());
					throw new IllegalArgumentException("CONFLITO DE DATA (HORA), DELETANDO PASSAGEM");
				}break;
			}
		}
	}
//GETTER DA LISTAAVIAO
	public ArrayList<PassagemAviao> getListaAviao (){
		return new ArrayList<>(listaAviao);
		// basicamente retorna uma copia do array listagem 
		// copia pois nao quero que o usuario tenha acesso ao origial
	}
//GETTER DA LISTAONIBUS
	public ArrayList<PassagemOnibus> getListaOnibus (){
		return new ArrayList<>(listaOnibus);
	}
//FILTRAR PASSAGEM DE AVIAO
	public ArrayList<PassagemAviao> filtrarPassagemAviao(LocalDate dataInicial, LocalDate dataFinal, 
															String pontPartida, String pontChegada){
		ArrayList<PassagemAviao> filtro = new ArrayList<>();
		// novo array aonde vou colocar todos os Voos filtrados
		for (PassagemAviao index : listaAviao) {
			//passando linha por linha da listagem
	        if ((dataInicial == null || index.getItinerario().getDataInicial().equals(dataInicial))
	        		// se o inicio for nulo ou for igual ao parametro da funcao passou
	        	&& (dataFinal == null || index.getItinerario().getDataFinal().equals(dataFinal))){
	        		// se o fim for nulo ou igual ao parametro da funçao passou
	        	
	        	if ((pontPartida == null || index.getItinerario().getPontPartida().equals(pontPartida))
	        		// se o local de decolagem for nulo ou igual ao parametro decolagem passou
	   	        	 && (pontChegada == null || index.getItinerario().getPontChegada().equals(pontChegada))){
	        		// se o local de pouso for nulo ou igual ao parametro de pouso passou
	        		
	            filtro.add(index); // se passou em tudo adiciona no filtro
	        	}
	        }
		}return filtro; // retorna filtro filtrado
	}
//FILTRAR PASSAGEM DE ONIBUS	
	public ArrayList<PassagemOnibus> filtrarPassagemOnibus(LocalDate dataInicial, LocalDate dataFinal, 
															  String pontPartida, String pontChegada){
		ArrayList<PassagemOnibus> filtro = new ArrayList<>();
		for (PassagemOnibus index : listaOnibus) {
	        if ((dataInicial == null || index.getItinerario().getDataInicial().equals(dataInicial))
	        	&& (dataFinal == null || index.getItinerario().getDataFinal().equals(dataFinal))){
	        	
	        	if ((pontPartida == null || index.getItinerario().getPontPartida().equals(pontPartida))
	   	        	 && (pontChegada == null || index.getItinerario().getPontChegada().equals(pontChegada))){
	        		
	            filtro.add(index); 
	        	}
	        }
		}return filtro;
	}
}
