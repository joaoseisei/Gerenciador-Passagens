package View;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import Modelo.Usuario;

public class TelaUsuario {
//ATRIBUTOS
	private JFrame tela;
	private JPanel painel, configuracao, filtro, passagem, favoritoPainel;
	private JScrollPane container, favorito;
	private JLabel userLB, tituloLB, subtituloLB;
	private Font nomeFont, tituloFont, inputsFont;
	private JTextField dataInicial, dataFinal, pontPartida, pontChegada;
	private JLabel dataInicialLB, dataFinalLB, pontPartidaLB, pontChegadaLB;
	private JButton confirmacao, visualizarFavoritos;
	DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	//-------------USUARIO------------
	private Usuario usuario;
//CONSTRUTOR
	public TelaUsuario(Usuario usuario) {
	//PUXANDO O USUARIO
		this.usuario = usuario;
	//-------------FONTES-----------------------------
		nomeFont = new Font("Verdana", Font.BOLD, 27);
		tituloFont = new Font("Verdana", Font.BOLD, 35);
		inputsFont = new Font("Verdana", Font.BOLD, 16);
	//--------------TELA------------------------------
		tela = new JFrame("PAPO-USUARIO");
		tela.setSize(1100, 700);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//-------------PAINEL-----------------------------
		painel = new JPanel();
		painel.setBackground(Color.LIGHT_GRAY);
		tela.add(painel);
	//----------PAINEL LAYOUT-------------------------
		painel.setLayout(null);
		//CONTAINER DE CONFIGURACOES
		configuracao = new JPanel();
		configuracao.setBounds(0, 0, 200, 700);
		configuracao.setBackground(Color.GRAY);
	//CONTA
		userLB = new JLabel(usuario.getNome());
		userLB.setFont(nomeFont);
		userLB.setForeground(Color.WHITE);
		userLB.setBounds(20,20, 100, 200);
		configuracao.add(userLB);
		//FAVORITOS
		favorito = new JScrollPane();
		favorito.setBounds(5, 50, 189, 595);
		favorito.setBackground(Color.GRAY);
		favorito.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		favoritoPainel = new JPanel();
		favoritoPainel.setLayout(new BoxLayout(favoritoPainel, BoxLayout.Y_AXIS));
		visualizarFavoritos = new JButton("VISUALIZAR FAVORITOS");
		favoritoPainel.add(visualizarFavoritos);
//BOTAO
		favorito.setViewportView(favoritoPainel);
		//ADICIONANDO FAVORITOS AO PAINEL
		painel.add(favorito);
	//ADICIONANDO CONTA AO PAINEL
		painel.add(configuracao);
	//TITULO
		tituloLB = new JLabel("Gerenciador de Passagens");
		tituloLB.setFont(tituloFont);
		tituloLB.setForeground(Color.BLACK);
		tituloLB.setBounds(350, 10, 600, 50);
		painel.add(tituloLB);
	//FILTRO
		filtro = new JPanel();
		filtro.setBounds(245, 70, 800, 100);
		filtro.setBackground(Color.GRAY);
		//TEXTOS
		dataInicialLB = new JLabel("Data inicial:");
		dataInicialLB.setFont(inputsFont);
		dataInicialLB.setForeground(Color.WHITE);
		dataInicialLB.setBounds(250, 85, 100, 20);
		dataFinalLB = new JLabel("Data Final:");
		dataFinalLB.setFont(inputsFont);
		dataFinalLB.setForeground(Color.WHITE);
		dataFinalLB.setBounds(252, 130, 100, 20);
		pontPartidaLB = new JLabel("Digite Entrada:");
		pontPartidaLB.setFont(inputsFont);
		pontPartidaLB.setForeground(Color.WHITE);
		pontPartidaLB.setBounds(580, 85, 150, 20);
		pontChegadaLB = new JLabel("Digite Saida:");
		pontChegadaLB.setFont(inputsFont);
		pontChegadaLB.setForeground(Color.WHITE);
		pontChegadaLB.setBounds(582, 130, 150, 20);
		painel.add(dataInicialLB);
		painel.add(dataFinalLB);
		painel.add(pontPartidaLB);
		painel.add(pontChegadaLB);
		//INPUTS
		dataInicial = new JTextField(20);
		dataInicial.setBounds(360, 80, 200, 30);
		dataFinal = new JTextField(20);
		dataFinal.setBounds(360, 125, 200, 30);
		pontPartida = new JTextField(20);
		pontPartida.setBounds(720, 80, 200, 30);
		pontChegada = new JTextField(20);
		pontChegada.setBounds(720, 125, 200, 30);
		painel.add(dataInicial);
		painel.add(dataFinal);
		painel.add(pontPartida);
		painel.add(pontChegada);
		//CONFIRMACAO
		confirmacao = new JButton("FILTRAR");
		confirmacao.setBackground(Color.lightGray);
		confirmacao.setBounds(940, 85, 90, 70);
//BOTAO
		painel.add(confirmacao);
	//ADICIONANDO FILTRO
		painel.add(filtro);
	//CONTAINER PASSAGENS
		container = new JScrollPane();
		container.setBounds(245, 200, 800, 450);
		container.setBackground(Color.GRAY);
		container.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//PAINEL DE PASSAGEM
		passagem = new JPanel();
        passagem.setLayout(new BoxLayout(passagem, BoxLayout.Y_AXIS));
        //TITULO
        subtituloLB = new JLabel("RESULTADO:");
        passagem.add(subtituloLB);
        
        //ADICIONANDO NO CONTAINER
        container.setViewportView(passagem);
        
		painel.add(container);
	}
//-----------USUARIO--------------
	public Usuario getUsuario(){
		return usuario;
	}
//-----------BOTOES---------------
	public JButton getConfirmacao(){
		return confirmacao;
	}
	public JButton getVisualizarFavoritos(){
		return visualizarFavoritos;
	}
//-----------INPUTS---------------
	public LocalDate getDataInicial(){
		if(dataInicial == null ||dataInicial.getText().isEmpty()) {
			return null;
		}else {
			return LocalDate.parse(dataInicial.getText(), formatador);
		}
	}
	public LocalDate getDataFinal(){
		if(dataFinal == null ||dataFinal.getText().isEmpty()) {
			return null;
		}else {
			return LocalDate.parse(dataFinal.getText(), formatador);
		}
	}
	public String getPontPartida(){
		if(pontPartida.getText().isEmpty()) {
			return null;
		}else {
			return pontPartida.getText();
		}
	}
	public String getPontChegada(){
		if(pontChegada.getText().isEmpty()) {
			return null;
		}else {
			return pontChegada.getText();
		}
	}
//-----------JPANEL---------------
	public JPanel getContainerPassagem(){
		return passagem;
	}
	public JPanel getFavoritoPainel(){
		return favoritoPainel;
	}
//-----------JLABEL--------------
	public JLabel getSubtituloLB(){
		return subtituloLB;
	}
//---------JSCROLLPANE------------
	public JScrollPane getContainer(){
		return container;
	}
	public JScrollPane getFavorito(){
		return favorito;
	}
//EXIBIR TELA
	public void exibir() {
    	tela.setVisible(true);
    }
//OCULAR TELA
	public void ocultar() {
    	tela.setVisible(false);
    }
}