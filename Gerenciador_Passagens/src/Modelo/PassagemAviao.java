package Modelo;
import java.time.LocalDate;
import java.time.LocalTime;

public class PassagemAviao extends Passagem{ 
//ATRIBUTOS:
	private Integer classe;							//CLASSE
	private Integer pesoBagagem;					//PESO DA BAGAGEM
	private String tipoVoo;							//TIPO DE VOO
	private Integer alturaVoo;						//ALTURA DO VOO
//CONSTRUTOR	
    public PassagemAviao(LocalDate dataInicial, LocalDate dataFinal, LocalTime horaInicial, LocalTime horaFinal,
					String pontPartida, String pontChegada, String[] escalas, Double preco, String marca, 
					Integer classe, Integer pesoBagagem, String tipoVoo, Integer alturaVoo){
	//SUPER
		super(dataInicial, dataFinal, horaInicial, horaFinal, pontPartida, pontChegada,  escalas, preco, marca);
	//CLASSE
		if(classe >=1 && classe <= 3) {this.classe = classe;}
			else {throw new IllegalArgumentException("Tipo de classe nao suportada (1, 2, 3)");}
	//PESO DA BAGAGEM
		if(pesoBagagem >= 0) {this.pesoBagagem = pesoBagagem;}
			else {throw new IllegalArgumentException("O peso da Bagagem nao pode ser negativo");}
	//TIPO DO VOO
		this.tipoVoo = tipoVoo;
	//ALTURA DO VOO
		if(alturaVoo > 200) {this.alturaVoo = alturaVoo;}
			else {throw new IllegalArgumentException("Aviao nao pode voar tao baixo, aumente a altura");}
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
    	if(novaClasse != null) {
    		this.classe = novaClasse;
    	}
    }
    public void setPesoBagagem(Integer novoPesoBagagem) {
    	if(novoPesoBagagem != null && novoPesoBagagem >= 0 && novoPesoBagagem <= 100) {
    		this.pesoBagagem = novoPesoBagagem;
    	}
    }
    public void setTipoVoo(String novoTipoVoo) {
    	if(novoTipoVoo != null) {
    		this.tipoVoo = novoTipoVoo;
    	}
    }
    public void setAlturaVoo(Integer novaAlturaVoo) {
    	if(novaAlturaVoo != null && novaAlturaVoo > 200) {
    		this.alturaVoo = novaAlturaVoo;
    	}
    }
//METODO ABSTRATO 
    @Override
    public Double calculaPreco() {
		if(  (((super.getPreco()*3) + (pesoBagagem*5) - (super.getNumEscalas()*20)) * (classe-4) * (-1))  > 0){
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
                + "\n  Peso da Bagagem: " + pesoBagagem +"kg" + " | Tipo do Voo: " + tipoVoo + " | Altura do Voo: " + alturaVoo + " Metros"
				+ "} \n ";
    }
}