package Modelo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Memoria {
//ATRIBUTOS
	private ArrayList<Itinerario> listaItinerario = new ArrayList<>(); 		//LISTA DE ITINERARIOS
	private ArrayList<PassagemAviao> listaAviao = new ArrayList<>();		//LISTA PASSAGENS DE AVIAO
	private ArrayList<PassagemOnibus> listaOnibus = new ArrayList<>();		//LISTA PASSAGENS DE ONIBUS
	private ArrayList<Admin> listaEmpresa = new ArrayList<>();				//LISTA DE CONTAS EMPRESARIAIS
	private ArrayList<Usuario> listaUsuario= new ArrayList<>();				//LISTA DE CONTAS PESSOAIS
//------------------------------ADICIONAR----------------------------------------//
//ADICIONAR ITINERARIO
	public void addItinerario(LocalDate dataInicial, LocalDate dataFinal, LocalTime horaInicial, 
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
//ADICIONAR CONTA
	public void addConta(Boolean tipo, String nome, String senha, String novaSenha) {
		if(tipo) {
			Admin novaEmpresa = new Admin(tipo ,nome, senha, novaSenha);
			listaEmpresa.add(novaEmpresa);
		}else {
			Usuario novoUsuario = new Usuario(tipo, nome, senha, novaSenha);
			listaUsuario.add(novoUsuario);
		}
	}
	
//------------------------------DELETAR------------------------------------------//
//DELETAR ITINERARIO
	public void deleteItinerario(String idItinerario) {
		for(Itinerario index : listaItinerario) {
			if(idItinerario.equals(index.getIdItinerario())) {
				listaItinerario.remove(index);
				break;
			}	
		}
	}
//DELETAR PASSAGEM
	public void deletePassagem(Boolean aviao, String id){
		if (aviao) {
			for(PassagemAviao index : listaAviao){	
				if(index.getId().equals(id)) {		
					listaAviao.remove(index);		
					break;							
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
	
//---------------------------------EDITAR----------------------------------------//
//EDITAR ITINERARIO
	public void editItinerario(String idItinerario, LocalDate dataInicial, LocalDate dataFinal, 
			LocalTime horaInicial, LocalTime horaFinal,String pontPartida, String pontChegada ) {
		for(Itinerario index : listaItinerario) {
			if(idItinerario.equals(index.getIdItinerario())) {
				for(PassagemAviao indexA : listaAviao) {
					if(index.toString().equals(indexA.getItinerario().toString())) {
						indexA.getItinerario().setDataInicial(dataInicial);
						indexA.getItinerario().setDataFinal(dataFinal);
						indexA.getItinerario().setHoraInicial(horaInicial);
						indexA.getItinerario().setHoraFinal(horaFinal);
						indexA.getItinerario().setPontPartida(pontPartida);
						indexA.getItinerario().setPontChegada(pontChegada);
					}
				}
				for(PassagemOnibus indexB : listaOnibus) {
					if(index.toString().equals(indexB.getItinerario().toString())) {
						indexB.getItinerario().setDataInicial(dataInicial);
						indexB.getItinerario().setDataFinal(dataFinal);
						indexB.getItinerario().setHoraInicial(horaInicial);
						indexB.getItinerario().setHoraFinal(horaFinal);
						indexB.getItinerario().setPontPartida(pontPartida);
						indexB.getItinerario().setPontChegada(pontChegada);
					}
				}
				index.setDataInicial(dataInicial);
				index.setDataFinal(dataFinal);
				index.setHoraInicial(horaInicial);
				index.setHoraFinal(horaFinal);
				index.setPontPartida(pontPartida);
				index.setPontChegada(pontChegada);
				if(index.getDataInicial().isAfter(index.getDataFinal())){
					throw new IllegalArgumentException("CONFLITO DE DATA (DIA)");
				}else if(index.getDataInicial().equals(index.getDataFinal()) &&
						index.getHoraInicial().isAfter(index.getHoraFinal())) {
					throw new IllegalArgumentException("CONFLITO DE DATA (HORA)");
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
				}break;					
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
	
//---------------------------------GETTERS--------------------------------------//
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
//GETTER DE USUARIO
	public ArrayList<Usuario> getListaUsuario() {
		return listaUsuario;
	}

//---------------------------------FILTROS-------------------------------------//
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

//----------------------------------FAZER LOGIN--------------------------------//
	public String fazerLogin(String nome, String senha, Boolean Empresa) {
		String resultadoLogin = "r";
		if(Empresa) {
			for(Admin index : listaEmpresa) {
				if(index.getNome().equals(nome) && index.getSenha().equals(index.criptografarSenha(senha))){
					resultadoLogin = "EmpresaLogada";
		
				}
			}
		}else {
			for(Usuario index : listaUsuario) {
				if(index.getNome().equals(nome) && index.getSenha().equals(index.criptografarSenha(senha))){
					resultadoLogin = "UsuarioLogado";
				}
			}
		}return resultadoLogin;
	}
	
//------------------------------ADICIONAR FAVORITOS----------------------------//
	public void addFavoritosPA(String idu, String idp){
		for(Usuario index : listaUsuario) {
			if(idu.equals(index.getIDU())){
				for(PassagemAviao indexA : listaAviao) {
					if(idp.equals(indexA.getId())) {
						index.addFavoritoAviao(indexA);
					}
				}
				for(PassagemOnibus indexB : listaOnibus) {
					if(idp.equals(indexB.getId())) {
						index.addFavoritoOnibus(indexB);
					}
				}
			}
		}
	}
}