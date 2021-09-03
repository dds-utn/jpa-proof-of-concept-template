package utn.dds.persistencia.futbol;

import org.junit.Assert;
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
    // para persistir necesitamos: anotar, poner un id y listarlo en el persistence.xml
    Jugador dani = new Jugador();
    dani.setNombre("Dani");
    dani.setPosicion("11");

    Assert.assertEquals("Dani", dani.getNombre());
    Assert.assertNull(dani.getId());

    System.out.println("Estamos por persisir");
    // para hacer persistible, tenemos al mensaje persist,
    // que pone al objeto en el contexto de persistencia
    // y permite que JPA lo mande a la base de datos mediante un insert
    // cuando lo juzgue adecuado
    entityManager().persist(dani);

    // fuerza el procesamiento de las operaciones que aun no han impactado
    // en la base de datos
    // entityManager().flush();

    // el mensaje clear borra el contexto de persistencia, invalidado caches
    // entityManager().clear();

    System.out.println("Acabamos de volver de persistir");



    Assert.assertNotNull(dani.getId());




    System.out.println("Estamos por buscar en el entity manager");
    // busca en el contexto de persistencia: si está cache, lo saca de ahí
    // si no, lo saca de la base de datos
    // la identidad de los objetos se preserva siempre que el mismo
    // salga de caché
    Jugador dani2 = entityManager().find(Jugador.class, dani.getId());
    System.out.println("Acabamos de volver del EM");

    Assert.assertNotNull(dani2);
    Assert.assertEquals(dani.getId(), dani2.getId());
    Assert.assertEquals(dani.getNombre(), dani2.getNombre());
    Assert.assertSame(dani, dani2);
    Assert.assertTrue(dani == dani2);


    // Sin embargo, los mensajes flush
    // y clear los tomaremos como de bajo nivel:
    // salvo situaciones excepcionalisimas, no los usaremos
    // y confiaremos en las capas de abstracción que utilizaremos más arriba:
    // o bien el test de persistencia, o bien el manejo de transacciones
    // a nivel aplicacion web
  }
}
