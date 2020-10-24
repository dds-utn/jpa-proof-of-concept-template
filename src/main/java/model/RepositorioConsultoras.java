package model;

import java.util.List;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

public class RepositorioConsultoras implements WithGlobalEntityManager {

  public static RepositorioConsultoras instancia = new RepositorioConsultoras();

  public List<Consultora> listar() {
    return entityManager()//
        .createQuery("from Consultora", Consultora.class) //
        .getResultList();
  }

  public List<Consultora> listarSegunEmpleados() {
    return entityManager()//
            .createQuery("from Consultora order by cantidad_empleados desc", Consultora.class) //
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
