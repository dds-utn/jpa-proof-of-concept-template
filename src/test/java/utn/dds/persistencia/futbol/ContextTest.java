package utn.dds.persistencia.futbol;

import org.junit.Test;

import utn.dds.persistencia.futbol.db.EntityManagerHelper;

public class ContextTest {

	@Test
	public void contextUp() {
		EntityManagerHelper
			.getEntityManager();
	}
}
