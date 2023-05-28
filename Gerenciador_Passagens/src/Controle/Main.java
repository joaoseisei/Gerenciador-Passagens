package Controle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import Modelo.*;
import View.Login;
import View.TelaAdmin;
import View.TelaUsuario;

public class Main {
//OBJETOS
	static Login login = new Login();
	static Memoria memoria = new Memoria();
	static DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//CRIAR UMA CONTA
	public static void criarConta() {
		if(login.getNome().trim().isEmpty() || login.getSenha().trim().isEmpty()) {
			throw new IllegalArgumentException("NOME OU SENHA SÃO NULOS");
		}else {
			if((memoria.verificarUser(login.getNome(), login.getSenha()) == false || 
					memoria.getListaUsuario().isEmpty()) && login.getTipo() == false) {
				memoria.addConta(login.getTipo(), login.getNome(), login.getSenha(), login.getSenha());
			}else if((memoria.verificarAdmin(login.getNome(), login.getSenha()) == false || 
					memoria.getListaAdmin().isEmpty()) && login.getTipo() == true){
				memoria.addConta(login.getTipo(), login.getNome(), login.getSenha(), login.getSenha());
			}else {
				throw new IllegalArgumentException("EXISTE UMA CONTA CADASTRADA COM AS MESMAS CREDENCIAIS");
			}
		}
	}
//FAZER LOGIN
	public static void fazerLogin() {
		if(memoria.fazerLogin(login.getNome(), login.getSenha(), login.getTipo()).equals("UsuarioLogado")) {
			login.ocultar();
			TelaUsuario telaUser = new TelaUsuario(memoria.getUsuarioOBJ(login.getNome(), login.getSenha()));
			telaUser.exibir();
			telaUser.getConfirmacao().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					telaUser.resetFiltro(telaUser.getContainerPassagem());
					LocalDate inicio = telaUser.getDataInicial();
					LocalDate fim = telaUser.getDataFinal();
					String pontPartida = telaUser.getPontPartida();
					String pontChegada = telaUser.getPontChegada();
					for (Itinerario index : memoria.filtrarItinerario(inicio, fim, pontPartida, pontChegada)) {
						telaUser.addPassagem(telaUser.getUsuario(), telaUser.getContainerPassagem(), index.toString());
					}
					for (PassagemAviao index : memoria.filtrarPassagemAviao(inicio, fim, pontPartida, pontChegada)) {
						telaUser.addPassagem(telaUser.getUsuario(), telaUser.getContainerPassagem(), index.toString());
					}
					for (PassagemOnibus index : memoria.filtrarPassagemOnibus(inicio, fim, pontPartida, pontChegada)) {
						telaUser.addPassagem(telaUser.getUsuario(), telaUser.getContainerPassagem(), index.toString());
					}
				}
			});
		}else if( memoria.fazerLogin(login.getNome(), login.getSenha(), login.getTipo()).equals("AdminLogado")) {
			login.ocultar();
			TelaAdmin telaADM = new TelaAdmin(memoria.getAdminOBJ(login.getNome(), login.getSenha()));
			telaADM.exibir();
		}
	}
//FILTRAR PASSAGENS
	public static void filtrarPassagens() {
		
	}
//METODO MAIN
	public static void main(String[] args) {
	//CRIANDO PASSAGENS DE TESTE
		memoria.addItinerario(LocalDate.of(2023, 12, 04), LocalDate.of(2023, 12, 05), 
						  	LocalTime.of(14, 0), LocalTime.of(18, 0),
						  	"Brasil", "Chile" );
		memoria.addItinerario(LocalDate.of(2023, 12, 06), LocalDate.of(2023, 12, 07), 
						  	LocalTime.of(14, 0), LocalTime.of(18, 0),
						  	"Brasil", "Chile" );
		memoria.addPassagemAviao(LocalDate.of(2023, 12, 04), LocalDate.of(2023, 12, 05), 
				  LocalTime.of(14, 0), LocalTime.of(18, 0),
				  "Brasil", "Chile" , new String[] {"SP-Brasil", "BA-Argentina"} , 
				  700.08, "Gol", 3 , 10, "Comercial", 1000);
		memoria.addPassagemAviao(LocalDate.of(2023, 7, 04), LocalDate.of(2023, 7, 04), 
				  LocalTime.of(10, 0), LocalTime.of(15, 0),
				  "PB-Brasil", "DF-Brasil" , new String[] {} , 
				  300.38, "Azul", 2 , 20, "Comercial", 900);
		memoria.addPassagemOnibus(LocalDate.of(2023, 12, 04), LocalDate.of(2023, 12, 5), 
				  LocalTime.of(14, 0), LocalTime.of(1, 0),
				  "SP-Brasil", "DF-Brasil" , new String[] {"SP-Brasil", "GO-BRASIL", "BA-BRASIL"} , 
				  150.31, "Mercedes", true, 0, new Integer [] {}, true);
		memoria.addPassagemOnibus(LocalDate.of(2023, 7, 26), LocalDate.of(2023, 7, 26), 
				  LocalTime.of(14, 0), LocalTime.of(18, 0),
				  "GO-Brasil", "DF-Brasil" , new String[] {} , 
				  100.08, "Buson", false, 0, new Integer [] {}, false);
		login.exibir();
	//BOTAO FAZER REGISTRO
		login.getFazerRegistro().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                criarConta();
            }
        });
	//BOTAO FAZER LOGIN	
		login.getFazerLogin().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fazerLogin();
			}
		});	
		
	}	
}