package utn.dds.persistencia.futbol;

import static org.junit.Assert.*;

import org.junit.Test;

import utn.dds.persistencia.futbol.db.EntityManagerHelper;

public class ContextTest {

	@Test
	public void contextUp() {
		EntityManagerHelper.getEntityManager();
	}

	@Test
	public void testName() throws Exception {
		EntityManagerHelper.withTransaction(() -> System.out.println(""));
	}
}
