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
  
  }
}
