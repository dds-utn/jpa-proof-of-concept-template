package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "Prendas")
public class Prenda extends BaseEntity {
  @Column
  private String nombre;
  @Enumerated
  private Color color;

  public Prenda(String nombre, Color color) {
    super();
    this.nombre = nombre;
    this.color = color;
  }

  public Color getColor() {
    return color;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setColor(Color color) {
    this.color = color;
  }

}
