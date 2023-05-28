package Controle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;

import Modelo.Memoria;
import View.Login;
import View.TelaAdmin;
import View.TelaUsuario;

public class Main {
//OBJETOS
	static Login login = new Login();
	static Memoria memoria = new Memoria();
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
            	for(int i = 0; i < memoria.filtrarPassagemAviao(telaUser.getDataInicial(), 
            	telaUser.getDataFinal(),telaUser.getPontPartida(), telaUser.getPontChegada()).size(); i++) {
       
            		telaUser.addPassagem(memoria.getUsuarioOBJ(login.getNome(),login.getSenha()), //usuario
            				telaUser.getContainerPassagem(), 									  //JPainel
                			memoria.filtrarPassagemAviao(telaUser.getDataInicial(), telaUser.getDataFinal(),
    						telaUser.getPontPartida(), telaUser.getPontChegada()).get(i).toString());
            	}
            	for(int i = 0; i < memoria.filtrarPassagemOnibus(telaUser.getDataInicial(), 
            	telaUser.getDataFinal(),telaUser.getPontPartida(), telaUser.getPontChegada()).size(); i++) {
            		
            		telaUser.addPassagem(memoria.getUsuarioOBJ(login.getNome(),login.getSenha()), //usuario
							 telaUser.getContainerPassagem(), 									  //JPainel
							 memoria.filtrarPassagemOnibus(telaUser.getDataInicial(), telaUser.getDataFinal(),
						     telaUser.getPontPartida(), telaUser.getPontChegada()).get(i).toString());
            		}
            	for(int i = 0; i < memoria.filtrarItinerario(telaUser.getDataInicial(), 
            	telaUser.getDataFinal(),telaUser.getPontPartida(), telaUser.getPontChegada()).size(); i++) {
            		telaUser.addPassagem(memoria.getUsuarioOBJ(login.getNome(),login.getSenha()), //usuario
            				telaUser.getContainerPassagem(), 									  //JPainel
                			memoria.filtrarItinerario(telaUser.getDataInicial(), telaUser.getDataFinal(),
    						telaUser.getPontPartida(), telaUser.getPontChegada()).get(i).toString());
            		
            		}
            	telaUser.addPassagem(memoria.getUsuarioOBJ(login.getNome(),login.getSenha()), //usuario
            				telaUser.getContainerPassagem(), 								  //JPainel
                			memoria.getItinerario().toString());
            	System.out.println(memoria.getItinerario());
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
		memoria.addItinerario(LocalDate.of(2023, 12, 04), LocalDate.of(2023, 12, 05), 
						  	LocalTime.of(14, 0), LocalTime.of(18, 0),
						  	"Brasil", "Chile" );
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