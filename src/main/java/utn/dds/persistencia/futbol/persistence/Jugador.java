package utn.dds.persistencia.futbol.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Jugador {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nombre;
  private String posicion;

  public String getNombre() {
    return nombre;
  }

  @Transient
  private List<String> lesiones = new ArrayList<>();

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getPosicion() {
    return posicion;
  }

  public void setPosicion(String posicion) {
    this.posicion = posicion;
  }

  public Long getId() {
    return id;
  }

}
