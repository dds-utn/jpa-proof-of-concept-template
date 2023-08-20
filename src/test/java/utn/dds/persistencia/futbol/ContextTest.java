package utn.dds.persistencia.futbol;


import io.github.flbulgarelli.jpa.extras.test.SimplePersistenceTest;
import org.junit.jupiter.api.Test;
import utn.dds.persistencia.futbol.persistence.Jugador;

import static org.junit.jupiter.api.Assertions.*;

public class ContextTest implements SimplePersistenceTest {

  // ===========================================
  // Ojo, ¡esto no es un test propiamente dicho!
  // ===========================================


  @Test
  public void test() {
    Jugador dani = new Jugador();
    dani.setNombre("Dani");
    dani.setPosicion("11");

    System.out.println("Haciendo persistible");
    entityManager().persist(dani);
    assertEquals((Long) 1L, dani.getId());
    dani.setPosicion("9");

    System.out.println("Buscando");
    Jugador dani2 = entityManager().find(Jugador.class, 1L);

    assertNotNull(dani2);
    assertEquals(dani.getId(), dani2.getId());
    assertEquals("9", dani2.getPosicion());
    assertSame(dani, dani2);

    System.out.println("Sincronizando");
    entityManager().flush();  // No debería estar en su código, sino en un lugar muy especial
    entityManager().clear();  // idem

    System.out.println("Buscando nuevamente");
    Jugador dani3 = entityManager().find(Jugador.class, 1L);

    assertNotNull(dani3);
    assertEquals(dani.getId(), dani3.getId());
    assertEquals("9", dani3.getPosicion());
    assertNotSame(dani, dani3);
  }
}
