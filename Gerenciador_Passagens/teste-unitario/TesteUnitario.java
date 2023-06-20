import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test ;

import Modelo.*;
import View.*;
import Controle.*;

public class TesteUnitario{
	Memoria memoria = new Memoria();
	TelaLogin telaLogin = new TelaLogin();
	TelaLoginControle tlc = new TelaLoginControle(memoria, telaLogin);
	Admin adm = new Admin(true, "teste","teste");
	
	@Test
	void testNomeAdmin() {
		Assertions.assertEquals(adm.getNome(), "teste");
	}
	@Test
	void testTipoAdmin() {
		Assertions.assertEquals(adm.getTipo(), true);
	}
	@Test 
	void testAddAdmin(){
		Assertions.assertEquals(tlc.verificacaoLogin("teste","teste", true), "erro");
	}
}