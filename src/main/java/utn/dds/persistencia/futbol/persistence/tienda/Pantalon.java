package utn.dds.persistencia.futbol.persistence.tienda;

import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Entity
public class Pantalon extends Producto {

  @Enumerated
  private Talle talle;

  @Enumerated
  private Color color;

  public Talle getTalle() {
    return talle;
  }

  public Color getColor() {
    return color;
  }

  public void setTalle(Talle talle) {
    this.talle = talle;
  }

  public void setColor(Color color) {
    this.color = color;
  }

}
