package utn.dds.persistencia.futbol.persistence.tienda;

public class Pantalon extends Producto {

  private Talle talle;
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
