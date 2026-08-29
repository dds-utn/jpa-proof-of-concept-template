package utn.dds.persistencia.biblioteca;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Biblioteca {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nombre;

  @OneToMany
  @JoinColumn(name = "biblioteca_id")
  private List<Publicacion> publicaciones = new ArrayList<>();

  public Long getId() {
    return id;
  }

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
