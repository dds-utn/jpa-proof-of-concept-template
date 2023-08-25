package utn.dds.persistencia.futbol.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Equipo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nombre;
  private Long cantidadAfiliados;

  private Liga liga;

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Long getCantidadAfiliados() {
    return cantidadAfiliados;
  }

  public void setCantidadAfiliados(Long cantidadAfiliados) {
    this.cantidadAfiliados = cantidadAfiliados;
  }

  public Long getId() {
    return id;
  }

}
