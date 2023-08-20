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

    assertNull(dani.getId());

    entityManager().persist(dani); // hago persistible a dani

    assertNotNull(dani.getId());
    
    // agregamos una nueva instancia:
    Jugador caro = new Jugador();
    caro.setNombre("Dani");
    caro.setPosicion("11");

    entityManager().persist(caro);

    assertNotNull(dani.getId()); 
    assertNotEquals(dani.getId(), caro.getId());
    
    Jugador dani2 = entityManager().find(Jugador.class, dani.getId());

    assertEquals(dani2.getId(), dani.getId()); // esto no debería resultar extraño
    assertSame(dani2, dani); // y esto tampoco, al fin y al cabo estamos recuperando un objeto que ya tenemos, ¿no?
  }
}
