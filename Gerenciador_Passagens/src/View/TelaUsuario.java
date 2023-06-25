package View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Modelo.Usuario;

public class TelaUsuario {
//ATRIBUTOS
	private JFrame tela;
	private JPanel painel, configuracao, conteudoConfiguracao,  filtro, conteudoFiltro, passagem, 
	icone, od, oe, testa, sair, info, utilidade, fav, confirmacao;
	private JScrollPane container;
	private JLabel userLB, sairLB, infoLB, subtituloLB, itinerarioLB, passagemAviaoLB, passagemOnibusLB,
	favLB, confirmacaoLB, dataInicialLB, dataFinalLB, pontPartidaLB, pontChegadaLB;
	private Font nomeFont, inputsFont;
	DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private JTextField dataInicial = new JTextField();
	private JTextField dataFinal = new JTextField();
	private JTextField pontPartida = new JTextField();
	private JTextField pontChegada = new JTextField();
	
	private boolean itinerario = true;
	private boolean passagemAviao = true;
	private boolean passagemOnibus = true;
	//-------------USUARIO------------
	private Usuario usuario;
//CONSTRUTOR
	public TelaUsuario(Usuario usuario) {
	//PUXANDO O USUARIO
		this.usuario = usuario;
	//-------------FONTES-----------------------------
		nomeFont = new Font("Verdana", Font.BOLD, 24);
		inputsFont = new Font("Verdana", Font.BOLD, 17);
	//--------------TELA------------------------------
		tela = new JFrame("PAPO-USUARIO");
		tela.setSize(1100, 700);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLocationRelativeTo(null);
	//-------------PAINEL-----------------------------
		painel = new JPanel();
		painel.setBackground(new Color(210, 194, 233 ));
		tela.add(painel);
	//----------PAINEL LAYOUT-------------------------
		painel.setLayout(null);
		//CONTAINER DE CONFIGURACOES
		configuracao = new JPanel();
		configuracao.setLayout(null);
		configuracao.setBounds(-40, -10, 200, 680);
			conteudoConfiguracao = new JPanel();
			conteudoConfiguracao.setLayout(null);	
			conteudoConfiguracao.setBounds(0, 50, 200, 600);
			conteudoConfiguracao.setBackground(Color.BLACK);//new Color(195, 194, 197)
			Animator.arredondarBordas(configuracao, conteudoConfiguracao, 50);
			
		painel.add(configuracao);
		//ICONE
			icone = new JPanel();
			icone.setLayout(null);
			icone.setBounds(57, 0, 120, 120);
			icone.setOpaque(false);
			icone.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(117, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND), Color.DARK_GRAY));
			conteudoConfiguracao.add(icone);
			
				testa = new JPanel();
				testa.setBackground(Color.DARK_GRAY);
				testa.setBounds(3, 20, 114, 30);
				icone.add(testa);
			
				od = new JPanel();
				od.setBounds(65, 35, 45, 45);
				od.setOpaque(false);
				od.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(44, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND), Color.white));
				icone.add(od);
				
				oe = new JPanel();
				oe.setBounds(10, 35, 45, 45);
				oe.setOpaque(false);
				oe.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(44, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND), Color.white));
				icone.add(oe);
				
			//USERNAME
				userLB = new JLabel(usuario.getNome());
				userLB.setFont(nomeFont);
				userLB.setForeground(Color.gray);
				userLB.setBounds(79,45, 200, 200);
				conteudoConfiguracao.add(userLB);
			
			//EXIBIR FAVORITOS
				fav = new JPanel();
				fav.setLayout(null);
				fav.setBounds(60, 305, 120, 30);
				fav.setOpaque(false);
				fav.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(25, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND),Color.GRAY));
				
					favLB = new JLabel(" favoritos");
					favLB.setBounds(8, 4, 100, 20);
					favLB.setFont(inputsFont);
					favLB.setForeground(Color.white);
					fav.add(favLB);
				
				conteudoConfiguracao.add(fav);
				
			//INFO
				info = new JPanel();
				info.setLayout(null);
				info.setBounds(67, 505, 100, 30);
				info.setOpaque(false);
				info.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(25, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND),Color.GRAY));
				
					infoLB = new JLabel("INFO");
					infoLB.setBounds(20, 4, 70, 20);
					infoLB.setFont(inputsFont);
					infoLB.setForeground(Color.white);
					info.add(infoLB);
				
				conteudoConfiguracao.add(info);
				info.addMouseListener(new MouseAdapter() {
		            public void mouseClicked(MouseEvent e){
		            	JOptionPane.showMessageDialog(null, "Obrigado por acessaro o gerenciador de passagens papo\n"
		            			+ "Aqui você pode procurar todo tipo de passagem de ônibus e avião\n"
		            			+ "basta clicar no coraçao vermelho para favoritar uma passagem e clicar no favoritos para ver os favoritos\n"
		            			+ "as letras I, A,O no canto direito da tela indicam quais tipos de passagem você quer ver,\n"
		            			+ "i para itinerário, a para avião e o para ônibus","INFORMAÇÕES", JOptionPane.INFORMATION_MESSAGE);
		            }
		        });
				
			//SAIR
				sair = new JPanel();
				sair.setLayout(null);
				sair.setBounds(67, 555, 100, 30);
				sair.setOpaque(false);
				sair.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(25, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND), new Color(145, 84, 234 )));
				
					sairLB = new JLabel("SAIR");
					sairLB.setBounds(20, 4, 70, 20);
					sairLB.setFont(inputsFont);
					sairLB.setForeground(Color.white);
					sair.add(sairLB);
				
				conteudoConfiguracao.add(sair);
	//FILTRO
		filtro = new JPanel();
		filtro.setBounds(200, -10, 800, 150);
		filtro.setLayout(null);
			conteudoFiltro = new JPanel();
			conteudoFiltro.setLayout(null);
			Color c = new Color(233, 233, 233 );
			conteudoFiltro.setBackground(c);
			conteudoFiltro.setBounds(20, 5, 760, 150);
			Animator.arredondarBordas(filtro, conteudoFiltro, 30);
			painel.add(filtro);
		//INPUTS
			dataInicialLB = new JLabel("Data Inicial:");
			dataInicialLB.setFont(inputsFont);
			dataInicialLB.setBounds(30, 10, 200, 50);
			conteudoFiltro.add(dataInicialLB);
			dataInicial = Animator.jssTextField(dataInicial, 160, 20, 130, 30, "DD/MM/YYYY");
			
			dataFinalLB = new JLabel("Data Final:");
			dataFinalLB.setFont(inputsFont);
			dataFinalLB.setBounds(30, 55, 200, 40);
			conteudoFiltro.add(dataFinalLB);
			dataFinal =  Animator.jssTextField(dataFinal, 160, 60, 130, 30, "DD/MM/YYYY");

			pontPartidaLB = new JLabel("Ponto de Partida:");
			pontPartidaLB.setFont(inputsFont);
			pontPartidaLB.setBounds(400, 10, 200, 50);
			conteudoFiltro.add(pontPartidaLB);
			pontPartida = Animator.jssTextField(pontPartida, 600, 20, 130, 30, "Brasil, China...");
			
			pontChegadaLB = new JLabel("Ponto de Chegada:");
			pontChegadaLB.setFont(inputsFont);
			pontChegadaLB.setBounds(400, 55, 200, 40);
			conteudoFiltro.add(pontChegadaLB);
			pontChegada = Animator.jssTextField(pontChegada, 600, 60, 130, 30, "China, Brasil...");
			
			conteudoFiltro.add(dataInicial);
			conteudoFiltro.add(dataFinal);
			conteudoFiltro.add(pontPartida);
			conteudoFiltro.add(pontChegada);
		//BOTAO
			confirmacao = new JPanel();
			confirmacao.setBounds(310,105, 100, 30);
			confirmacao.setOpaque(false);
			confirmacao.setLayout(null);
			confirmacao.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(25, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND), new Color(145, 84, 234 )));
			
				confirmacaoLB = new JLabel("filtrar");
				confirmacaoLB.setBounds(20, 4, 70, 20);
				confirmacaoLB.setFont(inputsFont);
				confirmacaoLB.setForeground(Color.WHITE);
				conteudoFiltro.add(confirmacao);
				confirmacao.add(confirmacaoLB);

	//CONTAINER PASSAGENS
		container = new JScrollPane();
		container.setBounds(200,160, 800, 480);
		container.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND),Color.BLACK));
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
		
	//TABELA LATERAL DE UTILIDADES	
		utilidade = new JPanel();
		utilidade.setLayout(null);
		utilidade.setBounds(1040, -14, 50, 700);
		utilidade.setBackground(Color.BLACK);
			
			itinerarioLB = new JLabel("I");
			itinerarioLB.setFont(nomeFont);
			itinerarioLB.setForeground(Color.white);
			itinerarioLB.setBounds(12, 30, 30, 30);
			utilidade.add(itinerarioLB);
			itinerarioLB.addMouseListener(new MouseAdapter(){public void mouseClicked(MouseEvent e){trocarItinerario();}});
			
			passagemAviaoLB = new JLabel("A");
			passagemAviaoLB.setFont(nomeFont);
			passagemAviaoLB.setForeground(Color.white);
			passagemAviaoLB.setBounds(10, 70, 30, 30);
			utilidade.add(passagemAviaoLB);
			passagemAviaoLB.addMouseListener(new MouseAdapter(){public void mouseClicked(MouseEvent e){trocarPassagemAviao();}});
			
			passagemOnibusLB = new JLabel("O");
			passagemOnibusLB.setFont(nomeFont);
			passagemOnibusLB.setForeground(Color.white);
			passagemOnibusLB.setBounds(10, 110, 30, 30);
			utilidade.add(passagemOnibusLB);
			passagemOnibusLB.addMouseListener(new MouseAdapter(){public void mouseClicked(MouseEvent e){trocarPassagemOnibus();}});
			
		painel.add(utilidade);
	}
//-----------USUARIO--------------
	public Usuario getUsuario(){
		return usuario;
	}
//-----------BOTOES---------------
	public JPanel getConfirmacao(){
		return confirmacao;
	}
	public JPanel getFav() {
		return fav;
	}
	public JPanel getSair() {
		return sair;
	}
//-----------INPUTS---------------
	public LocalDate getDataInicial(){
		if(dataInicial == null ||dataInicial.getText().isEmpty()||dataInicial.getText().equals("DD/MM/YYYY")) {
			return null;
		}else {
			return LocalDate.parse(dataInicial.getText(), formatador);
		}
	}
	public LocalDate getDataFinal(){
		if(dataFinal == null ||dataFinal.getText().isEmpty()||dataFinal.getText().equals("DD/MM/YYYY")) {
			return null;
		}else {
			return LocalDate.parse(dataFinal.getText(), formatador);
		}
	}
	public String getPontPartida(){
		if(pontPartida.getText().isEmpty() || pontPartida.getText().equals("Brasil, China...")) {
			return null;
		}else {
			return pontPartida.getText();
		}
	}
	public String getPontChegada(){
		if(pontChegada.getText().isEmpty() || pontChegada.getText().equals("China, Brasil...")) {
			return null;
		}else {
			return pontChegada.getText();
		}
	}
//-----------JPANEL---------------
	public JPanel getContainerPassagem(){
		return passagem;
	}
//-----------JLABEL--------------
	public JLabel getSubtituloLB(){
		return subtituloLB;
	}
//---------JSCROLLPANE------------
	public JScrollPane getContainer(){
		return container;
	}
//-----------BOOLEANOS------------
	public boolean getItinerario() {
		return itinerario;
	}
	public boolean getPassagemAviao() {
		return passagemAviao;
	}
	public boolean getPassagemOnibus() {
		return passagemOnibus;
	}
//METODOS
	public void atualizarFavoritos(){
		container.removeAll();
    	for(int i = 0; i < usuario.getFavoritos().size(); i++){
    		JPanel caixa = new JPanel();
    		JLabel conteudo = new JLabel(usuario.getFavoritos().get(i).toString());
    		caixa.add(conteudo);
    		container.add(caixa);
    	}
    }
	
	public void addPassagem(Usuario user, JPanel containerA, String informacao) {
		JPanel caixa = new JPanel();
		String[] linhas = informacao.split("\n"); 
    	caixa.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        for (String linha : linhas) {
            JLabel conteudo = new JLabel(linha);
            caixa.add(conteudo);
        }
		JButton favorito = new JButton("♥");
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
					usuario.addFavoritos(informacao);
				}
			}
		});
		caixa.add(favorito);
		caixa.setPreferredSize(new Dimension(500, 100));
		caixa.setLayout(new BoxLayout(caixa, BoxLayout.Y_AXIS));
		containerA.add(caixa);
		container.setViewportView(passagem);
	}
	
	public void resetFiltro(JPanel container, JLabel texto) {
 		container.removeAll();
 		texto = new JLabel("RESULTADO:");
 		container.add(texto);
 	}
	public void trocarItinerario() {
		if(itinerario) {
			itinerario = false;
			itinerarioLB.setForeground(Color.red);
		}else {
			itinerario = true;
			itinerarioLB.setForeground(Color.white);
		}
	}
	public void trocarPassagemAviao() {
		if(passagemAviao) {
			passagemAviao = false;
			passagemAviaoLB.setForeground(Color.red);
		}else {
			passagemAviao = true;
			passagemAviaoLB.setForeground(Color.white);
		}
	}
	public void trocarPassagemOnibus() {
		if(passagemOnibus) {
			passagemOnibus = false;
			passagemOnibusLB.setForeground(Color.red);
		}else {
			passagemOnibus = true;
			passagemOnibusLB.setForeground(Color.white);
		}
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