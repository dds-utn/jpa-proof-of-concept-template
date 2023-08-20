package model;

import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.util.List;

public class RepositorioConsultoras implements WithSimplePersistenceUnit {

  public static RepositorioConsultoras instancia = new RepositorioConsultoras();

  public List<Consultora> listar() {
    return entityManager()//
        .createQuery("from Consultora", Consultora.class) //
        .getResultList();
  }

  public Consultora buscar(long id) {
    return entityManager().find(Consultora.class, id);
  }

  public void agregar(Consultora consultora) {
    entityManager().persist(consultora);
  }

  public List<Consultora> buscarPorNombre(String nombre) {
    return entityManager() //
        .createQuery("from Consultora c where c.nombre like :nombre", Consultora.class) //
        .setParameter("nombre", "%" + nombre + "%") //
        .getResultList();
  }

}
