package View;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login{
//ATRIBUTOS
	private JFrame tela;
	private JPanel container, inputsContainer, nomeContainer, senhaContainer;
	private JLabel titulo, nomeLB, senhaLB;
	private JTextField nomeTF, senhaTF;
	private Font tituloFont, subtituloFont;
	private JButton botaoConfirmacao;
	private GridBagConstraints layout;
	private String nome;
	private String senha;
//CONSTRUTOR
    public Login() {
//-----------------------FONTES--------------------------
    	tituloFont = new Font("Verdana", Font.BOLD, 70);
    	subtituloFont = new Font("Verdana", Font.BOLD, 20);
//------------------------TELA---------------------------
    	tela = new JFrame("Gerenciador de Passagens");
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(new Dimension(1200,700));
        //CONTAINERS
        container = new JPanel(new GridBagLayout());
        tela.setContentPane(container);
        container.setBackground(Color.CYAN);
//-----------------------TITULO---------------------------
        titulo = new JLabel("Gerenciador de Passagens");
        //COR E ESTILO
        titulo.setFont(tituloFont);
        titulo.setForeground(Color.DARK_GRAY);
        //ALINHAMENTO
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setVerticalAlignment(SwingConstants.TOP);
        container.add(titulo);
//----------------------INPUTS------------------------
      //INPUTS CONTAINER
        inputsContainer = new JPanel();
        inputsContainer.setBackground(Color.LIGHT_GRAY);
        container.add(inputsContainer);
//----------------------INPUTS LOGIN------------------------ 
      //NOME
        //CONTAINER
        nomeContainer = new JPanel();
        nomeContainer.setBackground(Color.BLACK);
        //TEXTO NOME
        nomeLB = new JLabel("DIGITE O NOME DE USUARIO:");
        nomeLB.setFont(subtituloFont);
        nomeLB.setForeground(Color.ORANGE);
        nomeContainer.add(nomeLB, BorderLayout.CENTER);
        //INPUT NOME
        nomeTF = new JTextField(50); 
        nomeContainer.add(nomeTF, BorderLayout.CENTER);
        inputsContainer.add(nomeContainer);
        
      //------------------------SENHA--------------------------------
        //CONTAINER
        senhaContainer = new JPanel();
        senhaContainer.setBackground(Color.BLACK);
        //TEXTO SENHA
        senhaLB = new JLabel("DIGITE SUA SENHA:");
        senhaLB.setFont(subtituloFont);
        senhaLB.setForeground(Color.ORANGE);
        senhaContainer.add( senhaLB, BorderLayout.CENTER);
        //INPUT SENHA
        senhaTF = new JTextField(50); 
        senhaContainer.add(senhaTF, BorderLayout.CENTER);
        inputsContainer.add(senhaContainer);
      //------------------------CONFIRMACAO---------------------------
        //BOTAO CONFIRMAÇAO
        botaoConfirmacao = new JButton("CONFIRMAR");
        inputsContainer.add(botaoConfirmacao, BorderLayout.SOUTH);
        
        JPanel imagem = new JPanel();
        ImageIcon imageIcon = new ImageIcon("C:\\\\Users\\\\joaos\\\\Downloads\\\\sherek.JPG");
        JLabel label = new JLabel(imageIcon);
        imagem.add(label);
        inputsContainer.add(label, BorderLayout.SOUTH);
        
  //----------------------LAYOUT---------------------------  
        
        layout = new GridBagConstraints();
        layout.gridy = 1;
        layout.weighty = 1;
        layout.fill = GridBagConstraints.BOTH;
        container.add(inputsContainer, layout);
    	
    }
//GETTERS
    public String getNome() {
    	return nome;
    }
    public String getSenha() {
    	return senha;
    }
    public JButton getBC() {
    	return botaoConfirmacao;
    }
    public String getNomeTF() {
    	return nomeTF.getText();
    }
    public String getSenhaTF() {
    	return senhaTF.getText();
    }
//SETTERS
    public void setNome(String novoNome) {
    	this.nome = novoNome;
    }
    public void setSenha(String novaSenha) {
    	this.senha = novaSenha;
    }
//EXIBIR TELA
    public void exibir() {
    	tela.setVisible(true);
    }
//OCULTAR TELA
    public void ocultar() {
    	tela.setVisible(false);
    }
}