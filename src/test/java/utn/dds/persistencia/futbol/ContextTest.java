package utn.dds.persistencia.futbol;

import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import utn.dds.persistencia.futbol.persistence.Jugador;

public class ContextTest extends AbstractPersistenceTest implements WithGlobalEntityManager {

  // ===========================================
  // Ojo, ¡esto no es un test propiamente dicho!
  // ===========================================
  
  
  @Test
  public void test() {
    Jugador dani = new Jugador();
    dani.setNombre("Dani");
    dani.setPosicion("11");
  
  }
}
