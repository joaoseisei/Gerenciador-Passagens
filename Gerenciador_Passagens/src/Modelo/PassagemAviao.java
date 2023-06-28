package Modelo;
/**
 * A classe passagemAviao é herdada da classe passagens, que por sua vez tem um itinerario. Sendo assim, 
 * nessa classe temos todos os itens a cima mais 4 atributos que definem uma passagem de avião.
 * 
 * @author joaoseisei
 * @since 2023
 * @version 1.3
 */
public class PassagemAviao extends Passagem{ 
//ATRIBUTOS:
	private Integer classe;							//CLASSE
	private Integer pesoBagagem;					//PESO DA BAGAGEM
	private String tipoVoo;							//TIPO DE VOO
	private Integer alturaVoo;						//ALTURA DO VOO
//CONSTRUTOR	
	/**
	 * Esse construtor é responsável por adicionar todos os atributos de uma passagem de avião, isso ocorre
	 * pois é importante criar uma passagem de avião com todos as informações definidas. Além disso existem
	 * verificações como só permitir a classe de 1 a 3, não permitir peso de bagagem negativo e colocar altura
	 * de voo mínima como 200 metros, essas verificações são feitas usando setters dentro do construtor.
	 * 
	 * @param itinerario
	 * @param escalas
	 * @param preco
	 * @param marca
	 * @param classe
	 * @param pesoBagagem
	 * @param tipoVoo
	 * @param alturaVoo
	 */
    public PassagemAviao(Itinerario itinerario,String[] escalas,Double preco,String marca, 
						Integer classe,Integer pesoBagagem,String tipoVoo,Integer alturaVoo){
	//SUPER
		super(itinerario, escalas, preco, marca);
	//CLASSE
		setClasse(classe);
	//PESO DA BAGAGEM
		setPesoBagagem(pesoBagagem);
	//TIPO DO VOO
		this.tipoVoo = tipoVoo;
	//ALTURA DO VOO
		setAlturaVoo(alturaVoo);
	}
//GETTERS
    public Integer getClasse() {
    	return classe;
    }
    public Integer getPesoBagagem() {
    	return pesoBagagem;
    }
    public String getTipoVoo() {
    	return tipoVoo;
    }
    public Integer getAlturaVoo() {
    	return alturaVoo;
    }
//SETTERS
    public void setClasse(Integer novaClasse) {
    	if(novaClasse != null) this.classe = novaClasse;
    }
    public void setPesoBagagem(Integer novoPesoBagagem) {
    	if(novoPesoBagagem != null && novoPesoBagagem >= 0 && novoPesoBagagem <= 100) {
    		this.pesoBagagem = novoPesoBagagem;
    	}
    }
    public void setTipoVoo(String novoTipoVoo) {
    	if(novoTipoVoo != null) this.tipoVoo = novoTipoVoo;
    }
    public void setAlturaVoo(Integer novaAlturaVoo) {
    	if(novaAlturaVoo != null && novaAlturaVoo > 200) this.alturaVoo = novaAlturaVoo;
    }
//METODO ABSTRATO 
    /**
     * Esse método é herdado da classe passagem e é modificado para calcular o preço de acordo com o peso da bagagem,
     * número de escalas e classe, esse método nunca irá retornar algo menor que 0.00.
     * 
     * @return retornará o preco calculado de acordo com a passagem de avião.
     */
    @Override
    public Double calculaPreco() {
		if( (((super.getPreco()*3) + (pesoBagagem*5) - (super.getNumEscalas()*20)) * (classe-4) * (-1))  > 0){
			return Math.round(((super.getPreco()*3) + (pesoBagagem*5) - (super.getNumEscalas()*20)) * (classe-4) * (-100.0))/100.0;
		}else{
			return 0.00;
		}
    }
//TOSTRING
    @Override
    public String toString(){
	//SUPER
        return super.toString()
	//TOSTRING AVIAO
                + "\n  Tipo: Avião" + " | Marca: " + getMarca() + " (AVIÃO)" + " | Classe: " + classe + "°" + " | Preço: R$" + calculaPreco()
                + "\n  Peso da Bagagem: " + pesoBagagem +"kg" + " | Tipo do Voo: " + tipoVoo + " | Altura do Voo: " + alturaVoo + " Metros";
    }
}