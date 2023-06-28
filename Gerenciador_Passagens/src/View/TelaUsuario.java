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

import Controle.UsuarioControle;
/**
 * A classe TelaUsuario é responsavel por exibir todo o painel de login utilizando o swing do java, em forma de interface gráfica.
 * 
 * @author joaoseisei
 * @since 2023
 * @version 1.2
 */
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
	private UsuarioControle usuario;
//CONSTRUTOR
	/**
	 * O contrutor de TelaUsuario recebe como parametro um Usuário, isso é para que cada TelaUsuario se adapte ao usuário,
	 * além disso basicamente é colocado todo o conteudo da interface gráfica quando a classe é criada
	 * para sempre que instancia-la aparecer a interface gráfica.
	 * 
	 * @param usuario 
	 */
	public TelaUsuario(UsuarioControle usuario) {
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
				userLB = new JLabel(usuario.getUsuario().getNome());
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
	public UsuarioControle getUsuarioControle(){
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
	/**
	 * Esse método é responsável por adicionar passagens e itinerarios no container, além disso ele também adiciona um botão de adicionar nos favoritos
	 * do usuario e verifica se essa passagem ja existe nos favoritos, se não existir ou a lista de favoritos estiver vazia ele adiciona, também é feito
	 * um separamento de linha, para que o container tenham diversas linhas uma em baixo da outra utilizando o .slipt("\n"), pois o próprio
	 * tostring ja tem o tamanho ideal e barramento necessário.
	 * 
	 * @param user Usuário a ser verificado para adição de favoritos.
	 * @param containerA Container que será criado com as informações.
	 * @param informacao Informação a ser adicionada.
	 */
	public void addPassagem(JPanel containerA, String informacao) {
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
		favorito.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					usuario.addFavoritoFiltrado(informacao);
				}
			}
		);
		caixa.add(favorito);
		caixa.setPreferredSize(new Dimension(500, 100));
		caixa.setLayout(new BoxLayout(caixa, BoxLayout.Y_AXIS));
		containerA.add(caixa);
		container.setViewportView(passagem);
	}
	/**
	 * Esse método é responsável por resetar todo o conteúdo de um container e adicionar uma label com a mesagem "resultado:",
	 * isso é utilizado para resetar o container sempre que for filtrar algo.
	 * 
	 * @param container
	 * @param texto
	 */
	public void resetFiltro(JPanel container, JLabel texto) {
 		container.removeAll();
 		texto = new JLabel("RESULTADO:");
 		container.add(texto);
 	}
	/**
	 * Esse método é responsavel por definir o tipo de itinerario que o usuário deseja ver, se for true ele irá ver, e se for false a letra
	 * ficará vermelha e o usuário não verá os itinerarios.
	 */
	public void trocarItinerario() {
		if(itinerario) {
			itinerario = false;
			itinerarioLB.setForeground(Color.red);
		}else {
			itinerario = true;
			itinerarioLB.setForeground(Color.white);
		}
	}
	/**
	 * Esse método é responsavel por definir o tipo de passagem que o usuário deseja ver, se for true ele irá ver, e se for false a letra
	 * ficará vermelha e o usuário não verá as passagens de avião.
	 */
	public void trocarPassagemAviao() {
		if(passagemAviao) {
			passagemAviao = false;
			passagemAviaoLB.setForeground(Color.red);
		}else {
			passagemAviao = true;
			passagemAviaoLB.setForeground(Color.white);
		}
	}
	/**
	 * Esse método é responsavel por definir o tipo de passagem que o usuário deseja ver, se for true ele irá ver, e se for false a letra
	 * ficará vermelha e o usuário não verá as passagem de ônibus.
	 */
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
	/**
	 * Esse método é responsável por exibir a tela, sempre que ele for chamado a tela que é o JFrame que é a tela ficará visivel.
	 */
	public void exibir() {
    	tela.setVisible(true);
    }
//OCULAR TELA
	/**
	 * Esse método é responsável por ocultar a tela, sempre que ele for chamado a tela que é o JFrame que é a tela ficará oculto.
	 */
	public void ocultar() {
    	tela.setVisible(false);
    }
}