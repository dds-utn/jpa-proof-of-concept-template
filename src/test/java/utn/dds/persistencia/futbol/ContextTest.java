package utn.dds.persistencia.futbol;

import java.util.List;

import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import utn.dds.persistencia.futbol.persistence.Formacion;
import utn.dds.persistencia.futbol.persistence.Jugador;

public class ContextTest extends AbstractPersistenceTest implements WithGlobalEntityManager {
  
  @Test
  public void test() {
    List<Formacion> formaciones = 
        entityManager().createQuery("from Formacion", Formacion.class).getResultList();
    
    for (Formacion formacion : formaciones) {
      System.out.println("Formacion: " + formacion + " goles: " + formacion.getGoles());
      
      for (Jugador jugador : formacion.getJugadores()) {
        System.out.println("Jugador: " + jugador.getNombre());
      }
    }
    
  }
}
