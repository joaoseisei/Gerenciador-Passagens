package View;
import java.awt.*;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Login {
	
	public static void main(String[] args){
        JFrame telaLogin = new JFrame("Gerenciador de Passagens Papo");
        telaLogin.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Configuração para fechar o frame ao clicar no "X" da janela
        telaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Exibe o frame
        telaLogin.setVisible(true);


        // componente JPanel
        JPanel miJPanel = new JPanel();
        miJPanel.setSize(300, 300);

        // usamos este diseño para centrar los componentes de JPanel
        miJPanel.setLayout(new GridBagLayout());

        // componente JTextField
        JLabel miJLabel = new JLabel();
        miJLabel.setText("Dime tu opinión acerca de Java Swing:   ");

        // componente JTextArea
        JTextArea miJTextArea = new JTextArea(5,20); 

        // conecta los componentes JLabel y JTextField en JPanel
        miJPanel.add(miJLabel);
        miJPanel.add(miJTextArea);
    }

}
