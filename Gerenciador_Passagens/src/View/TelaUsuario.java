package View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import Modelo.*;

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
		tela = new JFrame("PAPO-USUARIO" +" | "+ usuario.getIDU());
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
		visualizarFavoritos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	favoritoPainel.removeAll();
            	favoritoPainel.add(visualizarFavoritos);
            	for(int i = 0; i < usuario.getFavoritos().size(); i++) {
            		addPassagem(usuario, favoritoPainel, usuario.getFavoritos().get(i).toString());
            		favorito.setViewportView(favoritoPainel);
            	}
            }
        });
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
        confirmacao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	addPassagem(usuario, passagem, "teste 1");
            	addPassagem(usuario, passagem, "teste 2");
            	container.setViewportView(passagem);
            }
        });
        //ADICIONANDO NO CONTAINER
        container.setViewportView(passagem);
        
		painel.add(container);
	}
//GETTERS
	public Usuario getUsuario() {
		return usuario;
	}
//ADICIONAR PASSAGEM	
	public static void addPassagem(Usuario user, JPanel container, String informacao) {
		JPanel caixa = new JPanel();
		JLabel conteudo = new JLabel(informacao);
		JButton favorito = new JButton("♥");
		caixa.setBackground(Color.WHITE);
		favorito.setBackground(Color.pink);
		favorito.setBounds(0, 0, 20, 20);
		favorito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!user.getFavoritos().isEmpty() || user.getFavoritos() != null) {
					int i = 0;
			        for (String index : user.getFavoritos()) {
			            if (index.equals(informacao)) {
			                i++;
			            }
			        }
			        if (i == 0) {
			            user.addFavoritos(informacao);
			        }
				}else {
					addFavorito(user, informacao);
				}
			}
		});
		caixa.add(favorito);
		caixa.add(conteudo);
		container.add(caixa);
	}
//ADICIONAR FAVORITO	
	public static void addFavorito(Usuario user, String informacao) {
		user.addFavoritos(informacao);
	}
	public JButton getConfirmacao() {
		return confirmacao;
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