package Modelo;

import java.util.*;

/**
 * A classe passagem é uma classe abstrata com informações basicas de uma
 * passagem, como preço, marca... Além disso ela receberá um objeto Itinerario
 * como atributo e servirá para ser herdada pelas classes: PassagemAviao e
 * PassagemOnibus.
 * 
 * @author joaoseisei
 * @since 2023
 * @version 1.3
 */
public abstract class Passagem {
//ATRIBUTOS
	private Itinerario itinerario; // ITINERARIO
	private String[] escalas; // ESCALAS
	private Integer numEscalas; // NUMERO DE ESCALAS
	private Double preco; // PREÇO
	private String marca; // MARCA
	private final String id; // ID DO ITINERARIO
//CONSTRUTOR	

	/**
	 * O construtor de Passagem recebe todos os atributos para a criação de uma
	 * passagem, nele existem diversas verificações para manter o máximo de coesão
	 * possível, como conflito de horario e local através de setters, também é
	 * adicionado um gerador de id único.
	 * 
	 * @param itinerario
	 * @param escalas
	 * @param preco
	 * @param marca
	 */
	public Passagem(Itinerario itinerario, String[] escalas, Double preco, String marca) {
		// ITINERARIO
		this.itinerario = itinerario;
		// ESCALAS E NUMERO DE ESCALAS
		setEscalasENumEscalas(escalas);
		// PRECO
		setPreco(preco);
		// MARCA
		this.marca = marca;
		// ID
		this.id = String.format("%07d", new Random().nextInt(100000));
	}

//GETTERS   
	public Itinerario getItinerario() {
		return itinerario;
	}

	public String[] getEscalas() {
		return escalas;
	}

	public Integer getNumEscalas() {
		return numEscalas;
	}

	public Double getPreco() {
		return preco;
	}

	public String getMarca() {
		return marca;
	}

	public String getId() {
		return id;
	}

//SETTERS
	/**
	 * Esse método é responsável por definir o número de escalas automaticamente
	 * sempre que for adicionado ou removido uma escala da lista de escalas
	 * "escalas".
	 * 
	 * @param novaEscala Nova lista de escalas
	 */
	public void setEscalasENumEscalas(String[] novaEscala) {
		this.escalas = novaEscala != null ? novaEscala.clone() : new String[0]; // Nao retorna array nulo, sim um vazio
		if (novaEscala != null)
			this.numEscalas = novaEscala.length;
		else
			this.numEscalas = 0;
	}

	public void setPreco(Double novoPreco) {
		if (novoPreco != null && novoPreco > 0)this.preco = novoPreco;
	}

	public void setMarca(String novaMarca) {
		if (novaMarca != null)this.marca = novaMarca;
	}

	public void setItinerario(Itinerario itinerario) {
		if (itinerario != null)this.itinerario = itinerario;
	}

//METODO ABSTRATO
	/**
	 * Esse método é responsavel por calcular o preço, ele é abstrato pois o calculo
	 * de preço de PassagemAviao e PassagemOnibus é diferente.
	 * 
	 * @return retornará o preco calculado de acordo com o tipo de passagem.
	 */
	public abstract Double calculaPreco();

//TOSTRING
	public String toString() {
		return "  Data de Partida: " + itinerario.getDataInicial() + " / " + itinerario.getHoraInicial()
				+ " | Data de Chegada: " + itinerario.getDataFinal() + " / " + itinerario.getHoraFinal()
				+ "\n  Local de Partida: " + itinerario.getPontPartida() + " | Local de Chegada: "
				+ itinerario.getPontChegada() + " | Id da Passagem: " + id + "\n  Numero de escalas: " + numEscalas
				+ " | Escalas: " + Arrays.toString(escalas);
		// aqui estou formatando o toString para facilitar a leitura de objetos
	}
}