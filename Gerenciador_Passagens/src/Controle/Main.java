package Controle;

import java.time.LocalDate;
import java.time.LocalTime;

import Modelo.Memoria;
import View.TelaAdmin;
import View.TelaLogin;
/**
 * 
 * 
 * @author joaoseisei
 * @since 2023
 * @version V2.1
 */
public class Main{	
	
	public static void main(String[] args) {
		Memoria memoria = new Memoria();
		TelaLogin telaLogin = new TelaLogin();
		TelaLoginControle tlControle = new TelaLoginControle(memoria, telaLogin);
		telaLogin.exibir();
		tlControle.TLControler();
		
		tlControle.addConta(true, "adm", "adm");
		TelaAdmin telaAdmin = new TelaAdmin(memoria.getAdminOBJ("adm", "adm"));
		TelaAdminControle taControle = new TelaAdminControle(memoria, telaAdmin);
		taControle.addItinerario(LocalDate.of(2023, 12, 04), LocalDate.of(2023, 12, 05), 
			  	LocalTime.of(14, 0), LocalTime.of(18, 0),
			  	"Brasil", "Chile" );
		taControle.addItinerario(LocalDate.of(2023, 12, 06), LocalDate.of(2023, 12, 07), 
			  	LocalTime.of(14, 0), LocalTime.of(18, 0),
			  	"Brasil", "Chile" );
		taControle.addPassagemAviao(LocalDate.of(2023, 12, 04), LocalDate.of(2023, 12, 05), 
			  	LocalTime.of(14, 0), LocalTime.of(18, 0),
			  	"Brasil", "Chile" , new String[] {"SP-Brasil", "BA-Argentina"} , 
	  			700.08, "Gol", 3 , 10, "Comercial", 1000);
		taControle.addPassagemAviao(LocalDate.of(2023, 7, 04), LocalDate.of(2023, 7, 04), 
				LocalTime.of(10, 0), LocalTime.of(15, 0),
	  			"PB-Brasil", "DF-Brasil" , new String[] {} , 
	  			300.38, "Azul", 2 , 20, "Comercial", 900);
		taControle.addPassagemOnibus(LocalDate.of(2023, 12, 04), LocalDate.of(2023, 12, 5), 
				LocalTime.of(14, 0), LocalTime.of(1, 0),
				"SP-Brasil", "DF-Brasil" , new String[] {"SP-Brasil", "GO-BRASIL", "BA-BRASIL"} , 
				150.31, "Mercedes", true, new String [] {}, true);
		taControle.addPassagemOnibus(LocalDate.of(2023, 7, 26), LocalDate.of(2023, 7, 26), 
				LocalTime.of(14, 0), LocalTime.of(18, 0),
				"GO-Brasil", "DF-Brasil" , new String[] {} , 
				100.08, "Buson", false, new String [] {}, false);
	}	
}