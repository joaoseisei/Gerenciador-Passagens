package View;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import Modelo.Admin;

public class TelaAdmin {
//ATRIBUTOS
	private JFrame tela;
	private JPanel painel, configuracao, conteudo;
	private JLabel userLB, dataInicialLB, horaInicialLB, pontPartidaLB, dataFinalLB, horaFinalLB, pontChegadaLB, idLB, 
	idItinerarioLB, precoLB, marcaLB, classeLB, tipoVooLB, pesoBagagemLB, alturaVooLB, escalasLB, horarioParadasLB, dadosAdm;
	private JTextField dataInicial, horaInicial, pontPartida, dataFinal, horaFinal, pontChegada, idPassagem, idItinerario,
	preco, marca, classe, tipoVoo, pesoBagagem, alturaVoo, escalas, horarioParadas;
	private Font titulo, inputsFont;
	private JCheckBox leito, refeicaoInclusa;	
	private JButton criarIt, criarPA, criarPO, editarIt, editarPA, editarPO, excluirIt, excluirPA, excluirPO, atualizar;
	private JScrollPane container;
	DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("HH:mm");
	//-------------ADMIN------------
	private Admin admin;
//CONSTRUTOR
	public TelaAdmin(Admin admin) {
	//PUXANDO O ADMIN
		this.admin = admin;
	//-------------FONTES-----------------------------
		titulo = new Font("Verdana", Font.BOLD, 20);
		inputsFont = new Font("Verdana", Font.BOLD, 16);
	//--------------TELA------------------------------	
		tela = new JFrame("PAPO-ADMIN" +" | "+ admin.getIDU());
		tela.setSize(1200, 700);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//-------------PAINEL-----------------------------	
		painel = new JPanel();
		painel.setBackground(Color.LIGHT_GRAY);
		tela.add(painel);
	//----------PAINEL DE CONTROLE--------------------
		painel.setLayout(null);
		//CONTAINER DE CONFIGURACOES
		configuracao = new JPanel();
		configuracao.setBounds(0, 0, 550, 700);
		configuracao.setBackground(Color.DARK_GRAY);
		userLB = new JLabel("PAINEL DE CONTROLE - " + admin.getNome());
		userLB.setFont(titulo);
		userLB.setForeground(Color.WHITE);
		userLB.setBounds(10, 5, 500, 35);

	//---------------INPUTS---------------------------
		dataInicialLB = new JLabel("Data inicial:");
		formatacao(dataInicialLB, 10, 65, 100, 20);
		dataFinalLB = new JLabel("Data Final:");
		formatacao(dataFinalLB, 280, 65, 100, 20);
		pontPartidaLB = new JLabel("Entrada:");
		formatacao(pontPartidaLB, 10, 105, 150, 20);
		pontChegadaLB = new JLabel("Chegada:");
		formatacao(pontChegadaLB, 280, 105, 150, 20);
		horaInicialLB = new JLabel("Hora Ini.:");
		formatacao(horaInicialLB, 10, 145, 150, 20);
		horaFinalLB = new JLabel("Hora Fin.:");
		formatacao(horaFinalLB, 280, 145, 150, 20);
		idLB = new JLabel("ID Passagem:");
		formatacao(idLB, 10, 185, 150, 20);
		idItinerarioLB = new JLabel("ID Itinerario:");
		formatacao(idItinerarioLB, 10, 225, 150, 20);
		precoLB = new JLabel("Preco:");
		formatacao(precoLB, 10, 265, 150, 20);
		marcaLB = new JLabel("Marca:");
		formatacao(marcaLB, 280, 265, 150, 20);
		classeLB = new JLabel("Classe:");
		formatacao(classeLB, 10, 305, 150, 20);
		tipoVooLB = new JLabel("Tipo Voo:");
		formatacao(tipoVooLB, 280, 305, 150, 20);
		pesoBagagemLB = new JLabel("Pesso BG:");
		formatacao(pesoBagagemLB, 10, 345, 150, 20);
		alturaVooLB = new JLabel("Alt Voo:");
		formatacao(alturaVooLB, 280, 345, 150, 20);
		escalasLB = new JLabel("Escalas:");
		formatacao(escalasLB, 10, 385, 150, 20);
		horarioParadasLB = new JLabel("Horario Paradas:");
		formatacao(horarioParadasLB, 10, 425, 150, 20);
		
		painel.add(dataInicialLB);
		painel.add(dataFinalLB);
		painel.add(pontPartidaLB);
		painel.add(pontChegadaLB);
		painel.add(horaInicialLB);
		painel.add(horaFinalLB);
		painel.add(idLB);
		painel.add(idItinerarioLB);
		painel.add(precoLB);
		painel.add(marcaLB);
		painel.add(classeLB);
		painel.add(tipoVooLB);
		painel.add(pesoBagagemLB);
		painel.add(alturaVooLB);
		painel.add(escalasLB);
		painel.add(horarioParadasLB);
		
		dataInicial = new JTextField(20);
		dataInicial.setBounds(120, 60, 150, 30);
		
		dataFinal = new JTextField(20);
		dataFinal.setBounds(380, 60, 150, 30);
		
		pontPartida = new JTextField(20);
		pontPartida.setBounds(120, 100, 150, 30);
		
		pontChegada = new JTextField(20);
		pontChegada.setBounds(380, 100, 150, 30);
		
		horaInicial = new JTextField(20);
		horaInicial.setBounds(120, 140, 150, 30);
		
		horaFinal = new JTextField(20);
		horaFinal.setBounds(380, 140, 150, 30);
		
		idPassagem = new JTextField(20);
		idPassagem.setBounds(160, 180, 350, 30);
		
		idItinerario = new JTextField(20);
		idItinerario.setBounds(160, 220, 350, 30);
		
		preco = new JTextField(20);
		preco.setBounds(120, 260, 150, 30);
		
		marca = new JTextField(20);
		marca.setBounds(380, 260, 150, 30);
		
		classe = new JTextField(20);
		classe.setBounds(120, 300, 150, 30);
		
		tipoVoo = new JTextField(20);
		tipoVoo.setBounds(380, 300, 150, 30);
		
		pesoBagagem = new JTextField(20);
		pesoBagagem.setBounds(120, 340, 150, 30);
		
		alturaVoo = new JTextField(20);
		alturaVoo.setBounds(380, 340, 150, 30);
		
		escalas = new JTextField(20);
		escalas.setBounds(160, 380, 350, 30);
		
		horarioParadas = new JTextField(20);
		horarioParadas.setBounds(160, 420, 350, 30);
		
		painel.add(dataInicial);
		painel.add(dataFinal);
		painel.add(pontPartida);
		painel.add(pontChegada);
		painel.add(horaInicial);
		painel.add(horaFinal);
		painel.add(idPassagem);
		painel.add(idItinerario);
		painel.add(preco);
		painel.add(marca);
		painel.add(classe);
		painel.add(tipoVoo);
		painel.add(pesoBagagem);
		painel.add(alturaVoo);
		painel.add(escalas);
		painel.add(horarioParadas);
		
		leito = new JCheckBox("Leito");
		leito.setBackground(Color.gray);
		leito.setBounds(50, 460, 150, 30);
		
		refeicaoInclusa = new JCheckBox("Refeicao inclusa");
		refeicaoInclusa.setBackground(Color.gray);
		refeicaoInclusa.setBounds(300, 460, 150, 30);
		
		painel.add(leito);
		painel.add(refeicaoInclusa);
		
		criarIt = new JButton("Criar Itinerario");
		criarIt.setBackground(Color.lightGray);
		criarIt.setBounds(10, 510, 130, 30);
		
		criarPA = new JButton("Criar passagem aviao");
		criarPA.setBackground(Color.lightGray);
		criarPA.setBounds(170, 510, 170, 30);
		
		criarPO = new JButton("Criar passagem onibus");
		criarPO.setBackground(Color.lightGray);
		criarPO.setBounds(360, 510, 170, 30);
		
		editarIt = new JButton("Editar Itinerario");
		editarIt.setBackground(Color.lightGray);
		editarIt.setBounds(10, 550, 130, 30);
		
		editarPA = new JButton("Editar passagem aviao");
		editarPA.setBackground(Color.lightGray);
		editarPA.setBounds(170, 550, 170, 30);
		
		editarPO = new JButton("Editar passagem onibus");
		editarPO.setBackground(Color.lightGray);
		editarPO.setBounds(360, 550, 170, 30);
		
		excluirIt = new JButton("Excluir Itinerario");
		excluirIt.setBackground(Color.lightGray);
		excluirIt.setBounds(10, 590, 130, 30);
		
		excluirPA = new JButton("Excluir passagem aviao");
		excluirPA.setBackground(Color.lightGray);
		excluirPA.setBounds(170, 590, 170, 30);
		
		excluirPO = new JButton("Excluir passagem onibus");
		excluirPO.setBackground(Color.lightGray);
		excluirPO.setBounds(360, 590, 170, 30);
		
		painel.add(criarIt);
		painel.add(criarPA);
		painel.add(criarPO);
		painel.add(editarIt);
		painel.add(editarPA);
		painel.add(editarPO);
		painel.add(excluirIt);
		painel.add(excluirPA);
		painel.add(excluirPO);
		
		painel.add(userLB);
		painel.add(configuracao);
	//---------------CONTAINER---------------------------
		//Botao atualizar
		atualizar = new JButton("ATUALIZAR");
		atualizar.setBackground(Color.gray);
		atualizar.setBounds(730, 30, 170, 30);
		painel.add(atualizar);
		//Container com as passagens
		container = new JScrollPane();
		container.setBounds(570, 70, 595, 580);
		container.setBackground(Color.GRAY);
		//Painel de conteudos
		conteudo = new JPanel();
		conteudo.setLayout(new BoxLayout(conteudo, BoxLayout.Y_AXIS));
        //TITULO
        dadosAdm = new JLabel("Mudanças feitas:     " + admin.getMudancaFeita());
        dadosAdm.setAlignmentX(Component.LEFT_ALIGNMENT); 
        conteudo.add(dadosAdm);
        
        //ADICIONANDO NO CONTAINER
        container.setViewportView(conteudo);
        
        painel.add(container);
	}
//GETTERS
	public Admin getAdmin() {
		return admin;
	}
//--------------------JAVAX-------------------------------------
	public JScrollPane getContainer() {
		return container;
	}
	public JPanel getConteudo() {
		return conteudo;
	}
//------------------ITINERARIO----------------------------------
	public LocalDate getDataInicial(){
		if(dataInicial == null ||dataInicial.getText().isEmpty()) {
			return null;
		}else {
			return LocalDate.parse(dataInicial.getText(), formatador);
		}
	}
	public LocalDate getDataFinal(){
		if(dataFinal == null || dataFinal.getText().isEmpty()) {
			return null;
		}else {
			return LocalDate.parse(dataFinal.getText(), formatador);
		}
	}
	public LocalTime getHoraInicial() {
		if(horaInicial == null || horaInicial.getText().isEmpty()) {
			return null;
		}else {
			return LocalTime.parse(horaInicial.getText(), formatadorHora);
		}
	}
	public LocalTime getHoraFinal() {
		if(horaFinal == null || horaFinal.getText().isEmpty()) {
			return null;
		}else {
			return LocalTime.parse(horaFinal.getText(), formatadorHora);
		}
	}
	public String getPontPartida(){
		if(pontPartida == null || pontPartida.getText().isEmpty()) {
			return null;
		}else {
			return pontPartida.getText();
		}
	}
	public String getPontChegada(){
		if(pontChegada == null || pontChegada.getText().isEmpty()) {
			return null;
		}else {
			return pontChegada.getText();
		}
	}
//-------------------ARRAYS-------------------------------------
	public String[] getEscalas() {
		if(escalas == null || escalas.getText().isEmpty()) {
			return null;
		}else {
			return escalas.getText().split(",");
		}
	}
	public String[] getHorarioParadas() {
		if(horarioParadas == null || horarioParadas.getText().isEmpty()) {
			return new String[0];
		}else {
			return horarioParadas.getText().split(",");
		}
	}
//------------------NUMEROS-------------------------------------
	public Integer getClasse() {
		if(classe == null || classe.getText().isEmpty()) {
			return null;
		}else{
			return Integer.parseInt(classe.getText());
		}
	}
	public Integer getPesoBagagem() {
		if(pesoBagagem == null || pesoBagagem.getText().isEmpty()) {
			return null;
		}else {
			return Integer.parseInt(pesoBagagem.getText());
		}
	}
	public Integer getAlturaVoo() {
		if(alturaVoo == null || alturaVoo.getText().isEmpty()) {
			return null;
		}else {
			return Integer.parseInt(alturaVoo.getText());
		}
	}
	public Double getPreco() {
		if(preco == null || preco.getText().isEmpty()) {
			return null;
		}else {
			return Double.parseDouble(preco.getText());
		}
	}
//-----------------STRINGS--------------------------------------
	public String getMarca() {
		if(marca == null || marca.getText().isEmpty()) {
			return null;
		}else {
			return marca.getText();
		}
	}
	public String getTipoVoo() {
		if(tipoVoo == null || tipoVoo.getText().isEmpty()) {
			return null;
		}else {
			return tipoVoo.getText();
		}
	}
	public String getIdItinerairo() {
		if(idItinerario == null || idItinerario.getText().isEmpty()) {
			return null;
		}else {
			return idItinerario.getText();
		}
	}
	public String getIdPassagem() {
		if(idPassagem == null || idPassagem.getText().isEmpty()) {
			return null;
		}else {
			return idPassagem.getText();
		}
	}
//-----------------BOOLEAN--------------------------------------
	public Boolean getLeito() {
		return leito.isSelected();
	}
	public Boolean getRefeicaoInclusa() {
		return refeicaoInclusa.isSelected();
	}
//------------------BOTOES--------------------------------------
	public JButton getAtualizar() {
		return atualizar;
	}
	public JButton getCriarIt() {
		return criarIt;
	}
	public JButton getCriarPA() {
		return criarPA;
	}
	public JButton getCriarPO() {
		return criarPO;
	}
	public JButton getEditarIt() {
		return editarIt;
	}
	public JButton getEditarPA() {
		return editarPA;
	}
	public JButton getEditarPO() {
		return editarPO;
	}
	public JButton getExcluirIt() {
		return excluirIt;
	}
	public JButton getExcluirPA() {
		return excluirPA;
	}
	public JButton getExcluirPO() {
		return excluirPO;
	}
//AUTOMATIZAR FORMATAÇAO
	public void formatacao(JLabel linha,int x,int y,int xw,int yh) {
		linha.setFont(inputsFont);
		linha.setForeground(Color.WHITE);
		linha.setBounds(x, y, xw, yh);
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