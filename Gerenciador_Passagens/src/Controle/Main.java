package Controle;
import java.time.LocalDate;
import java.time.LocalTime;

import Modelo.Admin;
import Modelo.Memoria;
import Modelo.Usuario;
import View.Login;
import View.TelaAdmin;
import View.TelaUsuario;


public class Main {	
//METODO MAIN
	public static void main(String[] args) {
		Memoria memoria = new Memoria();
	//------------------LOGIN-------------------
		Login login = new Login();
		TelaLoginControle TLControle = new TelaLoginControle(memoria, login);
		login.exibir();
		TLControle.criarContaButton();
		TLControle.fazerLoginButton();

		
		
		TelaAdminControle TAControle = new TelaAdminControle(memoria);
		TAControle.addItinerario(LocalDate.of(2023, 12, 04), LocalDate.of(2023, 12, 05), 
			  	LocalTime.of(14, 0), LocalTime.of(18, 0),
			  	"Brasil", "Chile" );
		TAControle.addItinerario(LocalDate.of(2023, 12, 06), LocalDate.of(2023, 12, 07), 
			  	LocalTime.of(14, 0), LocalTime.of(18, 0),
			  	"Brasil", "Chile" );
		TAControle.addPassagemAviao(LocalDate.of(2023, 12, 04), LocalDate.of(2023, 12, 05), 
				LocalTime.of(14, 0), LocalTime.of(18, 0),
				"Brasil", "Chile" , new String[] {"SP-Brasil", "BA-Argentina"} , 
				700.08, "Gol", 3 , 10, "Comercial", 1000);
		TAControle.addPassagemAviao(LocalDate.of(2023, 7, 04), LocalDate.of(2023, 7, 04), 
				LocalTime.of(10, 0), LocalTime.of(15, 0),
				"PB-Brasil", "DF-Brasil" , new String[] {} , 
				300.38, "Azul", 2 , 20, "Comercial", 900);
		TAControle.addPassagemOnibus(LocalDate.of(2023, 12, 04), LocalDate.of(2023, 12, 5), 
				LocalTime.of(14, 0), LocalTime.of(1, 0),
				"SP-Brasil", "DF-Brasil" , new String[] {"SP-Brasil", "GO-BRASIL", "BA-BRASIL"} , 
				150.31, "Mercedes", true, 0, new String[] {"2", "2"}, true);
		TAControle.addPassagemOnibus(LocalDate.of(2023, 7, 26), LocalDate.of(2023, 7, 26), 
				LocalTime.of(14, 0), LocalTime.of(18, 0),
				"GO-Brasil", "DF-Brasil" , new String[] {} , 
				100.08, "Buson", false, 0, new String[] {}, false);
		
	}	
}