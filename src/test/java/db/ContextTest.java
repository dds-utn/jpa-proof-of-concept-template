package db;


import io.github.flbulgarelli.jpa.extras.test.SimplePersistenceTest;
import org.junit.jupiter.api.Test;
import utn.dds.persistencia.biblioteca.*;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ContextTest implements SimplePersistenceTest {

  @Test
  void contextUp() {
    assertNotNull(entityManager());
  }

  @Test
  void contextUpWithTransaction() throws Exception {
    withTransaction(() -> {
    });
  }

  @Test
  void smokeTest() throws Exception {
    var autor = new Autor();
    autor.setNombre("Jorge Luis");
    autor.setApellido("Borges");

    var libro = new Libro();
    libro.setTitulo("Ficciones");
    libro.setFechaPublicacion(LocalDate.of(1944, 1, 1));
    libro.setAutor(autor);
    libro.setIsbn("978-0802130204");
    libro.setCantidadPaginas(224);

    var revista = new Revista();
    revista.setTitulo("National Geographic");
    revista.setFechaPublicacion(LocalDate.of(2023, 6, 1));
    revista.setAutor(autor);
    revista.setNumero(42);
    revista.setPeriodicidad(Periodicidad.MENSUAL);

    var biblioteca = new Biblioteca();
    biblioteca.setNombre("La biblioteca de Babel");

    withTransaction(() -> {
      entityManager().persist(autor);
      entityManager().persist(libro);
      entityManager().persist(revista);
      entityManager().persist(biblioteca);
    });

    assertNotNull(biblioteca.getId());
  }

}
