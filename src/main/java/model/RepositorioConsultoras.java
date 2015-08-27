package model;

import java.util.List;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

public class RepositorioConsultoras implements WithGlobalEntityManager {

  public static RepositorioConsultoras instancia = new RepositorioConsultoras();

  public List<Consultora> listar() {
    return entityManager(). //
        createQuery("from Consultora", Consultora.class). //
        getResultList();
  }

  public Consultora buscar(long id) {
    return entityManager().find(Consultora.class, id);
  }

}
