package main;

import model.Consultora;

import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

public class Bootstrap implements
  WithGlobalEntityManager, 
  EntityManagerOps, 
  TransactionalOps {

  public static void main(String[] args) {
    new Bootstrap().run();
  }

  public void run() {
    withTransaction(() -> {
      persist(new Consultora("dblandit", 10));
      persist(new Consultora("2diseños", 15));
      persist(new Consultora("chakanalabs", 2));
    });
  }

}
