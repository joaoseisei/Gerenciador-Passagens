package View;
import java.awt.*;
import javax.swing.*;

public class Login {
//ATRIBUTOS
	private JFrame tela;
	private JPanel painel;
	private JLabel usuarioLB, senhaLB;
	private JButton fazerLogin, fazerRegistro;
	private JTextField nome;
	private JPasswordField senha;
	private Font fonteInputs;
	private JCheckBox tipo;
//CONSTRUTOR
	public Login() {
	//-------------FONTES----------------------------
		fonteInputs = new Font("Verdana", Font.BOLD, 18);
	//--------------TELA------------------------------
		tela = new JFrame("PAPO-LOGIN");
		tela.setSize(400, 200);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//-------------PAINEL-----------------------------
		painel = new JPanel();
		painel.setBackground(Color.DARK_GRAY);
		tela.add(painel);
	//-------------INPUTS-----------------------------
		painel.setLayout(null);
	//TEXTOS
		usuarioLB = new JLabel("Usuario");
		usuarioLB.setFont(fonteInputs);
		usuarioLB.setForeground(Color.LIGHT_GRAY);
		usuarioLB.setBounds(20, 19, 100, 30);
		senhaLB = new JLabel("Senha");
		senhaLB.setFont(fonteInputs);
		senhaLB.setForeground(Color.LIGHT_GRAY);
		senhaLB.setBounds(20, 59, 100, 30);
		painel.add(usuarioLB);
		painel.add(senhaLB);
	//INPUTS
		nome = new JTextField(20);
		nome.setBounds(110, 20, 250, 30);
		senha = new JPasswordField(20);
		senha.setBounds(110, 60, 250, 30);
		painel.add(nome);
		painel.add(senha);
	//BOTOES
		fazerLogin = new JButton("LOGAR");
		fazerLogin.setBackground(Color.lightGray);
		fazerLogin.setBounds(20, 120, 100, 30);
		fazerRegistro = new JButton("REGISTRAR");
		fazerRegistro.setBackground(Color.lightGray);
		fazerRegistro.setBounds(260, 120, 100, 30);
		painel.add(fazerLogin);
		painel.add(fazerRegistro);
	//CHECKBOX
		tipo = new JCheckBox("ADM");
		tipo.setBackground(Color.gray);
		tipo.setBounds(165, 120, 60, 30);
		painel.add(tipo);
	}
//GETTERS
	public String getNome() {
		return nome.getText();
	}
	public String getSenha() {
		return String.valueOf(senha.getPassword());
	}
	public JButton getFazerLogin() {
		return fazerLogin;
	}
	public JButton getFazerRegistro() {
		return fazerRegistro;
	}
	public boolean getTipo() {
		return tipo.isSelected();
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