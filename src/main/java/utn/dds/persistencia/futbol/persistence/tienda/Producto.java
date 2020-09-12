package utn.dds.persistencia.futbol.persistence.tienda;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Producto {
  
  @Id
  @GeneratedValue
  private Long id;

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
