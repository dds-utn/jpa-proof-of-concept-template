package utn.dds.persistencia.biblioteca;

import java.time.LocalDate;

public abstract class Publicacion {

  private String titulo;
  private LocalDate fechaPublicacion;
  private Autor autor;

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public LocalDate getFechaPublicacion() {
    return fechaPublicacion;
  }

  public void setFechaPublicacion(LocalDate fechaPublicacion) {
    this.fechaPublicacion = fechaPublicacion;
  }

  public Autor getAutor() {
    return autor;
  }

  public void setAutor(Autor autor) {
    this.autor = autor;
  }

}
