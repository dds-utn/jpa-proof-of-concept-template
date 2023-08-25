package utn.dds.persistencia.futbol.persistence.tienda;

import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Entity
public class Remera extends Producto {

  @Enumerated
  private Talle talle;

  @Enumerated
  private Color color;

  @Enumerated
  private GeneroRemera genero;

  public Talle getTalle() {
    return talle;
  }

  public Color getColor() {
    return color;
  }

  public GeneroRemera getGenero() {
    return genero;
  }

  public void setTalle(Talle talle) {
    this.talle = talle;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public void setGenero(GeneroRemera genero) {
    this.genero = genero;
  }


}
