package Modelo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Memoria {
//ATRIBUTOS
	private ArrayList<Itinerario> listaItinerario = new ArrayList<>(); 		//LISTA DE ITINERARIOS
	private ArrayList<PassagemAviao> listaAviao = new ArrayList<>();		//LISTA PASSAGENS DE AVIAO
	private ArrayList<PassagemOnibus> listaOnibus = new ArrayList<>();		//LISTA PASSAGENS DE ONIBUS
//ADICIONAR ITINERARIO
	public void criarItinerario(LocalDate dataInicial, LocalDate dataFinal, LocalTime horaInicial, 
								LocalTime horaFinal,String pontPartida, String pontChegada) {
		Itinerario novoItinerario = new Itinerario(dataInicial, dataFinal, horaInicial, 
							   horaFinal, pontPartida, pontChegada);
		listaItinerario.add(novoItinerario);
	}
//ADICIONAR PASSAGEM AVIAO
	public void addPassagemAviao( String idItinerario, String[] escalas, Double preco, 
				String marca, Integer classe, Integer pesoBagagem, String tipoVoo, Integer alturaVoo) {
		for(Itinerario index : listaItinerario) {
			if(idItinerario.equals(index.getIdItinerario())) {
				PassagemAviao novaPA = new PassagemAviao (index.getDataInicial(), index.getDataFinal(),
						index.getHoraInicial(), index.getHoraFinal(), 
						index.getPontPartida(), index.getPontChegada(), 
						escalas, preco, marca, classe, pesoBagagem, tipoVoo, alturaVoo);
				if(index.getDataInicial().isAfter(LocalDate.now())|| index.getDataInicial().isEqual(LocalDate.now())) {
					listaAviao.add(novaPA);
				}break;	
			}
		}
	}
//ADICIONAR PASSAGEM ONIBUS
	public void addPassagemOnibus(String idItinerario, String[] escalas, Double preco, 
				String marca, Boolean leito, Integer[] horarioParadas, Boolean refeicaoInclusa){
		for(Itinerario index : listaItinerario) {
			if(idItinerario.equals(index.getIdItinerario())) {
				PassagemOnibus novaPO = new PassagemOnibus (index.getDataInicial(), index.getDataFinal(), 
						  index.getHoraInicial(), index.getHoraFinal(), 
						  index.getPontPartida(), index.getPontChegada(), 
						  escalas, preco, marca, leito, horarioParadas, refeicaoInclusa);
				if(index.getDataInicial().isAfter(LocalDate.now())||index.getDataInicial().isEqual(LocalDate.now())) {
					listaOnibus.add(novaPO);
				}break;	
			}
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
//EDITAR ITINERARIO
	public void editItinerario(String idItinerario, LocalDate dataInicial, LocalDate dataFinal, 
			LocalTime horaInicial, LocalTime horaFinal,String pontPartida, String pontChegada ) {
		for(Itinerario index : listaItinerario) {
			if(idItinerario.equals(index.getIdItinerario())) {
				index.setDataInicial(dataInicial);
				index.setDataFinal(dataFinal);
				index.setHoraInicial(horaInicial);
				index.setHoraFinal(horaFinal);
				index.setPontPartida(pontPartida);
				index.setPontChegada(pontChegada);
				if(index.getDataInicial().isAfter(index.getDataFinal())){
					throw new IllegalArgumentException("CONFLITO DE DATA (DIA), DELETANDO PASSAGEM");
				}else if(index.getDataInicial().equals(index.getDataFinal()) &&
						index.getHoraInicial().isAfter(index.getHoraFinal())) {
					throw new IllegalArgumentException("CONFLITO DE DATA (HORA), DELETANDO PASSAGEM");
				}break;	
			}
		}
	}
//EDITAR PASSAGEM AVIAO
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
//EDITAR PASSAGEM ONIBUS
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
//GETTER DE ITINERARIO
	public ArrayList<Itinerario> getItinerario(){
		return new ArrayList<>(listaItinerario);
	}
//GETTER DA LISTAAVIAO
	public ArrayList<PassagemAviao> getListaAviao (){
		return new ArrayList<>(listaAviao);
	}
//GETTER DA LISTAONIBUS
	public ArrayList<PassagemOnibus> getListaOnibus (){
		return new ArrayList<>(listaOnibus);
	}
//FILTRAR PASSAGEM DE AVIAO
	public ArrayList<PassagemAviao> filtrarPassagemAviao(LocalDate dataInicial, LocalDate dataFinal, 
															String pontPartida, String pontChegada){
		ArrayList<PassagemAviao> filtro = new ArrayList<>();
		for (PassagemAviao index : listaAviao) {
			if ((dataInicial == null || index.getItinerario().getDataInicial().equals(dataInicial))
			 && (dataFinal == null || index.getItinerario().getDataFinal().equals(dataFinal))
			 && (pontPartida == null || index.getItinerario().getPontPartida().equals(pontPartida))
			 && (pontChegada == null || index.getItinerario().getPontChegada().equals(pontChegada))){
	            filtro.add(index);
	        } 
		}return filtro;
	}
//FILTRAR PASSAGEM DE ONIBUS	
	public ArrayList<PassagemOnibus> filtrarPassagemOnibus(LocalDate dataInicial, LocalDate dataFinal, 
															  String pontPartida, String pontChegada){
		ArrayList<PassagemOnibus> filtro = new ArrayList<>();
		for (PassagemOnibus index : listaOnibus) {
	        if ((dataInicial == null || index.getItinerario().getDataInicial().equals(dataInicial))
	         && (dataFinal == null || index.getItinerario().getDataFinal().equals(dataFinal))
	         && (pontPartida == null || index.getItinerario().getPontPartida().equals(pontPartida))
	         && (pontChegada == null || index.getItinerario().getPontChegada().equals(pontChegada))){	
	        	filtro.add(index); 
	        }
		}return filtro;
	}
}