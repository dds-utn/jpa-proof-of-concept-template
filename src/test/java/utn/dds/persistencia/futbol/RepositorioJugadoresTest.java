package utn.dds.persistencia.futbol;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;
import utn.dds.persistencia.futbol.persistence.Jugador;
import utn.dds.persistencia.futbol.persistence.RepositorioJugadores;

import java.util.List;

public class RepositorioJugadoresTest extends AbstractPersistenceTest implements WithGlobalEntityManager {

    private RepositorioJugadores repositorioJugadores;

    @Before
    public void init(){
        repositorioJugadores = new RepositorioJugadores();
        entityManager().persist(new Jugador("dani"));
        entityManager().persist(new Jugador("juli"));
        entityManager().persist(new Jugador("marcos"));
    }

    @Test
    public void deberiaEncontrarAlJugadorPorNombre() {
        List<Jugador> jugadores = repositorioJugadores.filtrarPorNombre("dani");
        Assert.assertEquals(1, jugadores.size());
        Jugador dani = jugadores.get(0);
        Assert.assertEquals("dani", dani.getNombre());

    }

    @Test
    public void noDeberiaEncontrarUnJugadorSiNoExiste() {
        Assert.assertEquals(0, repositorioJugadores.filtrarPorNombre("cintia").size());
    }

}
