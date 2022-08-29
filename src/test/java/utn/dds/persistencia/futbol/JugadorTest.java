package utn.dds.persistencia.futbol;
import static org.junit.Assert.*;

import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import utn.dds.persistencia.futbol.persistence.Jugador;

public class JugadorTest extends AbstractPersistenceTest implements WithGlobalEntityManager {

  // ===========================================
  // Ojo, ¡esto no es un test propiamente dicho!
  // ===========================================

  @Test
  public void test() {
    Jugador dani = new Jugador();
    dani.setNombre("Dani");
    dani.setPosicion("11");

    entityManager().persist(dani);
    assertEquals(dani.getId(), (Long) 1L);

    // esto es a fines demostrativos
    // no haríamos un clear normalmente justo después de un persist
    entityManager().clear();

    Jugador dani2 = entityManager().find(Jugador.class, 1L);
    dani.getNombre();
    assertNotNull(dani2);
    assertSame(dani2, dani);

    assertNull(entityManager().find(Jugador.class, 2L));

  }
}
