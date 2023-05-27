package View;

import javax.swing.JFrame;

public class TelaUsuario {
	private JFrame tela;
	public TelaUsuario() {
		tela = new JFrame("Gerenciador de Passagens");
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
