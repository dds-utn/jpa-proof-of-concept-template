package utn.dds.persistencia.biblioteca;

import javax.persistence.Entity;

@Entity
public class Libro extends Publicacion {

  private String isbn;
  private int cantidadPaginas;

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public int getCantidadPaginas() {
    return cantidadPaginas;
  }

  public void setCantidadPaginas(int cantidadPaginas) {
    this.cantidadPaginas = cantidadPaginas;
  }

}
