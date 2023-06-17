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
	private JTextField nome;
	private JPasswordField senha, novaSenha;
	private JLabel tituloLBE, tituloLBD, registroLB, loginLB, tituloLB, confirmacaoLB, tipoSeletor;
	private JTextPane informacaoD, informacaoE;
	private boolean logando = true;
	private boolean tipo = false;
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
			Animator.arredondarBordas(controle, conteudoControle, 100);
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
				Animator.arredondarBordas(registro, conteudoRegistro, 30);
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
				Animator.arredondarBordas(login, conteudoLogin, 30);
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
			Animator.arredondarBordas(container, conteudoContainer, 100);
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
		conteudoContainer.add(Animator.jssTextField(nome, 20, 70, 300, 50, "Username"));
		//Basicamente eu to pegando um textfield comum e passando a JSSTEXTFIELD para deixar mais elegante
		senha = new JPasswordField();
		conteudoContainer.add(Animator.jssTextField(senha, 20, 150, 300, 50, "Password"));
		novaSenha = new JPasswordField();
	//------------------TIPO---------------------------
		tipoSeletor = new JLabel("XD");
		tipoSeletor.setFont(new Font("Tahoma", Font.BOLD, 20));
		tipoSeletor.setBounds(770, 370, 60, 30);
		tipoSeletor.addMouseListener(new MouseAdapter(){public void mouseClicked(MouseEvent e){selecionarTipo();}});
		conteudoControle.add(tipoSeletor);
	//----------------BOTAO-----------------------------
		confirmacao = new JPanel();
		confirmacao.setLayout(null);
		confirmacao.setBounds(60, 300, 200, 50);
			//----------CONTEUDO BOTAO-----------
			conteudoConfirmacao = new JPanel();
			conteudoConfirmacao.setBounds(10, 7, 180, 40);
			conteudoConfirmacao.setBackground(Color.DARK_GRAY);
			Animator.arredondarBordas(confirmacao, conteudoConfirmacao, 30);
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
	public boolean getTipo() {
		return tipo;
	}
	public String getNome() {
		if(nome.getText().equals("Username")) {
			return null;
		}
		return nome.getText();
	}
	public String getSenha() {
		if(String.valueOf(senha.getPassword()).equals("Password")) {
			return null;
		}else {
			return  String.valueOf(senha.getPassword());
		}
	}
	public String getNovaSenha() {
		if(String.valueOf(novaSenha.getPassword()).equals("Password")) {
			return null;
		}else {
			return String.valueOf(novaSenha.getPassword());
		}
	}
	public JPanel getConfirmacao() {
		return confirmacao;
	}
//SELECIONAR TIPO
	public void selecionarTipo() {
		if(tipo) {
			tipo = false;
			tipoSeletor.setForeground(Color.DARK_GRAY);
		}else {
			tipo = true;
			tipoSeletor.setForeground(Color.RED);
		}
	}
//REGISTRO
	public void registro() {
		//ANIMACAO
        new Thread(() -> {
            try {Animator.moverHorizontal(container, 1, 95, 305, 2);}
            	catch(InterruptedException y) {}
            //É necessario criar um Thread para a animacao funcionar corretamente, pois ele
            //irá desencadear o loop que existe um Thread.sleep para deixar a animacao mais suave
        }).start();
        //FUNCOES
        painel.setBackground(new Color(191, 191, 191));
        tituloLB.setText("Registro");
        conteudoContainer.add(Animator.jssTextField(novaSenha, 20, 230, 300, 50, "Password"));
        confirmacaoLB.setText("REGISTRAR");
        confirmacaoLB.setBounds(40, 2, 130, 30);
        logando = false;
	}
//LOGIN
	public void login() {
		//ANIMACAO
        new Thread(() -> {
            try {Animator.moverHorizontal(container, 1, 405, 235, -2);}
            	catch(InterruptedException y) {}
            //É necessario criar um Thread para a animacao funcionar corretamente, pois ele
            //irá desencadear o loop que existe um Thread.sleep para deixar a animacao mais suave
        }).start();
        //FUNCOES
        painel.setBackground(Color.BLACK);
        tituloLB.setText("Login");
        conteudoContainer.remove(Animator.jssTextField(novaSenha, 20, 230, 300, 50, "Confirm Password"));
        confirmacaoLB.setText("LOGAR");
        confirmacaoLB.setBounds(60, 2, 130, 30);
        logando = true;
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