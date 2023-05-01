package principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Main {
//METODO MAIN
	public static void main(String[] args) {
	//DEFININDO OBJETOS
		Memoria memoria = new Memoria();
		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	//ADICIONANDO PASSAGENS AVIAO
		memoria.addPassagemAviao(LocalDate.of(2023, 12, 04), LocalDate.of(2023, 12, 05), 
				  LocalTime.of(14, 0), LocalTime.of(18, 0),
				  "Brasil", "Chile" , new String[] {"SP-Brasil", "BA-Argentina"} , 
				  700.08, "Gol", 3 , 10, "Comercial", 1000);
		memoria.addPassagemAviao( LocalDate.of(2023, 12, 04), LocalDate.of(2023, 12, 05), 
				  LocalTime.of(14, 0), LocalTime.of(23, 30),
				  "Brasil", "Chile" , new String[] {"SP-Brasil", "BA-Argentina"} , 
				  700.08, "Gol", 1 , 30, "Comercial", 1000);
		memoria.addPassagemAviao(LocalDate.of(2023, 6, 12), LocalDate.of(2023, 6, 12), 
				  LocalTime.of(3, 0), LocalTime.of(10, 0),
				  "Chile", "Uruguai" , new String[] {} , 
				  640.42, "Latam", 3 , 10, "Militar", 2000);
		memoria.addPassagemAviao(LocalDate.of(2023, 11, 01), LocalDate.of(2023, 11, 02), 
				  LocalTime.of(23, 50), LocalTime.of(01, 10),
				  "SP-Brasil", "DF-Brasil" , new String[] {} , 
				  260.83, "Azul", 3 , 20, "Comercial", 1000);
		memoria.addPassagemAviao(LocalDate.of(2023, 7, 04), LocalDate.of(2023, 7, 04), 
				  LocalTime.of(10, 0), LocalTime.of(15, 0),
				  "PB-Brasil", "DF-Brasil" , new String[] {} , 
				  300.38, "Azul", 2 , 20, "Comercial", 900);
	//ADICIONANDO PASSAGENS ONIBUS	
		memoria.addPassagemOnibus(LocalDate.of(2023, 12, 04), LocalDate.of(2023, 12, 5), 
				  LocalTime.of(14, 0), LocalTime.of(1, 0),
				  "SP-Brasil", "DF-Brasil" , new String[] {"SP-Brasil", "GO-BRASIL", "BA-BRASIL"} , 
				  150.31, "Mercedes", true, new Integer [] {15}, true);
		memoria.addPassagemOnibus(LocalDate.of(2023, 12, 04), LocalDate.of(2023, 12, 6), 
				  LocalTime.of(10, 0), LocalTime.of(5, 0),
				  "SP-Brasil", "DF-Brasil" , new String[] {"SP-Brasil", "GO-BRASIL", "BA-BRASIL"} , 
				  150.31, "Mercedes", false, new Integer [] {1, 6}, false);
		memoria.addPassagemOnibus(LocalDate.of(2023, 9, 2), LocalDate.of(2023, 9, 3), 
				  LocalTime.of(1, 0), LocalTime.of(20, 0),
				  "PB-Brasil", "MG-Brasil" , new String[] {} , 
				  90.58, "Gol", true, new Integer [] {8, 13, 18}, true);
		memoria.addPassagemOnibus(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 10, 10), 
				  LocalTime.of(6, 0), LocalTime.of(18, 0),
				  "AM-Brasil", "BA-Brasil" , new String[] {} , 
				  150.18, "OptimusPrime", false, new Integer [] {14}, false);
		memoria.addPassagemOnibus(LocalDate.of(2023, 7, 26), LocalDate.of(2023, 7, 26), 
				  LocalTime.of(14, 0), LocalTime.of(18, 0),
				  "GO-Brasil", "DF-Brasil" , new String[] {} , 
				  100.08, "Buson", false, new Integer [] {}, false);
		
	//LOOP APLICACAO	
		while(true) {
			System.out.println("\nBem vindo, ao gerenciador e passagens PAPO, aqui está a lista de comandos:" 
							 + "\n  ○ PATotal - para pegar todas as passagens de aviao"
							 + "\n  ○ POTotal - para pegar todas as passagens de onibus"
							 + "\n  ○ PAFiltrada - para filtrar as passagens de aviao"
							 + "\n  ○ POFiltrada - para filtrar as passagens de onibus"
							 + "\n  ○ EditarPassagem - para editar uma passagem"
							 + "\n  ○ ExcluirPassagem - para Excluir passagem"
							 + "\n  ○ Sair - para sair"
							 + "\nDigite o que voce deseja");
			 String resposta = scanner.nextLine();
		//LISTA DAS PASSAGENS DE AVIAO
			 if(resposta.equalsIgnoreCase("PATotal")) {
				 System.out.println(memoria.getListaAviao() + "\n \nObrigado pela visita, tecle 'enter' para reiniciar");
				 String finalizar = scanner.nextLine();
		//LISTA DAS PASSAGENS DE ONIBUS
			 }else if(resposta.equalsIgnoreCase("POTotal")) {
				 System.out.println(memoria.getListaOnibus() + "\n \nObrigado pela visita, tecle 'enter' para reiniciar");
				 String finalizar = scanner.nextLine();
		//FILTRANDO PASSAGEM 
			 }else if(resposta.equalsIgnoreCase("PAFiltrada") || resposta.equalsIgnoreCase("POFiltrada")) {
				 System.out.println("Digite a data inicial (11/11/2020) ou tecle 'enter' para pular");
				 String dataInicial = scanner.nextLine();
				 System.out.println("Digite a data Final (11/11/2020) ou tecle 'enter' para pular");
				 String dataFinal = scanner.nextLine();
				 System.out.println("Digite o local de partida ou tecle 'enter' para pular");
				 String localPartida = scanner.nextLine();
				 System.out.println("Digite o local de Chegada ou tecle 'enter' para pular");
				 String localChegada = scanner.nextLine();
				 LocalDate a;
				 LocalDate b;
				 //DATA INICIAL
				 if(dataInicial.isEmpty()) {a = null;}
					else {a = LocalDate.parse(dataInicial, formatador);}
				 //DATA FINAL
				 if(dataFinal.isEmpty()) {b = null;}
				 	else {b = LocalDate.parse(dataFinal, formatador);}
				 //LOCAL DE PARTIDA
				 if(localPartida.isEmpty()) {localPartida = null;}
				 //LOCAL DE CHEGADA
				 if(localChegada.isEmpty()) {localChegada = null;}
			//FILTRANDO AVIAO
				 System.out.println("\nAqui estão as passagens filtradas:\n");
				 if(resposta.equalsIgnoreCase("PAFiltrada")) {
					 System.out.println(memoria.filtrarPassagemAviao(a, b, localPartida, localChegada));
			//FILTRANDO ONIBUS
				 }else if(resposta.equalsIgnoreCase("POFiltrada")) {
					 System.out.println(memoria.filtrarPassagemOnibus(a, b, localPartida, localChegada));
				 }
				 System.out.println("\nObrigado pela visita, tecle 'enter' para reiniciar");
				 String finalizar = scanner.nextLine();
		//EDITAR PASSAGEM
			 }else if(resposta.equalsIgnoreCase("EditarPassagem")) {
				 System.out.println("Digite Aviao para deletar uma passagem de Aviao e Onibus para passagem de Onibus");
				 String tipo = scanner.nextLine();
				 System.out.println("Digite o id da passagem");
				 String id = scanner.nextLine();
				 if(tipo.equalsIgnoreCase("Aviao")) {
					 memoria.editPassagemAviao(id, null, null, null, null, null, null, null,
							 					null, null, 1, 99, "TESTE", 999);
					 System.out.println("Passagem editada com sucesso");
				 }else if( tipo.equalsIgnoreCase("Onibus")){
					 memoria.editPassagemOnibus(id, LocalDate.of(2025, 5, 05), LocalDate.of(2025, 05, 05), 
							 					LocalTime.of(11,11), LocalTime.of(22, 22),
							 					"TESTE1", "TESTE2" , new String[] {"TESTE3", "TESTE4"} , 
							 					999.99, "TESTE5", true, new Integer [] {14, 18}, true);
					 System.out.println("Passagem editada com sucesso");
				 }else {
					 System.out.println("Opcao invalida :(");
				 }
		//EXCLUIR PASSAGEM		 
			 }else if(resposta.equalsIgnoreCase("ExcluirPassagem")){
				 System.out.println("Digite Aviao para deletar uma passagem de Aviao e Onibus para passagem de Onibus");
				 String tipo = scanner.nextLine();
				 System.out.println("Digite o id da passagem");
				 String id = scanner.nextLine();
				 if(tipo.equalsIgnoreCase("Aviao")) {
					 memoria.deletePassagem(true, id);
					 System.out.println("Passagem excluida com sucesso");
				 }else if( tipo.equalsIgnoreCase("Onibus")){
					 memoria.deletePassagem(false, id);
					 System.out.println("Passagem excluida com sucesso");
				 }else {
					 System.out.println("Opcao invalida :(");
				 }
		//SAIR		 
			 }else if(resposta.equalsIgnoreCase("sair")){
				 System.out.println("Obrigado pela preferencia :)");
				 break;
		//ERRO		 
			 }else {
				 System.out.println("Opcao invalida :(");
			 } 
		}
	}
}