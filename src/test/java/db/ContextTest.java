package db;

import io.github.flbulgarelli.jpa.extras.test.SimplePersistenceTest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ContextTest implements SimplePersistenceTest {

  @Test
  void contextUp() {

    Consultora mstislav = new Consultora("Mstislav", 20);
    mstislav.asignar(new Proyecto("PGM", BigDecimal.valueOf(30_0000)));

    persist(mstislav);

  }


}
