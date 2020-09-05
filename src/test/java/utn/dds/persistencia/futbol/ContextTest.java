package utn.dds.persistencia.futbol;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Assert;
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
    
    // esto lo hace persistIBLE
    entityManager().persist(dani);
    
    dani.setPosicion("12");
    
    assertNotNull(dani.getId());
   
    Jugador jugaderMisteriose =  entityManager().find(Jugador.class, dani.getId());
    
    assertNotNull(jugaderMisteriose);
    
    entityManager().clear(); // esto no lo hagan en casa
    Jugador jugaderMisteriose2 = entityManager().find(Jugador.class, dani.getId());
    
    assertNotNull(jugaderMisteriose2); 
  }
}
