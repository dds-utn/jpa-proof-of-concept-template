package model;

import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuarios implements WithSimplePersistenceUnit {

  public static RepositorioUsuarios instancia = new RepositorioUsuarios();

  public static List<Usuario> usuarioLogueados = new ArrayList<>();

  public List<Usuario> listar() {
    return entityManager()//
        .createQuery("from Usuario", Usuario.class) //
        .getResultList();
  }

  public Usuario getById(Long id){
    return entityManager().find(Usuario.class, id);
  }


  public void agregar(Usuario usuario) {
    entityManager().persist(usuario);
  }

  public Usuario buscarPorUsuarioYContrasenia(String username, String password) {
    return listar().stream()
        .filter(u -> u.getPassword().equals(password) && u.getUsername().equals(username)).findFirst().get();
  }


}
