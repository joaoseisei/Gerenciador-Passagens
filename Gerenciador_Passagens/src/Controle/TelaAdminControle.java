package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import Modelo.Itinerario;
import Modelo.Memoria;
import Modelo.PassagemAviao;
import Modelo.PassagemOnibus;

import View.TelaAdmin;

/**
 * A classe TelaAdminControle é responsável por vincular a classe TelaAdmin com
 * a memoria do sistema. Ademais, nessa classe que é realizado o CRUD do
 * sistema, ela é a classe que adminstrará a aplicação.
 * 
 * @author joaoseisei
 * @since 2023
 * @version 1.2
 */
public class TelaAdminControle {
//ATRIBUTOS
	private Memoria memoria;
	private TelaAdmin telaAdmin;

//CONSTRUTOR
	/**
	 * Esse construtor é responsável por vincular a TelaAdmin e a Memoria na classe,
	 * para poder utilizar banco de dados e botoẽs.
	 * 
	 * @param memoria
	 * @param telaAdmin
	 */
	public TelaAdminControle(Memoria memoria, TelaAdmin telaAdmin) {
		this.memoria = memoria;
		this.telaAdmin = telaAdmin;
	}

//-----------------------------------ADICIONAR--------------------------------------------	
	/**
	 * Método responsável por adicionar um itinerário único, eles são comparados
	 * pelo toString, sendo assim não existirão itinerários repetidos.
	 * 
	 * @param dataInicial a data inicial do itinerário.
	 * @param dataFinal   a data final do itinerário.
	 * @param horaInicial a hora inicial do itinerário.
	 * @param horaFinal   a hora final do itinerário.
	 * @param pontPartida o ponto de partida do itinerário.
	 * @param pontChegada o ponto de chegada do itinerário.
	 */
	public void addItinerario(LocalDate dataInicial, LocalDate dataFinal, LocalTime horaInicial, LocalTime horaFinal,
			String pontPartida, String pontChegada) {
		ArrayList<Itinerario> novaListaItinerario = new ArrayList<>(memoria.getListaItinerario());
		Itinerario novoItinerario = new Itinerario(dataInicial, dataFinal, horaInicial, horaFinal, pontPartida,
				pontChegada);
		if (novaListaItinerario.isEmpty() || novaListaItinerario.stream()
				.noneMatch(index -> index.toString().equals(novoItinerario.toString()))) {
			novaListaItinerario.add(novoItinerario);
			memoria.setListaItinerario(novaListaItinerario);
		}
		// Cria uma Lista que é igual a lista do getmemoria e verificamos se ela é vazia
		// primeiro para nao dar erro,
		// Caso a lista nao seja vazia, eu uso o stream para verificar elemento por
		// elemento e uso o noneMatch para
		// colocar uma condição, no caso se os ToString forem iguais, pois neles tem
		// todas as informaçoes de itinerario.
	}

	/**
	 * Método responsável por adicionar uma passagem de avião.
	 * 
	 * @param dataInicial
	 * @param dataFinal
	 * @param horaInicial
	 * @param horaFinal
	 * @param pontPartida
	 * @param pontChegada
	 * @param escalas
	 * @param preco
	 * @param marca
	 * @param classe
	 * @param pesoBagagem
	 * @param tipoVoo
	 * @param alturaVoo
	 */
	public void addPassagemAviao(LocalDate dataInicial, LocalDate dataFinal, LocalTime horaInicial, LocalTime horaFinal,
			String pontPartida, String pontChegada, String[] escalas, Double preco, String marca, Integer classe,
			Integer pesoBagagem, String tipoVoo, Integer alturaVoo) {
		ArrayList<PassagemAviao> novaListaAviao = new ArrayList<>(memoria.getListaAviao());
		Itinerario itinerarioPA = new Itinerario(dataInicial, dataFinal, horaInicial, horaFinal, pontPartida,
				pontChegada);
		PassagemAviao novaPA = new PassagemAviao(itinerarioPA, escalas, preco, marca, classe, pesoBagagem, tipoVoo,
				alturaVoo);
		if (dataInicial.isAfter(LocalDate.now()) || dataInicial.isEqual(LocalDate.now())) {
			novaListaAviao.add(novaPA);
			addItinerario(dataInicial, dataFinal, horaInicial, horaFinal, pontPartida, pontChegada);
			memoria.setListaAviao(novaListaAviao);
		}

	}

	/**
	 * Método responsável por adicionar uma passagem de ônibus.
	 * 
	 * @param dataInicial
	 * @param dataFinal
	 * @param horaInicial
	 * @param horaFinal
	 * @param pontPartida
	 * @param pontChegada
	 * @param escalas
	 * @param preco
	 * @param marca
	 * @param leito
	 * @param horarioParadas
	 * @param refeicaoInclusa
	 */
	public void addPassagemOnibus(LocalDate dataInicial, LocalDate dataFinal, LocalTime horaInicial,
			LocalTime horaFinal, String pontPartida, String pontChegada, String[] escalas, Double preco, String marca,
			Boolean leito, String[] horarioParadas, Boolean refeicaoInclusa) {
		ArrayList<PassagemOnibus> novaListaOnibus = new ArrayList<>(memoria.getListaOnibus());
		Itinerario itinerarioPO = new Itinerario(dataInicial, dataFinal, horaInicial, horaFinal, pontPartida,
				pontChegada);
		PassagemOnibus novaPO = new PassagemOnibus(itinerarioPO, escalas, preco, marca, leito, horarioParadas,
				refeicaoInclusa);
		if (dataInicial.isAfter(LocalDate.now()) || dataInicial.isEqual(LocalDate.now())) {
			novaListaOnibus.add(novaPO);
			addItinerario(dataInicial, dataFinal, horaInicial, horaFinal, pontPartida, pontChegada);
			memoria.setListaOnibus(novaListaOnibus);
		}
	}

//------------------------------------DELETAR---------------------------------------------	
	/**
	 * Método responsável por remover um itinerário, quando é excluido um itinerario
	 * excluimos todas as passagens que possuem esse itinerário.
	 * 
	 * @param idItinerario
	 */
	public void deleteItinerario(String idItinerario) {
		ArrayList<Itinerario> novaListaItinerario = new ArrayList<>(memoria.getListaItinerario());
		ArrayList<PassagemAviao> novaListaAviao = new ArrayList<>(memoria.getListaAviao());
		ArrayList<PassagemOnibus> novaListaOnibus = new ArrayList<>(memoria.getListaOnibus());
		for (Itinerario index : novaListaItinerario) {
			if (index.getIdItinerario().equals(idItinerario)) {
				for (PassagemAviao indexA : novaListaAviao) {
					if (indexA.getItinerario().toString().equals(index.toString())) {
						novaListaAviao.remove(indexA);
					}
				}
				for (PassagemOnibus indexB : novaListaOnibus) {
					if (indexB.getItinerario().toString().equals(index.toString())) {
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

	/**
	 * Método responsável por remover uma passagem de avião e ônibus isoladamente.
	 * 
	 * @param aviao
	 * @param id
	 */
	public void deletePassagem(Boolean aviao, String id) {
		ArrayList<PassagemAviao> novaListaAviao = new ArrayList<>(memoria.getListaAviao());
		ArrayList<PassagemOnibus> novaListaOnibus = new ArrayList<>(memoria.getListaOnibus());
		if (aviao) {
			novaListaAviao.removeIf(index -> index.getId().equals(id));
			memoria.setListaAviao(novaListaAviao);
		} else {
			novaListaOnibus.removeIf(index -> index.getId().equals(id));
			memoria.setListaOnibus(novaListaOnibus);
		}
	}

//-------------------------------------EDITAR---------------------------------------------		
	/**
	 * Edita o Itinerario de todas as passagens que possuem ele, entretanto se der
	 * um erro de lógica, o itinerario não é editado.
	 * 
	 * @param idItinerario
	 * @param dataInicial
	 * @param dataFinal
	 * @param horaInicial
	 * @param horaFinal
	 * @param pontPartida
	 * @param pontChegada
	 */
	public void editItinerario(String idItinerario, LocalDate dataInicial, LocalDate dataFinal, LocalTime horaInicial,
			LocalTime horaFinal, String pontPartida, String pontChegada) {
		ArrayList<Itinerario> novaListaItinerario = new ArrayList<>(memoria.getListaItinerario());
		ArrayList<PassagemAviao> novaListaAviao = new ArrayList<>(memoria.getListaAviao());
		ArrayList<PassagemOnibus> novaListaOnibus = new ArrayList<>(memoria.getListaOnibus());
		for (Itinerario index : novaListaItinerario) {
			if (idItinerario.equals(index.getIdItinerario())) {
				Itinerario backup = index;
				index.setDataInicial(dataInicial);
				index.setDataFinal(dataFinal);
				index.setHoraInicial(horaInicial);
				index.setHoraFinal(horaFinal);
				index.setPontPartida(pontPartida);
				index.setPontChegada(pontChegada);
				// VERIFICAÇÃO DE CONFLITO
				if (index.getDataInicial().isAfter(index.getDataFinal())
						&& index.getDataInicial().equals(index.getDataFinal())
						&& index.getHoraInicial().isAfter(index.getHoraFinal())) {
					index = backup;
					break;
				} else {
					// EDITANDO O ITINERARIO DOS AVIOES
					for (PassagemAviao indexA : novaListaAviao) {
						if (backup.toString().equals(indexA.getItinerario().toString())) {
							indexA.setItinerario(index);
						}
					}
					// EDITANDO O ITINERARIO DOS ONIBUS
					for (PassagemOnibus indexB : novaListaOnibus) {
						if (backup.toString().equals(indexB.getItinerario().toString())) {
							indexB.setItinerario(index);
						}
					}
				}
			}
		}
		memoria.setListaItinerario(novaListaItinerario);
		memoria.setListaAviao(novaListaAviao);
		memoria.setListaOnibus(novaListaOnibus);
	}

	/**
	 * Edita todos os atributos de uma passagem de avião.
	 * 
	 * @param id
	 * @param dataInicial
	 * @param dataFinal
	 * @param horaInicial
	 * @param horaFinal
	 * @param pontPartida
	 * @param pontChegada
	 * @param escalas
	 * @param preco
	 * @param marca
	 * @param classe
	 * @param pesoBagagem
	 * @param tipoVoo
	 * @param alturaVoo
	 */
	public void editPassagemAviao(String id, LocalDate dataInicial, LocalDate dataFinal, LocalTime horaInicial,
			LocalTime horaFinal, String pontPartida, String pontChegada, String[] escalas, Double preco, String marca,
			Integer classe, Integer pesoBagagem, String tipoVoo, Integer alturaVoo) {
		ArrayList<PassagemAviao> novaListaAviao = new ArrayList<>(memoria.getListaAviao());
		for (PassagemAviao index : novaListaAviao) {
			// passando linha por linha da listagem
			if (index.getId().equals(id)) {
				// CRUD ITINERARIO
				index.getItinerario().setDataInicial(dataInicial);
				index.getItinerario().setDataFinal(dataFinal);
				index.getItinerario().setHoraInicial(horaInicial);
				index.getItinerario().setHoraFinal(horaFinal);
				index.getItinerario().setPontPartida(pontPartida);
				index.getItinerario().setPontChegada(pontChegada);
				// CRUD PASSAGEM
				index.setEscalasENumEscalas(escalas);
				index.setPreco(preco);
				index.setMarca(marca);
				index.setClasse(classe);
				index.setPesoBagagem(pesoBagagem);
				index.setTipoVoo(tipoVoo);
				index.setAlturaVoo(alturaVoo);
				// VERIFICADOR DE DATAS
				if (index.getItinerario().getDataInicial().isAfter(index.getItinerario().getDataFinal())) {
					deletePassagem(true, index.getId());
					throw new IllegalArgumentException("CONFLITO DE DATA (DIA), DELETANDO PASSAGEM");
				} else if (index.getItinerario().getDataInicial().equals(index.getItinerario().getDataFinal())
						&& index.getItinerario().getHoraInicial().isAfter(index.getItinerario().getHoraFinal())) {
					deletePassagem(true, index.getId());
					throw new IllegalArgumentException("CONFLITO DE DATA (HORA), DELETANDO PASSAGEM");
				}
				break;
			}
		}
		memoria.setListaAviao(novaListaAviao);
	}

	/**
	 * Edita todos os atributos de uma passagem de ônibus.
	 * 
	 * @param id
	 * @param dataInicial
	 * @param dataFinal
	 * @param horaInicial
	 * @param horaFinal
	 * @param pontPartida
	 * @param pontChegada
	 * @param escalas
	 * @param preco
	 * @param marca
	 * @param leito
	 * @param horarioParadas
	 * @param refeicaoInclusa
	 */
	public void editPassagemOnibus(String id, LocalDate dataInicial, LocalDate dataFinal, LocalTime horaInicial,
			LocalTime horaFinal, String pontPartida, String pontChegada, String[] escalas, Double preco, String marca,
			Boolean leito, String[] horarioParadas, Boolean refeicaoInclusa) {
		ArrayList<PassagemOnibus> novaListaOnibus = new ArrayList<>(memoria.getListaOnibus());
		for (PassagemOnibus index : novaListaOnibus) {
			if (index.getId().equals(id)) {
				// CRUD ITINERARIO
				index.getItinerario().setDataInicial(dataInicial);
				index.getItinerario().setDataFinal(dataFinal);
				index.getItinerario().setHoraInicial(horaInicial);
				index.getItinerario().setHoraFinal(horaFinal);
				index.getItinerario().setPontPartida(pontPartida);
				index.getItinerario().setPontChegada(pontChegada);
				// CRUD PASSAGEM
				index.setEscalasENumEscalas(escalas);
				index.setPreco(preco);
				index.setMarca(marca);
				index.setLeito(leito);
				index.setHorarioENumParadas(horarioParadas);
				index.setRefeicaoInclusa(refeicaoInclusa);
				// VERIFICADOR DATAS
				if (index.getItinerario().getDataInicial().isAfter(index.getItinerario().getDataFinal())) {
					deletePassagem(false, index.getId());
					throw new IllegalArgumentException("ERRO DE DATAS, DELETANDO PASSAGEM");
				} else if (index.getItinerario().getDataInicial().equals(index.getItinerario().getDataFinal())
						&& index.getItinerario().getHoraInicial().isAfter(index.getItinerario().getHoraFinal())) {
					deletePassagem(true, index.getId());
					throw new IllegalArgumentException("CONFLITO DE DATA (HORA), DELETANDO PASSAGEM");
				}
				break;
			}
		}
		memoria.setListaOnibus(novaListaOnibus);
	}

	/**
	 * Esse método é responsável por atualizar o painel com as passagens, para ver
	 * as passagens ou itinerários mais atualizadas.
	 */
	public void atualizar() {
		telaAdmin.resetar();
		for (int i = 0; i < memoria.getListaItinerario().size(); i++) {
			telaAdmin.addInformacao(memoria.getListaItinerario().get(i).toString() + " | ID: "
					+ memoria.getListaItinerario().get(i).getIdItinerario());
		}
		for (PassagemAviao index : memoria.getListaAviao()) {
			telaAdmin.addInformacao(index.toString());
		}
		for (PassagemOnibus index : memoria.getListaOnibus()) {
			telaAdmin.addInformacao(index.toString());
		}
	}

//-------------------------------------BOTOES---------------------------------------------
	/**
	 * Esse método é responsáve por criar passagens, nele existem 3 ouvintes de
	 * botão que pegam os valores dos inputs e criam passagens, serve para
	 * itinerario passagem de ônibus e avião.
	 */
	public void criarButton() {
		// ITINERARIO
		telaAdmin.getCriarIt().addActionListener(new ActionListener() {
			/**
			 * Detecta o clique do mouse do botão CriarIT.
			 * 
			 * @param e Recebe como parametro o evento do clique do mouse.
			 */
			public void actionPerformed(ActionEvent e) {
				telaAdmin.getAdminControle().addMudanca();
				addItinerario(telaAdmin.getDataInicial(), telaAdmin.getDataFinal(), telaAdmin.getHoraInicial(),
						telaAdmin.getHoraFinal(), telaAdmin.getPontPartida(), telaAdmin.getPontChegada());
			}
		});
		// PASSAGEM AVIAO
		telaAdmin.getCriarPA().addActionListener(new ActionListener() {
			/**
			 * Detecta o clique do mouse do botão CriarPA.
			 * 
			 * @param e Recebe como parametro o evento do clique do mouse.
			 */
			public void actionPerformed(ActionEvent e) {
				telaAdmin.getAdminControle().addMudanca();
				addPassagemAviao(telaAdmin.getDataInicial(), telaAdmin.getDataFinal(), telaAdmin.getHoraInicial(),
						telaAdmin.getHoraFinal(), telaAdmin.getPontPartida(), telaAdmin.getPontChegada(),
						telaAdmin.getEscalas(), telaAdmin.getPreco(), telaAdmin.getMarca(), telaAdmin.getClasse(),
						telaAdmin.getPesoBagagem(), telaAdmin.getTipoVoo(), telaAdmin.getAlturaVoo());
			}
		});
		// PASSAGEM ONIBUS
		telaAdmin.getCriarPO().addActionListener(new ActionListener() {
			/**
			 * Detecta o clique do mouse do botão CriarPO.
			 * 
			 * @param e Recebe como parametro o evento do clique do mouse.
			 */
			public void actionPerformed(ActionEvent e) {
				telaAdmin.getAdminControle().addMudanca();
				addPassagemOnibus(telaAdmin.getDataInicial(), telaAdmin.getDataFinal(), telaAdmin.getHoraInicial(),
						telaAdmin.getHoraFinal(), telaAdmin.getPontPartida(), telaAdmin.getPontChegada(),
						telaAdmin.getEscalas(), telaAdmin.getPreco(), telaAdmin.getMarca(), telaAdmin.getLeito(),
						telaAdmin.getHorarioParadas(), telaAdmin.getRefeicaoInclusa());
			}
		});
	}

	/**
	 * Esse método é responsáve por editar passagens, nele existem 3 ouvintes de
	 * botão que pegam os valores dos inputs e editam passagens, serve para
	 * itinerario passagem de ônibus e avião.
	 */
	public void editarButton() {
		// ITINERARIO
		telaAdmin.getEditarIt().addActionListener(new ActionListener() {
			/**
			 * Detecta o clique do mouse do botão EditarIT.
			 * 
			 * @param e Recebe como parametro o evento do clique do mouse.
			 */
			public void actionPerformed(ActionEvent e) {
				telaAdmin.getAdminControle().addMudanca();
				editItinerario(telaAdmin.getIdItinerairo(), telaAdmin.getDataInicial(), telaAdmin.getDataFinal(),
						telaAdmin.getHoraInicial(), telaAdmin.getHoraFinal(), telaAdmin.getPontPartida(),
						telaAdmin.getPontChegada());
			}
		});
		// PASSAGEM AVIAO
		telaAdmin.getEditarPA().addActionListener(new ActionListener() {
			/**
			 * Detecta o clique do mouse do botão EditarPA.
			 * 
			 * @param e Recebe como parametro o evento do clique do mouse.
			 */
			public void actionPerformed(ActionEvent e) {
				telaAdmin.getAdminControle().addMudanca();
				editPassagemAviao(telaAdmin.getIdPassagem(), telaAdmin.getDataInicial(), telaAdmin.getDataFinal(),
						telaAdmin.getHoraInicial(), telaAdmin.getHoraFinal(), telaAdmin.getPontPartida(),
						telaAdmin.getPontChegada(), telaAdmin.getEscalas(), telaAdmin.getPreco(), telaAdmin.getMarca(),
						telaAdmin.getClasse(), telaAdmin.getPesoBagagem(), telaAdmin.getTipoVoo(),
						telaAdmin.getAlturaVoo());
			}
		});
		// PASSAGEM ONIBUS
		telaAdmin.getEditarPO().addActionListener(new ActionListener() {
			/**
			 * Detecta o clique do mouse do botão EditarPO.
			 * 
			 * @param e Recebe como parametro o evento do clique do mouse.
			 */
			public void actionPerformed(ActionEvent e) {
				telaAdmin.getAdminControle().addMudanca();
				editPassagemOnibus(telaAdmin.getIdPassagem(), telaAdmin.getDataInicial(), telaAdmin.getDataFinal(),
						telaAdmin.getHoraInicial(), telaAdmin.getHoraFinal(), telaAdmin.getPontPartida(),
						telaAdmin.getPontChegada(), telaAdmin.getEscalas(), telaAdmin.getPreco(), telaAdmin.getMarca(),
						telaAdmin.getLeito(), telaAdmin.getHorarioParadas(), telaAdmin.getRefeicaoInclusa());
			}
		});
	}

	/**
	 * Esse método é responsáve por excluir passagens, nele existem 3 ouvintes de
	 * botão que pegam os valores dos inputs e excluem passagens, serve para
	 * itinerario passagem de ônibus e avião.
	 */
	public void excluirButton() {
		// ITINERARIO
		telaAdmin.getExcluirIt().addActionListener(new ActionListener() {
			/**
			 * Detecta o clique do mouse do botão ExcluirIT.
			 * 
			 * @param e Recebe como parametro o evento do clique do mouse.
			 */
			public void actionPerformed(ActionEvent e) {
				telaAdmin.getAdminControle().addMudanca();
				deleteItinerario(telaAdmin.getIdItinerairo());
			}
		});
		// PASSAGEM AVIAO
		telaAdmin.getExcluirPA().addActionListener(new ActionListener() {
			/**
			 * Detecta o clique do mouse do botão ExcluirPA.
			 * 
			 * @param e Recebe como parametro o evento do clique do mouse.
			 */
			public void actionPerformed(ActionEvent e) {
				telaAdmin.getAdminControle().addMudanca();
				deletePassagem(true, telaAdmin.getIdPassagem());
			}
		});
		// PASSAGEM AVIAO
		telaAdmin.getExcluirPO().addActionListener(new ActionListener() {
			/**
			 * Detecta o clique do mouse do botão ExclirPO.
			 * 
			 * @param e Recebe como parametro o evento do clique do mouse.
			 */
			public void actionPerformed(ActionEvent e) {
				telaAdmin.getAdminControle().addMudanca();
				deletePassagem(false, telaAdmin.getIdPassagem());
			}
		});
	}

	/**
	 * Esse método é responsável por atualizar o painel com as passagens e
	 * itinerarios, nele existe um ouvinte de botão que atualiza o mesmo.
	 */
	public void atualizarButton() {
		telaAdmin.getAtualizar().addActionListener(new ActionListener() {
			/**
			 * Detecta o clique do mouse do botão Atualizar.
			 * 
			 * @param e Recebe como parametro o evento do clique do mouse.
			 */
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
	}
}