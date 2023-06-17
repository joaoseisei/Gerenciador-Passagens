import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test ;

import Modelo.Admin;

public class TesteUnitario{
	@Test
	void testNomeAdmin() {
		Admin adm = new Admin(true, "teste","teste");
		Assertions.assertEquals(adm.getNome(), "teste");
	}
	@Test
	void testTipoAdmin() {
		Admin adm = new Admin(true, "teste","teste");
		Assertions.assertEquals(adm.getTipo(), true);
	}

}