package View;
import javax.swing.*;
import Modelo.Admin;

public class TelaAdmin {
//ATRIBUTOS
	private JFrame tela;
	//-------------ADMIN------------
	private Admin admin;
//CONSTRUTOR
	public TelaAdmin(Admin admin) {
		this.admin = admin;
		tela = new JFrame("PAPO-ADMIN" +" | "+ admin.getIDU());
		tela.setSize(1000, 700);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
//GETTERS
	public Admin getUsuario() {
		return admin;
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