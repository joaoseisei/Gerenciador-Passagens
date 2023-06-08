package Controle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.*;
import Modelo.*;
import View.TelaUsuario;

public class TelaUsuarioControle {
//ATRIBUTOS
	private Memoria memoria;
	private TelaUsuario telaUser;
//CONSTRUTOR
	public TelaUsuarioControle(Memoria memoria,TelaUsuario telaUser) {
		this.memoria = memoria;
		this.telaUser = telaUser;
	}
//-----------------------------FILTRAR--------------------------------
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
	
	public void filtrar() {
		resetFiltro(telaUser.getContainerPassagem(), telaUser.getSubtituloLB());
		LocalDate inicio = telaUser.getDataInicial();
		LocalDate fim = telaUser.getDataFinal();
		String pontPartida = telaUser.getPontPartida();
		String pontChegada = telaUser.getPontChegada();
		//if(filtrar itinerario)
		for(String index : filtrarItinerario(inicio, fim, pontPartida, pontChegada)) {
			addPassagem(telaUser.getUsuario(), telaUser.getContainerPassagem(), index);
		}
		//if(filtrar pa)
		for(String index : filtrarPassagemAviao(inicio, fim, pontPartida, pontChegada)) {
			addPassagem(telaUser.getUsuario(), telaUser.getContainerPassagem(), index);
		}
		//if(filtrar po)
		for(String index : filtrarPassagemOnibus(inicio, fim, pontPartida, pontChegada)) {
			addPassagem(telaUser.getUsuario(), telaUser.getContainerPassagem(), index);
		}
	}
//------------------------------JAVAX----------------------------------
	public void resetFiltro(JPanel container, JLabel texto) {
 		container.removeAll();
 		texto = new JLabel("RESULTADO:");
 		container.add(texto);
 	}
	public void addPassagem(Usuario user, JPanel container, String informacao) {
		JPanel caixa = new JPanel();
		String[] linhas = informacao.split("\n"); 
    	caixa.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        for (String linha : linhas) {
            JLabel conteudo = new JLabel(linha);
            caixa.add(conteudo);
        }
		JButton favorito = new JButton("♥");
		favorito.setBackground(Color.pink);
		favorito.setBounds(0, 0, 20, 20);
		favorito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!user.getFavoritos().isEmpty() || user.getFavoritos() != null) {
					int i = 0;
			        for (String index : user.getFavoritos()) {
			            if (index.equals(informacao)) {
			                i++;
			            }
			        }
			        if (i == 0) {
			            user.addFavoritos(informacao);
			        }
				}else {
					addFavorito(user, informacao);
				}
			}
		});
		caixa.add(favorito);
		caixa.setPreferredSize(new Dimension(500, 100));
		caixa.setLayout(new BoxLayout(caixa, BoxLayout.Y_AXIS));
		container.add(caixa);
		telaUser.getContainer().setViewportView(telaUser.getContainerPassagem());
	}
//-------------------------FAVORITOS--------------------------------
	public void addFavorito(Usuario user, String informacao) {
		telaUser.getUsuario().addFavoritos(informacao);
	}
	public void atualizarFavoritos(){
    	telaUser.getFavoritoPainel().removeAll();
    	telaUser.getFavoritoPainel().add(telaUser.getVisualizarFavoritos());
    	for(int i = 0; i < telaUser.getUsuario().getFavoritos().size(); i++){
    		JPanel caixa = new JPanel();
    		JLabel conteudo = new JLabel(telaUser.getUsuario().getFavoritos().get(i).toString());
    		caixa.add(conteudo);
    		telaUser.getFavoritoPainel().add(caixa);
    		telaUser.getFavorito().setViewportView(telaUser.getFavoritoPainel());
    	}
    }
//---------------------------BOTOES--------------------------------
	public void atualizarFavoritosButton() {
		telaUser.getVisualizarFavoritos().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	atualizarFavoritos();
            }
        });
	}
	public void filtrarButton() {
		telaUser.getConfirmacao().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.out.println("Filtro atualizado");
                filtrar();
            }
        });
	}
}
