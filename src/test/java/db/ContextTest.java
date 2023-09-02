package db;

import io.github.flbulgarelli.jpa.extras.test.SimplePersistenceTest;
import model.Posicion;
import model.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ContextTest implements SimplePersistenceTest {

  @Test
  void contextUp() {
    assertNotNull(entityManager());
  }

  @Test
  void contextUpWithTransaction() throws Exception {
    withTransaction(() -> {});
  }

  void testEmbeddable() {
    var vehiculo = new Vehiculo();

    var posicion = new Posicion();
    posicion.setLatitud(10);
    posicion.setLongitud(15);

    vehiculo.setPosicion(posicion);

    var posicion2 = new Posicion();
    posicion2.setLatitud(11);
    posicion2.setLongitud(15);

    vehiculo.setPosicion(posicion2);

    vehiculo.getPosicion().setLongitud(12);

    persist(vehiculo);


  }
}
