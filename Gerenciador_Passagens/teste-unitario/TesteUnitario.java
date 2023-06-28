import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import Controle.AdminControle;
import Controle.TelaAdminControle;
import Controle.TelaLoginControle;
import Modelo.Admin;
import Modelo.Itinerario;
import Modelo.Memoria;
import View.TelaAdmin;
import View.TelaLogin;

public class TesteUnitario{
	Memoria memoria = new Memoria();
	TelaLogin telaLogin = new TelaLogin();
	TelaLoginControle tlc = new TelaLoginControle(memoria, telaLogin);
	
	//CRIAÇÃO DE ADMINISTRADOR
	Admin adm = new Admin(true, "teste","teste");
	AdminControle adminControle = new AdminControle(adm);
	TelaAdmin ta = new TelaAdmin(adminControle);
	TelaAdminControle tla = new TelaAdminControle(memoria, ta);
	
	@Test
	void testAddItinerario() {
		tla.addItinerario(LocalDate.of(2023, 12, 04), LocalDate.of(2023, 12, 05), 
			  								   LocalTime.of(14, 0), LocalTime.of(18, 0),
			  								   "Brasil", "Chile" );
		Assertions.assertEquals(memoria.getListaItinerario().size(), 1);
	}
	@Test
	void testEditarItinerario() {
		tla.addItinerario(LocalDate.of(2023, 12, 04), LocalDate.of(2023, 12, 05), 
				   LocalTime.of(14, 0), LocalTime.of(18, 0),
				   "Brasil", "Chile" );
		
		Itinerario it = memoria.getListaItinerario().get(0);
		
		tla.editItinerario(it.getIdItinerario(), 
							LocalDate.of(2024, 12, 12), LocalDate.of(2024, 12, 13), 
							LocalTime.of(11, 11), LocalTime.of(22, 22),
							"TESTE", "TESTE2");
		
		Assertions.assertEquals(it.getDataInicial(),LocalDate.of(2024, 12, 12));
		Assertions.assertEquals(it.getDataFinal(), LocalDate.of(2024, 12, 13));
		Assertions.assertEquals(it.getHoraInicial(), LocalTime.of(11, 11));
		Assertions.assertEquals(it.getHoraFinal(), LocalTime.of(22, 22));
		Assertions.assertEquals(it.getPontPartida(),"TESTE");
		Assertions.assertEquals(it.getPontChegada(), "TESTE2");
	}
	@Test
	void testDeleteItinerario() {
		tla.addItinerario(LocalDate.of(2023, 12, 04), LocalDate.of(2023, 12, 05), 
				   LocalTime.of(14, 0), LocalTime.of(18, 0),
				   "Brasil", "Chile" );
		tla.deleteItinerario(memoria.getListaItinerario().get(0).getIdItinerario());
		
		Assertions.assertEquals(memoria.getListaItinerario().size(), 0);
	}

}