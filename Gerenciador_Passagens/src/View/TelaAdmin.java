package View;
import javax.swing.*;

public class TelaAdmin {
//ATRIBUTOS
	private JFrame tela;
//CONSTRUTOR
	public TelaAdmin() {
		tela = new JFrame("PAPO-ADMIN");
		tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
