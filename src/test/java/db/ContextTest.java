package db;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import model.Consultora;
import model.Proyecto;

import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

public class ContextTest extends AbstractPersistenceTest implements
    WithGlobalEntityManager {

  @Test
  public void contextUp() {
    Consultora mstislav = new Consultora("Mstislav", 20);
    mstislav.asignar(new Proyecto("PGM", BigDecimal.valueOf(30_0000)));
 
    persist(mstislav);
  }

}
