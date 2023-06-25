package View;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Animator {
//ANIMACAO
	public static void moverHorizontal(JPanel painel,int tempo,int inicio,int fim, int escala)throws InterruptedException {
		int interacoes = Math.abs(fim - inicio);
		for(int i = 0; i < interacoes ; i++) {
			Thread.sleep(tempo);
			painel.setBounds((i*escala) + inicio, painel.getLocation().y, painel.getWidth(), painel.getHeight());
		}
	}
//ARREDONDAR BORDAS
	public static void arredondarBordas(JPanel container, JPanel painel, int raio){
		BasicStroke borda = new BasicStroke(raio, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		container.setBorder(BorderFactory.createStrokeBorder(borda, painel.getBackground()));
		container.setOpaque(false);
		container.add(painel);
	}
	public static void arredondarBordas(JPanel container, JScrollPane painel, int raio){
		BasicStroke borda = new BasicStroke(raio, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		container.setBorder(BorderFactory.createStrokeBorder(borda, painel.getBackground()));
		container.setOpaque(false);
		container.add(painel);
	}
//JSS TEXTFIELD
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