package Controle;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.time.LocalDate;
import java.util.ArrayList;

import Modelo.Memoria;
import Modelo.Itinerario;
import Modelo.PassagemAviao;
import Modelo.PassagemOnibus;

import View.TelaUsuario;

/**
 * A classe TelaUsuariControle é responsável por vincular a classe TelaUsuario com a memoria do sistema.
 * 
 * @author joaoseisei
 * @since 2023
 * @version V2.1
 *
 */
public class TelaUsuarioControle {
//ATRIBUTOS
	private Memoria memoria;
	private TelaUsuario telaUser;
//CONSTRUTOR
	/**
	 * Esse construtor é responsável por vincular a TelaUsuario e a Memoria na classe, para poder
	 * utilizar banco de dados e botoẽs.
	 * @param memoria
	 * @param telaUser
	 */
	public TelaUsuarioControle(Memoria memoria,TelaUsuario telaUser) {
		this.memoria = memoria;
		this.telaUser = telaUser;
	}
//-----------------------------FILTRAR--------------------------------
	/**
	 * Esse método é responsável por filtrar o ArrayList de itinerário com base nos 4 parâmetros abaixo, 
	 * caso o valor colocado for null ele passará no filtro, caso for diferente de null ele verificará se o
	 * index é igual ao valor escolhido com base no .equals.
	 * @param dataInicial
	 * @param dataFinal
	 * @param pontPartida
	 * @param pontChegada
	 * @return Retorna um ArrayList de Strins com os itinerários filtrados com os parâmetros escolhidos.
	 */
	public ArrayList<String> filtrarItinerario(LocalDate dataInicial,LocalDate dataFinal,String pontPartida,String pontChegada){
		ArrayList<String> filtro = new ArrayList<>();
		for(Itinerario index : memoria.getListaItinerario()) {
			if ((dataInicial == null || index.getDataInicial().equals(dataInicial))
			&& (dataFinal == null || index.getDataFinal().equals(dataFinal))
			&& (pontPartida == null || index.getPontPartida().equals(pontPartida))
			&& (pontChegada == null || index.getPontChegada().equals(pontChegada))) {
				filtro.add(index.toString());
			}
		}return filtro;
	}
	/**
	 * Esse método é responsável por filtrar o ArrayList de passagem de avião com base nos 4 parâmetros abaixo, 
	 * caso o valor colocado for null ele passará no filtro, caso for diferente de null ele verificará se o
	 * index é igual ao valor escolhido com base no .equals.
	 * @param dataInicial
	 * @param dataFinal
	 * @param pontPartida
	 * @param pontChegada
	 * @return Retorna um ArrayList de Strins com as passagens de aviões filtradas com os parâmetros escolhidos.
	 */
	public ArrayList<String> filtrarPassagemAviao(LocalDate dataInicial,LocalDate dataFinal,String pontPartida,String pontChegada){
		ArrayList<String> filtro = new ArrayList<>();
		for (PassagemAviao index : memoria.getListaAviao()) {
			if ((dataInicial == null || index.getItinerario().getDataInicial().equals(dataInicial))
			&& (dataFinal == null || index.getItinerario().getDataFinal().equals(dataFinal))
			&& (pontPartida == null || index.getItinerario().getPontPartida().equals(pontPartida))
			&& (pontChegada == null || index.getItinerario().getPontChegada().equals(pontChegada))){
				filtro.add(index.toString());
			} 
		}return filtro;
	}
	/**
	 * Esse método é responsável por filtrar o ArrayList de passagem de ônibus com base nos 4 parâmetros abaixo, 
	 * caso o valor colocado for null ele passará no filtro, caso for diferente de null ele verificará se o
	 * index é igual ao valor escolhido com base no .equals.
	 * @param dataInicial
	 * @param dataFinal
	 * @param pontPartida
	 * @param pontChegada
	 * @return Retorna um ArrayList de Strins com as passagens de ônibus filtrados com os parâmetros escolhidos.
	 */
	public ArrayList<String> filtrarPassagemOnibus(LocalDate dataInicial,LocalDate dataFinal,String pontPartida,String pontChegada){
		ArrayList<String> filtro = new ArrayList<>();
		for (PassagemOnibus index : memoria.getListaOnibus()) {
			if ((dataInicial == null || index.getItinerario().getDataInicial().equals(dataInicial))
			&& (dataFinal == null || index.getItinerario().getDataFinal().equals(dataFinal))
			&& (pontPartida == null || index.getItinerario().getPontPartida().equals(pontPartida))
			&& (pontChegada == null || index.getItinerario().getPontChegada().equals(pontChegada))){	
				filtro.add(index.toString()); 
			}
		}return filtro;
	}
	/**
	 * Esse método é responsável por receber os inputs da tela e filtrar conforme o valor deles
	 * utilizando a funções de filtrar feitas.
	 */
	public void filtrar() {
		telaUser.resetFiltro(telaUser.getContainerPassagem(), telaUser.getSubtituloLB());
		LocalDate inicio = telaUser.getDataInicial();
		LocalDate fim = telaUser.getDataFinal();
		String pontPartida = telaUser.getPontPartida();
		String pontChegada = telaUser.getPontChegada();
		
		if(telaUser.getItinerario()) {
			for(String index : filtrarItinerario(inicio, fim, pontPartida, pontChegada)) {
				telaUser.addPassagem(telaUser.getUsuario(), telaUser.getContainerPassagem(), index);
				System.out.println(index);
			}
		}
		if(telaUser.getPassagemAviao()) {
			for(String index : filtrarPassagemAviao(inicio, fim, pontPartida, pontChegada)) {
				telaUser.addPassagem(telaUser.getUsuario(), telaUser.getContainerPassagem(), index);
			}
		}
		if(telaUser.getPassagemOnibus()) {
			for(String index : filtrarPassagemOnibus(inicio, fim, pontPartida, pontChegada)) {
				telaUser.addPassagem(telaUser.getUsuario(), telaUser.getContainerPassagem(), index);
			}
		}
	}
//---------------------------BOTOES--------------------------------
	public void filtrarFavoritos() {
		telaUser.getFav().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
            	System.out.println("teste");
                telaUser.resetFiltro(telaUser.getContainerPassagem(), telaUser.getSubtituloLB());
                for(String index : telaUser.getUsuario().getFavoritos()) {
                	telaUser.addPassagem(telaUser.getUsuario(), telaUser.getContainerPassagem(), index);
                }
            }
        });
	}
	/**
	 * Essa função é responsavel por atualizar o painel de passagens de acordo com as preferências do usuário
	 * (data inicial, data final, ponto de partida e ponto de chegada).
	 */
	public void filtrarButton() {
		telaUser.getConfirmacao().addMouseListener(new MouseAdapter() {
			/**
			 * Na função MouseCliked é chamada a função filtrar que atualiza o filtro de acordo com as preferências.
			 * @param e Recebe como parametro o evento do clique do mouse.
			 */
            public void mouseClicked(MouseEvent e){
                filtrar();
            }
        });
	}
}