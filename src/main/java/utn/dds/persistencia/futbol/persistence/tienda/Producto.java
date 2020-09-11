package utn.dds.persistencia.futbol.persistence.tienda;

public abstract class Producto {

  private Double precio;
  private String descripcion;

  public void setPrecio(Double precio) {
    this.precio = precio;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public Double getPrecio() {
    return precio;
  }

}
