package Controle;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Modelo.Itinerario;
import Modelo.Memoria;
import Modelo.PassagemAviao;
import Modelo.PassagemOnibus;

import View.TelaAdmin;

public class TelaAdminControle {
//ATRIBUTOS
	private Memoria memoria;
	private TelaAdmin telaAdmin;
//CONSTRUTOR
	public TelaAdminControle(Memoria memoria, TelaAdmin telaAdmin){
		this.memoria = memoria;
		this.telaAdmin = telaAdmin;
	}
//-----------------------------------ADICIONAR--------------------------------------------	
	public void addItinerario(LocalDate dataInicial,LocalDate dataFinal,LocalTime horaInicial,LocalTime horaFinal,
	String pontPartida, String pontChegada){
		ArrayList<Itinerario> novaListaItinerario = new ArrayList<>(memoria.getListaItinerario());
		Itinerario novoItinerario = new Itinerario(dataInicial,dataFinal,horaInicial,horaFinal,pontPartida,pontChegada);
		if(novaListaItinerario.isEmpty() || novaListaItinerario.stream().noneMatch
				(index -> index.toString().equals(novoItinerario.toString()))){
			novaListaItinerario.add(novoItinerario);
			memoria.setListaItinerario(novaListaItinerario);
		}
		// Cria uma Lista que é igual a lista do getmemoria e verificamos se ela é vazia primeiro para nao dar erro,
		// Caso a lista nao seja vazia, eu uso o stream para verificar elemento por elemento e uso o noneMatch para
		// colocar uma condição, no caso se os ToString forem iguais, pois neles tem todas as informaçoes de itinerario.
	}	
	public void addPassagemAviao(LocalDate dataInicial,LocalDate dataFinal,LocalTime horaInicial,LocalTime horaFinal,
	String pontPartida,String pontChegada,String[] escalas,Double preco,String marca,Integer classe,Integer pesoBagagem,
	String tipoVoo,Integer alturaVoo){
		ArrayList<PassagemAviao> novaListaAviao = new ArrayList<>(memoria.getListaAviao());
		Itinerario itinerarioPA = new Itinerario(dataInicial,dataFinal,horaInicial,horaFinal,pontPartida,pontChegada);
		PassagemAviao novaPA = new PassagemAviao(itinerarioPA,escalas,preco,marca,classe,pesoBagagem,tipoVoo,alturaVoo);
		if(dataInicial.isAfter(LocalDate.now()) || dataInicial.isEqual(LocalDate.now())){	
			novaListaAviao.add(novaPA);
			addItinerario(dataInicial, dataFinal, horaInicial, horaFinal, pontPartida, pontChegada);
			memoria.setListaAviao(novaListaAviao);
		}
		
	}
	public void addPassagemOnibus(LocalDate dataInicial,LocalDate dataFinal,LocalTime horaInicial,LocalTime horaFinal,
	String pontPartida,String pontChegada,String[] escalas,Double preco,String marca,Boolean leito,String[] horarioParadas,
	Boolean refeicaoInclusa){
		ArrayList<PassagemOnibus> novaListaOnibus = new ArrayList<>(memoria.getListaOnibus());
		Itinerario itinerarioPO = new Itinerario(dataInicial,dataFinal,horaInicial,horaFinal,pontPartida,pontChegada);
		PassagemOnibus novaPO = new PassagemOnibus (itinerarioPO,escalas,preco,marca,leito,horarioParadas,refeicaoInclusa);
		if(dataInicial.isAfter(LocalDate.now())||dataInicial.isEqual(LocalDate.now())){
			novaListaOnibus.add(novaPO);
			addItinerario(dataInicial, dataFinal, horaInicial, horaFinal, pontPartida, pontChegada);
			memoria.setListaOnibus(novaListaOnibus);
		}
	}
//------------------------------------DELETAR---------------------------------------------	
	public void deleteItinerario(String idItinerario){
		ArrayList<Itinerario> novaListaItinerario = new ArrayList<>(memoria.getListaItinerario());
		ArrayList<PassagemAviao> novaListaAviao = new ArrayList<>(memoria.getListaAviao());
		ArrayList<PassagemOnibus> novaListaOnibus = new ArrayList<>(memoria.getListaOnibus());
		for(Itinerario index: novaListaItinerario) {
			if(index.getIdItinerario().equals(idItinerario)){
				for(PassagemAviao indexA : novaListaAviao) {
					if(indexA.getItinerario().toString().equals(index.toString())) {
						novaListaAviao.remove(indexA);
					}
				}
				for(PassagemOnibus indexB : novaListaOnibus) {
					if(indexB.getItinerario().toString().equals(index.toString())) {
						novaListaOnibus.remove(indexB);
					}
				}
			}
		}
		novaListaItinerario.removeIf(index -> index.getIdItinerario().equals(idItinerario));
		memoria.setListaItinerario(novaListaItinerario); 
		memoria.setListaAviao(novaListaAviao);
		memoria.setListaOnibus(novaListaOnibus);
	}
	public void deletePassagem(Boolean aviao, String id){
		ArrayList<PassagemAviao> novaListaAviao = new ArrayList<>(memoria.getListaAviao());
		ArrayList<PassagemOnibus> novaListaOnibus = new ArrayList<>(memoria.getListaOnibus());
		if(aviao){
			novaListaAviao.removeIf(index -> index.getId().equals(id));
			memoria.setListaAviao(novaListaAviao);
		}else{
			novaListaOnibus.removeIf(index -> index.getId().equals(id));
			memoria.setListaOnibus(novaListaOnibus);
		}
	}
//-------------------------------------EDITAR---------------------------------------------		
	public void editItinerario(String idItinerario,LocalDate dataInicial,LocalDate dataFinal,LocalTime horaInicial,
	LocalTime horaFinal,String pontPartida,String pontChegada){
		ArrayList<Itinerario> novaListaItinerario = new ArrayList<>(memoria.getListaItinerario());
		ArrayList<PassagemAviao> novaListaAviao = new ArrayList<>(memoria.getListaAviao());
		ArrayList<PassagemOnibus> novaListaOnibus = new ArrayList<>(memoria.getListaOnibus());
		for(Itinerario index : novaListaItinerario){
			if(idItinerario.equals(index.getIdItinerario())){
				Itinerario backup = index;
				index.setDataInicial(dataInicial);
				index.setDataFinal(dataFinal);
				index.setHoraInicial(horaInicial);
				index.setHoraFinal(horaFinal);
				index.setPontPartida(pontPartida);
				index.setPontChegada(pontChegada);
				//VERIFICAÇÃO DE CONFLITO
				if(index.getDataInicial().isAfter(index.getDataFinal()) && 
				   index.getDataInicial().equals(index.getDataFinal()) &&
				   index.getHoraInicial().isAfter(index.getHoraFinal())){
						index = backup;
						break;
				}else{
					//EDITANDO O ITINERARIO DOS AVIOES
					for(PassagemAviao indexA : novaListaAviao){
						if(backup.toString().equals(indexA.getItinerario().toString())) {
							indexA.getItinerario().setDataInicial(dataInicial);
							indexA.getItinerario().setDataFinal(dataFinal);
							indexA.getItinerario().setHoraInicial(horaInicial);
							indexA.getItinerario().setHoraFinal(horaFinal);
							indexA.getItinerario().setPontPartida(pontPartida);
							indexA.getItinerario().setPontChegada(pontChegada);
						}
					}
					//EDITANDO O ITINERARIO DOS ONIBUS
					for(PassagemOnibus indexB : novaListaOnibus){
						if(backup.toString().equals(indexB.getItinerario().toString())) {
							indexB.getItinerario().setDataInicial(dataInicial);
							indexB.getItinerario().setDataFinal(dataFinal);
							indexB.getItinerario().setHoraInicial(horaInicial);
							indexB.getItinerario().setHoraFinal(horaFinal);
							indexB.getItinerario().setPontPartida(pontPartida);
							indexB.getItinerario().setPontChegada(pontChegada);
						}
					}
				}
			}
		}
		memoria.setListaItinerario(novaListaItinerario);
		memoria.setListaAviao(novaListaAviao);
		memoria.setListaOnibus(novaListaOnibus);
	}
	public void editPassagemAviao(String id,LocalDate dataInicial,LocalDate dataFinal,LocalTime horaInicial,
	LocalTime horaFinal,String pontPartida,String pontChegada,String[] escalas,Double preco,String marca,
	Integer classe,Integer pesoBagagem,String tipoVoo,Integer alturaVoo){
		ArrayList<PassagemAviao> novaListaAviao = new ArrayList<>(memoria.getListaAviao());
		for(PassagemAviao index : novaListaAviao) {
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
		memoria.setListaAviao(novaListaAviao);
	}
	public void editPassagemOnibus(String id,LocalDate dataInicial,LocalDate dataFinal,LocalTime horaInicial,
	LocalTime horaFinal,String pontPartida,String pontChegada,String[] escalas,Double preco,String marca,
	Boolean leito,String[] horarioParadas,Boolean refeicaoInclusa){
		ArrayList<PassagemOnibus> novaListaOnibus = new ArrayList<>(memoria.getListaOnibus());
		for(PassagemOnibus index : novaListaOnibus) {
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
		memoria.setListaOnibus(novaListaOnibus);
	}
//-------------------------------------JAVAX----------------------------------------------
	public void addInformacao(String informacao) {
    	JPanel caixa = new JPanel();
    	String[] linhas = informacao.split("\n"); 
    	caixa.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        for (String linha : linhas) {
            JLabel conteudo = new JLabel(linha);
            caixa.add(conteudo);
        }
		caixa.setPreferredSize(new Dimension(500, 100));
		caixa.setLayout(new BoxLayout(caixa, BoxLayout.Y_AXIS));
		telaAdmin.getConteudo().add(caixa);
		telaAdmin.getContainer().setViewportView(telaAdmin.getConteudo());
	}
	public void atualizar(){
    	telaAdmin.getConteudo().removeAll();
    	JLabel dados = new JLabel("Mudanças feitas:     " + telaAdmin.getAdmin().getMudancaFeita());
    	telaAdmin.getConteudo().add(dados);
    	for(int i = 0; i < memoria.getListaItinerario().size(); i++){
    		addInformacao(memoria.getListaItinerario().get(i).toString()+" | ID: "+ memoria.getListaItinerario().get(i).getIdItinerario());
    	}
    	for(PassagemAviao index : memoria.getListaAviao()) {
    		addInformacao(index.toString());
    	}
    	for(PassagemOnibus index : memoria.getListaOnibus()) {
    		addInformacao(index.toString());
    	}
    	
    }
//-------------------------------------BOTOES---------------------------------------------
	public void criarButton() {
		telaAdmin.getCriarIt().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                telaAdmin.getAdmin().addMudanca();
                addItinerario(telaAdmin.getDataInicial(), telaAdmin.getDataFinal(), 
                telaAdmin.getHoraInicial(), telaAdmin.getHoraFinal(), telaAdmin.getPontPartida(),
                telaAdmin.getPontChegada());
            }
        });
		telaAdmin.getCriarPA().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	telaAdmin.getAdmin().addMudanca();
            	addPassagemAviao(telaAdmin.getDataInicial(), telaAdmin.getDataFinal(), 
            	telaAdmin.getHoraInicial(), telaAdmin.getHoraFinal(), telaAdmin.getPontPartida(), 
            	telaAdmin.getPontChegada(),telaAdmin.getEscalas(), telaAdmin.getPreco(), 
            	telaAdmin.getMarca(), telaAdmin.getClasse(), telaAdmin.getPesoBagagem(),
            	telaAdmin.getTipoVoo(), telaAdmin.getAlturaVoo());
            }
        });
		telaAdmin.getCriarPO().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	telaAdmin.getAdmin().addMudanca();
            	addPassagemOnibus(telaAdmin.getDataInicial(), telaAdmin.getDataFinal(), 
            	telaAdmin.getHoraInicial(), telaAdmin.getHoraFinal(), telaAdmin.getPontPartida(),
            	telaAdmin.getPontChegada(),telaAdmin.getEscalas(), telaAdmin.getPreco(), 
            	telaAdmin.getMarca(), telaAdmin.getLeito(), telaAdmin.getHorarioParadas(), 
            	telaAdmin.getRefeicaoInclusa());
            }
        });
	}
	public void editarButton() {
		telaAdmin.getEditarIt().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	telaAdmin.getAdmin().addMudanca();
            	editItinerario(telaAdmin.getIdItinerairo(), telaAdmin.getDataInicial(), 
            	telaAdmin.getDataFinal(), telaAdmin.getHoraInicial(), telaAdmin.getHoraFinal(),
            	telaAdmin.getPontPartida(), telaAdmin.getPontChegada());
            }
        });
		telaAdmin.getEditarPA().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	telaAdmin.getAdmin().addMudanca();
            	editPassagemAviao(telaAdmin.getIdPassagem(),telaAdmin.getDataInicial(), telaAdmin.getDataFinal(), 
                telaAdmin.getHoraInicial(), telaAdmin.getHoraFinal(), telaAdmin.getPontPartida(), 
                telaAdmin.getPontChegada(),telaAdmin.getEscalas(), telaAdmin.getPreco(), 
                telaAdmin.getMarca(), telaAdmin.getClasse(), telaAdmin.getPesoBagagem(),
                telaAdmin.getTipoVoo(), telaAdmin.getAlturaVoo());
            }
        });
		telaAdmin.getEditarPO().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	telaAdmin.getAdmin().addMudanca();
            	editPassagemOnibus(telaAdmin.getIdPassagem(), telaAdmin.getDataInicial(), telaAdmin.getDataFinal(), 
                telaAdmin.getHoraInicial(), telaAdmin.getHoraFinal(), telaAdmin.getPontPartida(),
                telaAdmin.getPontChegada(),telaAdmin.getEscalas(), telaAdmin.getPreco(), 
                telaAdmin.getMarca(), telaAdmin.getLeito(), telaAdmin.getHorarioParadas(), 
                telaAdmin.getRefeicaoInclusa());
            }
        });
	}
	public void excluirButton() {
		telaAdmin.getExcluirIt().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	telaAdmin.getAdmin().addMudanca();
            	deleteItinerario(telaAdmin.getIdItinerairo());
            }
        });
		telaAdmin.getExcluirPA().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	telaAdmin.getAdmin().addMudanca();
            	deletePassagem(true, telaAdmin.getIdPassagem());
            }
        });
		telaAdmin.getExcluirPO().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	telaAdmin.getAdmin().addMudanca();
            	deletePassagem(false, telaAdmin.getIdPassagem());
            }
        });
	}
	public void atualizarButton() {
		telaAdmin.getAtualizar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	atualizar();
            }
        });
	}
}