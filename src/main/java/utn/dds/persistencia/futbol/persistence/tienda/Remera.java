package utn.dds.persistencia.futbol.persistence.tienda;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Remera extends Producto {

  private Talle talle;
  private Color color;
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
