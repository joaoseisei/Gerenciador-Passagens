package View;
import java.awt.BorderLayout;
import java.awt.Color;
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
	private String nome;
	private String senha;
	private boolean confirmacao;
	private boolean ocultacao = false;
//CONSTRUTOR
    public Login() {
    //TELA
    	tela = new JFrame("Gerenciador de Passagens");
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
    //CONTAINERS
        JPanel container = new JPanel(new GridBagLayout());
        tela.setContentPane(container);
        container.setBackground(Color.lightGray);
    //TITULO
        JLabel titulo = new JLabel("Gerenciador de Passagens");
        //COR E ESTILO
        titulo.setFont(new Font("Verdana", Font.BOLD, 70));
        titulo.setForeground(Color.BLACK);
        //ALINHAMENTO
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setVerticalAlignment(SwingConstants.TOP);
        container.add(titulo);
    //INPUTS CONTAINER
        JPanel inputsContainer = new JPanel();
        inputsContainer.setBackground(Color.GRAY);
        container.add(inputsContainer);
        
   //----------------------INPUTS LOGIN---------------------------
        //------------------------TITULO-------------------------------
        JPanel tituloContainer = new JPanel();
        tituloContainer.setBackground(Color.PINK);
        JLabel tituloCC = new JLabel("FAZER LOGIN");
        tituloCC.setFont(new Font("Verdana", Font.BOLD, 50));
        tituloCC.setForeground(Color.BLACK);
        tituloContainer.add(tituloCC, BorderLayout.CENTER);
        inputsContainer.add(tituloContainer);
        
      //------------------------NOME---------------------------------
        //CONTAINER
        JPanel nomeContainer = new JPanel();
        nomeContainer.setBackground(Color.BLACK);
        //TEXTO NOME
        JLabel nome = new JLabel("DIGITE O NOME DE USUARIO:");
        nome.setFont(new Font("Verdana", Font.BOLD, 20));
        nome.setForeground(Color.ORANGE);
        nomeContainer.add(nome, BorderLayout.CENTER);
        //INPUT NOME
        JTextField nomeTF = new JTextField(50); 
        nomeContainer.add(nomeTF, BorderLayout.CENTER);
        inputsContainer.add(nomeContainer);
        
      //------------------------SENHA--------------------------------
        //CONTAINER
        JPanel senhaContainer = new JPanel();
        senhaContainer.setBackground(Color.BLACK);
        //TEXTO SENHA
        JLabel senha = new JLabel("DIGITE SUA SENHA:");
        senha.setFont(new Font("Verdana", Font.BOLD, 20));
        senha.setForeground(Color.ORANGE);
        senhaContainer.add( senha, BorderLayout.CENTER);
        //INPUT SENHA
        JTextField senhaTF = new JTextField(50); 
        senhaContainer.add(senhaTF, BorderLayout.CENTER);
        inputsContainer.add(senhaContainer);
      //------------------------CONFIRMACAO---------------------------
        //BOTAO CONFIRMAÇAO
        JButton confirmacao = new JButton("CONFIRMAR");
        inputsContainer.add(confirmacao, BorderLayout.SOUTH);
        confirmacao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {	
                setNome(nomeTF.getText());
                setSenha(senhaTF.getText());
                setOcultacao(true);
            }
        });
        
        JPanel imagem = new JPanel();
        ImageIcon imageIcon = new ImageIcon("C:\\\\Users\\\\joaos\\\\Downloads\\\\sherek.JPG");
        JLabel label = new JLabel(imageIcon);
        imagem.add(label);
        inputsContainer.add(label, BorderLayout.SOUTH);
        
  //----------------------INPUTS CRIAR CONTA---------------------------  
        
        
        
        GridBagConstraints layout = new GridBagConstraints();
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
    public boolean getConfirmacao() {
    	return confirmacao;
    }
    public boolean getOcultacao() {
    	return ocultacao;
    }
//SETTERS
    public void setNome(String novoNome) {
    	this.nome = novoNome;
    }
    public void setSenha(String novaSenha) {
    	this.senha = novaSenha;
    }
    public void setOcultacao(boolean novaOcultacao) {
    	this.ocultacao = novaOcultacao;
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