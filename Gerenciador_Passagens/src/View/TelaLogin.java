package View;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class TelaLogin{
//ATRIBUTOS
	private JFrame tela;
	private JPanel painel, container, conteudoContainer, controle, conteudoControle, registro, conteudoRegistro, 
	login, conteudoLogin, confirmacao, conteudoConfirmacao;
	private JTextField nome, senha, novaSenha;
	private JLabel tituloLBE, tituloLBD, registroLB, loginLB, tituloLB, confirmacaoLB;
	private JTextPane informacaoD, informacaoE;
	private JCheckBox tipo;
	private boolean logando = true;
//CONSTRUTOR
	public TelaLogin() {
	//--------------TELA------------------------------
		tela = new JFrame("PAPO");
		tela.setSize(1100,700);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLocationRelativeTo(null);
	//-------------PAINEL-----------------------------
		painel = new JPanel();
		painel.setBackground(Color.BLACK);
		painel.setLayout(null);
		tela.add(painel);
	//-------------CONTROLE----------------------------
		controle = new JPanel();
		controle.setLayout(null);
		controle.setBounds(120, 125, 850, 450);
		//--------------CONTEUDO CONTROLE---------------
			conteudoControle = new JPanel();
			conteudoControle.setBounds(20, 20, 800, 400);
			conteudoControle.setBackground(new Color(145, 84, 234 ));
			arredondarBordas(controle, conteudoControle, 100);
			conteudoControle.setLayout(null);
		//------------------ESQUERDA--------------------
			//------------TEXTO CONTAINER---------------
			tituloLBD = new JLabel("BEM-VINDO");
			tituloLBD.setFont(new Font("Tahoma", Font.BOLD, 40));
			tituloLBD.setBounds(510, 30, 400, 40);
			conteudoControle.add(tituloLBD);
			
			informacaoD = new JTextPane();
			informacaoD.setText("Aqui você pode buscar\n     passagens com  \n        segurança :)"); 
			informacaoD.setFont(new Font("Tahoma", Font.BOLD, 25));
			informacaoD.setOpaque(false);
			informacaoD.setEditable(false);
			informacaoD.setBounds(500, 120, 500, 200);
			conteudoControle.add(informacaoD);
			//---------------BOTAO--------------------
			registro = new JPanel();
			registro.setLayout(null);
			registro.setBounds(530, 300, 200, 50);
				//----------CONTEUDO BOTAO-----------
				conteudoRegistro = new JPanel();
				conteudoRegistro.setBounds(10, 7, 180, 40);
				conteudoRegistro.setBackground(Color.DARK_GRAY);
				arredondarBordas(registro, conteudoRegistro, 30);
				conteudoRegistro.setLayout(null);
				//-------------TEXTO------------------
					registroLB= new JLabel("REGISTRAR-SE");
					registroLB.setFont(new Font("Tahoma", Font.BOLD, 17));
					registroLB.setBounds(21, 2, 150, 30);
					registroLB.setForeground(Color.WHITE);
					conteudoRegistro.add(registroLB);
			conteudoControle.add(registro);
		//------------------DIREITA---------------------
			//------------TEXTO CONTAINER---------------
			tituloLBE = new JLabel("PRAZER :)");
			tituloLBE.setFont(new Font("Tahoma", Font.BOLD, 40));
			tituloLBE.setBounds(60, 30, 400, 40);
			conteudoControle.add(tituloLBE);
			
			informacaoE = new JTextPane();
			informacaoE.setText("O codigo fonte do\n     projeto está em  \n        github/joaoseisei"); 
			informacaoE.setFont(new Font("Tahoma", Font.BOLD, 25));
			informacaoE.setOpaque(false);
			informacaoE.setEditable(false);
			informacaoE.setBounds(40, 120, 500, 200);
			conteudoControle.add(informacaoE);
			//---------------BOTAO--------------------
			login = new JPanel();
			login.setLayout(null);
			login.setBounds(80, 300, 200, 50);
				//----------CONTEUDO BOTAO-----------
				conteudoLogin = new JPanel();
				conteudoLogin.setBounds(10, 7, 180, 40);
				conteudoLogin.setBackground(Color.DARK_GRAY);
				arredondarBordas(login, conteudoLogin, 30);
				conteudoLogin.setLayout(null);
				//-------------TEXTO------------------
					loginLB= new JLabel("LOGAR-SE");
					loginLB.setFont(new Font("Tahoma", Font.BOLD, 17));
					loginLB.setBounds(40, 2, 150, 30);
					loginLB.setForeground(Color.WHITE);
					conteudoLogin.add(loginLB);
			conteudoControle.add(login);
	//-------------CONTAINER----------------------------
		container = new JPanel();
		container.setLayout(null);
		container.setBounds(120, 100, 500, 500);
		//----------CONTEUDO CONTAINER------------------
			conteudoContainer = new JPanel();
			conteudoContainer.setBounds(70, 70, 400, 400);
			arredondarBordas(container, conteudoContainer, 100);
			//Na funcao arredondar bordas eu chamo 2 paneis, um servirá como borda arredondada,
			//e o outro será o painel principal com conteudos, no caso o conteudo container é onde colocarei
			//todos os inputs, e por ultimo recebe como parametro o raio da borda arredondada
			conteudoContainer.setLayout(null);
	//----------------TITULO-----------------------------
		tituloLB = new JLabel("Login");
		tituloLB.setFont(new Font("Tahoma", Font.BOLD, 30));
		tituloLB.setForeground(Color.BLACK);
		tituloLB.setBounds(120, 0, 300, 40);
		conteudoContainer.add(tituloLB);
	//---------------INPUTS------------------------------
		nome = new JTextField();
		conteudoContainer.add(jssTextField(nome, 20, 70, 300, 50, "Username"));
		//Basicamente eu to pegando um textfield comum e passando a JSSTEXTFIELD para deixar mais elegante
		senha = new JTextField();
		conteudoContainer.add(jssTextField(senha, 20, 150, 300, 50, "Password"));
		novaSenha = new JTextField();
	//------------------TIPO---------------------------
		tipo = new JCheckBox();
		tipo.setBackground(Color.black);
		tipo.setBounds(0, 0, 60, 30);
		painel.add(tipo);
	//----------------BOTAO-----------------------------
		confirmacao = new JPanel();
		confirmacao.setLayout(null);
		confirmacao.setBounds(60, 300, 200, 50);
			//----------CONTEUDO BOTAO-----------
			conteudoConfirmacao = new JPanel();
			conteudoConfirmacao.setBounds(10, 7, 180, 40);
			conteudoConfirmacao.setBackground(Color.DARK_GRAY);
			arredondarBordas(confirmacao, conteudoConfirmacao, 30);
			conteudoConfirmacao.setLayout(null);
			//-------------TEXTO------------------
				confirmacaoLB= new JLabel("LOGAR");
				confirmacaoLB.setFont(new Font("Tahoma", Font.BOLD, 17));
				confirmacaoLB.setBounds(60, 2, 130, 30);
				confirmacaoLB.setForeground(Color.WHITE);
				conteudoConfirmacao.add(confirmacaoLB);
		conteudoContainer.add(confirmacao);
	//-------------MOVIMENTAR A TELA--------------------
		registro.addMouseListener(new MouseAdapter(){public void mouseClicked(MouseEvent e){registro();}});
		login.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {login();}});
	//------------ADICIONANDO CONTAINERS-----------
	    painel.add(container); 
	    painel.add(controle);
	}
//GETTERS
	public boolean getLogando() {
		return logando;
	}
	public String getNome() {
		return nome.getText();
	}
	public String getSenha() {
		return senha.getText();
	}
	public String getNovaSenha() {
		return novaSenha.getText();
	}
	public JPanel getConfirmacao() {
		return confirmacao;
	}
	public boolean getTipo() {
		return tipo.isSelected();
	}
//REGISTRO
	public void registro() {
		//ANIMACAO
        new Thread(() -> {
            try {moverHorizontal(200, container, 2, 500, 500, 1, 95, 100);}
            	catch(InterruptedException y) {}
            //É necessario criar um Thread para a animacao funcionar corretamente, pois ele
            //irá desencadear o loop que existe um Thread.sleep para deixar a animacao mais suave
        }).start();
        //FUNCOES
        painel.setBackground(new Color(191, 191, 191));
        tituloLB.setText("Registro");
        conteudoContainer.add(jssTextField(novaSenha, 20, 230, 300, 50, "Confirm Password"));
        confirmacaoLB.setText("REGISTRAR");
        confirmacaoLB.setBounds(40, 2, 130, 30);
        logando = false;
        tipo.setBackground(Color.LIGHT_GRAY);
	}
//LOGIN
	public void login() {
		//ANIMACAO
        new Thread(() -> {
            try {moverHorizontal(200, container, -2, 500, 500, 1, 480, 100);}
            	catch(InterruptedException y) {}
            //É necessario criar um Thread para a animacao funcionar corretamente, pois ele
            //irá desencadear o loop que existe um Thread.sleep para deixar a animacao mais suave
        }).start();
        //FUNCOES
        painel.setBackground(Color.BLACK);
        tituloLB.setText("Login");
        conteudoContainer.remove(jssTextField(novaSenha, 20, 230, 300, 50, "Confirm Password"));
        confirmacaoLB.setText("LOGAR");
        confirmacaoLB.setBounds(60, 2, 130, 30);
        logando = true;
        tipo.setBackground(Color.black);
	}
//ANIMACOES
	public void moverHorizontal(int interacoes, JPanel painel, int escala, int altura, int largura, 
									int tempo, int inicio, int posicaoY) throws InterruptedException {
		Animator.moverHorizontal(interacoes, painel, escala, altura, largura, tempo, inicio, posicaoY);
	}
	public void moverVertical(int interacoes, JPanel painel, int escala, int altura, int largura, 
									int tempo, int inicio, int posicaoX) throws InterruptedException {
		Animator.moverVertical(interacoes, painel, escala, altura, largura, tempo, inicio, posicaoX);
	}
//ARREDONDAR BORDAS
	public void arredondarBordas(JPanel container, JPanel painel, int raio){
		Animator.arredondarBordas(container, painel, raio);
	}
//JSS TEXTFIELD
	public JTextField jssTextField(JTextField input,int posicaoX,int posicaoY,int largura,int altura,String mensagem){
		return Animator.jssTextField(input, posicaoX, posicaoY, largura, altura, mensagem);
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