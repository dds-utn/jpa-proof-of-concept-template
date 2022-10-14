package main;

import model.Consultora;

import model.Usuario;
import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

/**
 * Ejecutar antes de levantar el servidor por primera vez
 * 
 * @author flbulgarelli
 */

//Bootstrap // Seed // Migration // Fixture
public class Bootstrap implements WithGlobalEntityManager, EntityManagerOps, TransactionalOps {

  public static void main(String[] args) {
    new Bootstrap().run();
  }

  public void run() {
    withTransaction(() -> {
      persist(new Consultora("dblandit", 10));
      persist(new Consultora("2diseños", 15));
      persist(new Consultora("chakanalabs", 2));
      persist(new Consultora("consultoraLoca", 10));
      persist(new Consultora("rolicusulting", 20));
      persist(new Consultora("francoconsulting", 2));
      persist(new Consultora("otraConsultora", 10));
      persist(new Consultora("pirulo.com", 15));
      persist(new Consultora("blah", 2));
    });
  }

}
