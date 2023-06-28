package View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * A classe Animator é uma classe com somente métodos estaticos onde eu posso colocar em qualquer parte da view para deixa-la mais bonita,
 * essa classe conta com animação, arredondamento de bordas e um textField personalizado.
 * 
 * @author joaoseisei
 * @since 2023
 * @version 1.2
 */
public class Animator {
//ANIMACAO
	/**
	 * O método movimentarHorizontal é responsável por movimentar um painel no eixo X, esse método é estatico para poder ser utilizado
	 * em outras classes sem a necessidade de estanciar a classe Animator.
	 * 
	 * @param painel Painel a ser movimentado.
	 * @param tempo Tempo que o sistema deve esperar a cada interação.
	 * @param inicio Ponto de inicio do painel.
	 * @param fim Ponto de chegada do painel.
	 * @param escala Escala com que o painel se movimenta a cada interação.
	 * @throws InterruptedException Como foi utilizado o Thread.sleep para pausar o loop for a cada interação para deixar a animação
	 * mais suave é necessário ter em mente que o thread pode ser interrompido, o que causará esse erro.
	 */
	public static void moverHorizontal(JPanel painel,int tempo,int inicio,int fim, int escala)throws InterruptedException {
		int interacoes = Math.abs(fim - inicio);
		for(int i = 0; i < interacoes ; i++) {
			Thread.sleep(tempo);
			painel.setBounds((i*escala) + inicio, painel.getLocation().y, painel.getWidth(), painel.getHeight());
		}
	}
//ARREDONDAR BORDAS
	/**
	 * Esse método é responsavel por estilizar a borda de um JPanel, como o java não oferece esse recurso, esse método basicamente
	 * cria uma borda para um painel com o BorderFactory e oculta esse mesmo painel, deixando somente a borda arredondade disponivel, 
	 * isso pois se eu não ocultasse a borda ficaria dentro do proprio container e daria para ver a cor dele formando um quadrado,
	 * em seguida é adicionado o Painel da mesma cor da borda para servir como o painel de conteudo.
	 * 
	 * @param container Borda exterior.
	 * @param painel Conteudo do container.
	 * @param raio Raio da borda do painel.
	 */
	public static void arredondarBordas(JPanel container, JPanel painel, int raio){
		BasicStroke borda = new BasicStroke(raio, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		container.setBorder(BorderFactory.createStrokeBorder(borda, painel.getBackground()));
		container.setOpaque(false);
		container.add(painel);
	}
//JSS TEXTFIELD
	/**
	 * Esse método é responsavel por estilizar um JTextField, além disso ele coloca 2 eventos no mouse para ocultar a mensagem
	 * quando o mouse passar por cima e para exibir a mensagem quando o mouse não está em cima.
	 * 
	 * @param input
	 * @param posicaoX Posição que o input está no eixo X.
	 * @param posicaoY Posição que o input está no eixo Y.
	 * @param largura Largura do TextField.
	 * @param altura Altura do TextField
	 * @param mensagem Possivel mensagem que pode ser colocada dentro do TextField de forma opaca.
	 * @return Esse método retornará um JTextField estilizado.
	 */
	public static JTextField jssTextField(JTextField input,int posicaoX,int posicaoY,int largura,int altura,String mensagem){
		JPanel linha = new JPanel();
		linha.setBackground(Color.black);
		linha.setBounds(0, (altura*80/100), largura, 1);
		input.add(linha);
		//FORMATACAO DO INPUT
		input.setOpaque(false);			//DEIXANDO A TELA TRANSPARENTE
		input.setBorder(null);			//TIRANDO A BORDA DO INPUT
		input.setBounds(posicaoX, posicaoY, largura, altura);
		//MENSAGEM INICIAL DE AVISO
		input.setFont(new Font("Verdana", Font.BOLD, altura/2));
		input.setForeground(Color.LIGHT_GRAY);
		input.setText(mensagem);
		//VERIFICADOR DE MOUSE
		input.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
		        if(input.getText().equals(mensagem)) {
		        	input.setFont(new Font("Arial", Font.BOLD, altura/2));
		        	input.setForeground(Color.BLACK);
		        	input.setText(null);
		        	input.setEditable(true);	
		        	//Se o valor do input for igual a mensagem quando passar o mouse vai sumir
		        	//caso contrario significa que o usuario digitou algo e isso nao pode sumir
		        }
		    }
		    public void mouseExited(MouseEvent e) {
		        if(input.getText() == null || input.getText().isEmpty()) {
		        	input.setFont(new Font("Verdana", Font.BOLD, altura/2));
		        	input.setForeground(Color.LIGHT_GRAY);
		        	input.setText(mensagem);
		        	input.setEditable(false);
		        	//se o usuario nao digitou nada, enquanto ele nao tiver com o mouse em cima do input 
		        	//a mensagem do input é a definida na funçao
		        }
		    }
		});
		return input;
	}
}