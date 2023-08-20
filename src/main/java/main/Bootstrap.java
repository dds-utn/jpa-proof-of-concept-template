package main;

import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import model.Consultora;

import model.Usuario;

/**
 * Ejecutar antes de levantar el servidor por primera vez
 * 
 * @author flbulgarelli
 */
public class Bootstrap implements WithSimplePersistenceUnit {

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
