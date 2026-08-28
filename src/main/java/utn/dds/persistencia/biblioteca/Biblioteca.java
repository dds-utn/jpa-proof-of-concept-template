package utn.dds.persistencia.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

  private String nombre;
  private List<Publicacion> publicaciones = new ArrayList<>();

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public List<Publicacion> getPublicaciones() {
    return publicaciones;
  }

  public void setPublicaciones(List<Publicacion> publicaciones) {
    this.publicaciones = publicaciones;
  }

}
